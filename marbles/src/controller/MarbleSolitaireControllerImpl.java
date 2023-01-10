package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Implements the controller for Marble Solitaire.
 * This class consists of methods to play the game, render its contents,
 * and end the game when appropriate.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  protected MarbleSolitaireModel model;
  protected MarbleSolitaireView view;
  protected Readable input;

  /**
   * Implements the controller for a game of Marble Solitaire.
   *
   * @param model game model
   * @param view  displayed game
   * @param input user input to play game
   * @throws IllegalArgumentException if any of the parameters are null.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view, Readable input)
          throws IllegalArgumentException {
    if (model == null || view == null || input == null) {
      throw new IllegalArgumentException("Parameters cannot be null");
    }

    this.model = model;
    this.view = view;
    this.input = input;
  }

  /**
   * Plays a new game of Marble Solitaire.
   *
   * @throws IllegalStateException if controller is unable to
   *                               successfully read input or transmit output.
   */
  @Override
  public void playGame() throws IllegalStateException {
    Scanner scanner = new Scanner(this.input);
    int[] moveFromTo = new int[4];
    int fromToPosn = 0;

    this.render();

    // while the game is not over...
    while (!this.model.isGameOver()) {

      while (fromToPosn < 4) {

        try {
          String next = scanner.next();

          // if input is Q or q, quit game
          if (next.equalsIgnoreCase("q")) {
            this.quit();
            return;
          }

          // check that num is an integer
          int num = 0;
          try {
            num = (Integer.parseInt(next));
            // if integer is negative
            if ((Integer.parseInt(next) - 1 < 0)) {
              this.tryRenderMessage("All integers must be positive\n");
            }
          } catch (NumberFormatException e) {
            this.tryRenderMessage("Not an integer or 'q'.\n");
          }

          // if the input is positive int, add to move array
          if (num > 0) {
            moveFromTo[fromToPosn] = Integer.parseInt(next) - 1;
            fromToPosn++;
          }
        } catch (NoSuchElementException e) {
          throw new IllegalStateException("Readable is out of inputs");
        }
      }

      if (fromToPosn == 4) {
        // check that the move is valid
        try {
          this.model.move(moveFromTo[0], moveFromTo[1], moveFromTo[2], moveFromTo[3]);
        } catch (IllegalArgumentException e) {
          this.tryRenderMessage("Invalid move. Play again. " + "(" + (moveFromTo[0] + 1)
                  + ", " + (moveFromTo[1] + 1) + ") to (" + (moveFromTo[2] + 1)
                  + ", " + (moveFromTo[3] + 1) + ") is an invalid move.\n");
        }

        this.render();
        fromToPosn = 0;
      }
    }
    this.endGame();
  }


  /**
   * Quits a game of Marble Solitaire and renders the end screen after input "q".
   */
  private void quit() {
    try {
      this.view.renderMessage("Game quit!\n");
      this.view.renderMessage("State of game when quit:\n");
      this.view.renderBoard();
      this.view.renderMessage("\nScore: " + this.model.getScore());
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  /**
   * Ends the game of Marble Solitaire when the game is over.
   */
  private void endGame() {
    try {
      this.view.renderMessage("Game over!\n");
      this.view.renderBoard();
      this.view.renderMessage("\nScore: " + this.model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("controller is unable to "
              + "successfully read input or transmit output.");
    }
  }

  /**
   * Renders the game board and score message.
   */
  private void render() {
    try {
      this.view.renderBoard();
      this.view.renderMessage("\nScore: " + this.model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("controller is unable "
              + "to successfully read input or transmit output.");
    }
  }

  private void tryRenderMessage(String message) {

    try {
      this.view.renderMessage(message);
    } catch (IOException e) {
      throw new IllegalStateException("controller is unable to"
              + " successfully read input or transmit output.");
    }

  }

}




