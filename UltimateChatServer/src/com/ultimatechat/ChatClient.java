package com.ultimatechat;

import com.ultimatechat.models.Message;
import com.ultimatechat.models.User;

import javax.sound.midi.SysexMessage;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ChatClient {
    private static Socket serverConnection;
    private static Inputs reader;
    private static ClientListener listener;
    private static UserInput input;
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    private static String nick;
    private static User user;

    private class ClientListener extends Thread {
        boolean done = false;
        public void run() {
            while (!done) {
                try {
                    System.out.println(in.readObject());
                } catch (IOException | ClassNotFoundException e) {
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
                    String user_message = reader.str_input("");
                    if (user_message.equals("\\q")) {
                        done = true;
                    }
                    Message m = new Message(user, null, user_message);
                    System.out.println(m);
                    //out.writeUTF(user_message);
                    out.writeObject(m);
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
        user = new User(nick, null);

        try {
            InetAddress address = InetAddress.getByName(ip);
            serverConnection = new Socket(address, 3003);

            in = new ObjectInputStream(serverConnection.getInputStream());
            out = new ObjectOutputStream(serverConnection.getOutputStream());
            //in = new DataInputStream(serverConnection.getInputStream());
            //out = new DataOutputStream(serverConnection.getOutputStream());
            System.out.println(user);
            out.writeObject(user);
            System.out.println(user);
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
