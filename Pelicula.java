/*
Autores:
            Fariña, María José
            Fraticola, Paola
            Ferrer, Melina
            
*/


public class Pelicula
{
    
        String nombre;
        int año;
        boolean exhibidoONo;

    //tiene que estar constructor
    public Pelicula(String n, int a, boolean vof)
    {
        this.nombre = n;
        this.año = a;
        this.exhibidoONo = vof;
    }

    //tiene que estar los getters
    public String getNombre()
    {
        return nombre;
    }

    public int getAño()
    {
        return año;
    }
    public boolean getexhibidoONo()
    {
        return exhibidoONo;
    }
  
    //tiene que estar los setters para modificar los nombres
    public void setNombre(String nuevoNombre)
    {
        this.nombre = nuevoNombre;
    }

    public void setAño(int nuevoAño)
    {
        this.año = nuevoAño;
    }

    public void setExhibidoONo(boolean cambiar)
    {
         this.exhibidoONo = cambiar;
    }

    //si no hago esto no me muestra la lista
    @Override
    public String toString()
    {

        String colorTrue = "\033[0;32m"; // Color verde para true

        String colorFalse = "\033[0;31m"; // Color rojo para false
        String colorBlancoBrillante = "\033[1;97m";
        String resetColor = " \033[0;37m";
        //return colorBlancoBrillante + "Pelicula: " +resetColor + nombre + ", " + año + ", " + exhibidoONo;
        //return colorBlancoBrillante+"Pelicula:  "+resetColor + nombre +", ("+ año +"), ("+exhibidoONo +")";

        return colorBlancoBrillante+"Película: " + nombre +
                colorBlancoBrillante+", Año: " + año +
                ", Exhibida: " + (exhibidoONo ? colorTrue + "true" + resetColor : colorFalse + "false" + resetColor);

    }
}