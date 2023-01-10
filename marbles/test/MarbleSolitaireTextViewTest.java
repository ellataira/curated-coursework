import org.junit.Before;

import cs3500.marblesolitaire.controller.AppendableTest;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;


/**
 * Testing class for a MarbleSolitaire view.
 */
public class MarbleSolitaireTextViewTest extends AbstractViewTest {

  @Before
  public void init() {
    this.model = new EnglishSolitaireModel();
    this.app1 = new AppendableTest();
    this.viewExcTest = new MarbleSolitaireTextView(this.model, this.app1);
    this.app2 = new StringBuilder();
    this.viewGood = new MarbleSolitaireTextView(this.model, this.app2);
  }

  @Override
  public MarbleSolitaireTextView constructor1(MarbleSolitaireModelState state) {
    return new MarbleSolitaireTextView(state);
  }

  @Override
  public MarbleSolitaireTextView constructor2(MarbleSolitaireModelState state,
                                              Appendable destination) {
    return new MarbleSolitaireTextView(state, destination);
  }

  @Override
  public void testBoardRender() {
    String[] arr = this.viewGood.toString().split("\n");
    assertEquals("    O O O", arr[0]);
    assertEquals("    O O O", arr[1]);
    assertEquals("O O O O O O O", arr[2]);
    assertEquals("O O O _ O O O", arr[3]);
    assertEquals("O O O O O O O", arr[4]);
    assertEquals("    O O O", arr[5]);
    assertEquals("    O O O", arr[6]);
  }

}

