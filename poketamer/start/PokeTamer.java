package start;

import javax.swing.*;

import javafx.scene.control.RadioButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PokeTamer extends JFrame{
    ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    int  membershipOfTorchic, 
         membershipOfMudkip,
         membershipOfTreecko;

    JTextArea printProfile;
    
    public static String printPokemons(ArrayList<Pokemon> pokemons,int member){
        String hp = "Pokemon \n"+
                pokemons.get(member).getName() + "\n"+" health: \n" + String.format("%.0f",pokemons.get(member).getHealth())
                + "/ "+ String.format("%.0f",pokemons.get(member).maxHealth) + "\n" + "EXP: \n" + String.format("%.0f",pokemons.get(member).getExp()) + "/100.0"
                + "\n" + "Level: \n" + pokemons.get(member).getLevel();
        String weight = "\nWeight: \n"+
                pokemons.get(member).getWeight();
        return hp+weight;
    }

    public PokeTamer(){
        super("PokeTamer");
        String pokemonName[] = {
            "Torchic",     
            "Mudkip", 
            "Treecko",   
        };
        pokemons.add(new Torchic());
        pokemons.add(new Mudkip());
        pokemons.add(new Treecko());

        //<container>
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel pHeader = new JPanel();
        pHeader.setLayout(new FlowLayout());
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new FlowLayout());
        JPanel pFooter = new JPanel();
        pFooter.setLayout(new FlowLayout());
        JPanel pRight = new JPanel();
        //</container>
        
        //<pCenter>
        Icon iconWhite = new ImageIcon(getClass().getResource("pic_white.png"));

        JLabel iconPokemon = new JLabel("");
        ImageIcon iconTorchic = new ImageIcon(getClass().getResource("pic_torchic.gif_c200"));
        ImageIcon iconMudkip = new ImageIcon(getClass().getResource("pic_mudkip.gif"));
        ImageIcon iconTreecko = new ImageIcon(getClass().getResource("pic_treecko.gif"));
        iconPokemon.setIcon(iconWhite);

        JLabel iconItem = new JLabel("");
        ImageIcon iconBerry = new ImageIcon(getClass().getResource("pic_berry.png"));
        iconItem.setIcon(iconWhite);

        JLabel iconFeces = new JLabel("");
        ImageIcon iconUnji = new ImageIcon(getClass().getResource("pic_unji.png"));
        iconFeces.setIcon(iconWhite);

        pCenter.add(iconItem);
        pCenter.add(iconPokemon);
        pCenter.add(iconFeces);
        //</pCenter>

        //<pRight>
        printProfile = new JTextArea("",10,7);

        pRight.add(printProfile);
        //</pRight>


        //<pFooter>
        JLabel selectLabel = new JLabel("Select your pokemon: ");
        JRadioButton RBTorchic = new JRadioButton("Torchic", false);
        JRadioButton RBMudkip = new JRadioButton("Mudkip", false);
        JRadioButton RBTreecko = new JRadioButton("Treecko", false);
        ButtonGroup radioGroup = new ButtonGroup();
            radioGroup.add(RBTorchic);
            radioGroup.add(RBMudkip);
            radioGroup.add(RBTreecko);

        RBTorchic.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                iconPokemon.setIcon(iconTorchic);
                    membershipOfTorchic = 0;
                    printProfile.setText(printPokemons(pokemons,membershipOfTorchic));
            }
        });

        RBMudkip.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                iconPokemon.setIcon(iconMudkip);
                    membershipOfMudkip = 1;
                    printProfile.setText(printPokemons(pokemons,membershipOfMudkip));
            }
        });

        RBTreecko.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                iconPokemon.setIcon(iconTreecko);
                    membershipOfTreecko = 2;
                    printProfile.setText(printPokemons(pokemons,membershipOfTreecko));
            }
        });

        pFooter.add(selectLabel);
        pFooter.add(RBTorchic);
        pFooter.add(RBMudkip);
        pFooter.add(RBTreecko);
        //</pFooter>

        //<pHeader>
        JButton feedButton = new JButton("Feed");
        JButton cleanButton = new JButton("Clean");
        JButton exerciseButton = new JButton("Exercise");
        JButton battleButton = new JButton("Battle");
        JButton lvupButton = new JButton("Level Up");

        feedButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(RBTorchic.isSelected()){
                    eatBerry(membershipOfTorchic);
                    iconPokemon.setIcon(iconTorchic);
                    iconFeces.setIcon(iconUnji);
                }
                else if(RBMudkip.isSelected()){
                    eatBerry(membershipOfMudkip);
                    iconPokemon.setIcon(iconMudkip);
                    iconFeces.setIcon(iconUnji);
                }
                else if(RBTreecko.isSelected()){
                    eatBerry(membershipOfTreecko);
                    iconPokemon.setIcon(iconTreecko);
                    iconFeces.setIcon(iconUnji);
                }
            }
        });

        cleanButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                iconFeces.setIcon(iconWhite);
            }
        });

        exerciseButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(RBTorchic.isSelected()){
                    pokemons.get(membershipOfTorchic).move();
                    printProfile.setText(printPokemons(pokemons,membershipOfTorchic));
                    iconPokemon.setIcon(iconTorchic);
                }
                else if(RBMudkip.isSelected()){
                    pokemons.get(membershipOfMudkip).move();
                    printProfile.setText(printPokemons(pokemons,membershipOfMudkip));
                    iconPokemon.setIcon(iconMudkip);
                }
                else if(RBTreecko.isSelected()){
                    pokemons.get(membershipOfTreecko).move();
                    printProfile.setText(printPokemons(pokemons,membershipOfTreecko));
                    iconPokemon.setIcon(iconTreecko);
                }
            }
        });

        battleButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(RBTorchic.isSelected()){
                    pokemons.get(membershipOfTorchic).battle();
                    printProfile.setText(printPokemons(pokemons,membershipOfTorchic));
                    iconPokemon.setIcon(iconTorchic);
                }
                else if(RBMudkip.isSelected()){
                    pokemons.get(membershipOfMudkip).battle();
                    printProfile.setText(printPokemons(pokemons,membershipOfMudkip));
                    iconPokemon.setIcon(iconMudkip);
                }
                else if(RBTreecko.isSelected()){
                    pokemons.get(membershipOfTreecko).battle();
                    printProfile.setText(printPokemons(pokemons,membershipOfTreecko));
                    iconPokemon.setIcon(iconTreecko);
                }
            }
        });

        lvupButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(RBTorchic.isSelected()){
                    pokemons.get(membershipOfTorchic).levelUp();
                    printProfile.setText(printPokemons(pokemons,membershipOfTorchic));
                    iconPokemon.setIcon(iconTorchic);
                }
                else if(RBMudkip.isSelected()){
                    pokemons.get(membershipOfMudkip).levelUp();
                    printProfile.setText(printPokemons(pokemons,membershipOfMudkip));
                    iconPokemon.setIcon(iconMudkip);
                }
                else if(RBTreecko.isSelected()){
                    pokemons.get(membershipOfTreecko).levelUp();
                    printProfile.setText(printPokemons(pokemons,membershipOfTreecko));
                    iconPokemon.setIcon(iconTreecko);
                }
            }
        });

        pHeader.add(feedButton); 
        pHeader.add(cleanButton);
        pHeader.add(exerciseButton);
        pHeader.add(battleButton);
        pHeader.add(lvupButton);
        //</pHeader>

        //<container_add>
        c.add(pHeader, BorderLayout.NORTH);
        c.add(pCenter, BorderLayout.CENTER);
        c.add(pFooter, BorderLayout.SOUTH);
        c.add(pRight, BorderLayout.EAST);
        //</container_add>

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }
    public void eatBerry(int member){
        Berry berry = new Berry();
        pokemons.get(member).eat(berry);
        printProfile.setText(printPokemons(pokemons, member));
    }

}