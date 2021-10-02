package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private Gun gun;
    private boolean isAlive;

    public PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
    }

    private void setUsername(String userName) {
        this.username = userName;
    }

    @Override
    public String getUsername() {
        return null;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getHealth() {
        return 0;
    }

    private void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public int getArmor() {
        return 0;
    }

    private void setGun(Gun gun) {
        this.gun = gun;
    }

    @Override
    public Gun getGun() {
        return null;
    }

    private void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public void takeDamage(int points) {

    }
}
