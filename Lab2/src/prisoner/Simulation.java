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

    System.out.println("Player vs Player");
    new Simulation(new Player("p1"), new Player("p2"), numOfTurns);
    
    System.out.println("Player vs Competitor");
    new Simulation(new Player("p1"), new Competitor("p2"), numOfTurns);
    
    System.out.println("Player vs RandomChooser");
    new Simulation(new Player("p1"), new RandomChooser("p2"), numOfTurns);
    
    System.out.println("Player vs Unforgiving");
    new Simulation(new Player("p1"), new Unforgiving("p2"), numOfTurns);
    
    System.out.println("Player vs TitForTat");
    new Simulation(new Player("p1"), new TitForTat("p2"), numOfTurns);
    
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
      # Which kind of player wins against the most other kinds of players?
      > Looks like the Competitor wins the most of the time
    
      # Which two kinds of players score the highest together?
      > I got 30:80 on Player vs RandomChooser.
    
      # Which kind of player scores the highest against the range of other player types?
      > I'm not sure if I understand this question. But, I think the answer is Competitor. 100 vs 0
    
      # Describe a new kind of player (that could be coded) that would play better, in some way,
      than any of the 5 players you’ve defined. Just describe the player, don’t code it!
      > Oh, this is really hard. I don't have any ideas. Maybe it's because I've never been to jail =)
      > I guess I need some algorithm that would beat the Competitor. But, nothing comes to my mind
      > since the Competitor will win anyway or there will be a draw.
    */
  }
}
