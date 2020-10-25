/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sach;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author pc
 */
public class King extends Figurka {

    private boolean haveMove;

    public King(int pozX, int pozY, int typ, Policko[][] p, ArrayList<Figurka> figurky) {
        super(pozX, pozY, typ, p, figurky);
        if (this.typ == 1) {
            image = new ImageIcon(this.getClass().getResource("/images/King_w.png"));
        } else {
            image = new ImageIcon(this.getClass().getResource("/images/King_b.png"));
        }
        haveMove = true;
    }

    public boolean isHaveMove() {
        return haveMove;
    }

    @Override
    public boolean canMove(int x, int y) {
        if (this.isOnMap(x, y)) {
            for (Figurka fig : figurky) {
                if (fig.getTyp() != typ) {
                    if (fig.isDanger(x, y)) {
                        return false;
                    }
                }
            }
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
            }
        }
        return false;
    }

    @Override
    public void moznostiPohybu() {
        if (this.canMove(pozX, pozY + 1)) {
            this.p[this.pozX][this.pozY + 1].vysviet();
        }

        if (this.canMove(pozX, pozY - 1)) {
            this.p[this.pozX][this.pozY - 1].vysviet();
        }

        if (this.canMove(pozX + 1, pozY)) {
            this.p[this.pozX + 1][this.pozY].vysviet();
        }

        if (this.canMove(pozX - 1, pozY)) {
            this.p[this.pozX - 1][this.pozY].vysviet();
        }

        if (this.canMove(pozX - 1, pozY - 1)) {
            this.p[this.pozX - 1][this.pozY - 1].vysviet();
        }

        if (this.canMove(pozX - 1, pozY + 1)) {
            this.p[this.pozX - 1][this.pozY + 1].vysviet();
        }

        if (this.canMove(pozX + 1, pozY + 1)) {
            this.p[this.pozX + 1][this.pozY + 1].vysviet();
        }

        if (this.canMove(pozX + 1, pozY - 1)) {
            this.p[this.pozX + 1][this.pozY - 1].vysviet();
        }
        /* if (this.isOnMap(this.pozX, this.pozY + 1)) {
            if (p[this.pozX][this.pozY + 1].isIsEmpty()) {
                this.p[this.pozX][this.pozY + 1].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX][this.pozY + 1].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX][this.pozY + 1].vysviet();
                        }
                    }
                }
            }
        }

        if (this.isOnMap(this.pozX, this.pozY + (-1))) {
            if (p[this.pozX][this.pozY + (-1)].isIsEmpty()) {
                this.p[this.pozX][this.pozY + (-1)].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX][this.pozY + (-1)].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX][this.pozY + (-1)].vysviet();
                        }
                    }
                }
            }
        }

        if (this.isOnMap(this.pozX + 1, this.pozY)) {
            if (p[this.pozX + 1][this.pozY].isIsEmpty()) {
                this.p[this.pozX + 1][this.pozY].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX + 1][this.pozY].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX + 1][this.pozY].vysviet();
                        }
                    }
                }
            }
        }

        if (this.isOnMap(this.pozX + (-1), this.pozY)) {
            if (p[this.pozX + (-1)][this.pozY].isIsEmpty()) {
                this.p[this.pozX + (-1)][this.pozY].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX + (-1)][this.pozY].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX + (-1)][this.pozY].vysviet();
                        }
                    }
                }
            }
        }

        if (this.isOnMap(this.pozX + (-1), this.pozY + 1)) {
            if (p[this.pozX + (-1)][this.pozY + 1].isIsEmpty()) {
                this.p[this.pozX + (-1)][this.pozY + 1].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX + (-1)][this.pozY + 1].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX + (-1)][this.pozY + 1].vysviet();
                        }
                    }
                }
            }
        }

        if (this.isOnMap(this.pozX + (-1), this.pozY + (-1))) {
            if (p[this.pozX + (-1)][this.pozY + (-1)].isIsEmpty()) {
                this.p[this.pozX + (-1)][this.pozY + (-1)].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX + (-1)][this.pozY + (-1)].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX + (-1)][this.pozY + (-1)].vysviet();
                        }
                    }
                }
            }
        }

        if (this.isOnMap(this.pozX + 1, this.pozY + 1)) {
            if (p[this.pozX + 1][this.pozY + 1].isIsEmpty()) {
                this.p[this.pozX + 1][this.pozY + 1].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX + 1][this.pozY + 1].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX + 1][this.pozY + 1].vysviet();
                        }
                    }
                }
            }
        }

        if (this.isOnMap(this.pozX + 1, this.pozY + (-1))) {
            if (p[this.pozX + 1][this.pozY + (-1)].isIsEmpty()) {
                this.p[this.pozX + 1][this.pozY + (-1)].vysviet();
            } else {
                for (Figurka fig : figurky) {
                    if (fig.getRectangle().intersects(p[this.pozX + 1][this.pozY + (-1)].getBones())) {
                        if (fig.getTyp() != typ) {
                            this.p[this.pozX + 1][this.pozY + (-1)].vysviet();
                        }
                    }
                }
            }
        }*/
    }

    public boolean isSach() {
        if (this.typ == -1) {
            if (p[pozX][pozY].isDanger()) {
                System.out.println("sach cierny");
                return true;
            }
        } else {
            if (p[pozX][pozY].isDanger()) {
                System.out.println("sach biely");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isDanger(int x, int y) {
        /*if (this.typ == 1) {
            if (p[pozX][pozY].isDangerW()) {
                return true;
            } 
        } else {
            if(p[pozX][pozY].isDangerW()) {
                return true;
            } 
        }*/
        return false;

    }

    @Override
    public boolean canCapture(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean canMoveSach(int x, int y) {
        if (this.isOnMap(x, y)) {
            for (Figurka fig : figurky) {
                if (fig.getTyp() != typ) {
                    if (fig.isDanger(x, y)) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean mat() {
        if (isSach()) {
            System.out.println("sss");
            if (this.canMoveSach(pozX, pozY + 1)) {
                return false;
            }
            System.out.println("s11");
            if (this.canMoveSach(pozX, pozY - 1)) {
                return false;
            }
            System.out.println("s12");
            if (this.canMoveSach(pozX + 1, pozY)) {
                return false;
            }
            System.out.println("s13");
            if (this.canMoveSach(pozX - 1, pozY)) {
                return false;
            }
            System.out.println("s14");
            if (this.canMoveSach(pozX - 1, pozY - 1)) {
                return false;
            }
            System.out.println("s14");
            if (this.canMoveSach(pozX - 1, pozY + 1)) {
                return false;
            }
            System.out.println("s15");
            if (this.canMoveSach(pozX + 1, pozY + 1)) {
                return false;
            }
            System.out.println("s16");
            if (this.canMoveSach(pozX + 1, pozY - 1)) {
                return false;
            }
            System.out.println("mmm");
            return true;
        }
        return false;
    }

}
