package start;

abstract class Pokemon{
    public final double maxHealth;
    protected double health;
    protected double weight;
    protected String name;

    public Pokemon(String name, double maxHealth, double weight){
        this.name = name;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.weight = weight;
    }

    public double getWeight(){
        return this.weight;
    }

    public double getHealth(){
        return this.health;
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
        if(this.weight < 40)
            this.weight = 40;
    }
}