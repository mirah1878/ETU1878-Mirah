package client;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RenderedImage;
import java.io.*;
import java.nio.ByteBuffer;

public class Listener implements ActionListener {

    JTextField input;
    DataOutputStream os;

    public Listener(JTextField input, DataOutputStream os) {
        this.input = input;
        this.os = os;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = input.getText();
        try {
            os.writeUTF(message);
            os.flush();
            input.setText("");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

//    private void sendPicture(String path) throws IOException {
//        Image image = ImageIO.read(new File(path));
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ImageIO.write((RenderedImage) image, path.split(".")[1], byteArrayOutputStream);
//        byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
//
//        os.write(size);
//        os.
//    }
}
