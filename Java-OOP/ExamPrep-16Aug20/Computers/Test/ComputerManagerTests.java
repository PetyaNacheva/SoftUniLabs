package computers;

import org.junit.Assert;
import org.junit.Test;

public class ComputerManagerTests {
   @Test
    public void testConstructor(){
       ComputerManager computerManager = new ComputerManager();
       Computer computer = new Computer("Acer","Aspire",120);
       computerManager.addComputer(computer);
       String expectedModel = "Aspire";
       String actual = computer.getModel();
       int expectedCount =1;
       int actualCount = computerManager.getCount();
       Assert.assertEquals(expectedModel,actual);
       Assert.assertEquals(expectedCount,actualCount);
   }
   @Test
   public void testAddComputer(){
       ComputerManager computerManager = new ComputerManager();
       Computer computer = new Computer("Acer","Aspire",120);
       computerManager.addComputer(computer);
       int expectedCount =1;
       int actualCount = computerManager.getCount();
       Assert.assertEquals(expectedCount,actualCount);
   }

   @Test
    public void testGetComputerByManufacturer(){
       ComputerManager computerManager = new ComputerManager();
       Computer computer = new Computer("Acer","Aspire",120);
       computerManager.addComputer(computer);
       int expectedCount=1;
       Assert.assertEquals(expectedCount,computerManager.getComputersByManufacturer("Acer").size());

   }

    @Test
    public void testGetComputer(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Acer","Aspire",120);
        computerManager.addComputer(computer);
        Computer computer1 = new Computer("HP","Compaq",100);
        computerManager.addComputer(computer1);
        double expectedPrice =100;
        Assert.assertEquals(expectedPrice,computerManager.getComputer("HP","Compaq").getPrice(),0);

    }

    @Test
    public void testGetComputerCount(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Acer","Aspire",120);
        computerManager.addComputer(computer);
        int expectedCount=1;
        Assert.assertEquals(expectedCount,computerManager.getCount());
    }

    @Test
    public void testGetComputers(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Acer","Aspire",120);
        computerManager.addComputer(computer);
        Computer computer1 = new Computer("HP","Compaq",100);
        computerManager.addComputer(computer1);
        int expectedCount =2;
        Assert.assertEquals(expectedCount,computerManager.getComputers().size());
    }
    @Test
    public void testRemoveComputers(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Acer","Aspire",120);
        computerManager.addComputer(computer);
        Computer computer1 = new Computer("HP","Compaq",100);
        computerManager.addComputer(computer1);
        computerManager.removeComputer("HP","Compaq");
        int expectedCount =1;
        Assert.assertEquals(expectedCount,computerManager.getComputers().size());
    }



}
