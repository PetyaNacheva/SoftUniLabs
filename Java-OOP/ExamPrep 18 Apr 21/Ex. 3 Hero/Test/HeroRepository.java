package heroRepository;

import org.junit.Assert;
import org.junit.Test;

public class HeroRepositoryTests {
    @Test
    public void testCreateHero(){
        Hero hero = new Hero("Test",3);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(hero);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHeroShouldThrowException(){
        Hero hero = null;
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(hero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroShouldThrowExceptionHeroExist(){
        Hero hero = new Hero("Test",3);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(hero);
        heroRepository.create(hero);
    }
    @Test
    public void testGetCount(){
        Hero hero = new Hero("Test",3);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(hero);
        Assert.assertEquals(1,heroRepository.getCount());
    }

    @Test
    public void testRemove(){
        Hero hero = new Hero("Test",3);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(hero);
        heroRepository.remove(hero.getName());
    }
    @Test(expected = NullPointerException.class)
    public void testRemoveThrowException(){
        Hero hero = new Hero("",3);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(hero);
        heroRepository.remove(hero.getName());
    }
    @Test
    public void testGetHero(){
        Hero hero = new Hero("Test",3);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(hero);
        Assert.assertEquals("Test",heroRepository.getHero("Test").getName());
    }
    @Test
    public void testGetHeroHighestLevel(){
        Hero hero = new Hero("Test",3);
        Hero hero2 = new Hero("Test2",5);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(hero);
        heroRepository.create(hero2);
        int expected = 5;
        Assert.assertEquals(expected,heroRepository.getHeroWithHighestLevel().getLevel());
    }

    @Test
    public void testGetHeroes(){
        Hero hero = new Hero("Test",3);
        Hero hero2 = new Hero("Test2",5);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(hero);
        heroRepository.create(hero2);
        int expected = 2;
        Assert.assertEquals(expected,heroRepository.getHeroes().size());
    }
}
