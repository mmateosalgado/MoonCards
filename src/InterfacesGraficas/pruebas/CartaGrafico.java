package InterfacesGraficas.pruebas;

import model.Carta;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CartaGrafico {
    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        // Return the buffered image

        return bimage;
    }

    public static ImageIcon devolverValorEnArreglo(int valor){
        ImageIcon aDevolver = null;
        int digitos = Integer.toString(valor).length(); // cantidad de dígitos
        if(digitos>0){
            ImageIcon arregloNumeros[] = new ImageIcon[10];
            for(int i = 0; i<arregloNumeros.length;i++){
                 arregloNumeros[i] = new ImageIcon("src\\imagenes\\numbers\\"+i+".png");
                // cargamos el arreglo, correspondiendo el valor de la posicion, con su valor del dígito.
            }
             if(digitos == 1){
                 aDevolver = arregloNumeros[valor];
                 }else if(digitos>1){
                    ImageIcon [] arreglo = new ImageIcon[digitos];
                    for(int i = 0; i<digitos;i++) {
                        int resto = valor % 10;
                        arreglo[digitos-(i+1)] = arregloNumeros[resto];
                        valor = valor/10;
                    }
                    aDevolver = ajustarImagenesToUnicaImagen(arreglo);
                 }
            }
        return aDevolver;
    }

    /*
        * Esta funcion va a acomodar todos los valores del array, que son cada un una imagen en particular, como una única imagen
        * Va a ordenar según el orden del array. Ej. array[4] = [1,2,3,4] -> image: 1234.
    */
    public static ImageIcon ajustarImagenesToUnicaImagen(ImageIcon[] arrayImages){
        int heightTotal = 0;
        int widthTotal = 0;
        // se crea un arreglo de bufferImage con las imagenes dentro del arreglo.
        BufferedImage [] bufferedImageArray = new BufferedImage[arrayImages.length];
        for(int i = 0;i<arrayImages.length;i++){
            bufferedImageArray[i] = toBufferedImage(arrayImages[i].getImage());
            heightTotal+=bufferedImageArray[i].getHeight();
            widthTotal+=bufferedImageArray[i].getWidth();
        }

        BufferedImage imagenFondo = new BufferedImage(heightTotal,widthTotal, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = imagenFondo.createGraphics();

        for(int i = 0; i< bufferedImageArray.length;i++){
           if(i==0){
               g.drawImage(arrayImages[0].getImage(),0,0,null);
           }else{
               g.drawImage(arrayImages[i].getImage(),bufferedImageArray[i-1].getWidth()-55,0,null);

           }

        }
    return new ImageIcon(imagenFondo);
    }

}







