package org.test;

import java.awt.FileDialog;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.TestCase;
import org.example.Save;
import org.example.TextEditor;

public class SaveTest extends TestCase {
    @SuppressWarnings("resource")
    public void test() throws Exception{
        TextEditor gui = new TextEditor();
        gui.jTextArea.setText("We are testing the Save function");
        FileDialog saveDia = new FileDialog(gui.jFrame, "Save", FileDialog.SAVE);
        Save save = new Save();
        save.save(gui.jTextArea);
        FileReader fr=null;
        char[] chars = new char[1024];
        String test = "We are testing the Save function";
        int ch = 0;
        try
        {
            fr=new FileReader(saveDia.getDirectory()+saveDia.getFile());
            while((ch=fr.read())!=-1)
            {
                test = test+(char)ch;
            }

        }
        catch(IOException e)
        {
            System.out.println(e.toString());
        }
        finally
        {
            try
            {
                if(fr!=null)
                {
                    fr.close();
                }
            }
            catch(IOException e)
            {
                System.out.println(e.toString());
            }
        }

        assertEquals(test,"We are testing the Save function");
    }
}
