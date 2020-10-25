package sach;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author pc
 */
public class Queen extends Figurka {

    public Queen(int pozX, int pozY, int typ, Policko[][] p, ArrayList<Figurka> figurky) {
        super(pozX, pozY, typ, p, figurky);
        if (this.typ == 1) {
            image = new ImageIcon(this.getClass().getResource("/images/Queen_w.png"));
        } else {
            image = new ImageIcon(this.getClass().getResource("/images/Queen_b.png"));
        }
    }

    @Override
    public boolean canMove(int x, int y) {
        if (this.isOnMap(x, y)) {
            for (int i = 1; i < p.length; i++) {
                if (((pozX + i == x || pozX - i == x) && (pozY == y
                        || pozY + i == y || pozY - i == y))
                        || (pozX == x && pozY + i == y || pozY - i == y)) {
                    if (p[x][y].isIsEmpty()) {
                        return true;
                    } else {
                        for (Figurka fig : figurky) {
                            if (fig.getRectangle().intersects(p[x][y].getBones())) {
                                if (fig.getTyp() != typ) {
                                    this.stop = true;
                                    return true;
                                }
                                return false;
                            }
                            // return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean canCapture(int x, int y) {
        if (this.isOnMap(x, y)) {
            for (int i = 1; i < p.length; i++) {
                if (((pozX + i == x || pozX - i == x) && (pozY == y
                        || pozY + i == y || pozY - i == y))
                        || (pozX == x && pozY + i == y || pozY - i == y)) {
                    if (p[x][y].isIsEmpty()) {
                        return true;
                    } else {
                        for (Figurka fig : figurky) {
                            if (fig.getRectangle().intersects(p[x][y].getBones())) {
                                if (fig instanceof King) {
                                    return true;
                                } else {
                                    this.stop = true;
                                    return true;
                                }
                            }
                            this.stop = true;
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
        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canCapture(pozX + i, pozY)) {
                    if (x == pozX + i && y == pozY) {
                        p[x][y].setDanger(true);
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canCapture(pozX - i, pozY)) {
                    if (x == pozX - i && y == pozY) {
                        p[x][y].setDanger(true);
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canCapture(pozX, pozY - i)) {
                    if (x == pozX && y == pozY - i) {
                        p[x][y].setDanger(true);
                        return true;
                    }
                } else {
                    break;
                }
            }
        }

        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canCapture(pozX, pozY + i)) {
                    if (x == pozX && y == pozY + i) {
                        p[x][y].setDanger(true);
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        
        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canCapture(pozX + i, pozY + i)) {
                    if (x == pozX + i && y == pozY + i) {
                        p[x][y].setDanger(true);
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        
        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canCapture(pozX - i, pozY + i)) {
                    if (x == pozX - i && y == pozY + i) {
                        p[x][y].setDanger(true);
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        
        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canCapture(pozX + i, pozY - i)) {
                    if (x == pozX + i && y == pozY - i) {
                        p[x][y].setDanger(true);
                        return true;
                    }
                } else {
                    break;
                }
            }
        }

        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canCapture(pozX - i, pozY - i)) {
                    if (x == pozX - i && y == pozY - i) {
                        p[x][y].setDanger(true);
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }

    @Override
    public void moznostiPohybu() {
        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canMove(pozX + i, pozY)) {
                    this.p[this.pozX + i][this.pozY].vysviet();
                } else {
                    break;
                }
            }
        }
        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canMove(pozX - i, pozY)) {
                    this.p[this.pozX - i][this.pozY].vysviet();
                } else {
                    break;
                }
            }
        }
        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canMove(pozX, pozY + i)) {
                    this.p[this.pozX][this.pozY + i].vysviet();
                } else {
                    break;
                }
            }
        }
        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canMove(pozX, pozY - i)) {
                    this.p[this.pozX][this.pozY - i].vysviet();
                } else {
                    break;
                }
            }
        }
        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canMove(pozX + i, pozY + i)) {
                    this.p[this.pozX + i][this.pozY + i].vysviet();
                } else {
                    break;
                }
            }
        }
        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canMove(pozX - i, pozY + i)) {
                    this.p[this.pozX - i][this.pozY + i].vysviet();
                } else {
                    break;
                }
            }
        }
        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canMove(pozX + i, pozY - i)) {
                    this.p[this.pozX + i][this.pozY - i].vysviet();
                } else {
                    break;
                }
            }
        }
        stop = false;
        for (int i = 1; i < p.length; i++) {
            if (!this.stop) {
                if (this.canMove(pozX - i, pozY - i)) {
                    this.p[this.pozX - i][this.pozY - i].vysviet();
                } else {
                    break;
                }
            }
        }
    }

}
