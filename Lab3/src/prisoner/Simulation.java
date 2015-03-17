package prisoner;
import java.util.HashMap;

public class Simulation {

  final static boolean PROVIDE_INFORMATION_PER_TURN = false;
  private static HashMap results = new HashMap();

  /////////////// constructors
  public Simulation(Player p1, Player p2) {
    this(p1, p2, 200);
  }

  public Simulation(Player p1, Player p2, int numberOfTurns) {
    
    for (int k = 0; k < numberOfTurns; k++) {
      boolean p1cooperated = p1.cooperate();
      boolean p2cooperated = p2.cooperate();
      if (p1cooperated) {
        if (p2cooperated) {
          p1.increaseScore(3);
          p2.increaseScore(3);
        } else {
          p1.increaseScore(0);
          p2.increaseScore(5);
        }
      } else {
        if (p2cooperated) {
          p1.increaseScore(5);
          p2.increaseScore(0);
        } else {
          p1.increaseScore(1);
          p2.increaseScore(1);
        }
      }

      if (PROVIDE_INFORMATION_PER_TURN) {
        System.out.println("Turn " + k + ": " + p1 + " " + p1cooperated + "(score = " + p1.score() + "), " + p2 + " " + p2cooperated + "(score = " + p2.score() + ")");
      }

      p1.opponentChoice(p2cooperated);
      p2.opponentChoice(p1cooperated);
    }

    System.out.println("\nGame over, " + numberOfTurns + " turns:");
    System.out.println(" Player 1 (" + p1.getClass().getName() + ") has score = " + p1.score());
    System.out.println(" Player 2 (" + p2.getClass().getName() + ") has score = " + p2.score());
    
    recordScore(p1, p2);
  }
  
  private static void recordScore(Player p1, Player p2) {
    if(results.get(p1.getClass()) == null) {
      results.put(p1.getClass(), 0);
    }
    
    if(results.get(p2.getClass()) == null) {
      results.put(p2.getClass(), 0);
    }
    
    if(p1.score() > p2.score()) {
      results.put(p1.getClass(), (int) results.get(p1.getClass()) + 1);
      results.put(p2.getClass(), (int) results.get(p2.getClass()) - 1);
    } else if(p1.score() < p2.score()) {
      results.put(p1.getClass(), (int) results.get(p1.getClass()) - 1);
      results.put(p2.getClass(), (int) results.get(p2.getClass()) + 1);
    }
  }

  public static void main(String[] args) {
    int numOfTurns = 20;

    System.out.println("Cooperator vs Cooperator");
    new Simulation(new Cooperator("p1"), new Cooperator("p2"), numOfTurns);
    
    System.out.println("Cooperator vs Competitor");
    new Simulation(new Cooperator("p1"), new Competitor("p2"), numOfTurns);
    
    System.out.println("Cooperator vs RandomChooser");
    new Simulation(new Cooperator("p1"), new RandomChooser("p2"), numOfTurns);
    
    System.out.println("Cooperator vs Unforgiving");
    new Simulation(new Cooperator("p1"), new Unforgiving("p2"), numOfTurns);
    
    System.out.println("Cooperator vs TitForTat");
    new Simulation(new Cooperator("p1"), new TitForTat("p2"), numOfTurns);
    
    System.out.println("Competitor vs RandomChooser");
    new Simulation(new Competitor("p1"), new RandomChooser("p2"), numOfTurns);

    System.out.println("Competitor vs Unforgiving");
    new Simulation(new Competitor("p1"), new Unforgiving("p2"), numOfTurns);

    System.out.println("Competitor vs TitForTat");
    new Simulation(new Competitor("p1"), new TitForTat("p2"), numOfTurns);

    System.out.println("RandomChooser vs Unforgiving");
    new Simulation(new RandomChooser("p1"), new Unforgiving("p2"), numOfTurns);

    System.out.println("RandomChooser vs TitForTat");
    new Simulation(new RandomChooser("p1"), new TitForTat("p2"), numOfTurns);

    System.out.println("Unforgiving vs TitForTat");
    new Simulation(new Unforgiving("p1"), new TitForTat("p2"), numOfTurns);
    
    System.out.println("Rating: " + Simulation.results.toString());
    /*
    Output:
    
    run:
    Cooperator vs Cooperator

    Game over, 20 turns:
     Player 1 (prisoner.Cooperator) has score = 60
     Player 2 (prisoner.Cooperator) has score = 60
    Cooperator vs Competitor

    Game over, 20 turns:
     Player 1 (prisoner.Cooperator) has score = 0
     Player 2 (prisoner.Competitor) has score = 100
    Cooperator vs RandomChooser

    Game over, 20 turns:
     Player 1 (prisoner.Cooperator) has score = 30
     Player 2 (prisoner.RandomChooser) has score = 80
    Cooperator vs Unforgiving

    Game over, 20 turns:
     Player 1 (prisoner.Cooperator) has score = 60
     Player 2 (prisoner.Unforgiving) has score = 60
    Cooperator vs TitForTat

    Game over, 20 turns:
     Player 1 (prisoner.Cooperator) has score = 60
     Player 2 (prisoner.TitForTat) has score = 60
    Competitor vs RandomChooser

    Game over, 20 turns:
     Player 1 (prisoner.Competitor) has score = 68
     Player 2 (prisoner.RandomChooser) has score = 8
    Competitor vs Unforgiving

    Game over, 20 turns:
     Player 1 (prisoner.Competitor) has score = 24
     Player 2 (prisoner.Unforgiving) has score = 19
    Competitor vs TitForTat

    Game over, 20 turns:
     Player 1 (prisoner.Competitor) has score = 24
     Player 2 (prisoner.TitForTat) has score = 19
    RandomChooser vs Unforgiving

    Game over, 20 turns:
     Player 1 (prisoner.RandomChooser) has score = 15
     Player 2 (prisoner.Unforgiving) has score = 55
    RandomChooser vs TitForTat

    Game over, 20 turns:
     Player 1 (prisoner.RandomChooser) has score = 43
     Player 2 (prisoner.TitForTat) has score = 43
    Unforgiving vs TitForTat

    Game over, 20 turns:
     Player 1 (prisoner.Unforgiving) has score = 60
     Player 2 (prisoner.TitForTat) has score = 60
    Rating: {class prisoner.Cooperator=-2, class prisoner.Unforgiving=0, class prisoner.RandomChooser=-1, class prisoner.Competitor=4, class prisoner.TitForTat=-1}
    BUILD SUCCESSFUL (total time: 0 seconds)
    */
  }
}
