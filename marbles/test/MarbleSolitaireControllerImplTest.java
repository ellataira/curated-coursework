
import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.controller.ReadableTest1;
import cs3500.marblesolitaire.controller.ReadableTest2;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireMock;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Testing class for a Marble Solitaire Controller Implementation.
 */
public class MarbleSolitaireControllerImplTest {

  private MarbleSolitaireControllerImpl ctrl;

  MarbleSolitaireModel model = new EnglishSolitaireModel();
  Appendable app = new StringBuilder();
  MarbleSolitaireView view = new MarbleSolitaireTextView(model, app);


  @Test
  public void testPlayGameQuit() {
    Readable r = new StringReader("q");
    this.ctrl = new MarbleSolitaireControllerImpl(model, view, r);

    this.ctrl.playGame();

    String[] arr = app.toString().split("\n");

    assertEquals("    O O O", arr[0]);
    assertEquals("    O O O", arr[1]);
    assertEquals("O O O O O O O", arr[2]);
    assertEquals("O O O _ O O O", arr[3]);
    assertEquals("O O O O O O O", arr[4]);
    assertEquals("    O O O", arr[5]);
    assertEquals("    O O O", arr[6]);
    assertEquals("Score: 32", arr[7]);
    assertEquals("Game quit!", arr[8]);
    assertEquals("State of game when quit:", arr[9]);
    assertEquals("    O O O", arr[10]);
    assertEquals("    O O O", arr[11]);
    assertEquals("O O O O O O O", arr[12]);
    assertEquals("O O O _ O O O", arr[13]);
    assertEquals("O O O O O O O", arr[14]);
    assertEquals("    O O O", arr[15]);
    assertEquals("    O O O", arr[16]);
    assertEquals("Score: 32", arr[17]);
  }

  @Test
  public void testPlayGameMove() {
    Readable r = new StringReader("4\n2\n4\n4\nq");
    this.ctrl = new MarbleSolitaireControllerImpl(this.model, this.view, r);

    this.ctrl.playGame();

    String[] arr = app.toString().split("\n");

    assertEquals("    O O O", arr[0]);
    assertEquals("    O O O", arr[1]);
    assertEquals("O O O O O O O", arr[2]);
    assertEquals("O O O _ O O O", arr[3]);
    assertEquals("O O O O O O O", arr[4]);
    assertEquals("    O O O", arr[5]);
    assertEquals("    O O O", arr[6]);
    assertEquals("Score: 32", arr[7]);
    assertEquals("    O O O", arr[8]);
    assertEquals("    O O O", arr[9]);
    assertEquals("O O O O O O O", arr[10]);
    assertEquals("O _ _ O O O O", arr[11]);
    assertEquals("O O O O O O O", arr[12]);
    assertEquals("    O O O", arr[13]);
    assertEquals("    O O O", arr[14]);
    assertEquals("Score: 31", arr[15]);
  }

  @Test
  public void testPlayGame2Moves() {
    Readable r = new StringReader("4\n2\n4\n4\n6\n3\n4\n3\nq");
    this.ctrl = new MarbleSolitaireControllerImpl(this.model, this.view, r);

    this.ctrl.playGame();

    String[] arr = app.toString().split("\n");

    assertEquals("    O O O", arr[0]);
    assertEquals("    O O O", arr[1]);
    assertEquals("O O O O O O O", arr[2]);
    assertEquals("O O O _ O O O", arr[3]);
    assertEquals("O O O O O O O", arr[4]);
    assertEquals("    O O O", arr[5]);
    assertEquals("    O O O", arr[6]);
    assertEquals("Score: 32", arr[7]);
    assertEquals("    O O O", arr[8]);
    assertEquals("    O O O", arr[9]);
    assertEquals("O O O O O O O", arr[10]);
    assertEquals("O _ _ O O O O", arr[11]);
    assertEquals("O O O O O O O", arr[12]);
    assertEquals("    O O O", arr[13]);
    assertEquals("    O O O", arr[14]);
    assertEquals("Score: 31", arr[15]);
    assertEquals("    O O O", arr[16]);
    assertEquals("    O O O", arr[17]);
    assertEquals("O O O O O O O", arr[18]);
    assertEquals("O _ O O O O O", arr[19]);
    assertEquals("O O _ O O O O", arr[20]);
    assertEquals("    _ O O", arr[21]);
    assertEquals("    O O O", arr[22]);
    assertEquals("Score: 30", arr[23]);

  }

