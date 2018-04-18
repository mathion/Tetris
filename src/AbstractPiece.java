import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractPiece {

  // number of squares in one Tetris game piece
  protected static final int PIECE_COUNT = 4;
  protected boolean ableToMove; // can this piece move
  protected Square[] square; // the squares that make up this piece
  protected Grid grid; // the board this piece is on

  public AbstractPiece(int row, int col, Grid grid) {
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
  public boolean canMove(Commands direction) {
    if (!ableToMove) {
      return false;
    }

    // Each square must be able to move in that direction
    Boolean canMove = true;
    for (int i = 0; i < PIECE_COUNT; i++) {
      canMove = canMove && square[i].canMove(direction);
    }
    return canMove;
  }

	/*
	 * public void rotatePiece(int row, int col, Grid grid){
	 * 
	 * Square [2][2] initialPositions; 
	 * Square[][] rotatedRightPositions;
	 
	 
	 int middleRow =  square[1].getRow();
	 int middleCol = square[1].getCol();
	 
	 initialPositions[1][1] = 
	 
	 
	 for (int i = 0; i < PIECE_COUNT; i++) {
	 		int currentRow;
	 		int currentCol;
	 		
	 		currentRow = square[i].getRow();
	 		currentCol = square[i].getCol();
	 		
	 		
	 		
	 		
			points[i] = new Point(square[i].getRow(), square[i].getCol());
		}
	
	rightTiltTopRow(initialPositions,rotatedRightPositions);
	rightTiltMidRow	(initialPositions,rotatedRightPositions);
	rightTiltBotRow(initialPositions,rotatedRightPositions);
	
	 * }
	 */

  public void rightTiltTopRow(Square[][] iniPositions, Square[][] newPositions) {

    newPositions[0][2] = iniPositions[0][0];
    newPositions[1][2] = iniPositions[0][1];
    newPositions[2][2] = iniPositions[0][2];

  }

  public void rightTiltMidRow(Square[][] iniPositions, Square[][] newPositions) {

    newPositions[0][1] = iniPositions[1][0];
    newPositions[1][1] = iniPositions[1][1];
    newPositions[2][1] = iniPositions[1][2];

  }

  public void rightTiltBotRow(Square[][] iniPositions, Square[][] newPositions) {

    newPositions[0][0] = iniPositions[2][0];
    newPositions[1][0] = iniPositions[2][1];
    newPositions[2][0] = iniPositions[2][2];

  }

}
