package chat;

import client.Client;
import main.Main;

import java.io.IOException;


public class Chat extends Thread {

    String path;
    Client client;
    private boolean loop = true;

    public Chat(Client client) {
        this.client = client;
        this.path = Main.filename+client.getGroup();

        start();
    }

    @Override
    public void run() {
        String newMessage;
        String value;
        while (loop) {
            try {
                newMessage = client.getInput().readUTF();
                value = client.getNom()+"/// "+newMessage;
                function.Function.enregistrer(value,path);

            } catch (IOException e) {
                Main.tabclient.remove(client);
            }
        }
    }
}
