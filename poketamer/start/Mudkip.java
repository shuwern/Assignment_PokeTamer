package start;

public class Mudkip extends Pokemon implements Runable{
    public Mudkip(){
        super("Mudkip", 100, 50);
    }

    public void move(){
        this.run();
    }

    public void run(){
        this.reducedWeight(2);
    }
}