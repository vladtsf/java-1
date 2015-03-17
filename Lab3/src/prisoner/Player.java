package prisoner;

public abstract class Player {
  private int myScore;
  private String myName;

  public Player(String name) {
    myScore = 0;
    myName = name;
  }

  // returns the name and the class in parentheses
  @Override
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
  public abstract boolean cooperate();

  // called by the simulation framework after each turn is completed
  // parameter reflects oppenents choice in that turn.
  public abstract void opponentChoice(boolean opponentCooperated);
}
