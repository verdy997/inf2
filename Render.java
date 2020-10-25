/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sach;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author pc
 */
public class Render extends JPanel implements MouseListener, KeyListener {

    private Sachovnica sach;
    private ArrayList<Figurka> figurky;
    //private Pawn pawn;
    private Rook rook;
    private Bishop bishop;
    private Knight knight;
    private King king;
    private Queen queen;
    private int oznacenaFigurka;
    private int tah;
    private String filePath;

    public Render(String filePath) {
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(790, 790));
        sach = new Sachovnica(100);
        sach.nacitajSachovnicu();
        figurky = new ArrayList();
        this.tah = 1;
        this.filePath = filePath;
        
       /* king = new King(4, 0, 1, sach.getSach(), figurky);
        figurky.add(king);

        king = new King(4, 7, -1, sach.getSach(), figurky);
        figurky.add(king);

        knight = new Knight(1, 7, -1, sach.getSach(), figurky);
        figurky.add(knight);

        knight = new Knight(6, 7, -1, sach.getSach(), figurky);
        figurky.add(knight);

        knight = new Knight(1, 0, 1, sach.getSach(), figurky);
        figurky.add(knight);

        knight = new Knight(6, 0, 1, sach.getSach(), figurky);
        figurky.add(knight);

        this.rook = new Rook(7, 0, 1, sach.getSach(), figurky);
        figurky.add(rook);

        this.rook = new Rook(0, 0, 1, sach.getSach(), figurky);
        figurky.add(rook);

        this.rook = new Rook(7, 7, -1, sach.getSach(), figurky);
        figurky.add(rook);

        this.rook = new Rook(0, 7, -1, sach.getSach(), figurky);
        figurky.add(rook);

        this.queen = new Queen(3, 0, 1, sach.getSach(), figurky);
        figurky.add(queen);

        this.queen = new Queen(3, 7, -1, sach.getSach(), figurky);
        figurky.add(queen);

        this.bishop = new Bishop(2, 0, 1, sach.getSach(), figurky);
        //this.bishop = new Bishop(4, 5, 1, sach.getSach(), figurky);
        figurky.add(bishop);

        this.bishop = new Bishop(5, 0, 1, sach.getSach(), figurky);
        figurky.add(bishop);

        this.bishop = new Bishop(2, 7, -1, sach.getSach(), figurky);
        figurky.add(bishop);

        this.bishop = new Bishop(5, 7, -1, sach.getSach(), figurky);
        figurky.add(bishop);

        for (int i = 0; i < 8; i++) {
            figurky.add(new Pawn(i, 6, -1, sach.getSach(), figurky));
            figurky.add(new Pawn(i, 1, 1, sach.getSach(), figurky));
        }

        for (Figurka figurka : figurky) {
            sach.getSach()[figurka.getPozX()][figurka.getPozY()].setIsEmpty(false);
        }*/
        //this.saveBin();
        this.loadBin();
    }

    public void paintComponent(Graphics g) {

        Graphics g2 = (Graphics) g;
        sach.draw((Graphics2D) g2);

        for (Figurka pawnW : figurky) {
            pawnW.Vykresli(g);
        }
    }

    public void zhasniVsetky() {
        for (int i = 0; i < sach.getSach().length; i++) {
            for (int j = 0; j < sach.getSach()[i].length; j++) {
                sach.getSach()[i][j].zhasni();
            }
        }
    }

    public void odznacVsetky() {
        for (int i = 0; i < sach.getSach().length; i++) {
            for (int j = 0; j < sach.getSach()[i].length; j++) {
                sach.getSach()[i][j].odznac();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == 1) {
            for (int i = 0; i < figurky.size(); i++) {
                if (figurky.get(i).getRectangle().contains(e.getPoint()) && this.tah == figurky.get(i).getTyp()) {
                    zhasniVsetky();
                    figurky.get(i).moznostiPohybu();
                    oznacenaFigurka = i;
                    repaint();

                }
            }
        }
        if (e.getButton() == 3) {

            for (int i = 0; i < sach.getSach().length; i++) {
                for (int j = 0; j < sach.getSach()[i].length; j++) {

                    if (sach.getSach()[i][j].getBones().contains(e.getPoint()) && sach.getSach()[i][j].isIsVysvieteny()) {
                        int remove = -1;
                        for (int f = 0; f < figurky.size(); f++) {
                            if (figurky.get(f).getRectangle().intersects(sach.getSach()[i][j].getBones())) {
                                remove = f;
                            }
                        }

                        sach.getSach()[figurky.get(oznacenaFigurka).getPozX()][figurky.get(oznacenaFigurka).getPozY()].setIsEmpty(true);
                        figurky.get(oznacenaFigurka).setPozX(i);
                        figurky.get(oznacenaFigurka).setPozY(j);
                        if (figurky.get(oznacenaFigurka) instanceof Pawn) {
                            Pawn p = (Pawn) figurky.get(oznacenaFigurka);
                            p.bolPrvyTah();
                        }
                        sach.getSach()[figurky.get(oznacenaFigurka).getPozX()][figurky.get(oznacenaFigurka).getPozY()].setIsEmpty(false);
                        zhasniVsetky();
                        if (remove != -1) {
                            figurky.remove(remove);
                        }

                        this.odznacVsetky();

                        for (Figurka figurka : figurky) {
                            if (figurka.getTyp() == 1) {
                                for (Figurka figurka1 : figurky) {
                                    if (figurka1 instanceof King) {
                                        King k = (King) figurka1;
                                        if (k.getTyp() == -1) {
                                            if (figurka.isDanger(k.getPozX(), k.getPozY()));
                                        }
                                    }
                                }
                            } else {
                                for (Figurka figurka1 : figurky) {
                                    if (figurka1 instanceof King) {
                                        King k = (King) figurka1;
                                        if (k.getTyp() == 1) {
                                            if (figurka.isDanger(k.getPozX(), k.getPozY()));
                                        }
                                    }
                                }

                            }
                        }
                        isMat();

                        this.tah *= -1;
                        repaint();
                    }
                }
            }

        }
    }

    /* public void isMat(){
        if(king.)
    }*/
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void saveBin() {
        File file = new File("Sach.bin");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            SaveData sd = new SaveData();
            sd.setSach(sach);
            sd.setFigurky(figurky);
            sd.setTah(tah);
            oos.writeObject(sd);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Render.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Render.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadBin() {
        File file = new File(filePath + ".bin");
        FileInputStream fos;
        try {
            fos = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fos);
            SaveData sd = new SaveData();
            sd = (SaveData) ois.readObject();
            this.figurky = sd.getFigurky();
            this.tah = sd.getTah();
            this.sach = sd.getSach();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Render.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Render.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Render.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void isMat() {
        for (Figurka figurka : figurky) {
            if (figurka instanceof King) {
                King k = (King) figurka;
                if (k.mat()) {
                    System.out.println("mat");
                    if (k.getTyp() == 1) {
                        System.out.println("MAT biely");
                        } else {
                        System.out.println("MAT cierny");
                    } 
                    
                }
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("ulozene");
        if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("ulozene");
            this.saveBin();
        }
    }

}
