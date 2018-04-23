import java.awt.Color;

public class TShape extends AbstractPiece {


  public TShape(int row, int col, Grid grid) {
    super(row, col, grid);
    this.square[0] = new Square(grid, row, col - 1, Color.yellow, true);
    this.square[1] = new Square(grid, row, col, Color.yellow, true);
    this.square[2] = new Square(grid, row, col + 1, Color.yellow, true);
    this.square[3] = new Square(grid, row + 1, col, Color.yellow, true);
  }
}
