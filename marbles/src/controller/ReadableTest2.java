package cs3500.marblesolitaire.controller;

import java.nio.CharBuffer;
import java.util.NoSuchElementException;

/**
 * A Readable class to test for NumberFormatExceptions.
 */
public class ReadableTest2 implements Readable {

  /**
   * Dummy method to throw a NumberFormatException.
   *
   * @param cb the buffer to read characters into
   * @return nothing.
   * @throws NoSuchElementException when method is called.
   */
  @Override
  public int read(CharBuffer cb) throws NoSuchElementException {
    throw new NoSuchElementException("number format exception test!");
  }

}
