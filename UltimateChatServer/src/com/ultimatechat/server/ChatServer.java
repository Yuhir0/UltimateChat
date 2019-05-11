package com.ultimatechat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private static List<ClientListener> clients = new ArrayList<>();
    private static ServerSocket serverListener;

    private class ClientListener extends Thread {
        private Socket clientConnection;
        private DataInputStream in;
        private DataOutputStream out;

        public ClientListener(Socket clientConnection) {
            this.clientConnection = clientConnection;
            try {
                in = new DataInputStream(clientConnection.getInputStream());
                out = new DataOutputStream(clientConnection.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            boolean quit = false;
            String nick = null;
            try {
                nick = in.readUTF();
                System.out.println("User " + nick + " logged in with ip " + clientConnection.getInetAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }

            broadcastMessage("User " + nick + " logged in");
            while (!quit) {
                try {
                    String message = in.readUTF();
                    if (message.toLowerCase().equals("\\q")) {
                        quit = true;
                        broadcastMessage(nick + " logged out");
                        System.out.println("User " + nick + " logged out with ip " + clientConnection.getInetAddress());
                        clients.remove(this);
                    } else {
                        broadcastMessage(nick + ": " + message);
                        System.out.println(nick + ": " + message);
                    }
                } catch (IOException e) {
                    //e.printStackTrace();
                }
            }
        }

        private void broadcastMessage(String message) {
            for (ClientListener client : clients) {
                try {
                    if (!client.clientConnection.equals(clientConnection)) {
                        if (!client.clientConnection.getOOBInline()) {
                            clients.remove(client);
                        } else {
                            client.sendMessage(message);
                        }
                    }
                } catch (Exception e) {}
            }
        }

        public void sendMessage(String message) {
            try {
                out.writeUTF(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main (String[] args) {
        try {
            serverListener = new ServerSocket(3003);
            ChatServer parent = new ChatServer();

            while(true) {
                ClientListener client = parent.new ClientListener(serverListener.accept());
                client.start();
                clients.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
