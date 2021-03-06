/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr.project.controller.FindBestPathResultController;
import lapr.project.model.analysis.Simulation;
import lapr.project.model.analysis.TypePath;

/**
 *
 * @author Pedro Fernandes
 */
public class FindBestPathResultUI extends JDialog {

    /**
     * Guarda a janela anterior
     */
    private JDialog dialog;

    /**
     * Simulation created
     */
    private transient Simulation simulation;

    private transient FindBestPathResultController controller;

    private transient TypePath type;

    private JList jListSegments;
    private JList jListSegmentsResult;
    private JLabel lblStartNode;
    private JLabel lblEndNode;
    private JLabel lblComp;
    private JLabel lblVelStartSeg;
    private JLabel lblaltStartSeg;
    private JLabel lblVelEndSeg;
    private JLabel lblaltEndSeg;
    private JLabel lblCombConsumed;
    private JLabel lblCombRemain;
    private JLabel lblDistanceAcumulate;
    private JLabel lblTimeAcumulate;

    public FindBestPathResultUI(Simulation simulation, TypePath type ,JDialog dialog) {
        super(dialog, "Simulation Result: ",true );
        setTitle("Simulation Result: ");
        this.simulation = simulation;
        this.type = type;
        this.dialog = dialog;
        this.controller= new FindBestPathResultController(simulation,type);

        createComponents();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
        pack();
        setMinimumSize(new Dimension(400, 250));
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private void createComponents() {
        add(createPanelNorth(), BorderLayout.NORTH);
        add(createResultsPanel(), BorderLayout.CENTER);
        add(createButtonsPanel(), BorderLayout.SOUTH);

    }

    private JPanel createPanelNorth() {
        JPanel north = new JPanel(new GridLayout(5, 2));
        JLabel labelFlight = new JLabel(" ****************   FLIGHT PLAN INFO"
                + "   **************** ", JLabel.CENTER);

        int aux = 20;
        JTextField txtDesignation = new JTextField(aux);
        txtDesignation.setEnabled(false);
        txtDesignation.setText(controller.getPlan().getFlightDesignator());
        JTextField txtOrigin = new JTextField(aux);
        txtOrigin.setEnabled(false);
        txtOrigin.setText(controller.getPlan().getOrigin().getIATA());
        JTextField txtDestination = new JTextField(aux);
        txtDestination.setEnabled(false);
        txtDestination.setText(controller.getPlan().getDestination().getIATA());
        JTextField txtCrew = new JTextField(aux);
        txtCrew.setEnabled(false);
        txtCrew.setText(String.valueOf(controller.getSimulation().getCrew()));
        JTextField txtPassengers = new JTextField(aux);
        txtPassengers.setEnabled(false);
        txtPassengers.setText(String.valueOf(controller.getSimulation().getPassengers()));
        JTextField txtTravel = new JTextField(aux);
        txtTravel.setEnabled(false);
        txtTravel.setText(String.valueOf(controller.getTotalTravellingTime(type)));
        JTextField txtEnergy = new JTextField(aux);
        txtEnergy.setEnabled(false);
        txtEnergy.setText(String.valueOf(controller.getTotalConsume(type)));
        JTextField txtFlight = new JTextField(aux);
        txtFlight.setEnabled(false);
        txtFlight.setText(String.valueOf(controller.getTotalTravellingTime(type)));
       

        north.add(labelFlight);
        north.add(UI.createPanelLabelTextLabel("Airport Origin: ", txtOrigin, ""));
        north.add(UI.createPanelLabelTextLabel("Flight Plan Designator: ", txtDesignation, ""));
        north.add(UI.createPanelLabelTextLabel("Airport Destination: ", txtDestination, ""));
        north.add(UI.createPanelLabelTextLabel("Num Crew Elements: ", txtCrew, ""));
        north.add(UI.createPanelLabelTextLabel("Num Passengers: ", txtPassengers, ""));
        north.add(UI.createPanelLabelTextLabel("Total Traveling Time: ", txtTravel, ""));
        north.add(UI.createPanelLabelTextLabel("Total Flight Time: ", txtFlight, ""));
        north.add(UI.createPanelLabelTextLabel("Total Energy Consume: ", txtEnergy, ""));
        

        return north;
    }
    
    private JPanel createListPanel(String title, JList jlist) {

        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane sPane = new JScrollPane(jlist);

        JPanel p = new JPanel(new BorderLayout());
        
        int aux = 5;
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(title),
                new EmptyBorder(aux, aux, aux, aux)));

        p.add(sPane, BorderLayout.CENTER);

