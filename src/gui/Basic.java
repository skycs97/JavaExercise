package gui;

/**
 * Created by jyheo on 2016-05-16.
 */
import javax.swing.*;
import java.awt.*;

public class Basic extends JFrame {
    Basic() {
        setTitle("Basic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(new JLabel("Button"));
        getContentPane().add(new JButton("OK"));
        getContentPane().add(new JButton("Cancel"));

        setSize(320, 240);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Basic();
        // main thread is terminated!
    }
}

