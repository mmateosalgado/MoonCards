package com.company.app;

import InterfacesGraficas.PantallaInicio;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        menu();

    }

    public static void menu(){
        PantallaInicio inicio=new PantallaInicio();

        inicio.setBounds(0,0,500,500);
        inicio.setResizable(false);
        inicio.setVisible(true);
        inicio.setLocationRelativeTo(null);
        inicio.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
