package org.test;

import junit.framework.TestCase;
import org.example.Search;
import org.example.TextEditor;

import javax.swing.*;
import javax.swing.text.Highlighter;
import java.awt.*;

public class SearchTest extends TestCase {
    public void testSearch() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TextEditor gui = new TextEditor();
                JTextArea textArea = gui.jTextArea; // 获取主窗口中的文本区域
                JButton searchButton = new JButton("Search");
                gui.jFrame.add(searchButton, BorderLayout.SOUTH);

                Search search = new Search(gui.jFrame, textArea);

                search.findEdit.setText("search-text"); // 设置要搜索的文本

                searchButton.doClick(); // 模拟单击搜索按钮

                // 验证搜索结果是否按预期工作
                int start = search.start;
                int end = start + "search-text".length();
                Highlighter.Highlight[] highlights = textArea.getHighlighter().getHighlights();
                boolean isHighlighted = false;
                for (Highlighter.Highlight highlight : highlights) {
                    int highlightStart = highlight.getStartOffset();
                    int highlightEnd = highlight.getEndOffset();
                    if (highlightStart == start && highlightEnd == end) {
                        isHighlighted = true;
                        break;
                    }
                }

                assertTrue("Text is not highlighted as expected", isHighlighted);
            }
        });
    }
}
