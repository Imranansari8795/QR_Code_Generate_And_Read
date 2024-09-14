package com.test;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        try{
            File file = new File("C:\\Users\\imran\\OneDrive\\Desktop\\abc2.png");
            String text = "This is my Mall";
            ByteArrayOutputStream out = QRCode.from(text).to(ImageType.PNG).stream();
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(out.toByteArray());
            fos.close();
            JOptionPane.showMessageDialog(null,null,"QR Code",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(file.getAbsolutePath()));
            System.out.println("Success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
