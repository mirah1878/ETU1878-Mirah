package client;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import message.TextThread;

public class Fenetre extends JFrame {

    JTextArea allMessage;
    JTextField input = new JTextField();
    JButton button = new JButton("Send");
    JScrollPane scrollPane = new JScrollPane();

    public Fenetre(String title, DataOutputStream out , ObjectInputStream in){
        initFrame(title);

        input.setBounds(50,20,250,45);
        add(input);

        button.setBounds(350,20,100,45);
        add(button);
        button.addActionListener(new Listener(input,out));

        allMessage = new JTextArea();
        allMessage.setEditable(false);

        scrollPane.setViewportView(allMessage);
        scrollPane.setPreferredSize(new Dimension(300,300));
        scrollPane.setBounds(50,100,300,300);
        add(scrollPane);


        setVisible(true);
        new TextThread(in,allMessage);
    }


    public void initFrame(String title) {
        setTitle(title);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
    }
}
