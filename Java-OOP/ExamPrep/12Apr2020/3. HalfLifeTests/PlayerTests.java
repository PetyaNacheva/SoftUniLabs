package halfLife;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTests {
    @Test
    public void testConstructorCreateInstance(){
        Player player = new Player("Pesho",100);
        Assert.assertNotNull(player);
    }

    @Test
    public void testGetUsername(){
        Player player = new Player("Pesho",100);
        String actualName = player.getUsername();
        String expectedName = "Pesho";
        Assert.assertEquals(expectedName,actualName);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameInvalid(){
        Player player = new Player(null,100);
    }

    @Test
    public void testGetHealth(){
        Player player = new Player("Pesho",100);
        int actualHealth = player.getHealth();
        int expected = 100;
        Assert.assertEquals(expected,actualHealth);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthInvalid(){
        Player player = new Player("Pesho",-100);
    }

    @Test
    public void testGetGuns(){
        Gun gun = new Gun("Makarov",10);
        Player player = new Player("Pesho",100);
        player.addGun(gun);
        int actualSize = player.getGuns().size();
        int expected = 1;
        Assert.assertEquals(expected,actualSize);
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageBelowZero(){
        Player player = new Player("Pesho",100);
        player.takeDamage(100);
        player.takeDamage(50);
    }
    @Test
    public void testTakeDamageAfterAttackHealthIsZero(){
        Player player = new Player("Pesho",100);
        player.takeDamage(120);
        int actual =player.getHealth();
        int expected = 0;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testTakeDamage(){
        Player player = new Player("Pesho",100);
        player.takeDamage(20);
        int actual = player.getHealth();
        int  expected = 80;
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullGun(){
        Player player = new Player("Pesho",100);
        player.addGun(null);
    }

    @Test
    public void testAddGunValid(){
        Player player = new Player("Pesho",100);
        Gun gun = new Gun("Kalashnikov",20);
        player.addGun(gun);
        Gun expectedGun = gun;
        Gun actualGun = player.getGun(gun.getName());
        Assert.assertEquals(expectedGun,actualGun);
    }
    @Test
    public void testRemoveGun(){
        Player player = new Player("Pesho",100);
        Gun gun = new Gun("Kalashnikov",20);
        player.addGun(gun);
       boolean actual =  player.removeGun(gun);
        Assert.assertTrue(actual);
    }

    @Test
    public void testGetValidGun(){
        Player player = new Player("Pesho",100);
        Gun gun = new Gun("Kalashnikov",20);
        player.addGun(gun);
        Gun expectedGun = gun;
        Gun actualGun = player.getGun(gun.getName());
        Assert.assertEquals(expectedGun,actualGun);
    }
    @Test
    public void testGetInvalidGun(){
        Player player = new Player("Pesho",100);
        Gun gun = new Gun("Kalashnikov",20);
        player.addGun(gun);
        Gun expectedGun = null;
        Gun actualGun = player.getGun("rifle");
        Assert.assertNull(actualGun);
    }
}
