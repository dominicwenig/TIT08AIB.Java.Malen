package edu.dhbw.oswe.malen;

import java.awt.*;

public class Doppelstrich extends Strich {

    public Doppelstrich() {

    }

    public Doppelstrich(int startX, int startY, int endX, int endY, Color color) {
        super(startX, startY, endX, endY, color);
    }

    @Override
    public IVerbindung newVerbindung(int startX, int startY, int endX, int endY, Color color) {
        return new Doppelstrich(startX, startY, endX, endY, color);
    }

    @Override
    public void zeichne(Graphics g) {
        g.setColor(color);
        g.drawLine(startX, startY, endX, endY);
        g.drawLine(startX + 3, startY + 3, endX + 3, endY + 3);
    }

    @Override
    public String toString() {
        return "Doppelstrich";
    }

}
