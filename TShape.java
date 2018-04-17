import java.awt.Color;

public class TShape extends AbstractPiece{

	
	
	public TShape(int row, int col, Grid grid) {
		super(row, col, grid);
		constructPiece(row, col, grid);

		// Create the squares

	}

	public void constructPiece(int row, int col, Grid grid) {
		this.square[0] = new Square(grid, row, col - 1, Color.yellow, true);
		square[1] = new Square(grid, row, col, Color.yellow, true);
		square[2] = new Square(grid, row, col + 1, Color.yellow, true);
		square[3] = new Square(grid, row + 1, col, Color.yellow, true);

	}
}
