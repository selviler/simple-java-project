package Definition;

public class Zombie {
    String name;
    int damage, award, health, maxNumber;

    public Zombie(String name, int damage, int award, int health, int maxNumber) {
        this.name = name;
        this.damage = damage;
        this.award = award;
        this.health = health;
        this.maxNumber = maxNumber;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getDamage()
    {
        return this.damage;
    }
    public void setAward(int award){
        this.award = award;
    }
    public int getAward()
    {
        return this.award;
    }
    public void setHealth(int award){
        this.award = award;
    }
    public int getHealth()
    {
        return this.award;
    }
    public void setMaxNumber(int award){
        this.award = award;
    }
    public int getMaxNumber()
    {
        return this.award;
    }
}
