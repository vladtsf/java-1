package prisoner;

public class Competitor extends Player {

  public Competitor(String name) {
    super(name);
  }
  
  @Override
  public boolean cooperate() {
    return false;
  }

  @Override
  public void opponentChoice(boolean opponentCooperated) {
    // this does nothing   
  }
  
}
