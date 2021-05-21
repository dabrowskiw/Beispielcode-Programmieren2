package org.htw.prog2.beispiele.gui;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MainGUI extends JFrame {
    public MainGUI(String[] namesString) {
        super("This is a window");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        LinkedList<String> names = new LinkedList<>();
        for(String name : namesString) {
            names.add(name);
        }
        add(new NoisyButtonPanel(names));
        add(new NoisyLabelPanel(names));
        pack();
    }

    public static void main(String[] args) {
        MainGUI gui = new MainGUI(new String[]{"Max", "Luisa", "Andreas", "Johanna", "Milena", "Mario",
                "Sabine", "Thomas"});
        gui.setVisible(true);
    }
}
