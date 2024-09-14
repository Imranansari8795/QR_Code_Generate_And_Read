package com.test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.Result;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class QRReader {

    public static void main(String[] args) {
        try{
            JFileChooser ch = new JFileChooser();
            ch.showOpenDialog(null);
            File file = ch.getSelectedFile();

            if(file == null){
                throw new Exception("Invalid File...");
            }
            //            File file = new File("C:\\Users\\imran\\OneDrive\\Desktop\\abc2.png");
            Result r = new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(file)))));
//            System.out.println(r.getText());
//            JOptionPane.showMessageDialog(null,r.getText());
            JOptionPane.showMessageDialog(null,r.getText(),"QR Content",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(file.getAbsolutePath()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
