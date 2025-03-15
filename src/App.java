import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        int rowCount = 21;
        int colCount = 19;

        int tileSize = 32;
        int boardWidth = colCount * tileSize;
        int boardHeight = rowCount * tileSize;

        JFrame frame = new JFrame("Pacman");

        // frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(boardWidth, boardHeight);

        Pacman pacmangame = new Pacman();
        frame.add(pacmangame);
        frame.pack();
        frame.setVisible(true);

    }
}