  @Test
  public void testPlayGameOver() {
    Readable r = new StringReader("2\n4\n4\n4\n5\n4\n3\n4\n7" +
            "\n4\n5\n4\n4\n6\n4\n4\n4\n3\n4\n5\n4\n1\n4\n3");
    this.ctrl = new MarbleSolitaireControllerImpl(this.model, this.view, r);

    this.ctrl.playGame();

    String[] arr = app.toString().split("\n");

    assertEquals("Score: 26", arr[arr.length - 1]);
    assertEquals("    O _ O", arr[arr.length - 2]);
    assertEquals("    O _ O", arr[arr.length - 3]);
    assertEquals("O O O O O O O", arr[arr.length - 4]);
    assertEquals("_ _ O _ O _ O", arr[arr.length - 5]);
    assertEquals("O O O O O O O", arr[arr.length - 6]);
    assertEquals("    O _ O", arr[arr.length - 7]);
    assertEquals("    O O O", arr[arr.length - 8]);
    assertEquals("Game over!", arr[arr.length - 9]);
  }

  @Test
  public void testFullGame() {
    Readable r = new StringReader("2\n4\n4\n4\n5\n4\n3\n4\n7\n4\n5" +
            "\n4\n4\n6\n4\n4\n4\n3\n4\n5\n4\n1\n4\n3");
    this.ctrl = new MarbleSolitaireControllerImpl(this.model, this.view, r);

    this.ctrl.playGame();

    String[] arr = app.toString().split("\n");

    assertEquals("    O O O", arr[0]);
    assertEquals("    O O O", arr[1]);
    assertEquals("O O O O O O O", arr[2]);
    assertEquals("O O O _ O O O", arr[3]);
    assertEquals("O O O O O O O", arr[4]);
    assertEquals("    O O O", arr[5]);
    assertEquals("    O O O", arr[6]);
    assertEquals("Score: 32", arr[7]);
    assertEquals("    O O O", arr[8]);
    assertEquals("    O _ O", arr[9]);
    assertEquals("O O O _ O O O", arr[10]);
    assertEquals("O O O O O O O", arr[11]);
    assertEquals("O O O O O O O", arr[12]);
    assertEquals("    O O O", arr[13]);
    assertEquals("    O O O", arr[14]);
    assertEquals("Score: 31", arr[15]);
    assertEquals("    O O O", arr[16]);
    assertEquals("    O _ O", arr[17]);
    assertEquals("O O O O O O O", arr[18]);
    assertEquals("O O O _ O O O", arr[19]);
    assertEquals("O O O _ O O O", arr[20]);
    assertEquals("    O O O", arr[21]);
    assertEquals("    O O O", arr[22]);
    assertEquals("Score: 30", arr[23]);
    assertEquals("    O O O", arr[24]);
    assertEquals("    O _ O", arr[25]);
    assertEquals("O O O O O O O", arr[26]);
    assertEquals("O O O _ O O O", arr[27]);
    assertEquals("O O O O O O O", arr[28]);
    assertEquals("    O _ O", arr[29]);
    assertEquals("    O _ O", arr[30]);
    assertEquals("Score: 29", arr[31]);
    assertEquals("    O O O", arr[32]);
    assertEquals("    O _ O", arr[33]);
    assertEquals("O O O O O O O", arr[34]);
    assertEquals("O O O O _ _ O", arr[35]);
    assertEquals("O O O O _ _ O", arr[35]);
    assertEquals("    O _ O", arr[37]);
    assertEquals("    O _ O", arr[38]);
    assertEquals("Score: 28", arr[39]);
    assertEquals("    O O O", arr[40]);
    assertEquals("    O _ O", arr[41]);
    assertEquals("O O O O O O O", arr[42]);
    assertEquals("O O _ _ O _ O", arr[43]);
    assertEquals("O O O O O O O", arr[44]);
    assertEquals("    O _ O", arr[45]);
    assertEquals("    O _ O", arr[46]);
    assertEquals("Score: 27", arr[47]);
    assertEquals("    O O O", arr[48]);
    assertEquals("    O _ O", arr[49]);
    assertEquals("O O O O O O O", arr[50]);
    assertEquals("_ _ O _ O _ O", arr[51]);
    assertEquals("O O O O O O O", arr[52]);
    assertEquals("    O _ O", arr[53]);
    assertEquals("    O _ O", arr[54]);
    assertEquals("Score: 26", arr[55]);
    assertEquals("Game over!", arr[56]);
    assertEquals("    O O O", arr[57]);
    assertEquals("    O _ O", arr[58]);
    assertEquals("O O O O O O O", arr[59]);
    assertEquals("_ _ O _ O _ O", arr[60]);
    assertEquals("O O O O O O O", arr[61]);
    assertEquals("    O _ O", arr[62]);
    assertEquals("    O _ O", arr[63]);
    assertEquals("Score: 26", arr[64]);
  }

