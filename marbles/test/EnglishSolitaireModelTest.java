
import org.junit.Before;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests EnglishSolitaireModel methods.
 */
public class EnglishSolitaireModelTest extends AbstractModelTest {

  String b1;
  String b2;
  String b1afterMove;
  MarbleSolitaireTextView v1;
  MarbleSolitaireTextView v2;

  @Before
  public void init() {
    this.m1 = new EnglishSolitaireModel();
    this.m2 = new EnglishSolitaireModel(0, 2);
    this.m3 = new EnglishSolitaireModel(5);
    this.m4 = new EnglishSolitaireModel(5, 0, 5);
    this.m5 = new EnglishSolitaireModel(3, 0, 2);

    this.b1 =
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O";

    this.b2 = "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O";

    this.b1afterMove = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O";

    this.v1 = new MarbleSolitaireTextView(this.m1);
    this.v2 = new MarbleSolitaireTextView(this.m3);
  }

  @Override
  MarbleSolitaireModel constructor1() {
    return new EnglishSolitaireModel();
  }


  @Override
  MarbleSolitaireModel constructor2(int sRow, int sCol) {
    return new EnglishSolitaireModel(sRow, sCol);
  }

  @Override
  MarbleSolitaireModel constructor3(int a) {
    return new EnglishSolitaireModel(a);
  }

  @Override
  MarbleSolitaireModel constructor4(int a, int sRow, int sCol) {
    return new EnglishSolitaireModel(a, sRow, sCol);
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


  @Override
  public void testMakeBoard() {
    assertEquals(this.m1.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(0, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(0, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(0, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(0, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(0, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(1, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(1, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(1, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(1, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(2, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(2, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(2, 6), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(3, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.m1.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(3, 6), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(4, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(4, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(4, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(4, 6), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(5, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(5, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(5, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(5, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(5, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(5, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(6, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(6, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(6, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(6, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(6, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m1.getSlotAt(6, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m1.getSlotAt(6, 6), MarbleSolitaireModelState.SlotState.Invalid);
  }

  @Override
  public void testGetScore() {
    assertEquals(32, this.m1.getScore());
    assertEquals(32, this.m2.getScore());
    assertEquals(104, this.m3.getScore());
    assertEquals(104, this.m4.getScore());
  }

  @Override
  public void testIsGameOver() {
    assertFalse(this.m1.isGameOver());
    assertEquals(32, this.m1.getScore());

    this.m1.move(3, 1, 3, 3);
    this.m1.move(5, 2, 3, 2);
    this.m1.move(4, 0, 4, 2);
    assertFalse(this.m1.isGameOver());
    this.m1.move(2, 0, 4, 0);
    this.m1.move(3, 2, 5, 2);
    this.m1.move(6, 2, 4, 2);
    this.m1.move(4, 3, 4, 1);
    this.m1.move(4, 0, 4, 2);
    assertFalse(this.m1.isGameOver());
    this.m1.move(4, 5, 4, 3);
    this.m1.move(4, 2, 4, 4);
    this.m1.move(6, 3, 4, 3);
    this.m1.move(4, 3, 4, 5);
    this.m1.move(6, 4, 4, 4);
    this.m1.move(4, 5, 4, 3);
    this.m1.move(2, 5, 4, 5);
    this.m1.move(4, 6, 4, 4);
    assertFalse(this.m1.isGameOver());
    this.m1.move(2, 6, 4, 6);
    this.m1.move(4, 3, 4, 5);
    this.m1.move(4, 6, 4, 4);
    this.m1.move(2, 3, 2, 5);
    this.m1.move(4, 4, 2, 4);
    this.m1.move(2, 5, 2, 3);
    this.m1.move(0, 4, 2, 4);
    assertFalse(this.m1.isGameOver());
    this.m1.move(2, 3, 2, 5);
    this.m1.move(2, 1, 2, 3);
    this.m1.move(0, 2, 2, 2);
    assertFalse(this.m1.isGameOver());
    this.m1.move(2, 2, 2, 4);
    this.m1.move(0, 3, 2, 3);
    this.m1.move(3, 3, 1, 3);
    assertFalse(this.m1.isGameOver());
    this.m1.move(2, 5, 2, 3);
    this.m1.move(1, 3, 3, 3);
    assertTrue(this.m1.isGameOver());


    assertTrue(this.m1.isGameOver());
    assertEquals(1, this.m1.getScore());
  }


  @Override
  public void testToString() {
    assertEquals(this.b1, v1.toString());
    assertEquals(this.b2, v2.toString());

    MarbleSolitaireModel m = new EnglishSolitaireModel();
    m.move(5, 3, 3, 3);
    MarbleSolitaireTextView v1Move = new MarbleSolitaireTextView(m);
    assertEquals(this.b1afterMove, v1Move.toString());
  }

}
