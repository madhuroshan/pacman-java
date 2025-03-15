import java.awt.*;
import javax.swing.*;

public class Pacman extends JPanel {

    private int rowCount = 21;
    private int colCount = 19;
    private int tileSize = 32;
    private int boardWidth = colCount * tileSize;
    private int boardHeight = rowCount * tileSize;

    private Image wallImage;
    private Image blueGhostImage;
    private Image orangeGhostImage;
    private Image redGhostImage;
    private Image pinkGhostImage;

    private Image pacmanUpImage;
    private Image pacmanDownImage;
    private Image pacmanLeftImage;
    private Image pacmanRightImage;



    Pacman() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);


        // load images
        wallImage = new ImageIcon(getClass().getResource("assets/wall.png")).getImage();
        blueGhostImage = new ImageIcon(getClass().getResource("assets/blueGhost.png")).getImage();
        orangeGhostImage = new ImageIcon(getClass().getResource("assets/orangeGhost.png")).getImage();
        redGhostImage = new ImageIcon(getClass().getResource("assets/redGhost.png")).getImage();
        pinkGhostImage = new ImageIcon(getClass().getResource("assets/pinkGhost.png")).getImage();

        pacmanUpImage = new ImageIcon(getClass().getResource("assets/pacmanUp.png")).getImage();
        pacmanDownImage = new ImageIcon(getClass().getResource("assets/pacmanDown.png")).getImage();
        pacmanLeftImage = new ImageIcon(getClass().getResource("assets/pacmanLeft.png")).getImage();
        pacmanRightImage = new ImageIcon(getClass().getResource("assets/pacmanRight.png")).getImage();

        


    }
}
