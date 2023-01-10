package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractMarbleSolitaireModel;

/**
 * Represents possible instantiations of an {@code MarbleSolitaireModel}.
 * This class extends {@code AbstractMarbleSolitaireModel}.
 * EnglishSolitaireModel shares a common constructor with  other classes,
 * so I abstracted that constructor.
 * I also condensed the constructor into only one because in constructors with pre-set / hardcoded
 * parameters, those parameters will pass all exception checks.
 * EnglishSolitaireModel also shares methods with new classes from A3:
 * move()
 * isGameOver()
 * getBoardSize()
 * getSlotAt()
 * getScore()
 * makeBoard()
 * checkValidMove()
 * Now, EnglishSolitaireModel only needs to implement the abstract invalidSlot(),
 * which is called in the abstracted makeBoard().
 */
public class EnglishSolitaireModel extends AbstractMarbleSolitaireModel {


  /**
   * Constructor 1:
   * Takes in no parameters.
   * Constructs board of length 3 with the center at the middle of the board.
   */
  public EnglishSolitaireModel() {
    super(3, 3, 3);
    if (a % 2 == 0) {
      throw new IllegalArgumentException("arm thickness must be odd.");
    }
  }

  /**
   * Constructor 2:
   * Takes in the empty Cell coordinates as parameters and constructs a width=3 board with
   * appropriate empty cell.
   *
   * @param sRow empty Cell's row coordinate
   * @param sCol empty Cell's column coordinate
   * @throws IllegalArgumentException if the empty Cell's location does not exist on this board
   * @throws IllegalArgumentException if the empty Cell's location is invalid
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(3, sRow, sCol);
    if (a % 2 == 0) {
      throw new IllegalArgumentException("arm thickness must be odd.");
    }
  }

  /**
   * Constructor 3:
   * Takes in a given width for the game and constructs an appropriate board, with the empty
   * space in the center.
   *
   * @param a arm thickness for the board
   * @throws IllegalArgumentException if the provided arm thickness is not positive and odd
   */
  public EnglishSolitaireModel(int a) throws IllegalArgumentException {
    super(a, (a * 3 - 2) / 2, (a * 3 - 2) / 2);
    if (a % 2 == 0) {
      throw new IllegalArgumentException("arm thickness must be odd.");
    }
  }

  /**
   * Constructor 4:
   * Takes in the empty Cell's coordinates and the arm length to construct
   * a board of given size with given empty cell location.
   *
   * @param sRow empty Cell's row coordinate
   * @param sCol empty Cell's column coordinate
   * @param a    arm thickness for the board
   * @throws IllegalArgumentException if the arm thickness is not a positive, odd number
   * @throws IllegalArgumentException if the given empty Cell's location in invalid
   */
  public EnglishSolitaireModel(int a, int sRow, int sCol) throws IllegalArgumentException {
    super(a, sRow, sCol);
    if (a % 2 == 0) {
      throw new IllegalArgumentException("arm thickness must be odd.");
    }
  }

  @Override
  protected boolean invalidSlot(int i, int j) {
    int lowerBound = this.a - 1;
    int upperBound = 2 * this.a - 2;

    return ((i < lowerBound && j > upperBound)
            || (i < lowerBound && j < lowerBound)
            || (i > upperBound && j > upperBound)
            || (i > upperBound && j < lowerBound));
  }


}









