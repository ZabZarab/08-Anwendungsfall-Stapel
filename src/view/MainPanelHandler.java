package view;

import control.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jean-Pierre on 01.11.2016.
 */
public class MainPanelHandler {
    private JPanel panel;
    private JList correctedExams;
    private JList uncorrectedExams;
    private JTextField currentExam;
    private JButton newExamButton;
    private JButton startCorrectionButton;
    private JButton endCorrectionButton;
    private JTextArea outputArea;
    private MainController controller;

    public MainPanelHandler(MainController controller){
        this.controller = controller;
        createButtons();
    }

    private void createButtons(){
        endCorrectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endCorrection();
            }
        });
        startCorrectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCorrection();
            }
        });
        newExamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewExam();
            }
        });
    }

    private void update(){
        //Aktualisierung des unkorrigierten Stapels
        DefaultListModel listModel = new DefaultListModel();

        String[] output = controller.showUncorrectedExams();
        for(int i = 0; i < output.length; i++){
            String outputText = output[i];
            listModel.addElement(outputText);
        }

        uncorrectedExams.setModel(listModel);


        //Aktualisierung des korrigierten Stapels
        listModel = new DefaultListModel();

        output = controller.showCorrectedExams();
        for(int i = 0; i < output.length; i++){
            String outputText = output[i];
            listModel.addElement(outputText);
        }

        correctedExams.setModel(listModel);


        //Aktualisierung der aktuell zu korrigierenden Klausur
        currentExam.setText(controller.showCurrentCorrection());
    }

    public JPanel getPanel(){
        return panel;
    }

    private void addNewExam(){
        addTextToOutput("Es wurde eine neue Klausur abgegeben: " + controller.addNewExam());
        update();
    }

    private void startCorrection(){
        if(controller.startCorrection()){
            addTextToOutput("Es wird jetzt die Klausur " + controller.showCurrentCorrection() + " korrgiert.");
        }else{
            addTextToOutput("Entweder es befindet sich noch eine Klausur in Korrektur, oder es ist keine neue zum Korrigieren vorhanden.");
        }
        update();
    }

    private void endCorrection(){
        addTextToOutput("Es wurde " + controller.endCorrection() + " korrigiert.");
        update();
    }

    private void addTextToOutput(String textToAdd){
        outputArea.setText(outputArea.getText() + "\n" + textToAdd);
    }
}
