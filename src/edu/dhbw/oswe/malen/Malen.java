package edu.dhbw.oswe.malen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Malen implements ActionListener, ItemListener, MouseMotionListener {

    private Container behaelter;

    private int altesX = 0;
    private int altesY = 0;
    private Color aktuelleFarbe;
    private JButton loeschKnopf;
    private JComboBox farbWahl;
    private JComboBox strichWahl;
    private JButton endeKnopf;
    private Zeichnung zeichnung;
    private IVerbindung aktuelleStrich;

    private static final Color[] color;
    private static final String[] colorString;
    private static final IVerbindung[] verbindung;

    static {
        color = new Color[]{Color.black, Color.red, Color.yellow, Color.green, Color.blue, Color.cyan, Color.magenta};
        colorString = new String[]{"Schwarz", "Rot", "Gelb", "Gruen", "Blau", "Cyan", "Magenta"};
        verbindung = new IVerbindung[]{new Strich(), new Doppelstrich(), new Rechteck(), new Kreis()};
    }

    public void setBehaelter(Container behaelter) {
        this.behaelter = behaelter;
    }

    public void init() {
        JPanel menue = new JPanel();

        loeschKnopf = new JButton("Loeschen");
        loeschKnopf.addActionListener(this);
        loeschKnopf.setForeground(Color.black);
        loeschKnopf.setBackground(Color.lightGray);
        menue.add(loeschKnopf);

        farbWahl = new JComboBox();
        farbWahl.addItemListener(this);
        for (String cS : colorString) {
            farbWahl.addItem(cS);
        }
        farbWahl.setForeground(Color.white);
        farbWahl.setBackground(Color.black);
        menue.add(new JLabel("Farbe: "));
        menue.add(farbWahl);

        strichWahl = new JComboBox();
        strichWahl.addItemListener(this);
        for (IVerbindung v : verbindung) {
            strichWahl.addItem(v);
        }
        strichWahl.setForeground(Color.black);
        strichWahl.setBackground(Color.lightGray);
        menue.add(new JLabel("Strich: "));
        menue.add(strichWahl);

        endeKnopf = new JButton("Ende");
        endeKnopf.addActionListener(this);
        endeKnopf.setForeground(Color.black);
        endeKnopf.setBackground(Color.lightGray);
        menue.add(endeKnopf);

        zeichnung = new Zeichnung();
        zeichnung.setBackground(Color.white);

        behaelter.setLayout(new BorderLayout());
        behaelter.setBackground(Color.gray);
        behaelter.add(menue, BorderLayout.NORTH);
        behaelter.add(zeichnung, BorderLayout.CENTER);

        zeichnung.addMouseMotionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == loeschKnopf) {
            zeichnung.loesche();
        } else if (source == endeKnopf) {
            System.exit(0);
        }
    }

    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        Object item = e.getItem();

        if (source == farbWahl) {
            int i = 0;
            while (!item.toString().equals(colorString[i++])) {
            }
            aktuelleFarbe = color[i - 1];

            if (aktuelleFarbe == Color.black) {
                farbWahl.setForeground(Color.white);
            } else {
                farbWahl.setForeground(Color.black);
            }
            farbWahl.setBackground(aktuelleFarbe);
            farbWahl.transferFocus();

        } else if (source == strichWahl) {
            aktuelleStrich = (IVerbindung) item;
        }
    }

    public void mouseDragged(MouseEvent e) {
        Graphics g = zeichnung.getGraphics();

        IVerbindung s = aktuelleStrich.newVerbindung(altesX, altesY, e.getX(), e.getY(), aktuelleFarbe);
        s.zeichne(g);
        zeichnung.addiere(s);

        altesX = e.getX();
        altesY = e.getY();
    }

    public void mouseMoved(MouseEvent e) {
        altesX = e.getX();
        altesY = e.getY();
    }

}
