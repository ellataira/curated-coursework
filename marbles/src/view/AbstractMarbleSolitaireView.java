package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * An abstract class for the Marble Solitaire View. This class has been abstracted since A2.
 * in order to remove duplicated code when implementing the Triangle View.
 * The constructors and methods renderBoard() and renderMessage() are shared
 * by all concrete classes.
 * toString will be implemented in each concrete class.
 */
public abstract class AbstractMarbleSolitaireView implements MarbleSolitaireView {

  MarbleSolitaireModelState state;
  Appendable destination;

  /**
   * A text view of a game of Marble Solitaire.
   * The default destination for a view is System.out.
   *
   * @param state the current state of the game
   */
  public AbstractMarbleSolitaireView(MarbleSolitaireModelState state) {
    if (state == null) {
      throw new IllegalArgumentException("Provided model state is null");
    }
    this.state = state;
    this.destination = System.out;
  }

  /**
   * A text view of a game of Marble Solitaire.
   *
   * @param state       the current model state of the game
   * @param destination where the game is rendered
   */
  public AbstractMarbleSolitaireView(MarbleSolitaireModelState state, Appendable destination) {
    if (state == null || destination == null) {
      throw new IllegalArgumentException("Provided model state or appendable is null.");
    }

    this.state = state;
    this.destination = destination;
  }


  /**
   * Renders the String image of the board in given destination.
   *
   * @throws IOException if the transmission fails.
   */
  @Override
  public void renderBoard() throws IOException {
    destination.append(this.toString());
  }


  /**
   * Renders the given message in given destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if the transmission fails.
   */
  @Override
  public void renderMessage(String message) throws IOException {
    destination.append(message);
  }

  /**
   * Translates a Marble Solitaire board to a string where O  is a marble,
   * _ is empty, and " " is invalid.
   *
   * @return String representation of a game of MarbleSolitaire
   */
  public abstract String toString();
}
