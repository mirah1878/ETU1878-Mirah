package message;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TextThread extends Thread{

    ObjectInputStream in;
    JTextArea message;
    private int nbLu=0;
    private boolean loop = true;

    public TextThread(ObjectInputStream in, JTextArea message) {
        this.in = in;
        this.message = message;

        start();
    }

    private void showMessage(String[][] message) {
        for (int i=nbLu; i<message.length; i++) {
            this.message.setText(this.message.getText()+"\n"+message[i][0]+": "+message[i][1]);
        }
    }

    @Override
    public void run() {
        String[][] allMaessage;
        Object message;
        while (loop) {
            try {
                message = in.readObject();
                if(message instanceof String[][]) {
                    allMaessage = (String[][]) message;
                    showMessage(allMaessage);
                    nbLu = allMaessage.length;
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
