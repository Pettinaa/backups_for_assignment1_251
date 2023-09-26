//package org.example;
//
//import org.odftoolkit;
//import org.odftoolkit.simple.text.Paragraph;
//import org.odftoolkit.simple.text.TextTable;
//
//import java.awt.*;
//import java.io.File;
//
//public class OpenOdt {
//
//    private File file;
//    public void openodt(FileDialog openDia) {
//        mainFrame openWindow = new mainFrame();
//        openDia.setVisible(true);
//        // 显示打开文件对话框
//        String dirpath = openDia.getDirectory();
//        // 获取要打开的文件的路径
//        String fileName = openDia.getFile();
//        // 获取要打开的文件的文件名
//
//        if (dirpath == null || fileName == null) // 确保文件路径和文件名都不为null
//            return;
//        else
//            openWindow.jTextArea.setText("");
//        // 清空新编辑器的文本
//        file = new File(dirpath, fileName);
//        // 构建文件路径和文件名以获取文件
//
//        try {
//            TextDocument textDocument = TextDocument.loadDocument(file);
//            // 使用ODF Toolkit加载odt文件
//            StringBuilder content = new StringBuilder();
//
//            for (Paragraph paragraph : textDocument.getParagraphList()) {
//                content.append(paragraph.getTextContent()).append("\n");
//            }
//
//            openWindow.jTextArea.setText(content.toString());
//            // 将odt文件内容设置到文本区域中
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
