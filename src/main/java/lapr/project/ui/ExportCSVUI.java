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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import lapr.project.controller.ExportCSVController;
import lapr.project.model.Project;
import lapr.project.model.analysis.SegmentResult;
import lapr.project.model.analysis.Simulation;
import lapr.project.model.analysis.TypePath;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ExportCSVUI extends JDialog {

    /**
     * Instance variables.
     */
    private final int WINDOW_WIDTH = 195;
    private final int WINDOW_HEIGHT = 500;
    private transient ExportCSVController controller;
    private transient List<String> results;
    private JList listSimulations;
    private JList listComparison;
    private JList listShortestPath;
    private DialogSelectable dialog;
    private DialogSelectable dialogSimulation;
    private JDialog parentFrame;

    Project project;

    public ExportCSVUI(Project project, JDialog parentFrame) {
        super(parentFrame, "Export CSV", true);
        this.project = project;
        this.parentFrame = parentFrame;

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
        controller = new ExportCSVController(project);
        //dialogSimulation= new DialogSelectable(this, controller.getSimulationsList());
        results = controller.getSimulationsList();
        createComponents();
        pack();
        this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

    }

    private void createComponents() {
          FlowLayout fl = new FlowLayout(FlowLayout.LEADING);
        FlowLayout fl2 = new FlowLayout(FlowLayout.LEADING, 50, 0);

        JPanel panelLists = new JPanel();
        JPanel panelLabels = new JPanel(fl2);
        JLabel labelBest = createJLabels("List of simulations");

        panelLabels.add(labelBest);

        JPanel panelUpdateBtn = new JPanel(new FlowLayout());
        listSimulations = createJList("List of simulations");

        panelLists.add(listSimulations,BorderLayout.CENTER);

        JButton btn = createJButtonUpdate();
        panelUpdateBtn.add(btn, BorderLayout.NORTH);
        JButton btnExport = createExportJButton();
        panelUpdateBtn.add(btnExport, BorderLayout.SOUTH);
        add(panelLists, BorderLayout.WEST);
        add(panelLabels, BorderLayout.NORTH);
        add(panelUpdateBtn, BorderLayout.SOUTH);
    }

    private JLabel createJLabels(String text) {
        JLabel label = new JLabel(text);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        label.setBorder(border);
        return label;
    }

    private JList createJList(String keyValue) {
        JList list = new JList();

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        list.setBorder(border);
        list.setPreferredSize(new Dimension(150, 300));
        list.setListData(results.toArray());
        return list;
    }

    private JButton createJButtonUpdate() {
        JButton btn = new JButton();

        Icon icon = new ImageIcon("src/main/resources/images/Update-icon.png");
        btn.setIcon(icon);
        btn.setOpaque(true);
        Icon iconPressed = new ImageIcon("src/main/resources/images/Update-iconPressed.png");
        btn.setPressedIcon(iconPressed);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        btn.setBorder(border);
        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                String[] buttons = {"Filter by nodes", "Filter by aircraft type", "Cancel"};
                int rc = JOptionPane.showOptionDialog(null, "Choose the filter", "Filter", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);
                if (rc == 0) {
                    dialog = new DialogSelectable(ExportCSVUI.this, controller.getListOfAirports(), "Select origin node");
                    String originNode = dialog.getSelectedItem();
                    dialog = new DialogSelectable(ExportCSVUI.this, controller.getListOfAirports(), "Select destination node");
                    results = controller.getFlightPathAnalisysResultsGroupedByOriginDestination(originNode, dialog.getSelectedItem());
                    listSimulations.setListData(results.toArray());
                    //dialogSimulation = new DialogSelectable(ExportHTMLUI.this, results);
                }
                if (rc == 1) {
                    dialog = new DialogSelectable(ExportCSVUI.this, controller.getListOfAircraftTypes(), "Select aircraft type");
                    results = controller.getFlightPathAnalisysResultsGroupedByAircraftType(dialog.getSelectedItem());
                    listSimulations.setListData(results.toArray());

                }

            }

        });
        return btn;
    }

    public JButton createExportJButton() {
        JButton btn = new JButton();

        btn.setText("Export  results");
        Border border = BorderFactory.createLineBorder(Color.BLACK);
           btn.setPreferredSize(new Dimension(100,40));
        btn.setBorder(border);
        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (listSimulations.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Nothing selected to export.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int nrOfSelectedIndexes = listSimulations.getSelectedIndices().length;
                    if (nrOfSelectedIndexes > 4) {
                        JOptionPane.showMessageDialog(rootPane, "Select less than four items to export..", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String[] buttons = {"Export shortest path calculations", "Export most ecologic path calculations", "Export fastest path calculations", "Cancel"};
                        int rc = JOptionPane.showOptionDialog(null, "What to export?", "Export HTML", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
                        if (rc != 3) {
                            int selectedIndexes[] = listSimulations.getSelectedIndices();
                            JFileChooser chooser = new JFileChooser();
                            chooser.showSaveDialog(null);
                            String path = chooser.getCurrentDirectory().getAbsolutePath();

                            String allSims[] = (String[]) listSimulations.getSelectedValuesList().toArray(new String[selectedIndexes.length]);
                            if (rc == 0) {
                                if (controller.exportResults(allSims, path + "\\simulation_results.csv", "short")) {
                                    JOptionPane.showMessageDialog(rootPane, "Data exported sucessfully.", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                            if (rc == 1) {
                                if (controller.exportResults(allSims, path + "\\simulation_results.csv", "eco")) {
                                    JOptionPane.showMessageDialog(rootPane, "Data exported sucessfully.", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                            if (rc == 2) {
                                if (controller.exportResults(allSims, path + "\\simulation_results.csv", "fastest")) {
                                    JOptionPane.showMessageDialog(rootPane, "Data exported sucessfully.", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        }
                    }
                }
            }
        });
        return btn;
    }

    public void closeWindow() {
        String[] op = {"Yes", "No"};
        String question = "Close window?";
        int opcao = JOptionPane.showOptionDialog(this, question,
                "Export HTML", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

      public static void main(String[] args)
    {
         Project p = new Project();
        Simulation sim = new Simulation();
        sim.createPathSimulation(TypePath.ALL);
        sim.getShortestResultPath().getSegments().add(new SegmentResult());
           sim.getShortestResultPath().getSegments().add(new SegmentResult());
              sim.getShortestResultPath().getSegments().add(new SegmentResult());
                 sim.getShortestResultPath().getSegments().add(new SegmentResult());
        sim.getShortestResultPath().getSegments().add(new SegmentResult());
        p.getSimulationsList().getSimulationsList().add(sim);
        ExportCSVUI ui = new ExportCSVUI(p, new JDialog());
    }
}
