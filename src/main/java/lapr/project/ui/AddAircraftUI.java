/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import lapr.project.controller.AddAircraftController;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AddAircraftUI extends JFrame {

    /**
     * Instance variables
     */
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private final String WINDOW_TITLE = "Add aircraft";
    private AddAircraftController addAircraftController;
    private JTextField textRegistration;
    private JTextField textCompany;
    private JTextField textSeatsEcon;
    private JTextField textSeatsCommercial;
    private JTextField textNrOfCrewElements;
    private DialogSelectable dialog;
    private JButton btnSubmit;

    public AddAircraftUI(JFrame parentFrame) {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
        addAircraftController = new AddAircraftController();
        this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setTitle(WINDOW_TITLE);

        createComponents();
        this.setVisible(true);

    }

    public void createComponents() {
        JPanel panelLabels = createLabelsPanel();
        JPanel panelText = createTxtFieldPanel();
        add(panelLabels, BorderLayout.WEST);
        add(panelText, BorderLayout.CENTER);
        JPanel buttons = new JPanel(new FlowLayout());
        btnSubmit = createSubmitButton();
        JButton btnModel = createAddAircraftModelButton();
        buttons.add(btnModel);
        buttons.add(btnSubmit);
        add(buttons, BorderLayout.SOUTH);
    }

    public JPanel createLabelsPanel() {
        GridLayout layout = new GridLayout(5, 1);
        JPanel panel = new JPanel(layout);
        JLabel labelRegistration = createLabels("Registration ID:");
        JLabel labelCompany = createLabels("Company name:");
        JLabel labelSeatsEcon = createLabels("Nr. of seats in economic class:");
        JLabel labelSeatsCommercial = createLabels("Nr. of seats in commercial class:");
        JLabel labelNrOfCrewElements = createLabels("Nr. of crew elements:");
        panel.add(labelRegistration);
        panel.add(labelCompany);
        panel.add(labelSeatsEcon);
        panel.add(labelSeatsCommercial);
        panel.add(labelNrOfCrewElements);

        return panel;
    }

    public JPanel createTxtFieldPanel() {
        GridLayout layout = new GridLayout(5, 1);
        JPanel panel = new JPanel(layout);

        textRegistration = createJTextField();
        textCompany = createJTextField();
        textSeatsEcon = createJTextField();
        textSeatsCommercial = createJTextField();
        textNrOfCrewElements = createJTextField();
        panel.add(textRegistration);
        panel.add(textCompany);
        panel.add(textSeatsEcon);
        panel.add(textSeatsCommercial);
        panel.add(textNrOfCrewElements);
        return panel;
    }

    public JLabel createLabels(String text) {
        JLabel label = new JLabel();
        label.setText(text);
        return label;
    }

    public JTextField createJTextField() {
        JTextField text = new JTextField();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        text.setBorder(border);
        text.setPreferredSize(new Dimension(10, 10));

        return text;
    }

    public JButton createSubmitButton() {
        JButton button = new JButton("Create aircraft");
        button.setPreferredSize(new Dimension(170, 30));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {

                addAircraftController.createAircraft();
                try {
                    if (addAircraftController.setAircraftData(textRegistration.getText(), textCompany.getText(), Integer.parseInt(textSeatsEcon.getText()), Integer.parseInt(textSeatsCommercial.getText()), Integer.parseInt(textNrOfCrewElements.getText()))) {
                        JOptionPane.showMessageDialog(rootPane, "Aircraft added sucessfully.", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                        btnSubmit.setEnabled(false);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Invalid values submitted.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        button.setEnabled(false);
        return button;
    }

    public JButton createAddAircraftModelButton() {
        JButton button = new JButton("Insert aicraft model");
        button.setPreferredSize(new Dimension(170, 30));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {

                dialog = new DialogSelectable(AddAircraftUI.this, addAircraftController.getListOfAircraftModels());
                if (addAircraftController.setAircraftModel(dialog.getSelectedItem())) {
                    JOptionPane.showMessageDialog(rootPane, "Model set sucessfully.", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                    btnSubmit.setEnabled(true);
                }
            }
        });
        return button;
    }

    public void closeWindow() {
        String[] op = {"Yes", "No"};
        String question = "Close window?";
        int opcao = JOptionPane.showOptionDialog(this, question,
                "Add aircraft", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
}
