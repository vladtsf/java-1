package prisoner;

public class Cooperator extends Player {

  public Cooperator(String name) {
    super(name);
  }
  
  @Override
  public boolean cooperate() {
    return true;
  }
  
  @Override
  public void opponentChoice(boolean opponentCooperated) {
    // default implementation does nothing with this information
  }
  
}
