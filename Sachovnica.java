
package sach;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;


public class Sachovnica implements Serializable{
    private int size;
    private Policko[][] p;
    private Color c;
    
    public Sachovnica(int size) {
        this.size = size;
        this.p = new Policko[8][8];
        this.nacitajSachovnicu();
    }
    
    public void nacitajSachovnicu() {
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                int pom = 0;
                if (j%2 == 0) {
                    pom++;
                }
                if((i+pom)%2 == 0){
                    p[i][j] = new Policko(i*size, j*size, size, Color.GRAY.darker());
                    //System.out.println("Som tu" + p1.getC());

                    //p1.draw(g);
                    
                } else {
                    p[i][j] = new Policko(i*size, j*size, size, Color.WHITE);
                    //p1.draw(g);
                }
            }
        }
    }
    
    public void draw(Graphics2D g){
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                p[i][j].draw(g);
            }
        }
    }
    
    public Policko[][] getSach(){
        return p;
    }
}