        return p;
    }
    
    private JPanel createResultsPanel() {
        JPanel p = new JPanel(new GridLayout(1,3));
        
        JPanel p1 = new JPanel(new BorderLayout());
        jListSegments = new JList(controller.getSegmentsListTime(type).toArray());
        jListSegments.addListSelectionListener(new ListSelectionListener() {
                @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    if (!e.getValueIsAdjusting()) {
                        changeValues();
                    }
                } catch (NullPointerException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        });
        p1.add(createListPanel("Segments by time step: " +controller.getTimeStep(type), jListSegments), BorderLayout.CENTER);

        JPanel p2 = new JPanel(new GridLayout(11, 1));
        
        lblStartNode = createLabel("");
        lblEndNode = createLabel("");
        lblComp = createLabel("");
        lblVelStartSeg = createLabel("");
        lblaltStartSeg = createLabel("");
        lblVelEndSeg = createLabel("");
        lblaltEndSeg = createLabel("");
        lblCombConsumed = createLabel("");
        lblCombRemain = createLabel("");
        lblDistanceAcumulate = createLabel("");
        lblTimeAcumulate = createLabel("");
        
        p2.add(createPanelLabelLabel("Start Node: ", lblStartNode,""));
        p2.add(createPanelLabelLabel("End Node: ", lblEndNode,""));
        p2.add(createPanelLabelLabel("Size: ", lblComp,""));
        p2.add(createPanelLabelLabel("Initial Velocity: ", lblVelStartSeg,""));
        p2.add(createPanelLabelLabel("Initial Altitude: ", lblaltStartSeg,""));
        p2.add(createPanelLabelLabel("Final Velocity: ", lblVelEndSeg,""));
        p2.add(createPanelLabelLabel("Final Altitude: ", lblaltEndSeg,""));
        p2.add(createPanelLabelLabel("Consumption Consumed: ", lblCombConsumed,""));
        p2.add(createPanelLabelLabel("Consumption Remain: ", lblCombRemain,""));
        p2.add(createPanelLabelLabel("Distance Acumulated: ", lblDistanceAcumulate,""));
        p2.add(createPanelLabelLabel("Time Acumulated: ", lblTimeAcumulate,""));

        p.add(p1);
        p.add(p2);
        
        JPanel p3= createResultsPanel2();
        p.add(p3);

        return p;
    }
    
      private JPanel createResultsPanel2() {
        JPanel p = new JPanel(new GridLayout(1,2));
        
        JPanel p1 = new JPanel(new BorderLayout());
        jListSegmentsResult = new JList(controller.getSegmentsList(type).toArray());
        jListSegmentsResult.addListSelectionListener(new ListSelectionListener() {
                @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    if (!e.getValueIsAdjusting()) {
                        changeValues();
                    }
                } catch (NullPointerException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        });
        p1.add(createListPanel("Segments Results: ", jListSegmentsResult), BorderLayout.CENTER);

        p.add(p1);

        return p;
    }

    private JLabel createLabel(String label) {
        JLabel l = new JLabel(label);
        return l;
    }
    
    private JPanel createPanelLabelLabel(String text1, JLabel label, String text2){
        JPanel p = new JPanel(new FlowLayout());
        JLabel lb1 = new JLabel(text1, JLabel.RIGHT);
        lb1.setPreferredSize(new JLabel("Total Energy Consumption: ").
                                                        getPreferredSize());
        JLabel lb2 = new JLabel(text2, JLabel.LEFT);
        lb2.setPreferredSize(new Dimension(100,20));
        
        p.add(lb1);
        p.add(label);
        p.add(lb2);
        
        return p;
    }

    private Component createButtonsPanel() {
        FlowLayout l = new FlowLayout();

        l.setHgap(20);
        l.setVgap(20);

        JPanel p = new JPanel(l);

        p.setBorder(BorderFactory.createTitledBorder("Options:"));

        JButton bt1 = createButtonSave();
        JButton bt2 = createButonBack();

        getRootPane().setDefaultButton(bt1);

        p.add(bt1);
        p.add(bt2);

        return p;
    }

    private JButton createButtonSave() {
        JButton saveBtn = new JButton("Save in Data Base");
        saveBtn.setMnemonic(KeyEvent.VK_S);
        saveBtn.setToolTipText("Save the simulation in the data base and go to previous window");
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return saveBtn;

    }

    private JButton createButonBack() {
        JButton backBtn = new JButton("Back");
        backBtn.setMnemonic(KeyEvent.VK_B);
        backBtn.setToolTipText("Cancel save simulation in data base and go to previous window");
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
        return backBtn;
    }

    private void closeWindow() {
        String[] op = {"Yes", "No"};
        String question = "Close window and discard Simulation Result?";
        int opcao = JOptionPane.showOptionDialog(dialog, question,
                "Simulation Result", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
    
    private void changeValues(){
        lblStartNode.setText(controller.getNodeID());
        lblEndNode.setText(controller.getEndNodeID());
        lblComp.setText("erro");
        lblVelStartSeg.setText(String.valueOf(controller.getTas_0()));
        lblaltStartSeg.setText(String.valueOf(controller.getInitAltitude()));
        lblVelEndSeg.setText(String.valueOf(controller.getTas()));
        lblaltEndSeg.setText(String.valueOf(controller.getFinalAlt()));
        lblCombConsumed.setText(String.valueOf(controller.getConsumedActual()));
        lblCombRemain = createLabel("erro");
        lblDistanceAcumulate.setText(String.valueOf(controller.getDistance()));
        lblTimeAcumulate = createLabel(String.valueOf(controller.getFlightTime()));
    }

}
