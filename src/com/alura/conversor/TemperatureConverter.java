package com.alura.conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter {
    private JComboBox tempDe;
    private JComboBox tempPara;
    private JTextField txtTmpValor;
    private JButton btnTmpConverter;
    private JButton btnTmpVoltar;
    private JLabel titleTmpConverter;
    private JLabel labelTmpDe;
    private JLabel labelTmpPara;
    private JLabel labelTmpValor;
    private JPanel tempPanel;



    // Celcius to Fahrenheit
    static double Celcius_to_Fahrenheit(double Celcius){
        double Fahrenheit = (Celcius * 9/5) + 32;
        return Fahrenheit;
    }
    // Celcius to Kelvin
    static double Celcius_to_Kelvin(double Celcius){
        double Kelvin = Celcius + 273.15;
        return Kelvin;
    }

    // Fahrenheit to Celcius
    static double Fahrenheit_to_Celcius(double Fahrenheit){
        double Celcius = (Fahrenheit - 32) * 5/9;
        return Celcius;
    }
    // Fahrenheit to Kelvin
    static double Fahrenheit_to_Kelvin(double Fahrenheit){
        double Kelvin = (Fahrenheit - 32) * 5/9 + 273.15;
        return Kelvin;
    }

    // Kelvin to Celcius
    static double Kelvin_to_Celcius(double Kelvin){
        double Celcius = Kelvin - 273.15;
        return Celcius;
    }
    // Kelvin to Fahrenheit
    static double Kelvin_to_Fahrenheit(double Kelvin){
        double Fahrenheit = (Kelvin - 273.15) * 9/5 + 32;
        return Fahrenheit;
    }
    public TemperatureConverter() {
        JFrame temperatureFrame = new JFrame("Converter");
        temperatureFrame.setContentPane(tempPanel);
        temperatureFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        temperatureFrame.setBounds(800, 300, 800, 600);
        temperatureFrame.setVisible(true);

        btnTmpConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tempDe.getSelectedIndex() == 0 || tempPara.getSelectedIndex() == 0 || txtTmpValor.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Invalid Input", "Getting Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    double tempvalor = Double.parseDouble(txtTmpValor.getText());
                    double result = 0.0;
                    //From Ammout change into pounds
                    if (tempDe.getSelectedItem().toString() == "Celsius"){
                        switch (tempPara.getSelectedItem().toString()){
                            case "Celsius":
                                result = tempvalor;
                            break;
                            case "Fahrenheit":
                                result = Celcius_to_Fahrenheit(tempvalor);
                            break;
                            case "Kelvin":
                                result = Celcius_to_Kelvin(tempvalor);
                            break;
                        }
                    }
                    else if (tempDe.getSelectedItem().toString() == "Fahrenheit"){
                        switch (tempPara.getSelectedItem().toString()){
                            case "Celsius":
                                result = Fahrenheit_to_Celcius(tempvalor);
                                break;
                            case "Fahrenheit":
                                result = tempvalor;
                                break;
                            case "Kelvin":
                                result = Fahrenheit_to_Kelvin(tempvalor);
                                break;
                        }
                    }
                    else if (tempDe.getSelectedItem().toString() == "Kelvin"){
                        switch (tempPara.getSelectedItem().toString()){
                            case "Celsius":
                                result = Kelvin_to_Celcius(tempvalor);
                                break;
                            case "Fahrenheit":
                                result = Kelvin_to_Fahrenheit(tempvalor);
                                break;
                            case "Kelvin":
                                result = tempvalor;
                                break;
                        }
                    }

                    String amount = String.format("%.2f", result);
                    JOptionPane.showMessageDialog(null,tempvalor + " " + tempDe.getSelectedItem().toString() + " = " + amount + " " + tempPara.getSelectedItem().toString());
                }
            }
        });
        btnTmpVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
                temperatureFrame.setVisible(false);
            }
        });
    }
}
