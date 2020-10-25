package sach;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author pc
 */
public abstract class Figurka implements Serializable{

    protected ImageIcon image;
    protected int pozX, pozY;
    protected int typ;
    protected Policko[][] p;
    protected ArrayList<Figurka> figurky;
    protected boolean stop;
    protected int druh;

    public Figurka(int pozX, int pozY, int typ, Policko[][] p, ArrayList<Figurka> figurky) {
        this.figurky = figurky;
        this.pozX = pozX;
        this.pozY = pozY;
        this.typ = typ;
        this.p = p;
        this.stop = false;
    }

    public boolean isStop() {
        return stop;
    }

    public int getTyp() {
        return typ;
    }

    public int getPozX() {
        return pozX;
    }

    public int getPozY() {
        return pozY;
    }

    public abstract void moznostiPohybu();

    public void setPozX(int pozX) {
        this.pozX = pozX;
    }

    public void setPozY(int pozY) {
        this.pozY = pozY;
    }

    public void Vykresli(Graphics g) {
        try{
        g.drawImage(image.getImage(), pozX * 100, pozY * 100, null);
        }
        catch (NullPointerException e){
        
    }
        //image.paintIcon(c, g, pozX, typ);
    }

    public Rectangle getRectangle() {
        return new Rectangle(this.pozX * 100, this.pozY * 100, 100, 100);
    }

    public boolean isOnMap(int x, int y) {
        if (x >= 0 && y >= 0 && x < p.length && y < p.length) {
            return true;
        }
        return false;
    }

    public abstract boolean canCapture(int x, int y);
    
    public abstract boolean canMove(int x, int y);

    public abstract boolean isDanger(int x, int y);

}
