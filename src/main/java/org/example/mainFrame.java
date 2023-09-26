package org.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.itextpdf.text.DocumentException;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
public class mainFrame{

    //create a frame
    public JFrame jFrame = new JFrame();

    //creat JMenubar
    JMenuBar jMenuBar = new JMenuBar();

    //creat JMenu
    JMenu file = new JMenu("File");
    JMenu search= new JMenu("Search");
    JMenu view = new JMenu("View");
    JMenu manage = new JMenu("Manage");
    JMenu help = new JMenu("Help");
    JMenu time = new JMenu("T&D");

    //creat JMenuitem
    JMenuItem New = new JMenuItem("New", 'N');
    JMenuItem save = new JMenuItem("Save", 'S');
    JMenuItem open = new JMenuItem("Open", 'O');
    JMenuItem print = new JMenuItem("Print", 'P');
    JMenuItem exit = new JMenuItem("Exit");
    JMenuItem search1 = new JMenuItem("Search", 'F');
    JMenuItem pdf = new JMenuItem("Convert to PDF");
    JMenuItem select = new JMenuItem("Select", 'A');
    JMenuItem copy = new JMenuItem("Copy", 'C');
    JMenuItem paste = new JMenuItem("Paste", 'V');
    JMenuItem cut = new JMenuItem("Cut", 'X');
    JMenuItem about = new JMenuItem("About");
    JMenuItem time1 = new JMenuItem("Time and data in a panel");
    JMenuItem time2 = new JMenuItem("Time and data in the text");

    //create a text area for writing text
    JTextArea jTextArea = new RSyntaxTextArea(20, 30);
    private FileDialog openDia;

    public mainFrame() {
        //set up the frame
        jFrame.setTitle("Text Editor");
        jFrame.setSize(700, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //set an image on the position of title
        String path = "/icon.png"; // 注意路径不包含"/resources"部分ImageIcon icon = new ImageIcon(getClass().getResource(path));
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image image = icon.getImage();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        jFrame.setIconImage(image);

        //Set shortcut keys
        New.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.Event.CTRL_MASK));
        open.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK));
        print.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.Event.CTRL_MASK));
        search1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.Event.CTRL_MASK));
        select.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.Event.CTRL_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.Event.CTRL_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.Event.CTRL_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.Event.CTRL_MASK));



        //add JMenuItem to JMenu
        file.add(New);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);
        search.add(search1);
        view.add(pdf);
        manage.add(select);
        manage.add(copy);
        manage.add(paste);
        manage.add(cut);
        help.add(about);
        time.add(time1);
        time.add(time2);

        //add JMenu to JMenubar
        jMenuBar.add(file);
        jMenuBar.add(search);
        jMenuBar.add(view);
        jMenuBar.add(manage);
        jMenuBar.add(help);
        jMenuBar.add(time);

        //add JMenubar to JFrame
        jFrame.setJMenuBar(jMenuBar);

        //set up the writing area
        ((RSyntaxTextArea) jTextArea).setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        ((RSyntaxTextArea) jTextArea).setCodeFoldingEnabled(true);

        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        //add JTextArea to JFrame
        jFrame.add(jScrollPane, BorderLayout.CENTER);

        //open files
        openDia = new FileDialog(jFrame,"Open",FileDialog.LOAD);

        //make the JFrame can be seen
        jFrame.setVisible(true);

        //New function: to create a new (fresh) window
        New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new New();
            }
        });

        //open function
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Open open = new Open();
                open.opentxt(openDia);
            }
        });

        //Save function:
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Save save = new Save();
                save.save(jTextArea);
            }
        });

        //Print function
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Print(jTextArea,jFrame);
            }

        });

        //Exit function
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Search function:  search for text within the screen
        search1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Search(jFrame,jTextArea);
            }
        });

        // a PDF conversion function, the file can be saved inPDF format
        final JFileChooser pdfSaver = new JFileChooser();
        pdfSaver.setFileFilter(new FileNameExtensionFilter("pdf",".pdf"));
        pdf.addActionListener(e -> {
            pdfSaver.showDialog(jFrame, "save as pdf");
            File file = pdfSaver.getSelectedFile();
            Conversation pdf = new Conversation();
            try {
                pdf.conversation(file, jTextArea.getText());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (DocumentException e1) {
                e1.printStackTrace();
            }
        });

        //Select function: select all contents
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manage select = new Manage();
                select.select(jTextArea);
            }
        });

        //Copy function
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manage select = new Manage();
                select.copy(jTextArea);
            }
        });

        //Paste function
        paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manage select = new Manage();
                select.paste(jTextArea);
            }
        });

        //Cut function
        cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manage select = new Manage();
                select.cut(jTextArea);
            }
        });

        //the name and other information of our team
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TeamMember();
            }
        });

        //Time and Date: show the time and data in a panel
        time1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalendarPanel calendarPanel = new CalendarPanel();
            }
        });

        //Time and Date: write the time and data in the text
        time2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GregorianCalendar c=new GregorianCalendar();
                int hour=c.get(Calendar.HOUR_OF_DAY);
                int min=c.get(Calendar.MINUTE);
                int second=c.get(Calendar.SECOND);
                jTextArea.append(hour+":"+min+" "+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.DAY_OF_MONTH));
            }
        });
    }
}
