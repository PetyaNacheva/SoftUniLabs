package farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {

    @Test
    public void testConstructor(){
        Farm farm = new Farm("My",100);
        String expected = "My";

        Assert.assertEquals(expected, farm.getName());
        Assert.assertEquals(100,farm.getCapacity());
        Animal animal = new Animal("Cow",10);

        farm.add(animal);
        Assert.assertEquals(1,farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrow(){
        Farm farm = new Farm("My",0);
        Animal animal = new Animal("Cow",10);
        farm.add(animal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowAnimalExcist(){
        Farm farm = new Farm("My",2);
        Animal animal = new Animal("Cow",10);
        farm.add(animal);
        farm.add(animal);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacity(){
        Farm farm = new Farm("My",-2);
    }

    @Test(expected = NullPointerException.class)
    public void testInvalidName(){
        Farm farm = new Farm(" ",2);
    }

    @Test
    public void testRemove(){
        Farm farm = new Farm("My",2);
        Animal animal = new Animal("Cow",10);
        farm.add(animal);
        Assert.assertEquals(1,farm.getCount());
        farm.remove("Cow");
        Assert.assertEquals(0,farm.getCount());
    }

    @Test
    public void testRemoveShouldThrow(){
        Farm farm = new Farm("My",2);
        Animal animal = new Animal("Cow",10);
        farm.add(animal);
        Assert.assertEquals(1,farm.getCount());
        farm.remove("Fish");
        Assert.assertEquals(1,farm.getCount());

    }
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm
}
