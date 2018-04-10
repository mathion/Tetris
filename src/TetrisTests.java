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
        assertTrue(p.y==4);
      } else {
        assertTrue(p.y ==5);
      }
    }
  }


}
