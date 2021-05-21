package org.htw.prog2.beispiele.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class NoisyLabelPanel extends NoisyNamesPanel {

    public NoisyLabelPanel(List<String> names) {
        super(names);
    }

    @Override
    protected void init() {
        String[] layoutOrder = new String[] {BorderLayout.PAGE_START, BorderLayout.LINE_START, BorderLayout.CENTER,
                BorderLayout.LINE_END, BorderLayout.PAGE_END};
        setLayout(new BorderLayout());
        int pos = 0;
        for(String name : names) {
            add(new JLabel(name), layoutOrder[pos]);
            pos++;
            if(pos >= layoutOrder.length) {
                break;
            }
        }
    }
}
