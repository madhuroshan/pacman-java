import java.awt.*;
import java.util.HashSet;
import javax.swing.*;

public class Pacman extends JPanel {

    class Block {
        int x;
        int y;

        int width;
        int height;

        Image image;

        int startX;
        int startY;

        Block(int x, int y, int width, int height, Image image) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.image = image;

            this.startX = x;
            this.startY = y;
        }
    }

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

    HashSet<Block> foods;
    HashSet<Block> walls;
    HashSet<Block> ghosts;
    Block pacman;

    private String[] tileMap = {
        "XXXXXXXXXXXXXXXXXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X                 X",
        "X XX X XXXXX X XX X",
        "X    X       X    X",
        "XXXX XXXX XXXX XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXrXX X XXXX",
        "O       bpo       O",
        "XXXX X XXXXX X XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXXXX X XXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X  X     P     X  X",
        "XX X X XXXXX X X XX",
        "X    X   X   X    X",
        "X XXXXXX X XXXXXX X",
        "X                 X",
        "XXXXXXXXXXXXXXXXXXX" 
    };


    Pacman() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);


        // load images
        wallImage = new ImageIcon(getClass().getResource("../assets/wall.png")).getImage();
        blueGhostImage = new ImageIcon(getClass().getResource("../assets/blueGhost.png")).getImage();
        orangeGhostImage = new ImageIcon(getClass().getResource("../assets/orangeGhost.png")).getImage();
        redGhostImage = new ImageIcon(getClass().getResource("../assets/redGhost.png")).getImage();
        pinkGhostImage = new ImageIcon(getClass().getResource("../assets/pinkGhost.png")).getImage();

        pacmanUpImage = new ImageIcon(getClass().getResource("assets/pacmanUp.png")).getImage();
        pacmanDownImage = new ImageIcon(getClass().getResource("assets/pacmanDown.png")).getImage();
        pacmanLeftImage = new ImageIcon(getClass().getResource("assets/pacmanLeft.png")).getImage();
        pacmanRightImage = new ImageIcon(getClass().getResource("assets/pacmanRight.png")).getImage();

        loadMap();
        System.out.println("Pacman created");
        System.out.println(walls.size());
        System.out.println(ghosts.size());
        System.out.println(foods.size());

    }

    public void loadMap() {
        walls = new HashSet<Block>();
        ghosts = new HashSet<Block>();
        foods = new HashSet<Block>();

        for(int row=0;row<rowCount;row++) {
            for(int col=0;col<colCount;col++) {
                
                String rowString = tileMap[row];
                char blockType = rowString.charAt(col);

                int x = col * tileSize;
                int y = row * tileSize;

                switch (blockType) {
                    case 'X' -> {
                        Block wall = new Block(x, y, tileSize, tileSize, wallImage);
                        walls.add(wall);
                    }
                    case 'b' -> {
                        Block blueGhost = new Block(x, y, tileSize, tileSize, blueGhostImage);
                        ghosts.add(blueGhost);
                    }
                    case 'o' -> {
                        Block orangeGhost = new Block(x, y, tileSize, tileSize, orangeGhostImage);
                        ghosts.add(orangeGhost);
                    }
                    case 'r' -> {
                        Block redGhost = new Block(x, y, tileSize, tileSize, redGhostImage);
                        ghosts.add(redGhost);
                    }
                    case 'p' -> {
                        Block pinkGhost = new Block(x, y, tileSize, tileSize, pinkGhostImage);
                        ghosts.add(pinkGhost);
                    }
                    case 'P' -> pacman = new Block(x, y, tileSize, tileSize, pacmanRightImage);
                    case ' ' -> {
                        Block food = new Block(x+14, y+14, 4, 4, null);
                        foods.add(food);
                    }
                }
            }
        }
    }
}
