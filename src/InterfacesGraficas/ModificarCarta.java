package InterfacesGraficas;

import model.Carta;
import model.DatoPrincipal;
import model.Personaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarCarta extends JFrame implements ActionListener {
    private JLabel nombreTexto,VidaTexto,EnergiTexto,AltaTexto,DanioTexto;
    private JButton aceptar,salir;
    private Carta aModificar;

    public ModificarCarta(boolean nombre,boolean vida,boolean energia,boolean alta,boolean danio,Carta entrada){
        aModificar=entrada;

        Font h1=new Font("Belwe", Font.PLAIN,17);
        ImageIcon icono = new ImageIcon("src\\imagenes\\iconoTest.png");
        setTitle("MoonCards Admin - Modificar Cartas");
        setIconImage(icono.getImage());

        setBounds(0,0,400,600);

        setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);

        if(nombre){
            nombreTexto=new JLabel("Nombre ("+aModificar.getNombre()+")");
            nombreTexto.setFont(h1);
            nombreTexto.setBounds(20,20,150,30);
            add(nombreTexto);
        }

        if(vida){
            Personaje aux=(Personaje)aModificar;
            VidaTexto=new JLabel("Vida ("+aux.getCantidadDeVida()+")");
            VidaTexto.setFont(h1);
            VidaTexto.setBounds(20,50,90,30);
            add(VidaTexto);
        }

        if(energia){
            EnergiTexto=new JLabel("Energia ("+aModificar.getCostoEnergia()+")");
            EnergiTexto.setFont(h1);
            EnergiTexto.setBounds(20,80,90,30);
            add(EnergiTexto);
        }

        if(alta){
            AltaTexto=new JLabel("Alta ("+aModificar.isAlta()+")");
            AltaTexto.setFont(h1);
            AltaTexto.setBounds(20,110,90,30);
            add(AltaTexto);
        }

        if(danio){
            DanioTexto =new JLabel("Daño ("+aModificar.getDanoInflige()+")");
            DanioTexto.setFont(h1);
            DanioTexto.setBounds(20,140,90,30);
            add(DanioTexto);
        }

        salir=new JButton("Salir");
        salir.setFont(h1);
        salir.setBounds(20,200,120,50);
        salir.addActionListener(this);
        add(salir);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(salir)){
            setVisible(false);
            SeleccionMoficarCarta vuelta=new SeleccionMoficarCarta(aModificar);
        }
    }
}
