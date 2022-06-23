package InterfacesGraficas;

import Administrador.Administrador;
import Excepciones.InputInvalidoExcepcion;
import Excepciones.JtextFieldVacioException;
import Excepciones.NumeroInvalidoExcepcion;
import Excepciones.PasaNullExcepcion;
import model.Carta;
import model.DatoPrincipal;
import model.Personaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModificarCarta extends JFrame implements ActionListener {
    private JLabel nombreTexto,vidaTexto,energiTexto,AltaTexto,DanioTexto;
    private JTextField nombreEspacio,vidaEspacio,EnergiaEspacio,DanioEspacio;
    private JButton aceptar,salir;
    private Carta aModificar;

    //public ModificarCarta(boolean nombre,boolean vida,boolean energia,boolean alta,boolean danio,Carta entrada){
    public ModificarCarta(boolean nombre,boolean vida,boolean energia,boolean danio,Carta entrada){
        aModificar=entrada;

        Font h1=new Font("Belwe", Font.PLAIN,17);
        ImageIcon icono = new ImageIcon("src\\imagenes\\iconoTest.png");
        setTitle("MoonCards Admin - Modificar Cartas");
        setIconImage(icono.getImage());

        setBounds(0,0,400,300);

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

            nombreEspacio=new JTextField();
            nombreEspacio.setBounds(180,20,150,30);
            add(nombreEspacio);
        }

        if(vida){
            Personaje aux=(Personaje)aModificar;
            vidaTexto=new JLabel("Vida ("+aux.getCantidadDeVida()+")");
            vidaTexto.setFont(h1);
            vidaTexto.setBounds(20,50,90,30);
            add(vidaTexto);

            vidaEspacio=new JTextField();
            vidaEspacio.setBounds(180,50,150,30);
            add(vidaEspacio);
        }

        if(energia){
            energiTexto=new JLabel("Energia ("+aModificar.getCostoEnergia()+")");
            energiTexto.setFont(h1);
            energiTexto.setBounds(20,80,90,30);
            add(energiTexto);

            EnergiaEspacio=new JTextField();
            EnergiaEspacio.setBounds(180,80,150,30);
            add(EnergiaEspacio);
        }

        if(danio){
            DanioTexto =new JLabel("Daño ("+aModificar.getDanoInflige()+")");
            DanioTexto.setFont(h1);
            DanioTexto.setBounds(20,110,90,30);
            add(DanioTexto);

            DanioEspacio=new JTextField();
            DanioEspacio.setBounds(180,110,150,30);
            add(DanioEspacio);
        }

        /*
        if(alta){
            String aux;
            if(aModificar.isAlta()){
                aux="true";
                aModificar.setAlta(false);
            }else{
                 aux="false";
                aModificar.setAlta(true);
            }
            AltaTexto=new JLabel("Alta ("+aux+") ------> ahora ("+aModificar.isAlta()+")");
            AltaTexto.setFont(h1);
            AltaTexto.setBounds(20,110,300,30);
            add(AltaTexto);
        }

         */


        salir=new JButton("Salir");
        salir.setFont(h1);
        salir.setBounds(20,200,120,50);
        salir.addActionListener(this);
        add(salir);

        aceptar=new JButton("Aceptar");
        aceptar.setFont(h1);
        aceptar.setBounds(240,200,120,50);
        aceptar.addActionListener(this);
        add(aceptar);

    }

    public boolean inputsCompletos() throws JtextFieldVacioException {//valida que los inputs tengan datos
        boolean respuesta=false;

        if(!nombreEspacio.getText().isEmpty() && !DanioEspacio.getText().isEmpty() && !EnergiaEspacio.getText().isEmpty() && !vidaEspacio.getText().isEmpty()){
            respuesta=true;
        }else{
            throw new JtextFieldVacioException("Cargue los datos!");
        }

        return respuesta;
    }

    public boolean validarInput(String aValidar) throws PasaNullExcepcion, NumeroInvalidoExcepcion {//valida que los datos en los inputs sean validos
        String regex="[0-9]+";
        Pattern p=Pattern.compile(regex);
        boolean aux=false;

        if(aValidar==null){
            throw new PasaNullExcepcion("ERROR FATAL: SE PASA NULL!");
        }else{
            Matcher m =p.matcher(aValidar);
            aux= m.matches();
            if(aux){
                if(!(Integer.parseInt(aValidar)>0 && Integer.parseInt(aValidar)<=10)){
                    throw new NumeroInvalidoExcepcion("Los numeros deben estar entre el 1 y el 10");
                }
            }
        }

        return aux;
    }

    public boolean validarInputs() throws PasaNullExcepcion, InputInvalidoExcepcion, NumeroInvalidoExcepcion {
        boolean respuesta1,respuesta2,respuesta3;

        respuesta1=validarInput(vidaEspacio.getText());
        respuesta2=validarInput(DanioEspacio.getText());
        respuesta3=validarInput(EnergiaEspacio.getText());

        if(respuesta1 && respuesta2 && respuesta3){
            return true;
        }else{
            throw new InputInvalidoExcepcion("Ingrese solo numeros!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(salir)){
            setVisible(false);
            SeleccionMoficarCarta vuelta=new SeleccionMoficarCarta(aModificar);
        }else if(e.getSource().equals(aceptar)){
            Administrador admin=new Administrador();
            try{
                if(inputsCompletos()){
                    if(validarInputs()){
                        if(admin.validarNombreCarta(nombreEspacio.getText())) {
                            JOptionPane.showMessageDialog(null, "Se a guardado con exito!");
                            setVisible(false);
                            //TODO admin guarda
                            SeleccionAdmin vuelta = new SeleccionAdmin();
                        }else{
                            JOptionPane.showMessageDialog(null,"Ese nombre ya existe! Ingrese uno nuevo");
                        }
                    }
                }
            }catch (JtextFieldVacioException | InputInvalidoExcepcion | NumeroInvalidoExcepcion ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }catch (PasaNullExcepcion ex){
                ex.printStackTrace();
                System.exit(0);
            }
        }
    }
}
