package org.example;


import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CalendarPanel extends JPanel {
    private JLabel dateTimeLabel;

    private JDialog jDialog = new JDialog();
    public CalendarPanel() {

        jDialog.setTitle("time and data");
        jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // 修正关闭操作
        jDialog.setVisible(true);


        setLayout(new BorderLayout());

        dateTimeLabel = new JLabel();
        dateTimeLabel.setHorizontalAlignment(JLabel.CENTER);
        dateTimeLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        updateDateTimeLabel();

        add(dateTimeLabel, BorderLayout.CENTER);

        // Create a timer to update the date and time every second
        Timer timer = new Timer(1000, e -> updateDateTimeLabel());
        timer.start();


        jDialog.add(dateTimeLabel);
//        jDialog.pack(); // 使用pack()来自动调整窗口大小以适应内容
        jDialog.setSize(300, 150);
        jDialog.setLocationRelativeTo(null);
        jDialog.setVisible(true);

    }

    private void updateDateTimeLabel() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date();
        dateTimeLabel.setText(dateFormat.format(now));
    }
}
