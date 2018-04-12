import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * An L-Shape piece in the Tetris Game.
 *
 * This piece is made up of 4 squares in the following configuration:
 *
 * Sq <br> Sq <br> Sq Sq <br>
 *
 * The game piece "floats above" the Grid. The (row, col) coordinates are the location of the middle
 * Square on the side within the Grid
 *
 * @author CSC 143
 */
public class LShape {

  // number of squares in one Tetris game piece
  private static final int PIECE_COUNT = 4;
  private boolean ableToMove; // can this piece move
  private Square[] square; // the squares that make up this piece
  // Made up of PIECE_COUNT squares
  private Grid grid; // the board this piece is on

  /**
   * Creates an L-Shape piece. See class description for actual location of r and c
   *
   * @param row row location for this piece
   * @param col column location for this piece
   * @param grid the grid for this game piece
   */
  public LShape(int row, int col, Grid grid) {
    this.grid = grid;
    square = new Square[PIECE_COUNT];
    ableToMove = true;

    // Create the squares
    square[0] = new Square(grid, row - 1, col, Color.magenta, true);
    square[1] = new Square(grid, row, col, Color.magenta, true);
    square[2] = new Square(grid, row + 1, col, Color.magenta, true);
    square[3] = new Square(grid, row + 1, col + 1, Color.magenta, true);
  }

  /**
   * Draws the piece on the given Graphics context
   */
  public void draw(Graphics g) {
    for (int i = 0; i < PIECE_COUNT; i++) {
      square[i].draw(g);
    }
  }

  /**
   * Moves the piece if possible Freeze the piece if it cannot move down anymore
   *
   * @param command the direction to move
   */
  public void move(Commands command) {
    if (canMove(command)) {
      if (command == Commands.FAST_DROP) {
        while (canMove(command)) {
          for (int i = 0; i < PIECE_COUNT; i++) {
            square[i].move(Commands.DOWN);
          }
        }
      } else {
        for (int i = 0; i < PIECE_COUNT; i++) {
          square[i].move(command);
        }
      }
      // if we couldn't move, see if because we're at the bottom
    } else if (command == Commands.DOWN) {
      ableToMove = false;
    }
  }

  /**
   * Returns the (row,col) grid coordinates occupied by this Piece
   *
   * @return an Array of (row,col) Points
   */
  public Point[] getLocations() {
    Point[] points = new Point[PIECE_COUNT];
    for (int i = 0; i < PIECE_COUNT; i++) {
      points[i] = new Point(square[i].getRow(), square[i].getCol());
    }
    return points;
  }

  public Square[] getSquare() {
    return square;
  }

  /**
   * Return the color of this piece
   */
  public Color getColor() {
    // all squares of this piece have the same color
    return square[0].getColor();
  }

  /**
   * Returns if this piece can move in the given direction
   */
  public boolean canMove(Commands command) {
    if (!ableToMove) {
      return false;
    }

    // Each square must be able to move in that direction
    for (int i = 0; i < PIECE_COUNT; i++) {
      if (!square[i].canMove(command)) {
        return false;
      }
    }
    return true;
  }
}
