import java.awt.Color;

public class BarShape extends AbstractPiece {


  public BarShape(int row, int col, Grid grid) {
    super(row, col, grid);
    this.square[0] = new Square(grid, row, col - 1, Color.cyan, true);
    this.square[1] = new Square(grid, row, col, Color.cyan, true);
    this.square[2] = new Square(grid, row, col + 1, Color.cyan, true);
    this.square[3] = new Square(grid, row, col + 2, Color.cyan, true);
  }
}
