package prisoner;

public class Competitor extends Player {

  public Competitor(String name) {
    super(name);
  }
  
  @Override
  public boolean cooperate() {
    return false;
  }
  
}
