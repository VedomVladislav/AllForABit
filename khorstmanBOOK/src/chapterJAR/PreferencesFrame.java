package chapterJAR;

import java.io.*;
import java.util.prefs.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class PreferencesFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private Preferences root = Preferences.userRoot();
    private Preferences node = root.node("chapterJar");


    public PreferencesFrame() {

        //получить  положение, размеры и заголовок фрейма из свойств
        int left = node.getInt("left",0);
        int top = node.getInt("top",0);
        int width = node.getInt("width", DEFAULT_WIDTH);
        int height = node.getInt("width", DEFAULT_HEIGHT);

        //если заголовок не задан, запросить его у пользователя
        String title = node.get("title","");
        if (title.equals(""))  title = JOptionPane.showInputDialog("Please, enter the title: ");
            if(title == null) title = "";
            setTitle(title);

        //установить компонент для выбора и отображение XML-файлов
        final JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileFilter(new FileNameExtensionFilter("XML files","xml"));

        //установить меню
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu();
        menu.add(menu);

        JMenuItem exportItem = new JMenuItem("Export References");
        menu.add(exportItem);
        exportItem.addActionListener(event -> {
            if(chooser.showSaveDialog(PreferencesFrame.this) == JFileChooser.APPROVE_OPTION) {
                try {
                    savePreferences();
                    OutputStream out = new FileOutputStream(chooser.getSelectedFile());
                    node.exportNode(out);
                    out.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem importItem = new JMenuItem("Import preferences");
        menu.add(importItem);
        importItem.addActionListener(event -> {
            if(chooser.showSaveDialog((PreferencesFrame.this)) == JFileChooser.APPROVE_OPTION) {
                try {
                    InputStream in = new FileInputStream((chooser.getSelectedFile()));
                    Preferences.importPreferences(in);
                    in.close();
                    } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem exitItem = new JMenuItem();
        menu.add(exitItem);
        exitItem.addActionListener(event -> {
            savePreferences();
            System.exit(0);
        });
    }

    public void savePreferences() {
        node.putInt("left",getX());
        node.putInt("top",getY());
        node.putInt("width",getWidth());
        node.putInt("height",getHeight());
        node.put("title",getTitle());
    }

}
