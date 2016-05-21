package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by jyheo on 2016-05-22.
 */

class MyFish2 extends MyObject {
    private int velocity_x = 10;
    private int velocity_y = 10;

    public MyFish2(String name, String shape, int x, int y) {
        super(name, shape, x, y);
    }

    public void new_move(int width, int height) {
        int x = getX();
        int y = getY();

        double rand = Math.random();
        if (rand < 0.5)
            x += velocity_x;
        else
            y += velocity_y;
        if (x + getWidth() >= width) {
            x = width - getWidth();
            velocity_x = -velocity_x;
        } else if (x <= 0) {
            x = 0;
            velocity_x = -velocity_x;
        }
        if (y + getHeight() >= height) {
            y = height - getHeight();
            velocity_y = -velocity_y;
        } else if (y <= 0) {
            y = 0;
            velocity_y = -velocity_y;
        }
        setLocation(x, y);
    }
}


public class LakeMouse extends JFrame implements ActionListener {

    public LakeMouse(int width, int height) {
        setTitle("Lake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(width, height);
        setVisible(true);
        getContentPane().addMouseListener(new MyMouseListener());

        new javax.swing.Timer(100, this).start();
    }

    public void addMyObject(MyObject obj) {
        getContentPane().add(obj);
    }

    public void actionPerformed(ActionEvent e) { // for Timer
        moveObjects();
    }

    public void moveObjects() {
        int width = getContentPane().getWidth();
        int height =getContentPane().getHeight();

        for (Component c : getContentPane().getComponents()) {
            if (c instanceof MyObject)
                ((MyObject)c).new_move(width, height);

        }
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            MyFish2 f = new MyFish2("FIsh", "<#--<", e.getX(), e.getY());
            addMyObject(f);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        LakeMouse lake = new LakeMouse(320, 240);
        MyFish2 f = new MyFish2("FIsh", "<#--<", 20, 20);
        lake.addMyObject(f);
        lake.addMyObject(new MyRock("Rock", "(##)", 100, 100));

        // BAD Practice! changing the state of swing components in main thread.
        // Do it in the event dispatching thread.
        //while (true) {
        //    lake.moveObjects();
        //    Thread.sleep(100);
        //}
    }
}
