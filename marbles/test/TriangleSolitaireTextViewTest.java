import org.junit.Before;

import cs3500.marblesolitaire.controller.AppendableTest;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * Testing class for Triangle solitaire text views.
 */
public class TriangleSolitaireTextViewTest extends AbstractViewTest {


  @Before
  public void init() {
    this.model = new TriangleSolitaireModel();
    this.app1 = new AppendableTest();
    this.viewExcTest = new TriangleSolitaireTextView(this.model, this.app1);
    this.app2 = new StringBuilder();
    this.viewGood = new TriangleSolitaireTextView(this.model, this.app2);
  }


  @Override
  public MarbleSolitaireView constructor1(MarbleSolitaireModelState state) {
    return new TriangleSolitaireTextView(state);
  }

  @Override
  public MarbleSolitaireView constructor2(MarbleSolitaireModelState state, Appendable destination) {
    return new TriangleSolitaireTextView(state, destination);
  }

  @Override
  public void testBoardRender() {
    String[] arr = this.viewGood.toString().split("\n");
    assertEquals("    _", arr[0]);
    assertEquals("   O O", arr[1]);
    assertEquals("  O O O", arr[2]);
    assertEquals(" O O O O", arr[3]);
    assertEquals("O O O O O", arr[4]);
  }
}