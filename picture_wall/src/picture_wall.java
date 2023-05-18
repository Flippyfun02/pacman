import java.awt.*;
import javax.swing.JFrame;import java.io.File;
import javax.imageio.ImageIO;

public class picture_wall extends Canvas {

    Image Daenerys, Love_Quinn, Blair_Waldorf, Sheldon, Taylor_Swift;
    picture_wall() throws Exception {
        Daenerys = ImageIO.read(new File("/Users/amiebinan/Desktop/Java/picture_wall/src/daenerys.jpg"));
        Love_Quinn = ImageIO.read(new File("/Users/amiebinan/Desktop/Java/picture_wall/src/love_quinn.jpg"));
        Blair_Waldorf = ImageIO.read(new File("/Users/amiebinan/Desktop/Java/picture_wall/src/blair_waldorf.jpg"));
        Sheldon = ImageIO.read(new File("/Users/amiebinan/Desktop/Java/picture_wall/src/sheldon.jpg"));
        Taylor_Swift = ImageIO.read(new File("/Users/amiebinan/Desktop/Java/picture_wall/src/taylor_swift.jpg"));
    }

    public void paint (Graphics g) {

        // Resize images
        Daenerys = Daenerys.getScaledInstance(135,200, java.awt.Image.SCALE_SMOOTH);
        Blair_Waldorf = Blair_Waldorf.getScaledInstance(150,200, java.awt.Image.SCALE_SMOOTH);
        Love_Quinn = Love_Quinn.getScaledInstance(165,260, java.awt.Image.SCALE_SMOOTH);
        Sheldon = Sheldon.getScaledInstance(126,240, java.awt.Image.SCALE_SMOOTH);
        Taylor_Swift = Taylor_Swift.getScaledInstance(256, 144, java.awt.Image.SCALE_SMOOTH);

        // Daenerys
        g.setColor(new Color(97, 74, 62));
        g.fillRect(60, 135, 165, 230);
        g.drawImage(Daenerys, 75, 150, this);

        //Blair Waldorf
        g.setColor(new Color(230, 185, 5));
        g.fillRect(260, 25, 180, 230);
        g.drawImage(Blair_Waldorf, 275, 40, this);

        // Love Quinn
        g.setColor(new Color(186, 20, 98));
        g.fillRect(475, 60 ,195, 290);
        g.drawImage(Love_Quinn, 490, 75, this);

        // Sheldon
        g.setColor(new Color(81, 10, 102));
        g.fillRect(250, 290, 156, 270);
        g.drawImage(Sheldon, 265, 305, this);

        // Taylor Swift
        g.setColor(new Color(140, 3, 3));
        g.fillRect(435, 375, 286, 174);
        g.drawImage(Taylor_Swift, 450, 390, this);
    }
    public static void main(String[] args) throws Exception {
        JFrame window = new JFrame("Picture Wall");
        window.setSize(800, 600);
        picture_wall canvas = new picture_wall();
        window.add(canvas);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
