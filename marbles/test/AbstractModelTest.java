import org.junit.Assert;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * An abstract testing class to test models.
 * This class is extended in concrete classes Triangle- ,European- , and English-
 * SolitaireModel.
 */
public abstract class AbstractModelTest {

  MarbleSolitaireModel m1;
  MarbleSolitaireModel m2;
  MarbleSolitaireModel m3;
  MarbleSolitaireModel m4;
  MarbleSolitaireModel m5;

  abstract MarbleSolitaireModel constructor1();

  abstract MarbleSolitaireModel constructor2(int sRow, int sCol);

  abstract MarbleSolitaireModel constructor3(int a);

  abstract MarbleSolitaireModel constructor4(int a, int sRow, int sCol);


  @Test
  public void testValidConstructor() {
    try {
      this.m1 = constructor3(3);
      return;
    } catch (IllegalArgumentException e) {
      fail("should not have thrown an exception");
    }
    try {
      this.m1 = constructor4(3, 3, 3);
      return;
    } catch (IllegalArgumentException e) {
      fail("should not have thrown an exception");
    }
    try {
      this.m1 = constructor2(3, 3);
      return;
    } catch (IllegalArgumentException e) {
      fail("should not have thrown an exception");
    }
    try {
      this.m1 = constructor1();
      return;
    } catch (IllegalArgumentException e) {
      fail("should not have thrown an exception");
    }

  }

  @Test
  public void testInvalidConstructor2() {
    try {
      this.m1 = constructor2(30, 30);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("the given coordinates are invalid"))) {
        fail();
      }
    }
  }

  @Test
  public void testInvalidConstructor3() {
    try {
      this.m1 = constructor3(-3);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("arm thickness is not a positive number"))) {
        fail();
      }
    }
  }

  @Test
  public abstract void testInvalidConstructorOddArmOrInvalid();

  @Test
  public void testInvalidConstructor4() {
    try {
      this.m1 = constructor4(3, 0, 1);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("Invalid empty cell position (0, 1)"))) {
        fail();
      }
    }
    try {
      this.m1 = constructor4(3, 5, 6);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("Invalid empty cell position (5, 6)")
              || e.getMessage().equals("the given coordinates are invalid"))) {
        fail();
      }
    }
  }

  @Test
  public void testMove() {
    try {
      this.m1.move(0, 0, 0, 2);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("(0, 0) to (0, 2) is an invalid move."))) {
        fail();
      }
    }
    try {
      this.m1.move(-1, 0, 0, 2);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("Given coordinates must be within the board."))) {
        fail();
      }
    }
    try {
      this.m1.move(60, 0, 0, 2);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("Given coordinates must be within the board."))) {
        fail();
      }
    }
    try {
      this.m1.move(0, 2, 3, 2);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("(0, 2) to (3, 2) is an invalid move."))) {
        fail();
      }
    }
    try {
      this.m1.move(2, 3, 4, 3);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("(2, 3) to (4, 3) is an invalid move."))) {
        fail();
      }
    }
    try {
      this.m1.move(1, 3, 9, 3);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("Given coordinates must be within the board."))) {
        fail();
      }
    }
    try {
      this.m1.move(1, 3, 4, 3);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("(1, 3) to (4, 3) is an invalid move."))) {
        fail();
      }
    }
    try {
      this.m1.move(3, 2, 1, 4);
      fail("should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("(3, 2) to (1, 4) is an invalid move."))) {
        fail();
      }
    }

    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m1.getSlotAt(3, 3));

    this.m1.move(1, 3, 3, 3);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m1.getSlotAt(3, 3));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m1.getSlotAt(3, 3));

    this.m1.move(4, 3, 2, 3);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m1.getSlotAt(2, 3));
  }

  @Test
  public void testViewConstructorException() {
    try {
      new MarbleSolitaireTextView(null);
    } catch (IllegalArgumentException e) {
      if (!(e.getMessage().equals("Provided model state is null"))) {
        fail();
      }
    }
  }

  @Test
  public void testGetBoardSize() {
    assertEquals(7, this.m1.getBoardSize());
    assertEquals(13, this.m3.getBoardSize());
  }

  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.m1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m1.getSlotAt(4, 3));

    try {
      this.m1.getSlotAt(10, 300);
      fail("should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("the given location is beyond the board's dimensions.")) {
        fail();
      }
    }
  }

  @Test
  public abstract void testToString();

  @Test
  public abstract void testIsGameOver();

  @Test
  public abstract void testMakeBoard();

  @Test
  public abstract void testGetScore();


}
