package sach;

import java.awt.Graphics;
import java.util.ArrayList;
//import java.awt.Image;
import javax.swing.ImageIcon;

public class Pawn extends Figurka {

    private boolean prvyKrok;

    public Pawn(int pozX, int pozY, int typ, Policko[][] p, ArrayList<Figurka> figurky) {
        super(pozX, pozY, typ, p, figurky);
        if (this.typ == 1) {
            image = new ImageIcon(this.getClass().getResource("/images/Pawn_w.png"));
        } else {
            image = new ImageIcon(this.getClass().getResource("/images/Pawn_b.png"));
        }
        this.prvyKrok = true;

    }

    @Override
    public boolean isDanger(int x, int y) {
        if (canCapture(this.pozX - 1, this.pozY + (1 * typ))) {
            if (x == pozX - 1 && y == this.pozY + (1 * typ)) {
                p[x][y].setDanger(true);
                return true;
            }
        }

        if (canCapture(this.pozX + 1, this.pozY + (1 * typ))) {
            if (x == pozX + 1 && y == this.pozY + (1 * typ)) {
                p[x][y].setDanger(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canCapture(int x, int y) {
        if (this.isOnMap(x, y)) {
            if (!p[x][y].isIsEmpty()) {
                if (this.pozX - 1 == x || this.pozX + 1 == x && this.pozY + (1 * typ) == y) {
                    for (Figurka fig : figurky) {
                        if (fig.getRectangle().intersects(p[x][y].getBones())) {
                            if (fig.getTyp() != typ) {
                                return true;
                            }
                        }
                    }
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canMove(int x, int y) {
        if (this.isOnMap(x, y)) {
            if (!p[x][y].isIsEmpty()) {
                if (this.pozX - 1 == x || this.pozX + 1 == x && this.pozY + (1 * typ) == y) {
                    for (Figurka fig : figurky) {
                        if (fig.getRectangle().intersects(p[x][y].getBones())) {
                            if (fig.getTyp() != typ) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void moznostiPohybu() {

        if (this.isOnMap(this.pozX, this.pozY + (1 * typ)) && p[this.pozX][this.pozY + (1 * typ)].isIsEmpty()) {
            this.p[this.pozX][this.pozY + (1 * typ)].vysviet();
        }

        if (prvyKrok) {
            if (this.isOnMap(this.pozX, this.pozY + (2 * typ)) && p[this.pozX][this.pozY + (2 * typ)].isIsEmpty()) {
                if (this.isOnMap(this.pozX, this.pozY + (1 * typ)) && p[this.pozX][this.pozY + (1 * typ)].isIsEmpty()) {
                    this.p[this.pozX][this.pozY + (2 * typ)].vysviet();
                }
            }
        }

        if (canMove(this.pozX - 1, this.pozY + (1 * typ))) {
            this.p[this.pozX - 1][this.pozY + (1 * typ)].vysviet();
        }

        if (canMove(this.pozX + 1, this.pozY + (1 * typ))) {
            this.p[this.pozX + 1][this.pozY + (1 * typ)].vysviet();
        }
    }


    /*if (this.isOnMap(this.pozX - 1, this.pozY + (1 * typ))) {
            if (!p[this.pozX - 1][this.pozY + (1 * typ)].isIsEmpty()) {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX - 1][this.pozY + (1 * typ)].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX - 1][this.pozY + (1 * typ)].vysviet();
                        }
                    }
                }
            }
        }

        if (this.isOnMap(this.pozX + 1, this.pozY + (1 * typ))) {
            if (!p[this.pozX + 1][this.pozY + (1 * typ)].isIsEmpty()) {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX + 1][this.pozY + (1 * typ)].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX + 1][this.pozY + (1 * typ)].vysviet();
                        }
                    }
                }
            }
        }*/
    public void bolPrvyTah() {
        this.prvyKrok = false;
    }
}
