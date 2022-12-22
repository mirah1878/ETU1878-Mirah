package main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import client.Client;
import chat.Chat;
import chat.SendMessage;

import static function.Function.createFile;

public class Main {
    public static final String filename ="D:\\socket_1878\\CHAT\\AccesServeur\\Message\\";
    public static ArrayList<Client> tabclient = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8500);
        System.out.println("Serveur creer");

        Socket socket;
        while (true){
            socket = serverSocket.accept();

            DataInputStream in = new DataInputStream(socket.getInputStream());

            String nom = in.readUTF();
            String groupe = in.readUTF();

            Client client = new Client();
            client.setNom(nom);
            client.setGroup(groupe.toUpperCase());
            client.setInput(new DataInputStream(socket.getInputStream()));
            client.setOutput(new ObjectOutputStream(socket.getOutputStream()));

            if(!findSendMessage(client)) {
                createFile(new File(filename+client.getGroup()+".txt"));
                new SendMessage(client);
            }

            tabclient.add(client);
            new Chat(client);
        }
    }


    static boolean findSendMessage(Client client) {
        for (Client c: tabclient) {
            if(c.getGroup().equals(client.getGroup())) {
                return true;
            }
        }
        return false;
    }

}