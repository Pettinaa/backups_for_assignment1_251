package org.example;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Print {
    public Print(JTextArea text,JFrame frame)
    {
        try{
            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            //set the format of print
            PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
            PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
            //search the machine of printer

            PrintService service = ServiceUI.printDialog(null, 100, 100, printService, defaultService, flavor, pras);
            if (service!=null)//
            {
                DocPrintJob job = service.createPrintJob();
                DocAttributeSet das = new HashDocAttributeSet();
                //build print task
                Doc doc = new SimpleDoc(text.getText().getBytes(), flavor, das);
                //set print file's format
                job.print(doc, pras);
                //print
            }
            //set print dialog and go to print
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(frame,"Cannot print successfully");
        }
    }
}
