package prisoner;

public class Player {
  private int myScore;
  private String myName;

  public Player(String name) {
    myScore = 0;
    myName = name;
  }

  // returns the name and the class in parentheses
  public String toString() {
    return (myName);
  }

  ////// keeping score methods
  public void increaseScore(int amt) {
    myScore += amt;
  }

  public int score() {
    return myScore;
  }

  ////// choice methods
  // provides the players choice for this round, returning true if the
  // player should cooperate, or false otherwise.
  public boolean cooperate() {
    return true;
  }

  // called by the simulation framework after each turn is completed
  // parameter reflects oppenents choice in that turn.
  public void opponentChoice(boolean opponentCooperated) {
    // default implementation does nothing with this information
  }
}
