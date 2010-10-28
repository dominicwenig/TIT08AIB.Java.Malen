package edu.dhbw.oswe.malen;

import java.awt.*;

public class Strich implements IVerbindung {

    protected int startX;
    protected int startY;
    protected int endX;
    protected int endY;
    protected Color color;

    public Strich() {

    }

    public Strich(int startX, int startY, int endX, int endY, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
    }

    public IVerbindung newVerbindung(int startX, int startY, int endX, int endY, Color color) {
        return new Strich(startX, startY, endX, endY, color);
    }

    public void zeichne(Graphics g) {
        g.setColor(this.color);
        g.drawLine(this.startX, this.startY, this.endX, this.endY);
    }

    public String toString() {
        return "Strich";
    }

    protected void switcher() {
        if (startX > endX) {
            int tmp;
            tmp = startX;
            startX = endX;
            endX = tmp;
        }
        if (startY > endY) {
            int tmp;
            tmp = startY;
            startY = endY;
            endY = tmp;
        }
    }

}
