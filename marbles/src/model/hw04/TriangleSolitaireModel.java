package cs3500.marblesolitaire.model.hw04;

/**
 * Represents a triangle board shaped model of Marble Solitaire.
 * This class extends the abstract model class, and has four constructors.
 * It overrides the following methods from the abstract:
 * getBoardSize()
 * invalidSlot()
 * checkValidMove()
 */
public class TriangleSolitaireModel extends AbstractMarbleSolitaireModel {

  /**
   * Constructor 1:
   * Takes in no parameters.
   * Constructs board of length 5 with the center at (0,0)
   */
  public TriangleSolitaireModel() {
    super(5, 0, 0);
  }

  /**
   * Constructor 2:
   * Takes in a given width for the game and constructs an appropriate board, with the empty
   * space at (0,0).
   *
   * @param a arm thickness for the board
   * @throws IllegalArgumentException if the provided arm thickness is not positive .
   */
  public TriangleSolitaireModel(int a) {
    super(a, 0, 0);
  }

  /**
   * Constructor 3:
   * Takes in the empty Cell coordinates as parameters and constructs a width=5 board with
   * appropriate empty cell.
   *
   * @param sRow empty Cell's row coordinate
   * @param sCol empty Cell's column coordinate
   * @throws IllegalArgumentException if the empty Cell's location does not exist on this board
   * @throws IllegalArgumentException if the empty Cell's location is invalid
   */
  public TriangleSolitaireModel(int sRow, int sCol) {
    super(5, sRow, sCol);
  }

  /**
   * Constructor 4:
   * Takes in the empty Cell's coordinates and the arm length to construct
   * a board of given size with given empty cell location.
   *
   * @param sRow empty Cell's row coordinate
   * @param sCol empty Cell's column coordinate
   * @param a    arm thickness for the board
   * @throws IllegalArgumentException if the arm thickness is not a positive number.
   * @throws IllegalArgumentException if the given empty Cell's location in invalid
   */
  public TriangleSolitaireModel(int a, int sRow, int sCol) {
    super(a, sRow, sCol);
  }

  /**
   * Returns the width of the board, with is the same as arm thickness.
   *
   * @return integer width of board.
   */
  @Override
  public int getBoardSize() {
    return this.a;
  }

  /**
   * Determines if a given coordinate cell is invalid.
   *
   * @param i cell row ( 0 based )
   * @param j cell col (0 based )
   * @return true if invalid, else false.
   */
  @Override
  protected boolean invalidSlot(int i, int j) {
    return (j > i);
  }

  /**
   * Determines if the given coordinates make up a valid move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @return true if the move is valid, else false.
   */
  @Override
  protected boolean checkValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    boolean checkInputsValid = (!(this.board[fromRow][fromCol].equals(SlotState.Invalid)))
            && (!(this.board[toRow][toCol].equals(SlotState.Invalid)));
    // check if move is lateral or diagonal
    boolean onSameRow = ((Math.abs(toCol - fromCol) == 2) && (toRow == fromRow));
    boolean onDiagonal1 = (Math.abs(toCol - fromCol) == 2) && (Math.abs(toRow - fromRow) == 2);
    boolean onDiagonal2 = (Math.abs(toRow - fromRow) == 2) && (toCol == fromCol);
    boolean validDirection = onDiagonal1 || onDiagonal2 || onSameRow;
    // check if cells are in correct slot state to make a move
    boolean checkSlotStates = (this.board[(toRow + fromRow) / 2]
            [(toCol + fromCol) / 2].equals(SlotState.Marble)
            && (this.board[toRow][toCol].equals(SlotState.Empty))
            && (this.board[fromRow][fromCol].equals(SlotState.Marble)));

    return checkInputsValid && validDirection && checkSlotStates;
  }


}
