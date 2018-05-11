package start;

public class Treecko extends Pokemon implements Runable{
    public Treecko(){
        super("Treecko", 90, 30);
    }

    public void move(){
        this.run();
    }

    public void run(){
        this.reducedWeight(2);
    }
}