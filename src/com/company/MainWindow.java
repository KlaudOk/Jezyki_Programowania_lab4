package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MainWindow extends JFrame{


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow window = new MainWindow();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    public MainWindow() throws HeadlessException {
        this("undefined");
    }

    public MainWindow(String title) throws HeadlessException {
        super(title);
        buildFrame();
    }

    protected void buildFrame() {

        setBounds(0, 0, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel contentPane = new JPanel();
        contentPane.setFocusable(true);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton logButton = new JButton("Złap mnie");
        logButton.setSize(100,20);
        logButton.setLocation(160,150);
        logButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //aby najechac na przycisk nalezy sprobowac najechac na niego od lewej strony
                super.mouseEntered(e);
                Random r = new Random();
                Point p = MouseInfo.getPointerInfo().getLocation();
                double a =(int) p.getX();
                double b =(int) p.getY();
                int i = logButton.getX();
                int j = logButton.getY();
                if(a>(i+10)&&b>(j+10)){
                    int x = r.nextInt(200);
                    int y = r.nextInt(200);
                    logButton.setLocation(x,y);
                }

            }
        });


        logButton.setEnabled(true);
        contentPane.add(logButton);

        JButton canButton = new JButton("Zresetuj pozycje");
        canButton.setBounds(270,150,130,20);
        canButton.setEnabled(true);
        canButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                logButton.setLocation(160,150);
            }
        });
        contentPane.add(canButton);

        Kanwa pole = new Kanwa();
        pole.setFocusable(true);
        pole.setBounds(0,0,450,300);
        pole.setVisible(true);
        contentPane.add(pole);

        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int a = e.getX();
                int b = e.getY();
                contentPane.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        super.keyPressed(e);
                        if(e.getKeyChar()=='r'){
                            pole.ustawK(a,b);
                        }
                        if(e.getKeyChar()=='c'){
                            pole.ustawO(a,b);
                        }
                    }
                });

            }
        });


    }


}