import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractPiece implements Piece {

  // number of squares in one Tetris game piece
  private static final int PIECE_COUNT = 4;
  final Square[] square; // the squares that make up this piece
  final Grid grid; // the board this piece is on
  private boolean ableToMove; // can this piece move

  AbstractPiece(Grid grid) {
    this.grid = grid;
    square = new Square[PIECE_COUNT];
    ableToMove = true;
  }

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
  @Override
  public void move(Commands command) {
    if (canMove(command)) {
      if (command == Commands.FAST_DROP) {
        while (canMove(command)) {
          for (int i = 0; i < PIECE_COUNT; i++) {
            square[i].move(Commands.DOWN);
          }
        }
      } else if (command == Commands.ROTATE) {
        this.rotatePiece();
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
  @Override
  public boolean canMove(Commands direction) {
    if (!ableToMove) {
      return false;
    }

    if (direction == Commands.ROTATE) {
      return this.canRotate();
    }
    // Each square must be able to move in that direction
    Boolean canMove = true;
    for (int i = 0; i < PIECE_COUNT; i++) {
      canMove = canMove && square[i].canMove(direction);
    }
    return canMove;
  }

  public boolean canRotate() {
    if (!ableToMove) {
      return false;
    }
    Boolean canRotate = true;
    //toddy code
    for (int i = 0; i < PIECE_COUNT; i++) {
      canRotate = canRotate && square[i].canRotate(square[1]);
    }

    //toddy code
    return canRotate;
  }

  /**
   * Rotates the given piece
   */
  public void rotatePiece() {
    if (this.canRotate()) {
      for (int i = 0; i < PIECE_COUNT; i++) {
        square[i].rotate(square[1]);
      }
    }
  }
}
