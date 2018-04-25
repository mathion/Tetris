import java.awt.Color;

public class ZShape extends AbstractPiece {


  public ZShape(int row, int col, Grid grid) {
    super(row, col, grid);
    //4/25 was sqr[0] row,col  sqr[1] row, col+1 sqr[2] row+ col +
    this.square[0] = new Square(grid, row, col - 1, Color.red, true);
    this.square[1] = new Square(grid, row, col, Color.red, true);
    this.square[2] = new Square(grid, row + 1, col, Color.red, true);
    this.square[3] = new Square(grid, row + 1, col + 1, Color.red, true);
  }
}
