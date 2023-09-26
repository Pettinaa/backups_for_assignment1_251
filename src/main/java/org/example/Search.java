package org.example;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search {
    private JDialog dialog;
    private JTextArea textArea;
    private JTextField findEdit;
    private Highlighter highlighter;
    private DefaultHighlighter.DefaultHighlightPainter highlightPainter;
    private int start = 0;

    public Search(JFrame owner, JTextArea textArea) {
        dialog = new JDialog(owner);
        this.textArea = textArea;
        findEdit = new JTextField(12);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Searching Text");

        JButton searchBtn = new JButton("top-down search");
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int index;
                if (start > text.length())
                    start = text.length();

                index = text.indexOf(findEdit.getText(), start);
                if (index >= 0) {
                    highlightText(index, findEdit.getText().length());
                    start = index + findEdit.getText().length();
                } else {
                    JOptionPane.showMessageDialog(dialog, "No more occurrences found.");
                    start = 0;
                }
            }
        });

        panel1.add(label1);
        panel1.add(findEdit);
        panel1.add(searchBtn);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        panel2.add(cancelBtn);

        Container con = dialog.getContentPane();
        con.setLayout(new FlowLayout());
        con.add(panel1);
        con.add(panel2);

        dialog.setTitle("Search");
        dialog.setSize(400, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        // 初始化高亮显示
        highlighter = textArea.getHighlighter();
        highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.PINK);
    }

    private void highlightText(int startIndex, int length) {
        // 清除之前的高亮显示
        highlighter.removeAllHighlights();

        // 添加新的高亮显示
        try {
            highlighter.addHighlight(startIndex, startIndex + length, highlightPainter);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