  @Test
  public void testPlayInvalidAndValidInputs() {
    Readable r = new StringReader("a\n-1\n7\n9\n9\n4\n4\n2\n4\n4\nQ");
    this.ctrl = new MarbleSolitaireControllerImpl(model, view, r);

    this.ctrl.playGame();

    String[] arr = app.toString().split("\n");

    assertEquals("    O O O", arr[0]);
    assertEquals("    O O O", arr[1]);
    assertEquals("O O O O O O O", arr[2]);
    assertEquals("O O O _ O O O", arr[3]);
    assertEquals("O O O O O O O", arr[4]);
    assertEquals("    O O O", arr[5]);
    assertEquals("    O O O", arr[6]);
    assertEquals("Score: 32", arr[7]);
    assertEquals("Not an integer or 'q'.", arr[8]);
    assertEquals("All integers must be positive", arr[9]);
    assertEquals("Invalid move. Play again. " +
            "(7, 9) to (9, 4) is an invalid move.", arr[10]);
    assertEquals("    O O O", arr[11]);
    assertEquals("    O O O", arr[12]);
    assertEquals("O O O O O O O", arr[13]);
    assertEquals("O O O _ O O O", arr[14]);
    assertEquals("O O O O O O O", arr[15]);
    assertEquals("    O O O", arr[16]);
    assertEquals("    O O O", arr[17]);
    assertEquals("Score: 32", arr[18]);
    assertEquals("    O O O", arr[19]);
    assertEquals("    O O O", arr[20]);
    assertEquals("O O O O O O O", arr[21]);
    assertEquals("O _ _ O O O O", arr[22]);
    assertEquals("O O O O O O O", arr[23]);
    assertEquals("    O O O", arr[24]);
    assertEquals("    O O O", arr[25]);
    assertEquals("Score: 31", arr[26]);
    assertEquals("Game quit!", arr[27]);
    assertEquals("State of game when quit:", arr[28]);
    assertEquals("    O O O", arr[29]);
    assertEquals("    O O O", arr[30]);
    assertEquals("O O O O O O O", arr[31]);
    assertEquals("O _ _ O O O O", arr[32]);
    assertEquals("O O O O O O O", arr[33]);
    assertEquals("    O O O", arr[34]);
    assertEquals("    O O O", arr[35]);
    assertEquals("Score: 31", arr[36]);
  }

