package com.alura.conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.spi.LocaleNameProvider;

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
    private JButton btnBack;

    public CurrencyConverter() {

        String[] currencyUnits=
                {
                        "units",
                        "US Dollar",
                        "Brazilian Real",
                        "Canadian Dollar",
                };

        double US_Dollar = 1.00;
        double Brazilian_Real = 5.30;
        double Canadian_Dollar = 1.37;


        JFrame currencyFrame = new JFrame("Converter");
        currencyFrame.setContentPane(ConvesorMoeda);
        currencyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        currencyFrame.setBounds(800, 300, 800, 600);
        currencyFrame.setVisible(true);

        btnConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        if (moedaDe.getSelectedIndex() == 0 || moedaPara.getSelectedIndex() == 0 || txtValor.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Invalid Input", "Getting Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                                Double amountToChange = Double.parseDouble(txtValor.getText().replaceAll(",", "."));
                                double amountInPounds = 0.0;
                                //From Ammout change into pounds
                                switch (moedaDe.getSelectedItem().toString()) {

                                    case "USD":
                                        amountInPounds = amountToChange / US_Dollar;
                                        break;

                                    case "BRL":
                                        amountInPounds = amountToChange / Brazilian_Real;
                                        break;

                                    case "CDA":
                                        amountInPounds = amountToChange / Canadian_Dollar;
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

                                    case "CDA":
                                        newamount = amountInPounds * Canadian_Dollar;
                                        break;

                                    default:
                                        newamount = amountInPounds = 0.0;
                                }
                                String amount = String.format("%.2f", newamount);
                                JOptionPane.showMessageDialog(null,amountToChange + " " + moedaDe.getSelectedItem().toString() + " = " + amount + " " + moedaPara.getSelectedItem().toString());
                        }
                    }
                });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
                currencyFrame.setVisible(false);
                dispose();
            }
        });
    }
        }
