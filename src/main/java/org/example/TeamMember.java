package org.example;

import javax.swing.*;
import java.awt.*;

public class TeamMember {
    public TeamMember(){
        JDialog dialog = new JDialog();
        dialog.setTitle("About us");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // 修正关闭操作

        // 使用ClassLoader来获取资源
        ImageIcon image1 = new ImageIcon(TeamMember.class.getResource("/t1.png"));
        ImageIcon image2 = new ImageIcon(TeamMember.class.getResource("/t2.png"));

        // 缩小图片尺寸
        ImageIcon resizedImage1 = resizeImage(image1, 60, 60);
        ImageIcon resizedImage2 = resizeImage(image2, 60, 60);

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel imageLabel1 = new JLabel();
        imageLabel1.setIcon(resizedImage1);
        panel.add(imageLabel1, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.WEST;
        JLabel textLabel1 = new JLabel("Name: Xiaotong Chen | Id: 22009300");
        panel.add(textLabel1, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.CENTER;

        JLabel imageLabel2 = new JLabel();
        imageLabel2.setIcon(resizedImage2);
        panel.add(imageLabel2, constraints);

        constraints.gridx = 1;
        JLabel textLabel2 = new JLabel("Name: Meixian Shi | Id: 22009003");
        panel.add(textLabel2, constraints);

        dialog.add(panel);
        dialog.pack(); // 使用pack()来自动调整窗口大小以适应内容
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public static ImageIcon resizeImage(ImageIcon imageIcon, int width, int height) {
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

}
