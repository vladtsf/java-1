import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CounterTest {
  private Counter counter;
  
  public CounterTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
    counter = new Counter();
  }
  
  @After
  public void tearDown() {
  }

   @Test
   public void increment() {
     counter.increment();
     assertEquals(1, counter.value());
   }
   
   @Test
   public void reset() {
     counter.reset();
     assertEquals(0, counter.value());
   }
}
