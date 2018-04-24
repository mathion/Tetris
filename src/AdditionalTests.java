import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Point;

import org.junit.jupiter.api.Test;

public class AdditionalTests {
	
	
	//tests that gridlocked piece shouldn't be able to rotate
	@Test
	public void testCantRotate() {
	    Grid grid = new Grid();
	    LShape piece = new LShape(10, 5, grid);
	    for(int row = 0;row < Grid.HEIGHT; row++) {
	    	for(int col = 0;col < Grid.WIDTH; col++) {
	    		if(!(col == 4 && (row == 8 || row == 9 || row == 10)) || !(row == 10 && col == 5)){
	    			grid.set(row, col, Color.cyan);
	    		}
	    	}
	    }
	    assertFalse(piece.canRotate());
	    
	   
	  }
	
	
	//tests that piece can rotate
	@Test
	public void testCanRotate()
	{
		Grid grid = new Grid();
		LShape piece = new LShape(10, 5, grid);
		assertTrue(piece.canRotate());
		//make sure rotated to correct positions
		
		//assertTrue(grid.isSet(9,4));
		//assertTrue(grid.isSet(10,6));
		//assertTrue(grid.isSet(10,4));
		//assertTrue(grid.isSet(11,4));

	}
	
	//testing error bounds
	@Test
	public void testCantRotateIn2Wall() {
		Grid grid = new Grid();
		
		//checking right wall
		JShape piece = new JShape(10, 9, grid);
		assertFalse(piece.canRotate());
		
		//checking left wall
		LShape nPiece = new LShape(10,0,grid);
		assertFalse(nPiece.canRotate());
		
		//checking bottom
		BarShape nnPiece = new BarShape(18,5,grid);
		assertFalse(nnPiece.canRotate());
	}

}
