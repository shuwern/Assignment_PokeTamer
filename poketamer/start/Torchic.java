package start;

public class Torchic extends Pokemon implements Runable{
    public Torchic(){
        super("Torchic", 80, 40, 0, 1);
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