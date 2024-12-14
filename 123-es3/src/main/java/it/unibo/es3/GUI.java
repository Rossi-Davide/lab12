package it.unibo.es3;

import javax.swing.*;



import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GUI extends JFrame {
    
    private final Map<JButton,Pair<Integer,Integer>> cells = new HashMap<>();
    private final Logics logic;
    
    public GUI(int width) {

        logic = new LogicsImpl(width);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        
        JPanel panel = new JPanel(new GridLayout(width,width));
        JPanel maiPanel = new JPanel(new BorderLayout());
        maiPanel.add(panel,BorderLayout.CENTER);
        this.getContentPane().add(maiPanel);
        



        ActionListener al = e -> {
            var jb = (JButton)e.getSource();
            logic.hit(cells.get(jb));
        	jb.setText("*");
        };
                
        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
            	var pos = new Pair<>(j,i);
                final JButton jb = new JButton(" ");
                this.cells.put(jb, pos);
                jb.addActionListener(al);
                panel.add(jb);
            }
        }

        List<Pair<Integer,Integer>> initialPositions = logic.hitRandomPoints(3);

        updateButtonsAtPosition(initialPositions);


        ActionListener animate = e -> {
            List<Pair<Integer,Integer>> animations = logic.animate();

            updateButtonsAtPosition(animations);

            if(logic.toQuit()) {
                System.exit(0);
            }
        };

        JButton animButton = new JButton("<");
        animButton.addActionListener(animate);
        maiPanel.add(animButton,BorderLayout.SOUTH);

        this.setVisible(true);
    }


    public void updateButtonsAtPosition(List<Pair<Integer,Integer>> positions) {
        positions.forEach(position -> {
            JButton button = cells.entrySet()
                                    .stream()
                                    .filter(e -> e.getValue().equals(position))
                                    .findAny()
                                    .get()
                                    .getKey();
            button.setText("*");
        });
    }
    
}