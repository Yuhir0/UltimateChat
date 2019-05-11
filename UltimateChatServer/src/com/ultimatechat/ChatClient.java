package com.ultimatechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ChatClient {
    private static Socket serverConnection;
    private static Inputs reader;
    private static ClientListener listener;
    private static UserInput input;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static String nick;

    private class ClientListener extends Thread {
        boolean done = false;
        public void run() {
            while (!done) {
                try {
                    System.out.println(in.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void close() {
            done = true;
        }
    }

    private class UserInput extends Thread {
        boolean done = false;
        public void run() {
            while (!done) {
                try {
                    String user_mesage = reader.str_input("");
                    if (user_mesage.equals("\\q")) {
                        done = true;
                    }
                    out.writeUTF(user_mesage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void close() {
            done = true;
        }
    }

    public static void main(String[] args) throws IOException {
        ChatClient parent = new ChatClient();
        listener = parent.new ClientListener();
        input = parent.new UserInput();
        reader = new Inputs();

        String ip;
        if (args.length == 1) {
            ip = args[0];
        } else {
            ip = reader.str_input("Enter a ip: ");
        }

        nick = reader.str_input("Enter nick: ");

        try {
            InetAddress address = InetAddress.getByName(ip);
            serverConnection = new Socket(address, 3003);
            in = new DataInputStream(serverConnection.getInputStream());
            out = new DataOutputStream(serverConnection.getOutputStream());
            out.writeUTF(nick);
            listener.start();
            input.start();

            while (listener.isAlive() && input.isAlive());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverConnection != null) {
                serverConnection.close();
            }
            listener.close();
            input.close();
        }
    }
}
