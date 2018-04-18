import java.awt.Color;

public class BlockPiece extends AbstractPiece {

  public BlockPiece(int row, int col, Grid grid) {
    super(row, col, grid);
    this.square[0] = new Square(this.grid, row - 1, col, Color.gray, true);
    this.square[1] = new Square(this.grid, row - 1, col + 1, Color.gray, true);
    this.square[2] = new Square(this.grid, row, col, Color.gray, true);
    this.square[3] = new Square(this.grid, row, col + 1, Color.gray, true);
  }
}
