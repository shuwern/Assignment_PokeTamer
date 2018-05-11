package start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokeTamer extends JFrame{
    public static void main(String[] args){
        new PokeTamer();
    }

    public PokeTamer(){
        super("PokeTamer");
        //<container>
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel pHeader = new JPanel();
        pHeader.setLayout(new FlowLayout());
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new FlowLayout());
        JPanel pFooter = new JPanel();
        pFooter.setLayout(new FlowLayout());
        //</container>
        
        //<pCenter>
        Icon iconWhite = new ImageIcon(getClass().getResource("pic_white.png"));

        JLabel iconPokemon = new JLabel("");
        Icon iconTorchic = new ImageIcon(getClass().getResource("pic_torchic.png"));
        Icon iconMudkip = new ImageIcon(getClass().getResource("pic_mudkip.png"));
        Icon iconTreecko = new ImageIcon(getClass().getResource("pic_treecko.png"));
        iconPokemon.setIcon(iconTorchic);

        JLabel iconItem = new JLabel("");
        Icon iconBerry = new ImageIcon(getClass().getResource("pic_berry.png"));
        iconItem.setIcon(iconWhite);

        JLabel iconFeces = new JLabel("");
        Icon iconUnji = new ImageIcon(getClass().getResource("pic_unji.png"));
        iconFeces.setIcon(iconUnji);

        pCenter.add(iconItem);
        pCenter.add(iconPokemon);
        pCenter.add(iconFeces);
        //</pCenter>

        //<pHeader>
        JButton feedButton = new JButton("Feed");
        JButton cleanButton = new JButton("Clean");

        feedButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                iconItem.setIcon(iconBerry);
            }
        });

        cleanButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                iconFeces.setIcon(iconWhite);
            }
        });

        pHeader.add(feedButton); 
        pHeader.add(cleanButton);
        //</pHeader>

        //<pFooter>
        JLabel selectLabel = new JLabel("Select your starter: ");
        JRadioButton RBtorchic = new JRadioButton("Torchic", true);
        JRadioButton RBmudkip = new JRadioButton("Mudkip", false);
        JRadioButton RBtreecko = new JRadioButton("Treecko", false);
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(RBtorchic);
        radioGroup.add(RBmudkip);
        radioGroup.add(RBtreecko);

        RBtorchic.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                iconPokemon.setIcon(iconTorchic);
            }
        });

        RBmudkip.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                iconPokemon.setIcon(iconMudkip);
            }
        });

        RBtreecko.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                iconPokemon.setIcon(iconTreecko);
            }
        });

        pFooter.add(selectLabel);
        pFooter.add(RBtorchic);
        pFooter.add(RBmudkip);
        pFooter.add(RBtreecko);
        //</pFooter>

        //<container_add>
        c.add(pHeader, BorderLayout.NORTH);
        c.add(pCenter, BorderLayout.CENTER);
        c.add(pFooter, BorderLayout.SOUTH);
        //</container_add>

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }
}