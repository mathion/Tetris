
import java.awt.Color;

public class BlockPiece extends AbstractPiece {

	public BlockPiece(int r, int c, Grid g) {
		super(r, c, g);
		constructPiece(r,c,g);

	}
	
	@Override
	public void constructPiece(int row,int col, Grid grid)
	{
		this.square[0] = new Square(grid, row - 1, col, Color.gray, true);
		square[1] = new Square(grid, row - 1, col + 1, Color.gray, true);
		square[2] = new Square(grid, row, col, Color.gray, true);
		square[3] = new Square(grid, row, col + 1, Color.gray, true);
	}

}
