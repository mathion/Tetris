import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.awt.Color;
import java.awt.Point;
import org.junit.Test;

public class TetrisTests {

  @Test
  public void testMoveLeft() {
    Grid grid = new Grid();
    LShape piece = new LShape(10, 5, grid);
    assertTrue(piece.canMove(Commands.LEFT));
    piece.move(Commands.LEFT);
    for (int i = 0; i < piece.getLocations().length; i++) {
      Point p = piece.getLocations()[i];
      if (i < 3) {
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
    for (int i = 0; i < piece.getLocations().length; i++) {
      Point p = piece.getLocations()[i];
      if (i < 3) {
        assertEquals(6, p.y);
      } else {
        assertEquals(7, p.y);
      }
    }
  }

  @Test
  public void testMoveDown() {
    Grid grid = new Grid();
    LShape piece = new LShape(10, 5, grid);
    assertTrue(piece.canMove(Commands.DOWN));
    piece.move(Commands.DOWN);
    for (int i = 0; i < piece.getLocations().length; i++) {
      Point p = piece.getLocations()[i];
      if (i > 1) {
        assertEquals(12, p.x);
      } else {
        assertEquals(10 + i, p.x);
      }
    }
  }

  @Test
  public void testFastDrop() {
    Grid grid = new Grid();
    LShape piece = new LShape(10, 5, grid);
    assertTrue(piece.canMove(Commands.FAST_DROP));
    piece.move(Commands.FAST_DROP);
    for (int i = 0; i < piece.getLocations().length; i++) {
      Point p = piece.getLocations()[i];
      if (i > 1) {
        assertEquals(19, p.x);
      } else {
        assertEquals(17 + i, p.x);
      }
    }
  }

  @Test
  public void testCanMove() {
    Grid grid = new Grid();
    LShape piece = new LShape(10, 5, grid);
    assertTrue(piece.canMove(Commands.DOWN));
    assertTrue(piece.canMove(Commands.LEFT));
    assertTrue(piece.canMove(Commands.RIGHT));
    assertTrue(piece.canMove(Commands.FAST_DROP));

    piece = new LShape(18, 0, grid);
    assertFalse(piece.canMove(Commands.LEFT));
    assertFalse(piece.canMove(Commands.DOWN));
    assertFalse(piece.canMove(Commands.FAST_DROP));
    assertTrue(piece.canMove(Commands.RIGHT));

    piece = new LShape(18, 8, grid);
    assertTrue(piece.canMove(Commands.LEFT));
    assertFalse(piece.canMove(Commands.DOWN));
    assertFalse(piece.canMove(Commands.FAST_DROP));
    assertFalse(piece.canMove(Commands.RIGHT));
  }

  @Test
  public void testSquareCanMove() {
    Grid grid = new Grid();
    Square piece = new Square(grid, 10, 5, Color.cyan, true);
    assertTrue(piece.canMove(Commands.DOWN));
    assertTrue(piece.canMove(Commands.LEFT));
    assertTrue(piece.canMove(Commands.RIGHT));
    assertTrue(piece.canMove(Commands.FAST_DROP));

    piece = new Square(grid, 19, 0, Color.cyan, true);
    assertFalse(piece.canMove(Commands.LEFT));
    assertFalse(piece.canMove(Commands.DOWN));
    assertFalse(piece.canMove(Commands.FAST_DROP));
    assertTrue(piece.canMove(Commands.RIGHT));

    piece = new Square(grid, 19, 9, Color.cyan, true);
    assertTrue(piece.canMove(Commands.LEFT));
    assertFalse(!piece.canMove(Commands.DOWN));
    assertFalse(!piece.canMove(Commands.FAST_DROP));
    assertFalse(!piece.canMove(Commands.RIGHT));
  }

  @Test
  public void testSquareMove() {
    Grid grid = new Grid();
    Square square = new Square(grid, 10, 5, Color.cyan, true);

    square.move(Commands.LEFT);
    assertEquals(4, square.getCol());
    assertEquals(10, square.getRow());

    square.move(Commands.DOWN);
    assertEquals(4, square.getCol());
    assertEquals(11, square.getRow());

    square.move(Commands.RIGHT);
    assertEquals(5, square.getCol());
    assertEquals(11, square.getRow());
  }

  @Test
  public void testCheckRows() {
    Grid grid = new Grid();
    for (int row = 0; row < Grid.HEIGHT; row++) {
      for (int col = 0; col < Grid.WIDTH; col++) {
        if (row != 10 || (col == 4 || col == 5)) {
          grid.set(row, col, Color.cyan);
        }
      }
    }

    grid.checkRows();

    for (int row = 0; row < Grid.HEIGHT; row++) {
      for (int col = 0; col < Grid.WIDTH; col++) {
        if (row == Grid.HEIGHT - 1 && (col == 4 || col == 5)) {
          assertTrue(grid.isSet(row, col));
        } else {
          assertFalse(grid.isSet(row, col));
        }
      }
    }

  }
}
