package cs3500.marblesolitaire.model.hw02;

/**
 * A mock class to test Marble Solitaire game.
 * The controller method, playGame, will call upon the methods from the mock.
 * To test that the controller is reading inputs correctly.
 */
public class MarbleSolitaireMock implements MarbleSolitaireModel {
  final StringBuilder log;

  /**
   * The mock class takes in a StringBuilder to log inputs.
   *
   * @param log StringBuilder to append inputs to
   */
  public MarbleSolitaireMock(StringBuilder log) {
    this.log = log;
  }

  /**
   * Mocks a move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    log.append("fromRow: " + fromRow + " fromCol: "
            + fromCol + " toRow: " + toRow + " toCol: " + toCol);
  }

  /**
   * Mocks isGameOver: game is not over.
   * @return false, game not over
   */
  @Override
  public boolean isGameOver() {
    return false;
  }

  /**
   * Mocks getBoardSize: board is 7 wide.
   * @return 7
   */
  @Override
  public int getBoardSize() {
    return 0;
  }

  /**
   * Mocks getSlotState and returns null.
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return null
   */
  @Override
  public SlotState getSlotAt(int row, int col) {
    return null;
  }

  /**
   * Mocks get score and returns 0.
   * @return 0
   */
  @Override
  public int getScore() {
    return 0;
  }

}
