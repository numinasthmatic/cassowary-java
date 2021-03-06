// $Id: DraggableBox.java,v 1.5 1999/12/16 02:10:05 gjb Exp $
//
// Cassowary Incremental Constraint Solver
// Original Smalltalk Implementation by Alan Borning
// This C++ Implementation by Greg J. Badros, <gjb@cs.washington.edu>
// http://www.cs.washington.edu/homes/gjb
// (c) 1998, 1999 Alan Borning, Michael Noth, and Greg Badros.  
// See ../../LICENSE for legal details regarding this software
//
// Implementation of the DraggableBox class
// By Michael Noth, 9 Feb 1998
//
// DraggableBox.java

package org.klomp.cassowary.demo;

import java.awt.Graphics;

import org.klomp.cassowary.ClPoint;
import org.klomp.cassowary.ClVariable;

public class DraggableBox {
    ClPoint center;
    int sx, sy; // Screen x, y of center
    int width, height; // Dims of box

    public DraggableBox(double x, double y, int width, int height) {
        center = new ClPoint(x, y);
        this.width = width;
        this.height = height;
        cvt();
    }

    // this version for debugging
    // creates variables with names xa, ya
    public DraggableBox(int a) {
        center = new ClPoint(0, 0, a);
        this.width = 6;
        this.height = 6;
        cvt();
    }

    public DraggableBox() {
        center = new ClPoint(0, 0);
        this.width = 6;
        this.height = 6;
        cvt();
    }

    // Helper function to convert center to screen coords
    void cvt() {
        sx = (int) center.getX().getValue();
        sy = (int) center.getY().getValue();
    }

    // Draw the box
    public void draw(Graphics g) {
        cvt();
        g.drawRect(sx - (width / 2), sy - (height / 2), width, height);
    }

    public void SetCenter(double x, double y) {
        center.setXY(x, y);
        cvt();
    }

    public void SetSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double CenterX() {
        return center.getXValue();
    }

    public double CenterY() {
        return center.getYValue();
    }

    public ClVariable X() {
        return center.getX();
    }

    public ClVariable Y() {
        return center.getY();
    }

    public ClPoint CenterPt() {
        return center;
    }

    public boolean Contains(int x, int y) {
        if ((x >= sx - width / 2) && (x <= sx + width / 2) && (y >= sy - height / 2) && (y <= sy + height / 2))
            return true;
        else
            return false;
    }

}
