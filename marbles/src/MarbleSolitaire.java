
package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Class for Marble Solitaire the contains the main() method,
 * which instantiates a game of Marble Solitaire based on user inputs.
 * This class contains the entry point to the game.
 */
public final class MarbleSolitaire {

  /**
   * Starts a game of Marble Solitaire based on user inputs.
   * Game types are "english," "european," or "triangle"
   * user can edit the board size with  "-size" + int
   * user can edit empty slot location with "-hole" + rowInt + colInt
   *
   * @param args user inputs that create the game rendered.
   */
  public static void main(String[] args) {
    String shape = args[0];
    MarbleSolitaireModel model;
    MarbleSolitaireView view;
    int a = 0;
    int sRow = 0;
    int sCol = 0;
    Readable input = new InputStreamReader(System.in);

    if (shape.equals("english") || shape.equals("european")) {
      a = 3;
      sRow = 3;
      sCol = 3;
    } else if (shape.equals("triangle")) {
      a = 5;
      sRow = 0;
      sCol = 0;
    }

    // for either size or coords, but not both
    if (args.length > 1 && args.length < 6) {
      if (args[1].equals("-size")) {
        a = Integer.parseInt(args[2]);
      } else if (args[1].equals("-hole")) {
        sRow = Integer.parseInt(args[2]);
        sCol = Integer.parseInt(args[3]);
      }
    }
    // for both size and hole
    else if (args.length == 6) {
      if (args[1].equals("-size")) {
        a = Integer.parseInt(args[2]);
        sRow = Integer.parseInt(args[4]);
        sCol = Integer.parseInt(args[5]);
      } else if (args[1].equals("-hole")) {
        sRow = Integer.parseInt(args[2]);
        sCol = Integer.parseInt(args[3]);
        a = Integer.parseInt(args[5]);
      }
    }

    switch (shape) {
      case "english":
        model = new EnglishSolitaireModel(a, sRow, sCol);
        view = new MarbleSolitaireTextView(model);
        break;
      case "european":
        model = new EuropeanSolitaireModel(a, sRow, sCol);
        view = new MarbleSolitaireTextView(model);
        break;
      case "triangle":
        model = new TriangleSolitaireModel(a, sRow, sCol);
        view = new TriangleSolitaireTextView(model);
        break;
      default:
        throw new IllegalArgumentException("invalid board");
    }


    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, input);
    controller.playGame();
  }
}