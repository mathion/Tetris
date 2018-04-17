
import java.awt.Color;

public class BarShape extends AbstractPiece{

	
	
	public BarShape(int row, int col, Grid grid) {
		super(row, col, grid);
		constructPiece(row, col, grid);

		// Create the squares

	}

	public void constructPiece(int row, int col, Grid grid) {
		this.square[0] = new Square(grid, row, col - 1, Color.cyan, true);
		square[1] = new Square(grid, row, col, Color.cyan, true);
		square[2] = new Square(grid, row, col + 1, Color.cyan, true);
		square[3] = new Square(grid, row, col + 2, Color.cyan, true);

	}
}
