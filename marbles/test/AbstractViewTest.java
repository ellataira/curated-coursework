import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Abstract testing class for marble solitaire view.
 */
public abstract class AbstractViewTest {

  MarbleSolitaireModel model;
  Appendable app1;
  MarbleSolitaireView viewExcTest;
  MarbleSolitaireView viewGood;
  Appendable app2;

  public abstract MarbleSolitaireView constructor1(MarbleSolitaireModelState state);

  public abstract MarbleSolitaireView constructor2(MarbleSolitaireModelState state,
                                                   Appendable destination);

  @Test
  public abstract void testBoardRender();

  @Test
  public void testTextViewConstructors() {
    try {
      MarbleSolitaireView ms1 = constructor1(null);
      fail("should have thrown an illegal argument exception");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("Provided model state is null"))) {
        fail("should have thrown an illegal argument exception: Provided model state is null");
      }
    }
    try {
      MarbleSolitaireView ms1 = constructor2(null, null);
      fail("should have thrown an illegal argument exception");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("Provided model state or appendable is null."))) {
        fail("should have thrown an illegal argument exception: " +
                "Provided model state or appendable is null.");
      }
    }
    EnglishSolitaireModel m = new EnglishSolitaireModel();
    Appendable a = new StringBuilder();
    try {
      MarbleSolitaireView ms1 = constructor2(m, null);
      fail("should have thrown an illegal argument exception");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("Provided model state or appendable is null."))) {
        fail("should have thrown an illegal argument exception: " +
                "Provided model state or appendable is null.");
      }
    }
    try {
      MarbleSolitaireView ms1 = constructor2(null, a);
      fail("should have thrown an illegal argument exception");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("Provided model state or appendable is null."))) {
        fail("should have thrown an illegal argument exception: " +
                "Provided model state or appendable is null.");
      }
    }
  }

  @Test
  public void testRenderBoard() {
    try {
      this.viewExcTest.renderBoard();
      fail("Should have thrown IOException");
    } catch (IOException e) {
      if (!(e.getMessage().equals("appendable test class exception"))) {
        fail("Should have thrown IOException: appendable test class exception");
      }
    }

    try {
      this.viewGood.renderBoard();
    } catch (IOException e) {
      throw new RuntimeException("transmission failed");
    }
  }

  @Test
  public void testRenderMessage() {
    try {
      this.viewExcTest.renderMessage("oatmeal");
      fail("Should have thrown IOException");
    } catch (IOException e) {
      if (!(e.getMessage().equals("appendable test class exception"))) {
        fail("Should have thrown IOException: appendable test class exception");
      }
    }
    try {
      this.viewExcTest.renderMessage("oatmeal \n cats");
      fail("Should have thrown IOException");
    } catch (IOException e) {
      if (!(e.getMessage().equals("appendable test class exception"))) {
        fail("Should have thrown IOException: appendable test class exception");
      }
    }
    try {
      this.viewGood.renderMessage("oatmeal");
    } catch (IOException e) {
      throw new RuntimeException("transmission failed");
    }
    String s = this.app2.toString();
    assertEquals("oatmeal", s);
    try {
      this.viewGood.renderMessage("\ncats ");
    } catch (IOException e) {
      throw new RuntimeException("transmissoin failed");
    }
    String s2 = this.app2.toString();
    assertEquals("oatmeal\ncats ", s2);
  }
}
