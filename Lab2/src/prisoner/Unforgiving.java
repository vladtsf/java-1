package prisoner;

public class Unforgiving extends Player {

  private boolean isMad = false;
  
  public Unforgiving(String name) {
    super(name);
  }
  
  @Override
  public void opponentChoice(boolean opponentCooperated) {
    if(!opponentCooperated) {
      isMad = true;
    }
  }
  
  @Override
  public boolean cooperate() {
    return !isMad;
  }
  
}
