import java.awt.Color;

public class ZShape extends AbstractPiece{
	
	
	
	public ZShape(int row, int col, Grid grid) {
		super(row, col, grid);
		constructPiece(row, col, grid);

		// Create the squares

	}

	public void constructPiece(int row, int col, Grid grid) {
		this.square[0] = new Square(grid, row, col, Color.red, true);
		square[1] = new Square(grid, row, col + 1, Color.red, true);
		square[2] = new Square(grid, row + 1, col + 1, Color.red, true);
		square[3] = new Square(grid, row + 1, col + 2, Color.red, true);

	}

}
