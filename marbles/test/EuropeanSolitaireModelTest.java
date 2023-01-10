import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests European Marble Solitaire models.
 */
public class EuropeanSolitaireModelTest extends AbstractModelTest {
  @Before
  public void init() {
    this.m1 = new EuropeanSolitaireModel();
    this.m3 = new EuropeanSolitaireModel(5);
  }

  @Override
  MarbleSolitaireModel constructor1() {
    return new EuropeanSolitaireModel();
  }

  @Override
  MarbleSolitaireModel constructor2(int sRow, int sCol) {
    return new EuropeanSolitaireModel(sRow, sCol);
  }

  @Override
  MarbleSolitaireModel constructor3(int a) {
    return new EuropeanSolitaireModel(a);
  }

  @Override
  MarbleSolitaireModel constructor4(int a, int sRow, int sCol) {
    return new EuropeanSolitaireModel(a, sRow, sCol);
  }

  @Override
  public void testInvalidConstructorOddArmOrInvalid() {
    try {
      this.m1 = constructor4(4, 4, 4);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("arm thickness must be odd."))) {
        fail();
      }
    }
    try {
      this.m1 = constructor3(4);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("arm thickness must be odd."))) {
        fail();
      }
    }
    try {
      this.m1 = constructor2(0, 0);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("Invalid empty cell position (0, 0)"))) {
        fail();
      }
    }
  }

  @Test
  public void testMakeBoard() {
    assertEquals(m1.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(m1.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(m1.getSlotAt(0, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(0, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(0, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(0, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(m1.getSlotAt(0, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(m1.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(m1.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(1, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(1, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(1, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(1, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(m1.getSlotAt(2, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(2, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(2, 6), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(3, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(m1.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(3, 6), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(4, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(4, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(4, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(4, 6), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(5, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(m1.getSlotAt(5, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(5, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(5, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(5, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(5, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(m1.getSlotAt(6, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(m1.getSlotAt(6, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(m1.getSlotAt(6, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(6, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(6, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(m1.getSlotAt(6, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(m1.getSlotAt(6, 6), MarbleSolitaireModelState.SlotState.Invalid);
  }

  @Override
  public void testGetScore() {
    assertEquals(36, this.m1.getScore());
    assertEquals(128, this.m3.getScore());

    this.m1 = new EuropeanSolitaireModel(2,3);
    this.m1.move(0,3,2,3);
    this.m1.move(1,5,1,3);
    this.m1.move(3,5,1,5);

    assertEquals(33, this.m1.getScore());
  }

  @Override
  public void testIsGameOver() {
    this.m1 = new EuropeanSolitaireModel(2,3);
    assertFalse(this.m1.isGameOver());
    assertEquals(36, this.m1.getScore());

    this.m1.move(0,3,2,3);
    this.m1.move(1,5,1,3);
    this.m1.move(3,5,1,5);
    assertFalse(this.m1.isGameOver());
    this.m1.move(5,5,3,5);
    this.m1.move(2,3,2,5);
    this.m1.move(2,1,2,3);
    this.m1.move(0,2,2,2);
    this.m1.move(2,6,2,4);
    assertFalse(this.m1.isGameOver());
    this.m1.move(5,3,5,5);
    this.m1.move(3,4,5,4);
    this.m1.move(3,3,5,3);
    this.m1.move(6,3,4,3);
    this.m1.move(5,1,5,3);
    this.m1.move(6,4,4,4);
    assertFalse(this.m1.isGameOver());
    this.m1.move(4,1,2,1);
    this.m1.move(4,3,4,1);
    this.m1.move(1,1,3,1);
    this.m1.move(4,0,4,2);
    this.m1.move(2,0,4,0);
    this.m1.move(3,2,1,2);
    this.m1.move(1,2,1,4);
    this.m1.move(2,4,2,2);
    this.m1.move(3,6,3,4);
    assertFalse(this.m1.isGameOver());
    this.m1.move(3,4,5,4);
    this.m1.move(5,4,5,2);
    this.m1.move(5,2,3,2);
    this.m1.move(3,1,3,3);
    this.m1.move(1,5,1,3);
    assertTrue(this.m1.isGameOver());
    assertEquals(8, this.m1.getScore());
  }

  @Override
  public void testToString() {
    MarbleSolitaireView euroView = new MarbleSolitaireTextView(this.m1);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euroView.toString());
    this.m1.move(5,3,3,3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O", euroView.toString());

    MarbleSolitaireView euroView2 = new MarbleSolitaireTextView(this.m3);
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", euroView2.toString());
  }
}