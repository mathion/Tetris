import java.awt.Color;

public class SShape extends AbstractPiece {


  public SShape(int row, int col, Grid grid) {
    super(row, col, grid);
    this.square[0] = new Square(grid, row, col + 1, Color.green, true);
    this.square[1] = new Square(grid, row, col, Color.green, true);
    this.square[2] = new Square(grid, row + 1, col, Color.green, true);
    this.square[3] = new Square(grid, row + 1, col - 1, Color.green, true);
  }
}
