package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by martin on 24.4.15.
 */
public class MainFrame extends JFrame {

    JMenuBar menuBar;
    JMenu jMenu;

    public MainFrame(String title) throws HeadlessException {
        super(title);
        setBounds(200, 200, 200, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuBar = new JMenuBar();
        jMenu = new JMenu("Menu");
        JMenuItem menuItem = new JMenuItem("A text-only menu item",
                KeyEvent.VK_T);
        jMenu.add(menuItem);
        menuBar.add(jMenu);
        setJMenuBar(menuBar);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
