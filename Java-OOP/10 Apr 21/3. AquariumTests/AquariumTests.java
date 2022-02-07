package aquarium;

import org.junit.Assert;
import org.junit.Test;

public class AquariumTests {
    @Test
    public void testConstructor(){
        Aquarium aquarium = new Aquarium("Best",2);
        String name = "Best";
        int capacity = 2;
        Assert.assertEquals(name,aquarium.getName());
        Assert.assertEquals(capacity,aquarium.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorInvalidName(){
        Aquarium aquarium = new Aquarium("  ",2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorInvalidCapacity(){
        Aquarium aquarium = new Aquarium("Best",-2);
    }

    @Test
    public void testAdd(){
        Aquarium aquarium = new Aquarium("Best",1);
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);
        Assert.assertEquals(1,aquarium.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddIncorrectNumber(){
        Aquarium aquarium = new Aquarium("Best",1);
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);
        aquarium.add(fish);
    }
    @Test
    public void testRemove(){
        Aquarium aquarium = new Aquarium("Best",1);
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);
        aquarium.remove("Nemo");
        Assert.assertEquals(0, aquarium.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveIncorrectName(){
        Aquarium aquarium = new Aquarium("Best",1);
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);
        aquarium.remove("MMy");
    }

    @Test
    public void sellFish(){
        Aquarium aquarium = new Aquarium("Best",1);
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);
        aquarium.sellFish("Nemo");
        Assert.assertFalse(fish.isAvailable());
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellFishIncorrectName(){
        Aquarium aquarium = new Aquarium("Best",1);
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);
        aquarium.sellFish("My");

    }


    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium
}

