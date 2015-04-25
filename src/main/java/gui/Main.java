package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by martin on 24.4.15.
 */
public class Main {

    public static void main(String[] args) {

       ButtonGroup group = new ButtonGroup();
        JFrame f = new JFrame();
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        bar.add(menu);

        JRadioButtonMenuItem menuItem = new JRadioButtonMenuItem("A");
        group.add(menuItem);
        menu.add(menuItem);

        menuItem = new JRadioButtonMenuItem("B");
        group.add(menuItem);
        menu.add(menuItem);

        menuItem = new JRadioButtonMenuItem("C");
        group.add(menuItem);
        menu.add(menuItem);

        f.setJMenuBar(bar);
        f.setBounds(300, 300, 300, 200);
        f.setLayout(new FlowLayout());
        JButton studentsJbutton = new JButton("Studens");
        studentsJbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               new StudentTableFrame();
            }
        });

        JButton assigmentsJbutton = new JButton("Assigment");
        JButton coursesJbutton = new JButton("Courses");
        f.getContentPane().add(studentsJbutton);
        f.getContentPane().add(assigmentsJbutton);
        f.getContentPane().add(coursesJbutton);
        f.setVisible(true);
    }
}
