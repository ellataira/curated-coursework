package cs3500.marblesolitaire.model.hw04;

/**
 * Represents the model of a game of European Solitaire, which is octagon shaped.
 * It has four constructors.
 * This class extends the abstract model class, and implements
 * invalidSlot(). The rest of its methods are abstracted.
 */
public class EuropeanSolitaireModel extends AbstractMarbleSolitaireModel {

  /**
   * Constructor 1:
   * Takes in no parameters.
   * Constructs board of length 3 with the center at the middle of the board.
   */
  public EuropeanSolitaireModel() {
    super(3, 3, 3);
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
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(3, sRow, sCol);
  }

  /**
   * Constructor 3:
   * Takes in a given width for the game and constructs an appropriate board, with the empty
   * space in the center.
   *
   * @param a arm thickness for the board
   * @throws IllegalArgumentException if the provided arm thickness is not positive and odd.
   */
  public EuropeanSolitaireModel(int a) throws IllegalArgumentException {
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
  public EuropeanSolitaireModel(int a, int sRow, int sCol) throws IllegalArgumentException {
    super(a, sRow, sCol);
    if (a % 2 == 0) {
      throw new IllegalArgumentException("arm thickness must be odd.");
    }
  }

  /**
   * Determines if the cell at (i,j) is out of the scope of the board (invalid).
   *
   * @param i cell row ( 0 based )
   * @param j cell col (0 based )
   * @return true if invalid, else false
   */
  @Override
  protected boolean invalidSlot(int i, int j) {
    int width = this.getBoardSize();
    return ((i < this.a - 1 // top left
            && j < (width / 2) - ((this.a + 2 * i) / 2))
            // bottom left
            || (i > (width / 2) + ((this.a + (2 * j)) / 2)
            && j < this.a - 1)
            // top right
            || (i < this.a - 1
            && j > (width / 2) + ((this.a + (2 * i)) / 2))
            // bottom right
            || (i > (2 * this.a) - 2
            && j > (width / 2) + ((this.a + ((width - i - 1) * 2)) / 2)));
  }
}
