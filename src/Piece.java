public interface Piece {
  void rotatePiece();
  boolean canMove(Commands command);
  void move(Commands command);
}
