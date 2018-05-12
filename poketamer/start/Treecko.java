package start;

public class Treecko extends Pokemon implements Runable{
    public Treecko(){
        super("Treecko", 90, 30, 0, 1);
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