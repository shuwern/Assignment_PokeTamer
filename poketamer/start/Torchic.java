package start;

public class Torchic extends Pokemon implements Runable{
    public Torchic(){
        super("Torchic", 80, 40);
    }

    public void move(){
        this.run();
    }

    public void run(){
        this.reducedWeight(2);
    }
}