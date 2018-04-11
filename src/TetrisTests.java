import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.awt.Point;
import org.junit.Test;

public class TetrisTests {

  @Test
  public void testMoveLeft() {
    Grid grid = new Grid();
    LShape piece = new LShape(10, 5, grid);
    assertTrue(piece.canMove(Commands.LEFT));
    piece.move(Commands.LEFT);
    for (int i = 0; i < piece.getLocations().length; i++){
      Point p = piece.getLocations()[i];
      if (i<3){
        assertEquals(4, p.y);
      } else {
        assertEquals(5, p.y);
      }
    }
  }

  @Test
  public void testMoveRight() {
    Grid grid = new Grid();
    LShape piece = new LShape(10, 5, grid);
    assertTrue(piece.canMove(Commands.RIGHT));
    piece.move(Commands.RIGHT);
    for (int i = 0; i < piece.getLocations().length; i++){
      Point p = piece.getLocations()[i];
      if (i<3){
        assertEquals(6, p.y);
      } else {
        assertEquals(7, p.y);
      }
    }
  }



}
