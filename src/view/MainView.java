package view;

import control.MainController;

import javax.swing.*;

/**
 * Created by Jean-Pierre on 01.11.2016.
 */
public class MainView extends JFrame {

    public MainView(MainController controller){
        this.setTitle("Anwendungsfall Datenstruktur Stack");
        this.setBounds(50,50,1000,800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(new MainPanelHandler(controller).getPanel());
        this.setVisible(true);
    }
}
