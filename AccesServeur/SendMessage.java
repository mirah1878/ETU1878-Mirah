package chat;

import client.Client;
import main.Main;

import static function.Function.manisaline;
import static function.Function.getData;


public class SendMessage extends Thread {

    String filePath;
    int nbActu = 0;
    String[][] allMessage;
    private boolean loop = true;

    public SendMessage(Client client) {
        filePath = Main.filename+client.getGroup()+".txt";

        start();
    }

    private void sendMessage(Client client) throws Exception {
        allMessage = getData(filePath);
        client.getOutput().writeObject(allMessage);
        client.getOutput().flush();
    }

    @Override
    public void run() {
        while (loop) {
            try {
                int nbtemp = manisaline(filePath);
                if(nbtemp > nbActu) {
                    for (Client c: Main.tabclient) {
                        if (filePath.contains(c.getGroup())) {
                            sendMessage(c);
                        }
                    }
                }
                nbActu = nbtemp;

            }catch (Exception j){
                throw new RuntimeException(j);
            }


        }
    }
}
