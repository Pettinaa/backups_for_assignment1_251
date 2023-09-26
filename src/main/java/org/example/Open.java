package org.example;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Open{
    private File file;
    public void opentxt(FileDialog openDia) {
        mainFrame openWindow = new mainFrame();
        openDia.setVisible(true);
        //display the open window
        String dirpath = openDia.getDirectory();
        //get the file path of the file want to open
        String fileName = openDia.getFile();
        //get the file name of the file want to open

        if (dirpath == null || fileName == null)//contain the file path and name is not null
            return;
        else
            openWindow.jTextArea.setText("");
        //clean the new editor's text
        file = new File(dirpath, fileName);
        //build the file path and name to get the file

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            //read the file
            String line = null;
            //initial string to null
            while ((line = buffer.readLine()) != null) {
                openWindow.jTextArea.append(line + "\r\n");
                //add the strings to editor textarea
            }
            buffer.close();
            //close the file
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

}
