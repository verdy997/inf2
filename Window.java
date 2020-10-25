
package sach;

import javax.swing.JFrame;

/**
 *
 * @author pc
 */
public class Window extends JFrame{
    private int w, h;
    
    public Window(String title, int width, int height, String path){
        Render ren = new Render(path);
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(width, height);
        this.add(ren);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        
    }
}
