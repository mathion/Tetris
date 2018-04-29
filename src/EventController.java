/**
 * Handles events for the Tetris Game.  User events (key strokes) as well as periodic timer events.
 *
 * @author CSC 143
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

class EventController extends KeyAdapter implements ActionListener {

  private static final double PIECE_MOVE_TIME = 0.8; // wait 0.8 s every time
  private final Game game; // current game: grid and current piece
  private final Timer timer;
  // the piece moves down
  // increase to slow it
  // down
  private boolean gameOver;

  /**
   * Creates an EventController to handle key and timer events.
   *
   * @param game the game this is controlling
   */
  public EventController(Game game) {
    this.game = game;
    gameOver = false;
    double delay = 1000 * PIECE_MOVE_TIME; // in milliseconds
    timer = new Timer((int) delay, this);
    timer.setCoalesce(true); // if multiple events pending, bunch them to
    // 1 event
    timer.start();
  }

  /**
   * Responds to special keys being pressed.
   *
   * Currently just responds to the space key and the q(uit) key
   */
  public void keyPressed(KeyEvent e) {
    // if 'Q', quit the game
    if (e.getKeyCode() == KeyEvent.VK_Q) {
      timer.stop();
      ((JFrame) e.getSource()).dispose();
    }
    if (!gameOver) {
      switch (e.getKeyCode()) {
        case KeyEvent.VK_DOWN:
          handleCommand(Commands.DOWN);
          break;
        case KeyEvent.VK_LEFT:
          handleCommand(Commands.LEFT);
          break;
        case KeyEvent.VK_RIGHT:
          handleCommand(Commands.RIGHT);
          break;
        case KeyEvent.VK_SPACE:
          handleCommand(Commands.FAST_DROP);
          break;
        case KeyEvent.VK_UP:
          handleCommand(Commands.ROTATE);
          break;
      }
    }
  }

  /**
   * Updates the game periodically based on a timer event
   */
  public void actionPerformed(ActionEvent e) {
    handleCommand(Commands.DOWN);
  }

  /**
   * Update the game by moving in the given direction
   */
  private void handleCommand(Commands Command) {
    game.movePiece(Command);
    gameOver = game.isGameOver();
    if (gameOver) {
      timer.stop();
    }
  }
}
