package InterfacesGraficas;

import Administrador.Administrador;
import Excepciones.InputInvalidoExcepcion;
import Excepciones.JtextFieldVacioException;
import Excepciones.NumeroInvalidoExcepcion;
import Excepciones.PasaNullExcepcion;
import Razas.Golem;
import Razas.Humano;
import Razas.Necrofago;
import Razas.Orco;
import model.*;
import tiposHechizos.Curacion;
import tiposHechizos.Danio;
import tiposHechizos.Hielo;
import tiposHechizos.RobaCarta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModificarCarta extends JFrame implements ActionListener {
    private JLabel nombreTexto,vidaTexto,energiTexto,DanioTexto;
    private JTextField nombreEspacio,vidaEspacio,energiaEspacio,danioEspacio;
    private JButton aceptar,salir;
    private Carta aModificar;
    private boolean nombre,vida,energia,danio;

    //public ModificarCarta(boolean nombre,boolean vida,boolean energia,boolean alta,boolean danio,Carta entrada){
    public ModificarCarta(boolean nombre,boolean vida,boolean energia,boolean danio,Carta entrada){
        aModificar=entrada;
        this.nombre=nombre;
        this.vida=vida;
        this.energia=energia;
        this.danio=danio;

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

            energiaEspacio=new JTextField();
            energiaEspacio.setBounds(180,80,150,30);
            add(energiaEspacio);
        }

        if(danio){
            DanioTexto =new JLabel("Daño ("+aModificar.getDanoInflige()+")");
            DanioTexto.setFont(h1);
            DanioTexto.setBounds(20,110,90,30);
            add(DanioTexto);

            danioEspacio=new JTextField();
            danioEspacio.setBounds(180,110,150,30);
            add(danioEspacio);
        }

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

    public boolean inputCompleto(JTextField aTestear) throws JtextFieldVacioException {//valida que los inputs tengan datos
        boolean respuesta=false;

        if(!aTestear.getText().isEmpty()){
            respuesta=true;
        }else{
            throw new JtextFieldVacioException("Cargue los datos!");
        }

        return respuesta;
    }

    public boolean inputsCompletos() throws JtextFieldVacioException {
        boolean rta=false;
        if(nombre){
            rta=inputCompleto(nombreEspacio);
        }
        if(vida){
            rta=inputCompleto(vidaEspacio);
        }
        if(energia){
            rta=inputCompleto(energiaEspacio);
        }
        if(danio){
            rta=inputCompleto(danioEspacio);
        }
        return rta;
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
        boolean respuesta1=true;

        if(vida) {
            respuesta1 = validarInput(vidaEspacio.getText());
        }
        if(danio) {
            respuesta1 = validarInput(danioEspacio.getText());
        }
        if(energia) {
            respuesta1 = validarInput(energiaEspacio.getText());
        }

        if(respuesta1){
            return true;
        }else{
            throw new InputInvalidoExcepcion("Ingrese solo numeros!");
        }
    }

    public Personaje crearPersonaje()
    {
        Personaje rta= (Personaje) aModificar;

        if(nombre){
            rta.setNombre(nombreEspacio.getText());
        }
        if(vida){
            rta.setCantidadDeVida(Integer.parseInt(vidaEspacio.getText()));
        }
        if(energia){
            rta.setCostoEnergia(Integer.parseInt(energiaEspacio.getText()));
        }
        if(danio){
            rta.setDanoInflige(Integer.parseInt(danioEspacio.getText()));
        }

        return rta;
    }

    public Hechizo crearHechizo()
    {
        Hechizo rta= (Hechizo) aModificar;

        if(nombre){
            rta.setNombre(nombreEspacio.getText());
        }
        if(energia){
            rta.setCostoEnergia(Integer.parseInt(energiaEspacio.getText()));
        }
        if(danio){
            rta.setDanoInflige(Integer.parseInt(danioEspacio.getText()));
        }

        return rta;
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
                            Coleccion<Carta> coleccion=admin.cargarColeccionDeCartas();
                            if(aModificar instanceof Hechizo){
                                Carta hechizo=crearHechizo();
                                coleccion.getLista().set(aModificar.getId()-1,hechizo);
                            }else if(aModificar instanceof Personaje){
                                Personaje personaje=crearPersonaje();
                                coleccion.getLista().set(aModificar.getId()-1,personaje);
                            }
                            admin.cargarArchivoCartas(coleccion);
                            JOptionPane.showMessageDialog(null, "Se a guardado con exito!");
                            setVisible(false);
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
