
public class BombSquare extends GameSquare {
    private GameBoard board; // Object reference to the GameBoard this square is part of.
    private boolean hasBomb; // True if this squre contains a bomb. False otherwise.
    private boolean flagged;
    public static final int MINE_PROBABILITY = 10;
    boolean[][] grid = new boolean[30][30];
    public int bomb;

    public BombSquare(int x, int y, GameBoard board) {
        super(x, y, "images/blank.png");
        this.board = board;
        this.hasBomb = ((int) (Math.random() * MINE_PROBABILITY)) == 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                grid[i][j] = false;
                // hide all sqaures
            }
        }

    }

    // Click reveals map. (Test)
    // Click on square - detect which one (action listener and scan the board0)
    // Logic is done on the reveal - 1. Open more empty spaces. 2. Just show a
    // Numbered block. 3 Show bomb = game over
    // If bomb next to square show number.

    public void rightClicked() {
        if (flagged == false) {
            this.setImage("flag.png");
            flagged = true;
        } else if (flagged == true) {
            this.setImage("blank.png");
            flagged = false;
        }
        // can use for win condition. if all bombs flag == win.
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                BombSquare a = (BombSquare) board.getSquareAt(i, j);
            }
        }
    }

    public void leftClicked() {
        if (hasBomb == true) {
            this.setImage("bomb.png");
        } else {
            this.setImage("0.png");
            recursion(this.getXLocation(), this.getYLocation());
        }
        if (hasBomb == true) {
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 30; j++) {
                    BombSquare a = (BombSquare) board.getSquareAt(i, j);
                    if (a.hasBomb == true) {
                        a.setImage("bomb.png");
                    }
                }
            }
        }
    }

    public void recursion(int x, int y) {

        BombSquare clicked = (BombSquare) board.getSquareAt(x, y);
        if (clicked.hasBomb == false) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    BombSquare a = (BombSquare) board.getSquareAt(i, j);

                    // 1. take square clicked. 2. check 9 surrounding tiles. 3. If the tiles has x
                    // amount of bomb change to right picture else go blank.
                }
            }
        }
    }

}
