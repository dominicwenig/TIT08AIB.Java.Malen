package edu.dhbw.oswe.malen;

import javax.swing.*;

public class MalenMain {

    public static void main(String[] argument) {

        JFrame f = new JFrame("Malen");

        Malen m = new Malen();
        m.setBehaelter(f.getContentPane());
        m.init();

        f.pack();    // Trick: Erzeugt Peer-Frame
        f.setSize(600, 400);
        f.setVisible(true);
    }

}
