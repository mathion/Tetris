<<<<<<< HEAD
import java.awt.Color;
import java.awt.Graphics;

/**
 * One Square on our Tetris Grid or one square in our Tetris game piece
 *
 * @author CSC 143
 */
public class Square {

	// dimensions of a Square
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	private Grid grid; // the environment where this Square is
	private int row, col; // the grid location of this Square

	// possible move directions are defined by the Game class
	private boolean ableToMove; // true if this Square can move
	private Color color; // the color of this Square

	/**
	 * Creates a square
	 *
	 * @param grid
	 *            the Grid for this Square
	 * @param row
	 *            the row of this Square in the Grid
	 * @param col
	 *            the column of this Square in the Grid
	 * @param c
	 *            the Color of this Square
	 * @param mobile
	 *            true if this Square can move
	 * @throws IllegalArgumentException
	 *             if row and col not within the Grid
	 */
	public Square(Grid grid, int row, int col, Color c, boolean mobile) {
		if (row < 0 || row > Grid.HEIGHT - 1) {
			throw new IllegalArgumentException("Invalid row =" + row);
		}
		if (col < 0 || col > Grid.WIDTH - 1) {
			throw new IllegalArgumentException("Invalid column  = " + col);
		}

		// initialize instance variables
		this.grid = grid;
		this.row = row;
		this.col = col;
		color = c;
		ableToMove = mobile;
	}

