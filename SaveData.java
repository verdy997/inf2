package sach;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public class SaveData implements Serializable{

    private Sachovnica sach;
    private ArrayList<Figurka> figurky;
    private int tah;

    public SaveData() {
        figurky = new ArrayList<>();
        sach = new Sachovnica(100);
        this.tah = 1;
    }

    public Sachovnica getSach() {
        return sach;
    }

    public ArrayList<Figurka> getFigurky() {
        return figurky;
    }

    public int getTah() {
        return tah;
    }

    public void setSach(Sachovnica sach) {
        this.sach = sach;
    }

    public void setFigurky(ArrayList<Figurka> figurky) {
        this.figurky = figurky;
    }

    public void setTah(int tah) {
        this.tah = tah;
    }
    
    

    
}
