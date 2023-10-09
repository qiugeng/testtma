package com.getTema.tma.lyrric;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChineseZodiacCounter extends JFrame implements ActionListener {
    private JLabel ratLabel, oxLabel, tigerLabel, rabbitLabel, dragonLabel, snakeLabel,
            horseLabel, sheepLabel, monkeyLabel, roosterLabel, dogLabel, pigLabel, totalLabel;
    private JTextField ratField, oxField, tigerField, rabbitField, dragonField, snakeField,
            horseField, sheepField, monkeyField, roosterField, dogField, pigField, totalField;
    private JButton calculateButton;

    public ChineseZodiacCounter() {
        super("Chinese Zodiac Counter");

        // create labels and text fields for each zodiac
        ratLabel = new JLabel("Rat:");
        ratField = new JTextField(5);
        oxLabel = new JLabel("Ox:");
        oxField = new JTextField(5);
        tigerLabel = new JLabel("Tiger:");
        tigerField = new JTextField(5);
        rabbitLabel = new JLabel("Rabbit:");
        rabbitField = new JTextField(5);
        dragonLabel = new JLabel("Dragon:");
        dragonField = new JTextField(5);
        snakeLabel = new JLabel("Snake:");
        snakeField = new JTextField(5);
        horseLabel = new JLabel("Horse:");
        horseField = new JTextField(5);
        sheepLabel = new JLabel("Sheep:");
        sheepField = new JTextField(5);
        monkeyLabel = new JLabel("Monkey:");
        monkeyField = new JTextField(5);
        roosterLabel = new JLabel("Rooster:");
        roosterField = new JTextField(5);
        dogLabel = new JLabel("Dog:");
        dogField = new JTextField(5);
        pigLabel = new JLabel("Pig:");
        pigField = new JTextField(5);

        // create button to calculate total
        calculateButton = new JButton("Calculate Total");
        calculateButton.addActionListener(this);

        // create label and text field to display total
        totalLabel = new JLabel("Total:");
        totalField = new JTextField(10);
        totalField.setEditable(false);

        // create panel to hold labels and text fields
        JPanel inputPanel = new JPanel(new GridLayout(13, 2));
        inputPanel.add(ratLabel);
        inputPanel.add(ratField);
        inputPanel.add(oxLabel);
        inputPanel.add(oxField);
        inputPanel.add(tigerLabel);
        inputPanel.add(tigerField);
        inputPanel.add(rabbitLabel);
        inputPanel.add(rabbitField);
        inputPanel.add(dragonLabel);
        inputPanel.add(dragonField);
        inputPanel.add(snakeLabel);
        inputPanel.add(snakeField);
        inputPanel.add(horseLabel);
        inputPanel.add(horseField);
        inputPanel.add(sheepLabel);
        inputPanel.add(sheepField);
        inputPanel.add(monkeyLabel);
        inputPanel.add(monkeyField);
        inputPanel.add(roosterLabel);
        inputPanel.add(roosterField);
        inputPanel.add(dogLabel);
        inputPanel.add(dogField);
        inputPanel.add(pigLabel);
        inputPanel.add(pigField);
        inputPanel.add(calculateButton);

        // create panel to hold total label and text field
        JPanel outputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        outputPanel.add(totalLabel);
        outputPanel.add(totalField);

        // add panels to frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // calculate total and display in total field
        int ratCount = Integer.parseInt(ratField.getText());
        int oxCount = Integer.parseInt(oxField.getText());
        int tigerCount = Integer.parseInt(tigerField.getText());
        int rabbitCount = Integer.parseInt(rabbitField.getText());
        int dragonCount = Integer.parseInt(dragonField.getText());
        int snakeCount = Integer.parseInt(snakeField.getText());
        int horseCount = Integer.parseInt(horseField.getText());
        int sheepCount = Integer.parseInt(sheepField.getText());
        int monkeyCount = Integer.parseInt(monkeyField.getText());
        int roosterCount = Integer.parseInt(roosterField.getText());
        int dogCount = Integer.parseInt(dogField.getText());
        int pigCount = Integer.parseInt(pigField.getText());

        int totalCount = ratCount + oxCount + tigerCount + rabbitCount + dragonCount + snakeCount
                + horseCount + sheepCount + monkeyCount + roosterCount + dogCount + pigCount;

        totalField.setText(Integer.toString(totalCount));
    }

    public static void main(String[] args) {
        new ChineseZodiacCounter();
    }
}
