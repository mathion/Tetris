import java.awt.Color;

/**
 * An L-Shape piece in the Tetris Game.
 *
 * This piece is made up of 4 squares in the following configuration: The game piece "floats above"
 * the Grid. The (row, col) coordinates are the location of the middle Square on the side within the
 * Grid
 *
 * @author CSC 143
 */
class LShape extends AbstractPiece {

  /**
   * Creates an L-Shape piece. See class description for actual location of row and col
   *
   * @param row row location for this piece
   * @param col column location for this piece
   * @param grid the grid for this game piece
   */
  public LShape(int row, int col, Grid grid) {
    super(grid);
    this.square[0] = new Square(grid, row - 1, col, Color.magenta, true);
    this.square[1] = new Square(grid, row, col, Color.magenta, true);
    this.square[2] = new Square(grid, row + 1, col, Color.magenta, true);
    this.square[3] = new Square(grid, row + 1, col + 1, Color.magenta, true);
  }
}
