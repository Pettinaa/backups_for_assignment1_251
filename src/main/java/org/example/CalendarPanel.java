package org.example;


import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CalendarPanel extends JPanel {
    private JLabel dateTimeLabel;

    public CalendarPanel() {
        setLayout(new BorderLayout());

        dateTimeLabel = new JLabel();
        dateTimeLabel.setHorizontalAlignment(JLabel.CENTER);
        dateTimeLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        updateDateTimeLabel();

        add(dateTimeLabel, BorderLayout.CENTER);

        // Create a timer to update the date and time every second
        Timer timer = new Timer(1000, e -> updateDateTimeLabel());
        timer.start();
    }

    private void updateDateTimeLabel() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date();
        dateTimeLabel.setText(dateFormat.format(now));
    }
}
