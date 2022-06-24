package InterfacesGraficas;

import model.Carta;
import model.Hechizo;
import model.Personaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionMoficarCarta extends JFrame implements ActionListener {
    private  JCheckBox nombreCheck,vidaCheck,danioCheck,energiaCheck;
    private JButton aceptar,salir;
    private Carta aModificar;

    public SeleccionMoficarCarta(Carta entrada){
        Font h1=new Font("Belwe", Font.PLAIN,17);
        setTitle("MoonCards Admin - Modificar Cartas");
        ImageIcon icono = new ImageIcon("src\\imagenes\\logo.png");
        setIconImage(icono.getImage());

        aModificar=entrada;

        setBounds(0,0,450,270);

        setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);

        nombreCheck=new JCheckBox("Nombre");
        nombreCheck.setBounds(30,40,95,20);
        nombreCheck.setFont(h1);
        nombreCheck.addActionListener(this);
        add(nombreCheck);

        vidaCheck=new JCheckBox("Vida");
        vidaCheck.setBounds(30,70,90,20);
        vidaCheck.setFont(h1);
        vidaCheck.addActionListener(this);
        add(vidaCheck);

        if(aModificar instanceof Hechizo){
            vidaCheck.setVisible(false);
        }

        danioCheck=new JCheckBox("Daño");
        danioCheck.setBounds(30,100,90,20);
        danioCheck.setFont(h1);
        danioCheck.addActionListener(this);
        add(danioCheck);

        energiaCheck=new JCheckBox("Energia");
        energiaCheck.setBounds(30,130,90,20);
        energiaCheck.setFont(h1);
        energiaCheck.addActionListener(this);
        add(energiaCheck);

        aceptar=new JButton("Aceptar");
        aceptar.setBounds(230,30,150,50);
        aceptar.setFont(h1);
        aceptar.addActionListener(this);
        aceptar.setEnabled(false);
        add(aceptar);

        salir=new JButton("Salir");
        salir.setBounds(230,90,150,50);
        salir.setFont(h1);
        salir.addActionListener(this);
        add(salir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Solo se muestra el boton de aceptar si hay minimo una caracteristica a cambiar valida!
        if(nombreCheck.isSelected() || vidaCheck.isSelected() ||energiaCheck.isSelected() ||danioCheck.isSelected()){
            aceptar.setEnabled(true);
        }else{
            aceptar.setEnabled(false);
        }

        if(e.getSource().equals(salir)){
            setVisible(false);
            SeleccionAdmin volver=new SeleccionAdmin();
        }else if(e.getSource().equals(aceptar)){
            setVisible(false);
            ModificarCarta ida=new ModificarCarta(nombreCheck.isSelected(),vidaCheck.isSelected(),energiaCheck.isSelected(),danioCheck.isSelected(),aModificar);
        }
    }
}
