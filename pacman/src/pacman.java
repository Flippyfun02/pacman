import java.awt.*;
import javax.swing.JFrame;

public class pacman extends Canvas {

    public void draw_ghost(Graphics g, int posx, int y)
    {
        g.setColor(Color.RED);
        g.fillArc(posx, 200, 87, 100, 0, 180);
        // eyes
        g.setColor(Color.WHITE);
        g.fillArc(posx + 19, 230, 20, 20, 0, 360);
        g.fillArc(posx + 48, 230, 20, 20, 0, 360);
        g.setColor(Color.BLACK);
        g.fillArc(posx + 22,236, 13, 13, 0, 360);
        g.fillArc(posx + 51,236, 13, 13, 0, 360);    

        g.setColor(Color.RED);
        if (y > 0)
        {
            g.setColor(Color.RED);
            g.fillRect(posx, 250,87, 50 - 16);
            for (int z = 0; z < 3; z++)
            {
                for (int x = 0; x < 15; x++)
                {
                    g.fillRect(posx + x + z*29, 300 - 16, 1, 1+x);
                }
                for (int x = 0; x < 16; x++)
                {
                    g.fillRect(posx + 15 + x + z*29, 300 - 16, 1, 14 - x);
                }
            }
        }
        
        else
        {
            g.setColor(Color.RED);
            g.fillRect(posx, 250,87, 50);
            g.setColor(Color.BLACK);
            for (int z = 0; z < 3; z++)
            {
                for (int x = 0; x < 15; x++)
                {
                    g.fillRect(posx + x + z*29, 299 - x, 1, 1+x);
                }
                for (int x = 0; x < 16; x++)
                {
                    g.fillRect(posx + 15 + x + z*29, 286 + x, 1, 14 - x);
                }
            }
        } 
    }

    public void paint(Graphics g)
    {
        // g.fillRect(0, 0, 800, 600); // background
        int y = 1;
        for (int i = 0; i < 200; i++)
        {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 800, 600); // background
            
            
            g.setColor(Color.WHITE);
            for (int a = 0; a < 6; a++)
            {
                g.fillArc(650 - a*100, 245, 10, 10, 0, 360);
            }
            
            
            g.setColor(Color.BLACK);
            g.fillRect(100, 200, 50 + i, 100);

            if (i % 10 == 0)
                y *= -1;

            // draw pacman
            g.setColor(Color.YELLOW);
            if (y > 0)
                g.fillArc(100 + i, 200, 100, 100, 30, 295);
            else
                g.fillArc(100 + i, 200, 100, 100, 40, 270);

            // draw ghost
            draw_ghost(g, 500 - i, y);

            try {
                Thread.sleep(40);
            }
            catch(InterruptedException e) {}
        }
        // pacman dies
        for (int i = 0; i < 181; i += 2)
        {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 400, 600); // background

            g.setColor(Color.YELLOW);
            g.fillArc(300, 200, 100, 100, 90 + i, 180 - i);
            g.fillArc(300, 200, 100, 100, 270, 180-i);

            try {
                Thread.sleep(40);
            }
            catch(InterruptedException e) {}
        }
        
    }
    public static void main (String[] args)
    {
        JFrame win = new JFrame("Pacman");
        win.setSize(800, 600);
        pacman canvas = new pacman();
        win.add(canvas);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}