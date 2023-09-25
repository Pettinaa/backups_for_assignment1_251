package org.example;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class Save {
    private File file;
    public void save(JTextArea jta, FileDialog saveDia) {
        saveDia.setVisible(true);
        //display the save window
        String dirpath = saveDia.getDirectory();
        //get the path and save as string
        String fileName = saveDia.getFile();
        //get the filename and save as string
        if (dirpath == null || fileName == null)//contain the path and filename is not null
            return;
        else
            file=new File(dirpath,fileName);
        //build a new file

        try {
            BufferedWriter writetext = new BufferedWriter(new FileWriter(file));

            String text = jta.getText();
            //get the text included in the texteditor
            writetext.write(text);
            //output the string to the new file by stream

            writetext.close();
            //close the rewrite file
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }
}
