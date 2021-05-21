package org.htw.prog2.beispiele.gui;

import javax.swing.*;
import java.util.List;

public abstract class NoisyNamesPanel extends JPanel {
    protected List<String> names;

    public NoisyNamesPanel(List<String> names) {
        System.out.println("Those are the names I got:");
        for(String name : names) {
            System.out.println(" * " + name);
        }
        this.names = names;
        init();
    }

    protected abstract void init();
}
