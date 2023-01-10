package cs3500.marblesolitaire.controller;

import java.nio.CharBuffer;

/**
 * A Readable class to test for NumberFormatExceptions.
 */
public class ReadableTest1 implements Readable {

  /**
   * Dummy method to throw a NumberFormatException.
   *
   * @param cb the buffer to read characters into
   * @return nothing.
   * @throws NumberFormatException when method is called.
   */
  @Override
  public int read(CharBuffer cb) throws NumberFormatException {
    throw new NumberFormatException("number format exception test!");
  }
}
