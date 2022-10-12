package com.alura.conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame{
    private JComboBox moedaDe;
    private JComboBox moedaPara;
    private JButton btnConverter;
    private JLabel labelDe;
    private JLabel labelPara;
    private JPanel ConvesorMoeda;
    private JLabel titleConverter;
    private JTextField txtValor;
    private JLabel labelValor;

    public CurrencyConverter() {

        String[] currencyUnits=
                {
                        "units",
                        "US Dollar",
                        "Brazilian Real",
                };

        double US_Dollar = 1.00;
        double Brazilian_Real = 5.30;


        JFrame currencyFrame = new JFrame("Conversor de Moeda");
        currencyFrame.setContentPane(ConvesorMoeda);
        currencyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        currencyFrame.setBounds(1000, 500, 600, 400);
        currencyFrame.setVisible(true);

        btnConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        if (moedaDe.getSelectedIndex() == 0 || moedaPara.getSelectedIndex() == 0 || txtValor.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Invalid Input", "Getting Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                                Double amountToChange = Double.parseDouble(txtValor.getText());
                                double amountInPounds = 0.0;
                                //From Ammout change into pounds
                                switch (moedaDe.getSelectedItem().toString()) {

                                    case "USD":
                                        amountInPounds = amountToChange / US_Dollar;
                                        break;
                                    case "BRL":
                                        amountInPounds = amountToChange / Brazilian_Real;
                                        break;
                                    default:
                                        amountInPounds = 0.0;
                                }

                                double newamount = 0.0;
                                switch (moedaPara.getSelectedItem().toString()) {

                                    case "USD":
                                        newamount = amountInPounds * US_Dollar;
                                        break;

                                    case "BRL":
                                        newamount = amountInPounds * Brazilian_Real;
                                        break;
                                    default:
                                        newamount = amountInPounds = 0.0;
                                }
                                String amount = String.format("%.2f", newamount);
                                JOptionPane.showMessageDialog(null,amountToChange + " " + moedaDe.getSelectedItem().toString() + " valem " + amount + " " + moedaPara.getSelectedItem().toString());
                        }
                    }
                });
            }
        }
