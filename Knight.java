package sach;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author pc
 */
public class Knight extends Figurka {

    public Knight(int pozX, int pozY, int typ, Policko[][] p, ArrayList<Figurka> figurky) {
        super(pozX, pozY, typ, p, figurky);
        if (this.typ == 1) {
            image = new ImageIcon(this.getClass().getResource("/images/Knight_w.png"));
        } else {
            image = new ImageIcon(this.getClass().getResource("/images/Knight_b.png"));
        }
    }

    @Override
    public boolean canMove(int x, int y) {
        if (this.isOnMap(x, y)) {
            if ((pozX + 2 == x || pozX - 2 == x && pozY + 1 == y || pozY - 1 == y)
                    || (pozX + 1 == x || pozX - 1 == x && pozY + 2 == y || pozY - 2 == y)) {
                if (p[x][y].isIsEmpty()) {
                    return true;
                } else {
                    for (Figurka fig : figurky) {
                        if (fig.getRectangle().intersects(p[x][y].getBones())) {
                            if (fig.getTyp() != typ) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean canCapture(int x, int y) {
        if (this.isOnMap(x, y)) {
            if ((pozX + 2 == x || pozX - 2 == x && pozY + 1 == y || pozY - 1 == y)
                    || (pozX + 1 == x || pozX - 1 == x && pozY + 2 == y || pozY - 2 == y)) {
                if (p[x][y].isIsEmpty()) {
                    return true;
                } else {
                    for (Figurka fig : figurky) {
                        if (fig.getRectangle().intersects(p[x][y].getBones())) {
                            return true; 
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean isDanger(int x, int y) {
        if (this.canCapture(pozX + 2, pozY + 1)) {
            if (x == pozX + 2 && y == pozY + 1) {
                p[x][y].setDanger(true);
                return true;
            }
        }
        if (this.canCapture(pozX + 2, pozY - 1)) {
            if (x == pozX + 2 && y == pozY - 1) {
                p[x][y].setDanger(true);
                return true;
            }
        }
        if (this.canCapture(pozX - 2, pozY + 1)) {
            if (x == pozX - 2 && y == pozY + 1) {
                p[x][y].setDanger(true);
                return true;
            }
        }
        if (this.canCapture(pozX - 2, pozY - 1)) {
            if (x == pozX - 2 && y == pozY - 1) {
                p[x][y].setDanger(true);
                return true;
            }
        }
        if (this.canCapture(pozX + 1, pozY + 2)) {
            if (x == pozX + 1 && y == pozY + 2) {
                p[x][y].setDanger(true);
                return true;
            }
        }
        if (this.canCapture(pozX + 1, pozY - 2)) {
            if (x == pozX + 1 && y == pozY - 2) {
                p[x][y].setDanger(true);
                return true;
            }
        }
        if (this.canCapture(pozX - 1, pozY + 2)) {
            if (x == pozX - 1 && y == pozY + 2) {
                p[x][y].setDanger(true);
                return true;
            }
        }
        if (this.canCapture(pozX - 1, pozY - 2)) {
            if (x == pozX - 1 && y == pozY - 2) {
                p[x][y].setDanger(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public void moznostiPohybu() {
        if (this.canMove(pozX + 2, pozY + 1)) {
            this.p[this.pozX + 2][this.pozY + 1].vysviet();
        }
        if (this.canMove(pozX + 2, pozY - 1)) {
            this.p[this.pozX + 2][this.pozY - 1].vysviet();
        }
        if (this.canMove(pozX - 2, pozY + 1)) {
            this.p[this.pozX - 2][this.pozY + 1].vysviet();
        }
        if (this.canMove(pozX - 2, pozY - 1)) {
            this.p[this.pozX - 2][this.pozY - 1].vysviet();
        }
        if (this.canMove(pozX + 1, pozY + 2)) {
            this.p[this.pozX + 1][this.pozY + 2].vysviet();
        }
        if (this.canMove(pozX + 1, pozY - 2)) {
            this.p[this.pozX + 1][this.pozY - 2].vysviet();
        }
        if (this.canMove(pozX - 1, pozY + 2)) {
            this.p[this.pozX - 1][this.pozY + 2].vysviet();
        }
        if (this.canMove(pozX - 1, pozY - 2)) {
            this.p[this.pozX - 1][this.pozY - 2].vysviet();
        }
    }

    /* if (this.isOnMap(this.pozX + 1, this.pozY + 2)) {
            if (p[this.pozX + 1][this.pozY + 2].isIsEmpty()) {
                this.p[this.pozX + 1][this.pozY + 2].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX + 1][this.pozY + 2].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX + 1][this.pozY + 2].vysviet();
                        }
                    }
                }
            }
        }

        if (this.isOnMap(this.pozX - 1, this.pozY + 2)) {
            if (p[this.pozX - 1][this.pozY + 2].isIsEmpty()) {
                this.p[this.pozX - 1][this.pozY + 2].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX - 1][this.pozY + 2].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX - 1][this.pozY + 2].vysviet();
                        }
                    }
                }
            }
        }
        if (this.isOnMap(this.pozX + 1, this.pozY - 2)) {
            if (p[this.pozX + 1][this.pozY - 2].isIsEmpty()) {
                this.p[this.pozX + 1][this.pozY - 2].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX + 1][this.pozY - 2].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX + 1][this.pozY - 2].vysviet();
                        }
                    }
                }
            }
        }
        if (this.isOnMap(this.pozX - 1, this.pozY - 2)) {
            if (p[this.pozX - 1][this.pozY - 2].isIsEmpty()) {
                this.p[this.pozX - 1][this.pozY - 2].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX - 1][this.pozY - 2].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX - 1][this.pozY - 2].vysviet();
                        }
                    }
                }
            }
        }
        if (this.isOnMap(this.pozX + 2, this.pozY + 1)) {
            if (p[this.pozX + 2][this.pozY + 1].isIsEmpty()) {
                this.p[this.pozX + 2][this.pozY + 1].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX + 2][this.pozY + 1].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX + 2][this.pozY + 1].vysviet();
                        }
                    }
                }
            }
        }
        if (this.isOnMap(this.pozX - 2, this.pozY + 1)) {
            if (p[this.pozX - 2][this.pozY + 1].isIsEmpty()) {
                this.p[this.pozX - 2][this.pozY + 1].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX - 2][this.pozY + 1].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX - 2][this.pozY + 1].vysviet();
                        }
                    }
                }
            }
        }
        if (this.isOnMap(this.pozX - 2, this.pozY - 1)) {
            if (p[this.pozX - 2][this.pozY - 1].isIsEmpty()) {
                this.p[this.pozX - 2][this.pozY - 1].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX - 2][this.pozY - 1].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX - 2][this.pozY - 1].vysviet();
                        }
                    }
                }
            }
        }
        if (this.isOnMap(this.pozX + 2, this.pozY - 1)) {
            if (p[this.pozX + 2][this.pozY - 1].isIsEmpty()) {
                this.p[this.pozX + 2][this.pozY - 1].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX + 2][this.pozY - 1].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX + 2][this.pozY - 1].vysviet();
                        }
                    }
                }
            }
        }
    }*/
}
