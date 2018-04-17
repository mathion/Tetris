import java.awt.Color;

public class JShape extends AbstractPiece{

	
	public JShape(int row, int col, Grid grid) {
		super(row, col, grid);
		constructPiece(row, col, grid);

		// Create the squares

	}

	public void constructPiece(int row, int col, Grid grid) {
		this.square[0] = new Square(grid, row - 1, col, Color.blue, true);
		square[1] = new Square(grid, row, col, Color.blue, true);
		square[2] = new Square(grid, row + 1, col, Color.blue, true);
		square[3] = new Square(grid, row + 1, col - 1, Color.blue, true);

	}
}
