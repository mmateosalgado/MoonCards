package InterfacesGraficas;

import Administrador.Administrador;
import Excepciones.JtextFieldVacioException;
import model.Coleccion;
import model.Heroe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearHeroe extends JFrame implements ActionListener {

    private JButton salir,aceptar;
    private JTextField nombreEspacio;
    private JTextArea descripcionEspacio;
    private JLabel nombreTexto,descripcionTexto;

    public CrearHeroe(){
        Font fuente=new Font("Belwe", Font.PLAIN,25);
        ImageIcon icono = new ImageIcon("src\\imagenes\\iconoTest.png");
        setIconImage(icono.getImage());
        setTitle("MoonCards Admin");
        setBounds(0,0,500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        nombreTexto=new JLabel("Ingrese el nombre ");
        nombreTexto.setBounds(20,50,250,30);
        nombreTexto.setFont(fuente);
        add(nombreTexto);

        nombreEspacio=new JTextField();
        nombreEspacio.setBounds(250,50,200,30);
        add(nombreEspacio);

        descripcionTexto=new JLabel("Descripcion");
        descripcionTexto.setBounds(20,100,250,30);
        descripcionTexto.setFont(fuente);
        add(descripcionTexto);

        descripcionEspacio=new JTextArea();
        descripcionEspacio.setBounds(250,100,200,90);
        add(descripcionEspacio);

        salir=new JButton("Salir");
        salir.setFont(fuente);
        salir.setBounds(20,300,120,50);
        salir.addActionListener(this);
        add(salir);

        aceptar=new JButton("Aceptar");
        aceptar.setFont(fuente);
        aceptar.setBounds(330,300,130,50);
        aceptar.addActionListener(this);
        add(aceptar);

        setVisible(true);
    }

    public boolean inputsCompletos() throws JtextFieldVacioException {//valida que los inputs tengan datos
        boolean respuesta=false;

        if(!nombreEspacio.getText().isEmpty() && !descripcionEspacio.getText().isEmpty()){
            respuesta=true;
        }else{
            throw new JtextFieldVacioException("Cargue los datos!");
        }

        return respuesta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(salir)){
            setVisible(false);
            SeleccionAdmin volver=new SeleccionAdmin();
        }else if(e.getSource().equals(aceptar)){
            try {
                if(inputsCompletos()){
                    Administrador admin=new Administrador();
                    if(admin.validarNombreHeroes(nombreEspacio.getText())) {
                        Heroe aGuardar=new Heroe(nombreEspacio.getText(),20,new ImageIcon("src/imagenes/Heroes/heroeGenerico.png"),descripcionEspacio.getText());
                        Coleccion<Heroe> coleccion=admin.cargarColeccionDeHeroes();
                        coleccion.agregar(aGuardar);
                        admin.cargarArchivoHeroes(coleccion);
                        JOptionPane.showMessageDialog(null, "Se a guardado con exito!");
                        setVisible(false);
                        SeleccionAdmin volver=new SeleccionAdmin();
                    }else{
                        JOptionPane.showMessageDialog(null,"Ese nombre ya existe! Ingrese uno nuevo");
                    }
                }
            } catch (JtextFieldVacioException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
    }
}
