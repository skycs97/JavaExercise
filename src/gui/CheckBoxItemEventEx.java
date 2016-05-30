package gui;

/**
 * 명품Java 예제 11-4
 * Modified by jyheo on 2016-05-29.
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CheckBoxItemEventEx extends JFrame {
    String [] names = {"사과", "배", "체리"};
    JCheckBox [] fruits = new JCheckBox [names.length];

    int[] prices = new int[] {100, 500, 20000};

    JLabel sumLabel;
    int sum = 0;

    CheckBoxItemEventEx() {
        setTitle("체크박스와 ItemEvent  예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            sb.append(names[i]);
            sb.append(" ");
            sb.append(prices[i]);
            sb.append("원, ");
        }
        contentPane.add(new JLabel(sb.toString()));

        for(int i = 0; i < fruits.length; i++) {
            fruits[i] = new JCheckBox(names[i]);
            fruits[i].setBorderPainted(true);
            contentPane.add(fruits[i]);
            fruits[i].addItemListener(new MyItemListener());
        }
        sumLabel = new JLabel("현재 0 원 입니다.");
        contentPane.add(sumLabel);
        setSize(250,200);
        setVisible(true);
    }

    class MyItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            int selected=1;
            if(e.getStateChange() == ItemEvent.SELECTED)
                selected = 1;
            else
                selected = -1;
            if(e.getItem() == fruits[0])
                sum = sum + selected*100;  // 직접 가격값을 쓰지말고 price 배열을 이용하시오.
            else if(e.getItem() == fruits[1])
                sum = sum + selected*500;
            else
                sum = sum + selected*20000;

            sumLabel.setText("현재 "+sum+"원 입니다.");
        }
    }
    public static void main(String [] args) {
        new CheckBoxItemEventEx();
    }
}

