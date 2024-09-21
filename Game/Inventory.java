public class Inventory {
    private boolean water,food,firewood;
    private String wName, aName;
    private int damage, armor;


    Inventory(){
        this.water = false;
        this.food = false;
        this.firewood = false;
        this.damage = 0;
        this.armor = 0;
        this.wName = "";
        this.aName = "";
    }

    public boolean getWater(){
        return this.water;
    }
    public void setWater(boolean water){
        this.water = water;
    }

    public boolean getFood(){
        return this.food;
    }
    public void setFood(boolean food){
        this.food = food;
    }

    public boolean getFirewood(){
        return this.firewood;
    }
    public void setFirewood(boolean firewood){
        this.firewood = firewood;
    }

    public void setWName(String name){
        this.wName = name;
    }
    public String getWName(){
        return this.wName;
    }

    public void setaName(String aName){
        this.aName = aName;
    }
    public String getaName(){
        return this.aName;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getDamage(){
        return this.damage;
    }

    public void setArmor(int armor){
        this.armor = armor;
    }
    public int getArmor(){
        return this.armor;
    }


}
