package cs3500.marblesolitaire.controller;

/**
 * Represents a controller for Marble Solitaire.
 * the controller will take in inputs from the user and use them
 * to play a game of Marble Solitaire. It will call upon methods
 * to play the game, render an image of the game, and end the game.
 */
public interface MarbleSolitaireController {

  /**
   * Plays a new game of Marble Solitaire.
   * @throws IllegalStateException if controller is unable to
   *              successfully read input or transmit output.
   */
  void playGame() throws IllegalStateException;

}
