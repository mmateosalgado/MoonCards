package InterfacesGraficas;

import Administrador.Administrador;
import Excepciones.*;
import Razas.Golem;
import Razas.Humano;
import Razas.Necrofago;
import Razas.Orco;
import model.Carta;
import model.Coleccion;
import model.Hechizo;
import model.Personaje;
import tiposHechizos.Curacion;
import tiposHechizos.Danio;
import tiposHechizos.Hielo;
import tiposHechizos.RobaCarta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CargaNuevaCarta extends JFrame implements ActionListener {
    private JLabel nombreTexto,descripcionTexto,costoEnergiaTexto,valorEfectoTexto,danioInflijeTexto,vidaTexto,tipoPersonaje,tipoHechizo;
    private JTextField nombreEspacio,costoEnergiaEspacio,valorEfectoEspacio,danioInflijeEspacio,vidaEspacio;
    private JTextArea descripcionEspacio;
    private JCheckBox isRara;
    private JCheckBox orcoCheck,necrofagoCheck,golemCheck,humanoCheck;//ESPECIFICO PERSONAJE
    private JCheckBox robarCartaCheck,curacionCheck,danioCheck,hieloCheck;//ESPECIFICOS HECHIZO
    private JButton salir,aceptar;
    private boolean isPersonaje;

    public CargaNuevaCarta(boolean isPersonaje) throws HeadlessException {
        this.isPersonaje=isPersonaje;

        Font fuente=new Font("Belwe", Font.PLAIN,25);
        ImageIcon icono = new ImageIcon("src\\imagenes\\logo.png");
        setIconImage(icono.getImage());
        setTitle("MoonCards Admin");
        setBounds(0,0,500,900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        //DATOS COMUNES A LOS DOS TIPOS DE CARTA

        isRara=new JCheckBox("Es rara?(sino sera NORMAL)");
        isRara.setBounds(50,20,400,40);
        isRara.setFont(fuente);
        add(isRara);

        nombreTexto=new JLabel("Nombre");
        nombreTexto.setBounds(50,80,100,40);
        nombreTexto.setFont(fuente);
        add(nombreTexto);

        nombreEspacio=new JTextField();
        nombreEspacio.setBounds(200,80,200,40);
        add(nombreEspacio);

        costoEnergiaTexto=new JLabel("Energia");
        costoEnergiaTexto.setBounds(50,130,100,40);
        costoEnergiaTexto.setFont(fuente);
        add(costoEnergiaTexto);

        costoEnergiaEspacio=new JTextField();
        costoEnergiaEspacio.setBounds(200,130,200,40);
        add(costoEnergiaEspacio);

        valorEfectoTexto=new JLabel("Valor Efecto");
        valorEfectoTexto.setBounds(50,180,230,40);
        valorEfectoTexto.setFont(fuente);
        add(valorEfectoTexto);

        valorEfectoEspacio=new JTextField();
        valorEfectoEspacio.setBounds(230,180,200,40);
        add(valorEfectoEspacio);

        descripcionTexto=new JLabel("Descripcion");
        descripcionTexto.setBounds(50,230,160,40);
        descripcionTexto.setFont(fuente);
        add(descripcionTexto);

        descripcionEspacio=new JTextArea();
        descripcionEspacio.setBounds(50,280,300,100);
        add(descripcionEspacio);

        if(isPersonaje){
            vidaTexto=new JLabel("Vida");
            vidaTexto.setBounds(50,400,90,30);
            vidaTexto.setFont(fuente);
            add(vidaTexto);

            vidaEspacio=new JTextField();
            vidaEspacio.setBounds(200,400,200,40);
            add(vidaEspacio);

            danioInflijeTexto=new JLabel("Daño");
            danioInflijeTexto.setBounds(50,450,90,30);
            danioInflijeTexto.setFont(fuente);
            add(danioInflijeTexto);

            danioInflijeEspacio=new JTextField();
            danioInflijeEspacio.setBounds(200,450,200,40);
            add(danioInflijeEspacio);

            tipoPersonaje=new JLabel("Seleccione el tipo de Personaje");
            tipoPersonaje.setBounds(50,500,400,30);
            tipoPersonaje.setFont(fuente);
            add(tipoPersonaje);

            orcoCheck=new JCheckBox("Orco");
            orcoCheck.setBounds(50,550,100,30);
            orcoCheck.setFont(fuente);
            orcoCheck.addActionListener(this);
            add(orcoCheck);

            necrofagoCheck=new JCheckBox("Necrofago");
            necrofagoCheck.setBounds(50,600,190,30);
            necrofagoCheck.setFont(fuente);
            necrofagoCheck.addActionListener(this);
            add(necrofagoCheck);

            golemCheck=new JCheckBox("Golem");
            golemCheck.setBounds(50,650,120,30);
            golemCheck.setFont(fuente);
            golemCheck.addActionListener(this);
            add(golemCheck);

            humanoCheck=new JCheckBox("Humano");
            humanoCheck.setBounds(50,700,170,30);
            humanoCheck.setFont(fuente);
            humanoCheck.addActionListener(this);
            add(humanoCheck);

        }else{//HECHIZO
            tipoHechizo=new JLabel("Seleccione el tipo de Hechizo");
            tipoHechizo.setBounds(50,400,400,30);
            tipoHechizo.setFont(fuente);
            add(tipoHechizo);

            robarCartaCheck=new JCheckBox("Roba Carta");
            robarCartaCheck.setBounds(50,450,240,30);
            robarCartaCheck.setFont(fuente);
            robarCartaCheck.addActionListener(this);
            add(robarCartaCheck);

            curacionCheck=new JCheckBox("Curacion");
            curacionCheck.setBounds(50,500,190,30);
            curacionCheck.setFont(fuente);
            curacionCheck.addActionListener(this);
            add(curacionCheck);

            danioCheck=new JCheckBox("Daño");
            danioCheck.setBounds(50,550,100,30);
            danioCheck.setFont(fuente);
            danioCheck.addActionListener(this);
            add(danioCheck);

            hieloCheck=new JCheckBox("Hielo");
            hieloCheck.setBounds(50,600,140,30);
            hieloCheck.setFont(fuente);
            hieloCheck.addActionListener(this);
            add(hieloCheck);
        }

        salir=new JButton("Salir");
        salir.setFont(fuente);
        salir.setBounds(20,800,120,50);
        salir.addActionListener(this);
        add(salir);

        aceptar=new JButton("Aceptar");
        aceptar.setFont(fuente);
        aceptar.setBounds(330,800,140,50);
        aceptar.addActionListener(this);
        add(aceptar);

        setVisible(true);
    }

    public boolean inputsCompletos() throws JtextFieldVacioException {//valida que los inputs tengan datos
        boolean respuesta=false;

        boolean vida=false;
        boolean danio=false;
        if(isPersonaje){
             vida=vidaEspacio.getText().isEmpty();
             danio=danioInflijeEspacio.getText().isEmpty();

        }

        if(!nombreEspacio.getText().isEmpty() && !costoEnergiaEspacio.getText().isEmpty() && !descripcionEspacio.getText().isEmpty() &&!valorEfectoEspacio.getText().isEmpty() && !danio && !vida ){
            respuesta=true;
        }else{
            throw new JtextFieldVacioException("Cargue los datos!");
        }

        return respuesta;
    }

    public boolean validarInputs() throws PasaNullExcepcion, InputInvalidoExcepcion, NumeroInvalidoExcepcion {
        boolean respuesta1,respuesta2;
        boolean respuesta3=true;
        boolean respuesta4=true;

        respuesta1=Administrador.validarInput(costoEnergiaEspacio.getText());
        respuesta2=Administrador.validarInput(valorEfectoEspacio.getText());
        if(isPersonaje) {
            respuesta3 = Administrador.validarInput(danioInflijeEspacio.getText());
            respuesta4 = Administrador.validarInput(vidaEspacio.getText());
        }

        if(respuesta1 && respuesta2 && respuesta3 && respuesta4){
            return true;
        }else{
            throw new InputInvalidoExcepcion("Ingrese solo numeros!");
        }
    }

    public boolean checkBoxValidas(JCheckBox A,JCheckBox B,JCheckBox C,JCheckBox D)throws JCheckBoxInvalido{
        boolean auxA=A.isSelected();
        boolean auxB=B.isSelected();
        boolean auxC=C.isSelected();
        boolean auxD=D.isSelected();

        int test=0;

        if(auxA){
            test++;
        }
        if(auxB){
            test++;
        }
        if(auxC){
            test++;
        }
        if(auxD){
            test++;
        }

        if(test==1){
            return true;
        }else{
            throw new JCheckBoxInvalido("Solo se puede seleccionar un tipo!");
        }
    }

    public Personaje crearPersonaje(boolean humano,boolean orco,boolean necrofago,boolean golem)
    {
        ///Scanner Visuales que tendrían que estar.
        String nombre=nombreEspacio.getText();
        boolean rara=isRara.isSelected();
        int costoEnergia= Integer.parseInt(costoEnergiaEspacio.getText());
        int danoInflige= Integer.parseInt(danioInflijeEspacio.getText());
        int cantidadDeVida= Integer.parseInt(vidaEspacio.getText());
        int valorEfecto= Integer.parseInt(valorEfectoEspacio.getText());

        ImageIcon imagenGenerica=new ImageIcon("src/imagenes/Cartas/PersonajeGenerico.png");

        Personaje personaje=null;
        if(humano)
        {
            personaje=new Humano(nombre,rara,costoEnergia,danoInflige,cantidadDeVida,false,imagenGenerica,descripcionEspacio.getText(),valorEfecto);
        }
        else if(orco)
        {
            personaje=new Orco(nombre,rara,costoEnergia,danoInflige,cantidadDeVida,true,imagenGenerica,descripcionEspacio.getText(),valorEfecto);

        }
        else if(necrofago)
        {
            personaje=new Necrofago(nombre,rara,costoEnergia,danoInflige,cantidadDeVida,true,imagenGenerica,descripcionEspacio.getText(),valorEfecto);
        }
        else if(golem)
        {
            personaje=new Golem(nombre,rara,costoEnergia,danoInflige,cantidadDeVida,false,imagenGenerica,descripcionEspacio.getText(),valorEfecto);
        }

        Administrador admin=new Administrador();
        personaje.setId(admin.agregarId());

        return personaje;
    }

    public Hechizo crearHechizo(boolean curacion,boolean danio,boolean hielo,boolean robaCarta)
    {
        ///Scanner Visuales que tendrían que estar.
        String nombre=nombreEspacio.getText();
        boolean rara=isRara.isSelected();
        int costoEnergia= Integer.parseInt(costoEnergiaEspacio.getText());
        int valorEfecto= Integer.parseInt(valorEfectoEspacio.getText());

        ImageIcon imagenGenerica=new ImageIcon("src/imagenes/Cartas/HechizoGenerico.png");

        Hechizo hechizo=null;
        if(curacion)
        {
            hechizo=new Curacion(nombre,rara,costoEnergia,imagenGenerica,descripcionEspacio.getText(),valorEfecto);
        }
        else if(danio)
        {
            hechizo=new Danio(nombre,rara,costoEnergia,imagenGenerica,descripcionEspacio.getText(),valorEfecto);
        }
        else if(hielo)
        {
            hechizo=new Hielo(nombre,rara,costoEnergia,imagenGenerica,descripcionEspacio.getText(),valorEfecto);
        }
        else if(robaCarta)
        {
            hechizo=new RobaCarta(nombre,rara,costoEnergia,imagenGenerica,descripcionEspacio.getText(),valorEfecto);
        }

        Administrador admin=new Administrador();
        hechizo.setId(admin.agregarId());

        return hechizo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(salir)){
            setVisible(false);
            SeleccionAdmin vuelta=new SeleccionAdmin();
        }else if(e.getSource().equals(aceptar)){
            try {
                if(inputsCompletos()){
                    if(validarInputs()) {
                        Administrador admin=new Administrador();
                        if (isPersonaje) {
                            if (checkBoxValidas(orcoCheck, necrofagoCheck, golemCheck, humanoCheck)) {
                                if(admin.validarNombreCarta(true,nombreEspacio.getText())) {
                                    JOptionPane.showMessageDialog(null, "Se a guardado con exito!");
                                    setVisible(false);
                                    Personaje aGuardar=crearPersonaje(humanoCheck.isSelected(),orcoCheck.isSelected(),necrofagoCheck.isSelected(),golemCheck.isSelected());
                                    Administrador.guardarCarta(aGuardar);
                                    SeleccionAdmin vuelta = new SeleccionAdmin();
                                }else{
                                    JOptionPane.showMessageDialog(null,"Ese nombre ya existe! Ingrese uno nuevo");
                                }
                            }
                        } else {
                            if (checkBoxValidas(robarCartaCheck, curacionCheck, danioCheck, hieloCheck)) {
                                if(admin.validarNombreCarta(true,nombreEspacio.getText())) {
                                    JOptionPane.showMessageDialog(null, "Se a guardado con exito!");
                                    setVisible(false);
                                    Hechizo aGuardar=crearHechizo(curacionCheck.isSelected(),danioCheck.isSelected(),hieloCheck.isSelected(),robarCartaCheck.isSelected());
                                    Administrador.guardarCarta(aGuardar);
                                    SeleccionAdmin vuelta = new SeleccionAdmin();
                                }else{
                                    JOptionPane.showMessageDialog(null,"Ese nombre ya existe! Ingrese uno nuevo");
                                }
                            }
                        }
                    }
                }
            }catch (JCheckBoxInvalido |InputInvalidoExcepcion |JtextFieldVacioException | NumeroInvalidoExcepcion ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            } catch (PasaNullExcepcion ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
                System.exit(0);
            }
        }
    }
}
