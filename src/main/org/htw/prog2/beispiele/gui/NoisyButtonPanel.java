package org.htw.prog2.beispiele.gui;

import javax.swing.*;
import java.util.List;

public class NoisyButtonPanel extends NoisyNamesPanel {
    public NoisyButtonPanel(List<String> names) {
        super(names);
    }

    @Override
    protected void init() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for(String name : names) {
            add(new JButton(name));
        }
    }
}
