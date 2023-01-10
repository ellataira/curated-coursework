package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents the text (String) view of a game of Marble Solitaire.
 * This class has changed since A2 to extend an abstract class, and now
 * only needs to implement toString, which will be used by English and European Solitaires.
 */
public class MarbleSolitaireTextView extends AbstractMarbleSolitaireView {

  /**
   * A default text view of MarbleSolitaire where the destination is System.out.
   *
   * @param state Marble Solitaire Model State
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state) {
    super(state);
  }

  /**
   * A text view of a game of Marble Solitaire from a given game and its destination.
   *
   * @param state       Marble Solitaire Model State
   * @param destination where to render the text view
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state, Appendable destination) {
    super(state, destination);
  }

  /**
   * Returns a string that shows the current state of the board.
   * (O, _ or space for a marble, empty and invalid position).
   *
   * @return the game state as a String
   */
  @Override
  public String toString() {

    StringBuilder s = new StringBuilder();
    for (int i = 0; i < this.state.getBoardSize(); i++) {
      StringBuilder iLine = new StringBuilder();
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

