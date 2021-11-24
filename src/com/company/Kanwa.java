package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Kanwa extends JPanel {
    ArrayList<Rectangle> k = new ArrayList<Rectangle>();
    ArrayList<Oval> l = new ArrayList<>();

    public void ustawK(int a,int b){

        k.add(new Rectangle(a,b,50,30));
        repaint();

    }

    public void ustawO(int a,int b){

        l.add(new Oval(a,b,30,30));
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D f = (Graphics2D) g;
        Graphics2D q = (Graphics2D) g;


        for(Rectangle current:k){
            f.setColor(Color.BLUE);
            f.fill(current);
        }
        for(Oval current:l){
            q.setColor(Color.GREEN);
            q.fillOval(current.getX(),current.getY(),current.getW(),current.getH());
        }
    }


}
