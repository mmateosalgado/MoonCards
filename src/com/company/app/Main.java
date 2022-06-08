package com.company.app;

import InterfacesGraficas.PantallaInicio;

import javax.swing.*;



public class Main {

    public static void main(String[] args) {

        UISistema(); // Esto define el diseño UI DEL SISTEMA
        //menu();
/*
        ImageIcon icono1 = new ImageIcon("src\\imagenes\\testHeroe1.png");
        ImageIcon icono2 = new ImageIcon("src\\imagenes\\testHeroe2.png");
        Heroe heroeTest = new Heroe("Ekcros",100,icono1,"Este es un heroe muy poderoso y legendario. Con 100 de vida. Casi imposible de aniquilar.");
        Heroe heroeTest2 = new Heroe("Kratos",50,icono2,"Este es un heroe poderoso y casi legendario. Con 50 de vida. Dificil de aniquilar.");

        ColeccionHeroe coleccion = new ColeccionHeroe();
        coleccion.agregarHeroe(heroeTest);
        coleccion.agregarHeroe(heroeTest2);

        SeleccionHeroe seleccionHeroe = new SeleccionHeroe(coleccion);
*/
        menu();


    }

    public static void UISistema(){
        UIManager.LookAndFeelInfo info[] = UIManager.getInstalledLookAndFeels();
        for(UIManager.LookAndFeelInfo look: info)
           // System.out.println(look.getClassName());
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public static void menu(){
        PantallaInicio inicio=new PantallaInicio();
    }
}