  @Test
  public void testPlayGameNoSuchElement() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable a = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, a);
    Readable input = new ReadableTest2();
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, view, input);

    try {
      controller.playGame();
      fail("should have thrown an IllegalStateException");
    } catch (IllegalStateException e) {
      if (!(e.getMessage().equals("Readable is out of inputs"))) {
        fail("Should have throw IllegalStateException: Readable is out of inputs");
      }
    }
  }

  @Test
  public void testPlayGameNumberFormatExc() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable a = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, a);
    Readable input = new ReadableTest1();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, input);

    try {
      controller.playGame();
      fail("should have thrown a NumberFormatException");
    } catch (NumberFormatException e) {
      if (!(e.getMessage().equals("number format exception test!"))) {
        fail("should have thrown an IllegalStateException: Not an integer or 'q'.");
      }
    }
  }

  @Test
  public void testIntInputs() {
    Readable r = new StringReader("1\n2\n3\n4\nq");
    this.app = new StringBuilder();

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MarbleSolitaireMock(log);
    MarbleSolitaireView view = new MarbleSolitaireTextView(mock, this.app);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(mock, view, r);

    controller.playGame();

    assertEquals("fromRow: 0 fromCol: 1 toRow: 2 toCol: 3", log.toString());
  }

  @Test
  public void testMixedInputs() {
    Readable r = new StringReader("1 2 a w 3 4 q");
    this.app = new StringBuilder();

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MarbleSolitaireMock(log);
    MarbleSolitaireView view = new MarbleSolitaireTextView(mock, this.app);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(mock, view, r);

    controller.playGame();

    assertEquals("fromRow: 0 fromCol: 1 toRow: 2 toCol: 3", log.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testInvalidInputs() {
    Readable r = new StringReader("p @ !");
    this.app = new StringBuilder();

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MarbleSolitaireMock(log);
    MarbleSolitaireView view = new MarbleSolitaireTextView(mock, this.app);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(mock, view, r);

    controller.playGame();
  }

  @Test
  public void testQ() {
    Readable r = new StringReader("q");
    this.app = new StringBuilder();

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MarbleSolitaireMock(log);
    MarbleSolitaireView view = new MarbleSolitaireTextView(mock, this.app);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(mock, view, r);

    controller.playGame();

    assertEquals("", log.toString());
  }


  @Test
  public void testInputsNull() {
    Readable r = null;
    this.app = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MarbleSolitaireMock(log);
    MarbleSolitaireView view = new MarbleSolitaireTextView(mock, this.app);

    try {
      MarbleSolitaireController controller =
              new MarbleSolitaireControllerImpl(mock, view, r);
      fail("should have thrown exception");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Parameters cannot be null")) {
        fail();
      }
    }
  }

  @Test(expected = NullPointerException.class)
  public void testOutputNull() {
    Readable r = new StringReader("3 3 1 q");
    this.app = new StringBuilder();
    StringBuilder log = null;
    MarbleSolitaireModel mock = new MarbleSolitaireMock(log);
    MarbleSolitaireView view = new MarbleSolitaireTextView(mock, this.app);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(mock, view, r);
    assertEquals("", log.toString());
  }


  @Test
  public void testTriangleGameInputs() {
    Readable r = new StringReader("3 3 1 1 4 2 2 2 5 5 3 3 2 " +
            "2 4 4 5 4 3 2 2 1 4 3 5 3 3 3 3 3 5 5 5 1 5 3 3 1 5 1 q");
    this.app = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MarbleSolitaireMock(log);
    MarbleSolitaireView view = new TriangleSolitaireTextView(mock, this.app);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(mock, view, r);

    controller.playGame();

    assertEquals("fromRow: 2 fromCol: 2 toRow: 0 toCol: 0fromRow: 3 " +
            "fromCol: 1 toRow: 1 toCol: 1fromRow: 4 fromCol: 4 toRow: 2 toCol: 2fromRow: " +
            "1 fromCol: 1 toRow: 3 toCol: 3fromRow: 4 fromCol: 3 toRow: 2 toCol: 1fromRow: " +
            "1 fromCol: 0 toRow: 3 toCol: 2fromRow: 4 fromCol: 2 toRow: 2 toCol: 2fromRow: 2 " +
            "fromCol: 2 toRow: 4 toCol: 4fromRow: 4 fromCol: 0 toRow: 4 toCol: 2fromRow: 2 " +
            "fromCol: 0 toRow: 4 toCol: 0", log.toString());
  }

  @Test
  public void testInputsQ() {
    Readable r = new StringReader("q");
    this.app = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MarbleSolitaireMock(log);
    MarbleSolitaireView view = new TriangleSolitaireTextView(mock, this.app);

    assertEquals("", log.toString());
  }

  @Test
  public void testOutQ() {
    Readable r = new StringReader("1 2 3");
    this.app = new StringBuilder();
    StringBuilder log = new StringBuilder("q");
    MarbleSolitaireModel mock = new MarbleSolitaireMock(log);
    MarbleSolitaireView view = new TriangleSolitaireTextView(mock, this.app);

    assertEquals("q", log.toString());
  }


  @Test
  public void testTriangleGameInputsNull() {
    Readable r = null;
    this.app = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mock = new MarbleSolitaireMock(log);
    MarbleSolitaireView view = new TriangleSolitaireTextView(mock, this.app);

    try {
      MarbleSolitaireController controller =
              new MarbleSolitaireControllerImpl(mock, view, r);
      fail("should have thrown exception");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Parameters cannot be null")) {
        fail();
      }
    }
  }

  @Test(expected = NullPointerException.class)
  public void testTriangleGameOutputNull() {
    Readable r = new StringReader("3 3 1 q");
    this.app = new StringBuilder();
    StringBuilder log = null;
    MarbleSolitaireModel mock = new MarbleSolitaireMock(log);
    MarbleSolitaireView view = new TriangleSolitaireTextView(mock, this.app);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(mock, view, r);
    assertEquals("", log.toString());
  }

}