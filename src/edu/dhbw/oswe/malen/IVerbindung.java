package edu.dhbw.oswe.malen;

import java.awt.*;

public interface IVerbindung {

    public void zeichne(Graphics g);

    public IVerbindung newVerbindung(int startX, int startY, int endX, int endY, Color color);

    public String toString();

}
