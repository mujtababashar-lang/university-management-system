/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unimanag1;

/**
 *
 * @author win11
 */

import javax.swing.*;
import java.awt.event.*;

public class ButtonExample {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Button Demo");
        frame.setSize(400,300);
        frame.setLayout(null);

        JLabel label = new JLabel("Welcome");
        label.setBounds(130,40,200,30);

        JButton button = new JButton("Click Me");
        button.setBounds(120,100,120,40);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                label.setText("Button Clicked!");

            }

        });

        frame.add(label);
        frame.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}