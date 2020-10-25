
package sach;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

/**
 *
 * @author pc
 */
public class Policko implements Serializable{
    private int pozX, pozY ,size;
    private Color c;
    private boolean isEmpty, isVysvieteny, danger;
    

    public Policko(int pozX, int pozY, int size, Color c) {
        this.pozX = pozX;
        this.pozY = pozY;
        this.size = size;
        this.c = c;
        this.isEmpty = true;
        
    }

    public int getPozX() {
        return pozX;
    }

    public int getPozY() {
        return pozY;
    }

    public int getSize() {
        return size;
    }

    public Color getC() {
        return c;
    }
    
    public void draw(Graphics2D g) {
        g.setColor(c);
        g.fillRect(this.pozX, this.pozY, this.size, this.size);
        if(isVysvieteny){
            g.setColor(new Color(0,255,0,150));
            g.fillRect(this.pozX+5, this.pozY+5, this.size-10, this.size-10);
            //g.fillOval(pozX, pozY, size, size);
            
        }
    }
    
    public Rectangle getBones(){
        return new Rectangle(this.pozX, this.pozY, this.size, this.size);
    }

    public boolean isIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public boolean isIsVysvieteny() {
        return isVysvieteny;
    }
    
    public void vysviet(){
        isVysvieteny = true;
        
    }
    
    public void zhasni(){
        isVysvieteny = false;
    }
    
    public void odznac(){
        danger = false;
    }
    
    public boolean isDanger(){
        return danger;
    }
    
    
    public void setDanger(boolean danger){
        this.danger = danger;
    
    }
    
}
