package prisoner;

public class TitForTat extends Player {
  
  private boolean opponentCooperated = true;

  public TitForTat(String name) {
    super(name);
  }

  @Override
  public void opponentChoice(boolean opponentCooperated) {
    this.opponentCooperated = opponentCooperated;
  }

  @Override
  public boolean cooperate() {
    return opponentCooperated;
  }
}
