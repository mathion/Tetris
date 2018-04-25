import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public interface Piece {

  boolean canMove(Commands command);

  void move(Commands command);

  Color getColor();

  Point[] getLocations();

  void draw(Graphics g);
}
