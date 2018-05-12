package start;

public class Mudkip extends Pokemon implements Runable{
    public Mudkip(){
        super("Mudkip", 100, 50, 0, 1);
    }

    public void move(){
        this.run();
    }

    public void run(){
        this.reducedWeight(2);
    }

    public void battle(){
        this.reducedHealth(Math.random() * 7);
        this.expUp(Math.random() * 5);
    }
}