package com.ultimatechat.server;

import com.ultimatechat.models.Message;
import com.ultimatechat.models.User;

import java.io.*;
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
        private ObjectInputStream in;
        private ObjectOutputStream out;

        public ClientListener(Socket clientConnection) {
            this.clientConnection = clientConnection;
            try {
                //in = new DataInputStream(clientConnection.getInputStream());
                //out = new DataOutputStream(clientConnection.getOutputStream());
                in = new ObjectInputStream(clientConnection.getInputStream());
                out = new ObjectOutputStream(clientConnection.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            boolean quit = false;
            User user = null;
            try {
                user = (User) in.readObject();
                System.out.println("User " + user + " logged in with ip " + clientConnection.getInetAddress());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            broadcastMessage(new Message(null, null, "User " + user + " logged in"));
            while (!quit) {
                try {
                    System.out.println(in.readObject());
                    Message message = (Message) in.readObject();
                    if (message.getMessage().toLowerCase().equals("\\q")) {
                        quit = true;
                        broadcastMessage(new Message(null, null, user + " logged out"));
                        System.out.println("User " + user + " logged out with ip " + clientConnection.getInetAddress());
                        clientConnection.close();
                        clients.remove(this);
                    } else {
                        broadcastMessage(message);
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    //e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcastMessage(Message message) {
            for (ClientListener client : clients) {
                try {
                    if (!client.clientConnection.equals(clientConnection)) {
                        if (!client.clientConnection.getOOBInline()) {
                            clients.remove(client);
                        } else {
                            client.sendMessage(message);
                        }
                    }
                } catch (Exception ignore) {}
            }
        }

        public void sendMessage(Message message) {
            try {
                out.writeObject(message);
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
                System.out.println("Nueva conexion");
                client.start();
                clients.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
