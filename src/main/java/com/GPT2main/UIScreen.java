package com.GPT2main;

import javax.swing.*;

public class UIScreen extends JFrame{
    private JPanel mainPanel;

    public UIScreen(){
        add(mainPanel);

        setTitle("Your GPT");
        setSize(650,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public static void main(String[] args){
        UIScreen myScreen = new UIScreen();
    }

}
