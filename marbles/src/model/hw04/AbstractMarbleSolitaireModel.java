package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents an abstract class for MarbleSolitaireModel.
 * For A3,
 * I abstracted the constructor that is shared by English, Triangle, and European
 * Their multiple constructors all call the abstracted one with varying amounts of inputted and
 * predetermined values.
 * The methods getBoardSize(), invalidSlot(), and checkValidMove()
 * will have to be overridden in the Triangle model.
 * All remaining methods are either abstract or used as-is in all classes.
 */
public abstract class AbstractMarbleSolitaireModel implements MarbleSolitaireModel {
  public SlotState[][] board;
  public int a;
  public int sCol;
  public int sRow;

  /**
   * Constructor:
   * Takes in the empty Cell's coordinates and the arm length to construct
   * a board of given size with given empty cell location.
   *
   * @param sRow empty Cell's row coordinate
   * @param sCol empty Cell's column coordinate
   * @param a    arm thickness for the board
   * @throws IllegalArgumentException if the arm thickness is not a positive, odd number
   * @throws IllegalArgumentException if the given empty Cell's location in invalid
   */
  public AbstractMarbleSolitaireModel(int a, int sRow, int sCol) {
    if (a < 0) {
      throw new IllegalArgumentException("arm thickness is not a positive number");
    }

    this.a = a;
    this.sRow = sRow;
    this.sCol = sCol;
    this.makeBoard();


    try {
      this.getSlotAt(sRow, sCol);
    } catch (IllegalArgumentException e) {
      if (e.getMessage().equals("the given location is beyond the board's dimensions.")) {
        throw new IllegalArgumentException("the given coordinates are invalid");
      }
    }

    if (this.getSlotAt(sRow, sCol).equals(SlotState.Invalid) ) {
      throw new IllegalArgumentException("Invalid empty cell position ("
              + sRow + ", " + sCol + ")");
    }

  }


  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is invalid
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if ((fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0)
            || (fromRow > this.getBoardSize() - 1 || fromCol > this.getBoardSize() - 1
            || toRow > this.getBoardSize() - 1 || toCol > this.getBoardSize() - 1)) {
      throw new IllegalArgumentException("Given coordinates must be within the board.");
    }

    SlotState betweenCell = this.board[(fromRow + toRow) / 2][(toCol + fromCol) / 2];

    if (this.checkValidMove(fromRow, fromCol, toRow, toCol)) {

      this.board[fromRow][fromCol] = SlotState.Empty;
      this.board[toRow][toCol] = SlotState.Marble;
      this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = SlotState.Empty;

    } else {
      throw new IllegalArgumentException("(" + fromRow + ", " + fromCol
              + ") to (" + toRow + ", " + toCol + ") is an invalid move.");
    }
  }


  /**
   * Determines if the game is over. A game is over when there are no more
   * possible moves.
   *
   * @return true if the game is over, else false
   */
  @Override
  public boolean isGameOver() {
    boolean isGameOver = false;

    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {

        if (i + 2 < this.getBoardSize() && checkValidMove(i, j, i + 2, j)) {
          return isGameOver;
        } else if (i - 2 >= 0 && checkValidMove(i, j, i - 2, j)) {
          return isGameOver;
        } else if (j + 2 < this.getBoardSize() && checkValidMove(i, j, i, j + 2)) {
          return isGameOver;
        } else if (j - 2 >= 0 && checkValidMove(i, j, i, j - 2)) {
          return isGameOver;
        } else if (i + 2 < this.getBoardSize() && j + 2 < this.getBoardSize()
                && checkValidMove(i, j, i + 2, j + 2)) {
          return isGameOver;
        } else if (i - 2 >= 0 && j - 2 >= 0
                && checkValidMove(i, j, i - 2, j - 2)) {
          return isGameOver;
        }
      }
    }
    isGameOver = true;
    return isGameOver;
  }


  /**
   * Return the size of this board.
   * this method will be overridden in TriangleModel.
   *
   * @return integer of width of the board
   */
  @Override
  public int getBoardSize() {
    return this.a * 3 - 2;
  }

  /**
   * Returns the Slot State at the given location.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return Slot State (empty, marble, or invalid)
   * @throws IllegalArgumentException if the row or the column are beyond
   *                                  the dimensions of the board
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row > this.getBoardSize() || col < 0 || col > this.getBoardSize()) {
      throw new IllegalArgumentException("the given location is beyond the board's dimensions.");
    }
    try {
      return this.board[row][col];
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new IllegalArgumentException("the given location is beyond the board's dimensions.");
    }
  }

  /**
   * Returns the number of marbles on the board.
   * The game is keeps score with the number of marbles remaining.
   *
   * @return integers of the number of marbles
   */
  @Override
  public int getScore() {
    int numMarbles = 0;
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board.length; j++) {
        if (this.board[i][j].equals(SlotState.Marble)) {
          numMarbles = numMarbles + 1;
        }
      }
    }
    return numMarbles;
  }

  /**
   * Constructs a complete game board with appropriate SlotStates before
   * any moves are made based on arm-length and center coordinate.
   * This loop is applicable to multiple board creations when it calls
   * an abstracted, board-shape-specific method, invalidSlot(i,j)
   */
  private void makeBoard() {
    this.board = new SlotState[this.getBoardSize()][this.getBoardSize()];

    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (this.invalidSlot(i, j)) {
          this.board[i][j] = SlotState.Invalid;
        } else if (i == this.sRow && j == this.sCol) {
          this.board[i][j] = SlotState.Empty;
        } else {
          this.board[i][j] = SlotState.Marble;
        }
      }
    }
  }

  /**
   * Determines if a certain cell is outside the scope of the board.
   *
   * @param i cell row ( 0 based )
   * @param j cell col (0 based )
   * @return
   */
  protected abstract boolean invalidSlot(int i, int j);

  /**
   * Determines if the game move between the provided Cells is valid by checking.
   * if the "to" and "from" are valid locations and.
   * are two spaces apart orthogonally, and if "to," "from," and middle cell.
   * are of the proper states.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @return true if the move between "to" and "from" is valid, else false
   */
  protected boolean checkValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    return (!(this.board[fromRow][fromCol].equals(SlotState.Invalid)))
            && (!(this.board[toRow][toCol].equals(SlotState.Invalid)))
            // true if to and from are one Cell apart
            && (((Math.abs(toRow - fromRow) == 2) && (toCol == fromCol))
            || ((Math.abs(toCol - fromCol) == 2) && (toRow == fromRow)))
            // true if Cells are correct states
            && (this.board[(toRow + fromRow) / 2][(toCol + fromCol) / 2].equals(SlotState.Marble)
            && (this.board[toRow][toCol].equals(SlotState.Empty))
            && (this.board[fromRow][fromCol].equals(SlotState.Marble)));
  }

}
