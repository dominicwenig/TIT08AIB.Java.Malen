package edu.dhbw.oswe.malen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Zeichnung extends JPanel {

    private List<IVerbindung> striche = new ArrayList<IVerbindung>();

    public void loesche() {
        this.striche = new ArrayList<IVerbindung>();
        repaint();
    }

    public void addiere(IVerbindung e) {
        striche.add(e);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IVerbindung s : striche) {
            s.zeichne(g);
        }
    }

}
