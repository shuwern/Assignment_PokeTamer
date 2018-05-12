package start;

abstract class Pokemon{
    public final double maxHealth;
    protected double health;
    protected double weight;
    protected String name;
    protected double exp;
    protected int level;

    public Pokemon(String name, double maxHealth, double weight, double exp, int level){
        this.name = name;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.weight = weight;
        this.exp = exp;
        this.level = level;
    }

    public double getWeight(){
        return this.weight;
    }

    public double getHealth(){
        return this.health;
    }

    public double getExp(){
        return this.exp;
    }

    public int getLevel(){
        return this.level;
    }

    public String getName(){
        return this.name;
    }

    public void eat(Berry berry){
        this.health += berry.getRestoreValue();
        this.weight += berry.getRestoreWeight();
        if(this.health > this.maxHealth)
            this.health = this.maxHealth;
        if(this.health <= 0)
            this.health = 0;
    }

    public void reducedHealth(double value){
        this.health -= value;
        if(this.health <= 0)
            this.health = 0;
    }

    public void reducedWeight(double value){
        this.weight -= value;
        if(this.weight < 30)
            this.weight = 30;
    }

    public void expUp(double value){
        if(this.health != 0 && this.weight <= 100)
            this.exp += value;
        if(this.exp > 100)
            this.exp = 100;
    }

    public void levelUp(){
        if(this.exp == 100){
            this.level += 1;
            this.exp = 0;
        }
    }

    abstract public void move();
    abstract public void battle();
}