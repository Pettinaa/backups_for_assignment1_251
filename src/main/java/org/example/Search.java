package org.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Search{
    Container con;
    JDialog dialog;
    JPanel panel1,panel2;
    JTextArea text;
    JLabel label1;
    JTextField findEdit;
    JCheckBox checkBox;
    ButtonGroup dirBtnGroup;
    JButton searchbtn,CancleBtn;
    int start;
    public Search(JFrame owner, JTextArea Jtext) {
        dialog = new JDialog(owner);
        text=Jtext;
        start = 0;
        panel1=new JPanel();
        panel1.setLayout(new FlowLayout());
        panel2=new JPanel();
        panel2.setLayout(new FlowLayout());

        panel1=new JPanel();
        panel1.setLayout(new FlowLayout());
        panel2=new JPanel();
        panel2.setLayout(new FlowLayout());
        //build panel
        label1=new JLabel("Searching Text");
        findEdit=new JTextField(12);
        searchbtn=new JButton("Search(top->bottom)");
        searchbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index;
                if (start>text.getCaretPosition())
                    start = text.getCaretPosition();

                index=text.getText().indexOf(findEdit.getText(),start);
                IndexNum(index);
            }
        });
        //design action
        panel1.add(label1);
        panel1.add(findEdit);
        panel1.add(searchbtn);

        CancleBtn=new JButton("Cancel");
        CancleBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        //design cancel
        panel2.add(CancleBtn);

        con=dialog.getContentPane();
        con.setLayout(new FlowLayout());
        con.add(panel1);
        con.add(panel2);
        dialog.setTitle("Search");
        dialog.setSize(400,150);
        dialog.setVisible(true);
        //set dialog
    }


    public void IndexNum(int index){
        if (index<0){
            JOptionPane.showMessageDialog(dialog,"There are no more searching text in the file");
            start=0;
        }
        else{
            text.select(index, index+findEdit.getText().length());
            start=index+findEdit.getText().length();
        }
    }
}
