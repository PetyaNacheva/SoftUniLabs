package aquarium;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class AquariumTests {

    @Test
    public void testConstructor(){
        Aquarium aquarium = new Aquarium("Test",20);
        String expect = "Test";
        int expectCapacity = 20;
        Assert.assertEquals(expect,aquarium.getName());
        Assert.assertEquals(expectCapacity,aquarium.getCapacity());
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameNullException(){
        Aquarium aquarium = new Aquarium("",20);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNullExceptionWithNull(){
        Aquarium aquarium = new Aquarium(null,20);
        Assert.assertNull(aquarium.getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeCapacity(){
        Aquarium aquarium = new Aquarium("Test",-20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFishThrowException(){
        Aquarium aquarium = new Aquarium("Test",0);
        Fish fish = new Fish("Test");
        aquarium.add(fish);
    }

    @Test
    public void testAddFish(){
        Aquarium aquarium = new Aquarium("Test",1);
        Fish fish = new Fish("Test");
        aquarium.add(fish);
        int expected =1;
        Assert.assertEquals(expected,aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowException(){
        Aquarium aquarium = new Aquarium("Test",1);
        Fish fish = new Fish("Test");
        aquarium.add(fish);
        aquarium.remove("My");
    }

    @Test
    public void testRemoveShouldRemoveCorrectly(){
        Aquarium aquarium = new Aquarium("Test",1);
        Fish fish = new Fish("Test");
        aquarium.add(fish);
        aquarium.remove("Test");
        Assert.assertEquals(0,aquarium.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSellFishThrowException(){
        Aquarium aquarium = new Aquarium("Test",1);
        Fish fish = new Fish("Test");
        aquarium.add(fish);
        aquarium.sellFish("My");
    }
    @Test
    public void testSellFishShouldWorkCorrectly(){
        Aquarium aquarium = new Aquarium("Test",1);
        Fish fish = new Fish("Test");
        aquarium.add(fish);
        aquarium.sellFish("Test");
        Assert.assertFalse(fish.isAvailable());
    }
}

