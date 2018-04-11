import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the Tetris board represented by a (HEIGHT - by - WIDTH) matrix of Squares.
 * <p>
 * The upper left Square is at (0,0). The lower right Square is at (HEIGHT -1, WIDTH -1).
 * <p>
 * Given a Square at (x,y) the square to the left is at (x-1, y) the square below is at (x, y+1)
 * <p>
 * Each Square has a color. A white Square is EMPTY; any other color means that spot is occupied
 * (i.e. a piece cannot move over/to an occupied square). A grid will also remove completely full
 * rows.
 *
 * @author CSC 143
 */
public class Grid {

  // Width and Height of Grid in number of squares
  public static final int HEIGHT = 20;
  public static final int WIDTH = 10;
  public static final int LEFT = 100; // pixel position of left of grid
  public static final int TOP = 50; // pixel position of top of grid
  public static final Color EMPTY = Color.WHITE;
  private static final int BORDER = 5;
  private Square[][] board;

  /**
   * Creates the grid
   */
  public Grid() {
    board = new Square[HEIGHT][WIDTH];

    // put squares in the board
    for (int row = 0; row < HEIGHT; row++) {
      for (int col = 0; col < WIDTH; col++) {
        board[row][col] = new Square(this, row, col, EMPTY, false);

      }
    }

  }

  /**
   * Returns true if the location (row, col) on the grid is occupied
   *
   * @param row the row in the grid
   * @param col the column in the grid
   */
  public boolean isSet(int row, int col) {
    return !board[row][col].getColor().equals(EMPTY);
  }

  /**
   * Changes the color of the Square at the given location
   *
   * @param row the row of the Square in the Grid
   * @param col the column of the Square in the Grid
   * @param c the color to set the Square
   * @throws IndexOutOfBoundsException if row < 0 || row>= HEIGHT || col < 0 || col >= WIDTH
   */
  public void set(int row, int col, Color c) {
    board[row][col].setColor(c);
  }

  /**
   * Checks for and remove all solid rows of squares.
   * <p>
   * If a solid row is found and removed, all rows above it are moved down and the top row set to
   * empty
   */
  public void checkRows() {
    for (int i = 0; i < board.length; i++) {
      if (rowIsFull(i)) {
        removeRow(i);
        for (int j = i; j > 0; j--) {
          if (rowIsEmpty(j)) {
            swapRows(j, j - 1);
          }
        }
      }
    }
  }


  /**
   * Checks if the given row is full.
   *
   * @param row the row to check in the grid
   * @return returns true if the row is full
   */
  private boolean rowIsFull(int row) {
    for (int i = 0; i < board[row].length; i++) {
      if (!this.isSet(row, i)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks if the given row is empty.
   *
   * @param row the row to check in the grid
   * @return returns true if the row is empty
   */
  private boolean rowIsEmpty(int row) {
    for (int i = 0; i < board[row].length; i++) {
      if (this.isSet(row, i)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Sets all of the squares in the given row to empty color.
   *
   * @param row the row of squares to remove
   */
  private void removeRow(int row) {
    for (Square square :
        board[row]) {
      square.setColor(EMPTY);
    }
  }

  /**
   * Swaps the colors of each square in two rows
   *
   * @param row1 the first row to swap
   * @param row2 the second row to swap
   */
  private void swapRows(int row1, int row2) {
    Color[] rowColors = new Color[board[row1].length];

    for (int i = 0; i < board[row1].length; i++) {
      rowColors[i] = board[row1][i].getColor();
      board[row1][i].setColor(board[row2][i].getColor());
    }

    for (int i = 0; i < board[row2].length; i++) {
      board[row2][i].setColor(rowColors[i]);
    }

  }


  /**
   * Draws the grid on the given Graphics context
   */
  public void draw(Graphics g) {

    // draw the edges as rectangles: left, right in blue then bottom in red
    g.setColor(Color.BLUE);
    g.fillRect(LEFT - BORDER, TOP, BORDER, HEIGHT * Square.HEIGHT);
    g.fillRect(LEFT + WIDTH * Square.WIDTH, TOP, BORDER, HEIGHT
        * Square.HEIGHT);
    g.setColor(Color.RED);
    g.fillRect(LEFT - BORDER, TOP + HEIGHT * Square.HEIGHT, WIDTH
        * Square.WIDTH + 2 * BORDER, BORDER);

    // draw all the squares in the grid
    // empty ones first (to avoid masking the black lines of the pieces that
    // have already fallen)
    for (int r = 0; r < HEIGHT; r++) {
      for (int c = 0; c < WIDTH; c++) {
        if (board[r][c].getColor().equals(EMPTY)) {
          board[r][c].draw(g);
        }
      }
    }
    for (int r = 0; r < HEIGHT; r++) {
      for (int c = 0; c < WIDTH; c++) {
        if (!board[r][c].getColor().equals(EMPTY)) {
          board[r][c].draw(g);
        }
      }
    }
  }
}
