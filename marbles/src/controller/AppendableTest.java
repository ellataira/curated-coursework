package cs3500.marblesolitaire.controller;

import java.io.IOException;

/**
 * Appendable class for testing purposes.
 */
public class AppendableTest implements Appendable {

  /**
   * Appends the specified character sequence to this Appendable.
   * @param csq
   *         The character sequence to append.  If {@code csq} is
   *         {@code null}, then the four characters {@code "null"} are
   *         appended to this Appendable.
   *
   * @return nothing
   * @throws IOException when the method is called
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("appendable test class exception");
  }

  /**
   * Appends the specified character sequence to this Appendable.
   * @param csq
   *         The character sequence from which a subsequence will be
   *         appended.  If {@code csq} is {@code null}, then characters
   *         will be appended as if {@code csq} contained the four
   *         characters {@code "null"}.
   *
   * @param start
   *         The index of the first character in the subsequence
   *
   * @param end
   *         The index of the character following the last character in the
   *         subsequence
   *
   * @return nothing
   * @throws IOException when the method is called
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("appendable test class exception");
  }

  /**
   * Appends the specified character sequence to this Appendable.
   * @param c
   *         The character to append
   *
   * @return nothing
   * @throws IOException when the method is called
   */
  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("appendable test class exception");
  }
}