	/**
	 * Returns the row for this Square
	 */
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Returns the column for this Square
	 */
	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * Returns true if this Square can move 1 spot in direction d
	 *
	 * @param originSquare
	 *            the square about which to rotate
	 */
	public boolean canRotate(Square originSquare) {
		if (!ableToMove) {
			return false;
		}

		int originSqrRow = originSquare.getRow();
		int originSqrCol = originSquare.getCol();
		int moveToRow = originSqrRow + col - originSqrCol;
		int moveToCol = originSqrCol - row + originSqrRow;

		if (moveToCol >= Grid.WIDTH || moveToRow >= Grid.HEIGHT || moveToCol < 0 || moveToRow < 0) {
			return false;
		}

		for (int i = Math.min(originSqrCol, moveToCol); i <= Math.max(originSqrCol, moveToCol); i++) {
			for (int j = Math.min(originSqrRow, moveToRow); j <= Math.max(originSqrRow, moveToRow); j++) {
				if (grid.isSet(j, i)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean canMove(Commands commands) {
		if (!ableToMove) {
			return false;
		}

		boolean move = true;
		// if the given direction is blocked, we can't move
		// remember to check the edges of the grid
		switch (commands) {
		case DOWN:
		case FAST_DROP:
			if (row == (Grid.HEIGHT - 1) || grid.isSet(row + 1, col)) {
				move = false;
			}
			break;

		// currently doesn't support checking LEFT or RIGHT
		// MODIFY so that it correctly returns if it can move left or right
		case LEFT:
			if (col == (0) || grid.isSet(row, col + -1)) {
				move = false;
			}
			break;
		case RIGHT:
			if (col == (Grid.WIDTH - 1) || grid.isSet(row, col + 1)) {
				move = false;
			}
			break;
		}
		return move;
	}

	/**
	 * moves this square in the given direction if possible.
	 *
	 * The square will not move if the direction is blocked, or if the square is
	 * unable to move.
	 *
	 * If it attempts to move DOWN and it can't, the square is frozen and cannot
	 * move anymore
	 *
	 * @param command
	 *            the direction to move
	 */
	public void move(Commands command) {
		if (canMove(command)) {
			switch (command) {
			case DOWN:
				row = row + 1;
				break;
			case LEFT:
				col += -1;
				break;
			case RIGHT:
				col += 1;
				break;
			// currently doesn't support moving LEFT or RIGHT
			// MODIFY so that the Square moves appropriately
			}
		}
	}

	/**
	 * Rotates the square about a square
	 * 
	 * @param originSquare
	 *            the square about which to rotate.
	 */
	public void rotate(Square originSquare) {
		int temp = row;
		row = originSquare.row + col - originSquare.col;
		col = originSquare.col - temp + originSquare.row;
	}

	/**
	 * Gets the color of this square
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Changes the color of this square
	 *
	 * @param c
	 *            the new color
	 */
	public void setColor(Color c) {
		color = c;
	}

	/**
	 * Draws this square on the given graphics context
	 */
	public void draw(Graphics g) {

		// calculate the upper left (x,y) coordinate of this square
		int actualX = Grid.LEFT + col * WIDTH;
		int actualY = Grid.TOP + row * HEIGHT;
		g.setColor(color);
		g.fillRect(actualX, actualY, WIDTH, HEIGHT);
		// black border (if not empty)
		if (!color.equals(Grid.EMPTY)) {
			g.setColor(Color.BLACK);
			g.drawRect(actualX, actualY, WIDTH, HEIGHT);
		}
	}
}
=======
import java.awt.Color;
import java.awt.Graphics;

/**
 * One Square on our Tetris Grid or one square in our Tetris game piece
 *
 * @author CSC 143
 */
public class Square {

  // dimensions of a Square
  public static final int WIDTH = 20;
  public static final int HEIGHT = 20;
  private Grid grid; // the environment where this Square is
  private int row, col; // the grid location of this Square

  // possible move directions are defined by the Game class
  private boolean ableToMove; // true if this Square can move
  private Color color; // the color of this Square

  /**
   * Creates a square
   *
   * @param grid the Grid for this Square
   * @param row the row of this Square in the Grid
   * @param col the column of this Square in the Grid
   * @param c the Color of this Square
   * @param mobile true if this Square can move
   * @throws IllegalArgumentException if row and col not within the Grid
   */
  public Square(Grid grid, int row, int col, Color c, boolean mobile) {
    if (row < 0 || row > Grid.HEIGHT - 1) {
      throw new IllegalArgumentException("Invalid row =" + row);
    }
    if (col < 0 || col > Grid.WIDTH - 1) {
      throw new IllegalArgumentException("Invalid column  = " + col);
    }

    // initialize instance variables
    this.grid = grid;
    this.row = row;
    this.col = col;
    color = c;
    ableToMove = mobile;
  }

  /**
   * Returns the row for this Square
   */
  public int getRow() {
    return row;
  }


  /**
   * Returns the column for this Square
   */
  public int getCol() {
    return col;
  }


  /**
   * Returns true if this Square can move 1 spot in direction d
   *
   * @param originSquare the square about which to rotate
   */
  public boolean canRotate(Square originSquare) {
    if (!ableToMove) {
      return false;
    }

    int originSqrRow = originSquare.getRow();
    int originSqrCol = originSquare.getCol();
    int moveToRow = originSqrRow + col - originSqrCol;
    int moveToCol = originSqrCol - row + originSqrRow;

    if (moveToCol >= Grid.WIDTH || moveToRow >= Grid.HEIGHT || moveToCol < 0 || moveToRow < 0) {
      return false;
    }

    for (int i = Math.min(originSqrCol, moveToCol); i <= Math.max(originSqrCol, moveToCol); i++) {
      for (int j = Math.min(originSqrRow, moveToRow); j <= Math.max(originSqrRow, moveToRow); j++) {
        if (grid.isSet(j,i)){
          return false;
        }
      }
    }
    return true;
    }

  public boolean canMove(Commands commands) {
    if (!ableToMove) {
      return false;
    }

    boolean move = true;
    // if the given direction is blocked, we can't move
    // remember to check the edges of the grid
    switch (commands) {
      case DOWN:
      case FAST_DROP:
        if (row == (Grid.HEIGHT - 1) || grid.isSet(row + 1, col)) {
          move = false;
        }
        break;

      // currently doesn't support checking LEFT or RIGHT
      // MODIFY so that it correctly returns if it can move left or right
      case LEFT:
        if (col == (0) || grid.isSet(row, col + -1)) {
          move = false;
        }
        break;
      case RIGHT:
        if (col == (Grid.WIDTH - 1) || grid.isSet(row, col + 1)) {
          move = false;
        }
        break;
    }
    return move;
  }

  /**
   * moves this square in the given direction if possible.
   *
   * The square will not move if the direction is blocked, or if the square is unable to move.
   *
   * If it attempts to move DOWN and it can't, the square is frozen and cannot move anymore
   *
   * @param command the direction to move
   */
  public void move(Commands command) {
    if (canMove(command)) {
      switch (command) {
        case DOWN:
          row = row + 1;
          break;
        case LEFT:
          col += -1;
          break;
        case RIGHT:
          col += 1;
          break;
      }
    }
  }

  /**
   * Rotates the square about a square
   * @param originSquare the square about which to rotate.
   */
  public void rotate(Square originSquare){
    int temp = row;
    row = originSquare.row + col - originSquare.col;
    col = originSquare.col - temp + originSquare.row;
  }

  /**
   * Gets the color of this square
   */
  public Color getColor() {
    return color;
  }

  /**
   * Changes the color of this square
   *
   * @param c the new color
   */
  public void setColor(Color c) {
    color = c;
  }

  /**
   * Draws this square on the given graphics context
   */
  public void draw(Graphics g) {

    // calculate the upper left (x,y) coordinate of this square
    int actualX = Grid.LEFT + col * WIDTH;
    int actualY = Grid.TOP + row * HEIGHT;
    g.setColor(color);
    g.fillRect(actualX, actualY, WIDTH, HEIGHT);
    // black border (if not empty)
    if (!color.equals(Grid.EMPTY)) {
      g.setColor(Color.BLACK);
      g.drawRect(actualX, actualY, WIDTH, HEIGHT);
    }
  }
}
>>>>>>> refs/remotes/origin/master
