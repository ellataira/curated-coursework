import org.junit.Before;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests Triangle Solitaire models.
 */
public class TriangleSolitaireModelTest extends AbstractModelTest {

  String t1;
  String t2;

  @Before
  public void init() {
    this.m1 = new TriangleSolitaireModel();
    this.m2 = new TriangleSolitaireModel(7, 2, 2);
    this.m3 = new TriangleSolitaireModel(5);
    this.m4 = new TriangleSolitaireModel(8);
    this.m5 = new TriangleSolitaireModel(6);

    this.t1 = "      O\n" +
            "     O O\n" +
            "    O O _\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O";

    this.t2 = "       _\n" +
            "      O O\n" +
            "     O O O\n" +
            "    O O O O\n" +
            "   O O O O O\n" +
            "  O O O O O O\n" +
            " O O O O O O O\n" +
            "O O O O O O O O";
  }

  @Override
  MarbleSolitaireModel constructor1() {
    return new TriangleSolitaireModel();
  }

  @Override
  MarbleSolitaireModel constructor2(int sRow, int sCol) {
    return new TriangleSolitaireModel(sRow, sCol);
  }

  @Override
  MarbleSolitaireModel constructor3(int a) {
    return new TriangleSolitaireModel(a);
  }

  @Override
  MarbleSolitaireModel constructor4(int a, int sRow, int sCol) {
    return new TriangleSolitaireModel(a, sRow, sCol);
  }

  @Override
  public void testInvalidConstructorOddArmOrInvalid() {
    try {
      this.m1 = constructor4(4, 0, 0);
      return;
    } catch (IllegalArgumentException e) {
      fail("triangles may have even widths");
    }
    try {
      this.m1 = constructor2(5, 5);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("Invalid empty cell position (5, 5)"))) {
        fail();
      }
    }
    try {
      this.m1 = constructor2(0,5);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("the given coordinates are invalid"))) {
        fail();
      }
    }


  }

  @Override
  public void testToString() {
    MarbleSolitaireView tv2 = new TriangleSolitaireTextView(this.m4);
    assertEquals(this.t2, tv2.toString());

    MarbleSolitaireView tv1 = new TriangleSolitaireTextView(this.m2);
    assertEquals(this.t1, tv1.toString());
    this.m2.move(0, 0, 2, 2);
    assertEquals("      _\n" +
            "     O _\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", tv1.toString());
  }

  @Override
  public void testIsGameOver() {
    boolean f = this.m1.isGameOver();

    assertFalse(this.m1.isGameOver());
    this.m1.move(2, 2, 0, 0);
    this.m1.move(3, 1, 1, 1);
    this.m1.move(4, 4, 2, 2);
    assertFalse(this.m5.isGameOver());
    this.m1.move(1, 1, 3, 3);
    this.m1.move(4, 3, 2, 1);
    this.m1.move(1, 0, 3, 2);
    this.m1.move(4, 2, 2, 2);
    assertFalse(this.m1.isGameOver());
    this.m1.move(2, 2, 4, 4);
    this.m1.move(4, 0, 4, 2);
    this.m1.move(2, 0, 4, 0);
    assertTrue(this.m1.isGameOver());
  }

  @Override
  public void testMove() {
    try {
      this.m1.move(300, 1, 1, 2);
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Given coordinates must be within the board.")) {
        fail();
      }
    }
    try {
      this.m1.move(3, 3, 1, 1);
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("(3, 3) to (1, 1) is an invalid move.")) {
        fail();
      }
    }

    this.m1.move(2, 2, 0, 0);

    try {
      this.m1.move(5, 5, 2, 2);
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Given coordinates must be within the board.")) {
        fail();
      }
    }
    try {
      this.m1.move(3, 3, 2, 1);
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("(3, 3) to (2, 1) is an invalid move.")) {
        fail();
      }
    }

    this.m1.move(3, 1, 1, 1);
    this.m1.move(4, 4, 2, 2);
    assertFalse(this.m5.isGameOver());
    this.m1.move(1, 1, 3, 3);
    this.m1.move(4, 3, 2, 1);
    this.m1.move(1, 0, 3, 2);
    this.m1.move(4, 2, 2, 2);
    assertFalse(this.m5.isGameOver());
    this.m1.move(2, 2, 4, 4);
    this.m1.move(4, 0, 4, 2);
    this.m1.move(2, 0, 4, 0);
  }

  @Override
  public void testGetBoardSize() {
    assertEquals(this.m1.getBoardSize(), 5);
    assertEquals(this.m2.getBoardSize(), 7);
    assertEquals(this.m4.getBoardSize(), 8);

  }

  @Override
  public void testMakeBoard() {
    assertEquals(this.m2.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(2, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.m2.getSlotAt(3, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(4, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(4, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(5, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(5, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(5, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(5, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(5, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(6, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(6, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(6, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(6, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(6, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(6, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.m2.getSlotAt(6, 6), MarbleSolitaireModelState.SlotState.Marble);


    assertEquals(this.m2.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m2.getSlotAt(1, 2), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m2.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m2.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m2.getSlotAt(4, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.m2.getSlotAt(5, 6), MarbleSolitaireModelState.SlotState.Invalid);

  }

  @Override
  public void testGetScore() {
    assertEquals(14, this.m1.getScore());
    this.m1.move(2, 2, 0, 0);
    assertEquals(13, this.m1.getScore());
    this.m1.move(3, 1, 1, 1);
    assertEquals(12, this.m1.getScore());
  }

  @Override
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m1.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.m1.getSlotAt(0,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m1.getSlotAt(1,1));
    try {
      this.m1.getSlotAt(10, 300);
      fail("should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("the given location is beyond the board's dimensions.")) {
        fail();
      }
    }
  }
}