package start;

import javax.swing.*;
import java.awt.*;

public class PokeTamer extends JFrame{
    public static void main(String[] args){
        new PokeTamer();
    }

    public PokeTamer(){
        super("PokeTamer");

        Container c = getContentPane();
        JLabel label = new JLabel("Test");

        c.add(label);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }
}