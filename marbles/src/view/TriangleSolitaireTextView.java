package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents a text view of a game of Triangle Marble Solitaire.
 * This class extends the abstract view class, so it only implements the toString method
 * that is unique to Triangle boards.
 */
public class TriangleSolitaireTextView extends AbstractMarbleSolitaireView {

  /**
   * The default view state constructor is rendered at System.out.
   *
   * @param state Triangle Solitaire Model State
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState state) {
    super(state);
  }

  /**
   * The Triangle Text View is rendered at the given destination.
   *
   * @param state       Triangle Solitaire Model State
   * @param destination where to render the text view
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState state, Appendable destination) {
    super(state, destination);
  }

  /**
   * Creates a String view of a Triangle Solitaire board.
   * Where O is a marble, _ is an empty, and " " is invalid.
   *
   * @return String representation of a game of Triangle solitaire.
   */
  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < this.state.getBoardSize(); i++) {
      StringBuilder iLine = new StringBuilder();
      int spacing = i;
      while (spacing < this.state.getBoardSize() - 1) {
        iLine.append(" ");
        spacing++;
      }
      for (int j = 0; j < this.state.getBoardSize(); j++) {

        switch (this.state.getSlotAt(i, j)) {
          case Invalid:
            iLine.append("  ");
            break;
          case Marble:
            iLine.append("O ");
            break;
          case Empty:
            iLine.append("_ ");
            break;
          default:
            iLine.append("");
        }
      }

      // removes whitespace at end of line
      String sEdit = iLine.toString().stripTrailing();

      // if this row is not the last, then add line break
      if (i < state.getBoardSize() - 1) {
        sEdit = sEdit + "\n";
      }
      s.append(sEdit);
    }
    return s.toString();
  }

}


