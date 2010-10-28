package edu.dhbw.oswe.malen;

import java.awt.*;

public class Kreis extends Strich {

    public Kreis() {

    }

    public Kreis(int startX, int startY, int endX, int endY, Color color) {
        super(startX, startY, endX, endY, color);
    }

    @Override
    public IVerbindung newVerbindung(int startX, int startY, int endX, int endY, Color color) {
        return new Kreis(startX, startY, endX, endY, color);
    }

    @Override
    public void zeichne(Graphics g) {
        g.setColor(color);
        super.switcher();
        g.drawOval(startX, startY, Math.abs(endX - startX), Math.abs(endY - startY));
    }

    @Override
    public String toString() {
        return "Kreis";
    }

}
