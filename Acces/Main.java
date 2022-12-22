package main;

import client.Fenetre;

import java.io.*;
import java.net.Socket;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket;

        String ip = JOptionPane.showInputDialog("Entrer l'adresse ip");
        socket = new Socket(ip,8500);

        DataOutputStream mamoka = new DataOutputStream(socket.getOutputStream());

        String st = JOptionPane.showInputDialog("Anarana");
        mamoka.writeUTF(st);

        String group = JOptionPane.showInputDialog("Groupe");
        mamoka.writeUTF(group);


        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        new Fenetre("Client ee",dos,in);

    }
}