import java.awt.Color;

public class JShape extends AbstractPiece {


  public JShape(int row, int col, Grid grid) {
    super(row, col, grid);
    this.square[0] = new Square(grid, row - 1, col, Color.blue, true);
    this.square[1] = new Square(grid, row, col, Color.blue, true);
    this.square[2] = new Square(grid, row + 1, col, Color.blue, true);
    this.square[3] = new Square(grid, row + 1, col - 1, Color.blue, true);
  }
}
