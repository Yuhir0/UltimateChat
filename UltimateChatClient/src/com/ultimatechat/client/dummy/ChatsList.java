package com.ultimatechat.client.dummy;

import com.ultimatechat.client.models.Chat;
import com.ultimatechat.client.models.Message;
import com.ultimatechat.client.models.User;

import java.util.ArrayList;

public class ChatsList {
    public ArrayList<Chat> chats;

    public ChatsList() {
        chats = new ArrayList<>();
        ArrayList<User> users = new UsersList().users;
        User me = users.get(0);
        User other = users.get(1);
        Chat chat = new Chat(me, other);
        chat.addMessage(new Message(me, other, "Hola"));
        chat.addMessage(new Message(other, me, "Hey! Que tal?"));
        chat.addMessage(new Message(me, other, "Bien tio, cuanto tiempo"));
        chats.add(chat);

        other = users.get(2);
        chat = new Chat(me, other);
        chat.addMessage(new Message(other, me, "Hey! Que tal?"));
        chats.add(chat);

        other = users.get(3);
        chat = new Chat(me, other);
        chat.addMessage(new Message(me, other, "Hola"));
        chat.addMessage(new Message(other, me, "Hey! Que tal?"));
        chat.addMessage(new Message(me, other, "He visto la nueva pelicula de pokemo, que pasada!"));
        chats.add(chat);

        other = users.get(4);
        chat = new Chat(me, other);
        chat.addMessage(new Message(me, other, "Hola"));
        chat.addMessage(new Message(other, me, "Como va todo"));
        chat.addMessage(new Message(me, other, "No me puedo quejar la verdad"));
        chats.add(chat);

        other = users.get(5);
        chat = new Chat(me, other);
        chat.addMessage(new Message(me, other, "Hola"));
        chat.addMessage(new Message(other, me, "Como va todo"));
        chat.addMessage(new Message(me, other, "No me puedo quejar la verdad"));
        chats.add(chat);

        other = users.get(6);
        chat = new Chat(me, other);
        chat.addMessage(new Message(me, other, "Hola"));
        chat.addMessage(new Message(other, me, "Como va todo"));
        chat.addMessage(new Message(me, other, "No me puedo quejar la verdad"));
        chats.add(chat);

        other = users.get(7);
        chat = new Chat(me, other);
        chat.addMessage(new Message(me, other, "Hola"));
        chat.addMessage(new Message(other, me, "Como va todo"));
        chat.addMessage(new Message(me, other, "No me puedo quejar la verdad"));
        chats.add(chat);

        other = users.get(8);
        chat = new Chat(me, other);
        chat.addMessage(new Message(me, other, "Hola"));
        chat.addMessage(new Message(other, me, "Como va todo"));
        chat.addMessage(new Message(me, other, "No me puedo quejar la verdad"));
        chats.add(chat);

        other = users.get(9);
        chat = new Chat(me, other);
        chat.addMessage(new Message(me, other, "Hola"));
        chat.addMessage(new Message(other, me, "Como va todo"));
        chat.addMessage(new Message(me, other, "No me puedo quejar la verdad"));
        chats.add(chat);
    }

    public Chat getChatByUsers(User sender, User receptor) {
        String id = sender + "+" + receptor;
        for (Chat chat: chats) {
            if (chat.getId().equals(id))
                return chat;
        }
        return null;
    }
}
