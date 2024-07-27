/*
Autores:
            Fariña, María José
            Fraticola, Paola
            Ferrer, Melina
            
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;



public class EmpezarPrograma
{
    static String FILE_PATH = "peliculasGuardadas.txt";

    public static ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();

    public static String colorVerde = "\033[0;32m";
    public static String colorVioleta = "\033[0;35m";
    public static String resetColor = " \033[0;37m";
    public static String subrayado = "\033[4;37m";
    public static String colorAzul = "\033[0;34m";
    public static String colorNegrita =  "\033[1;37m" ;
    public static String colorNegroBrillante = "\033[1;90m";
    public static String colorBlancoBrillante = "\033[1;97m";
    public static String lila_background = "\u001B[45m";
    public static String colorCyan = "\u001B[36m";
    public static String rojo_background = "\u001B[41m";

    public static void Msj(String texto)
    {
        System.out.println(texto);
    }

    public static void MsjMismaLinea(String texto)
    {
        System.out.print(texto);
    }

    public static void PeliculasOriginales()
    {
        
        Pelicula peliculaUno = new Pelicula("Barbie", 2023, false);
        Pelicula peliculaDos = new Pelicula("Encanto", 2021, false);
        Pelicula peliculaTres = new Pelicula("Trolls 3", 2023, true);
        Pelicula peliculaCuatro = new Pelicula("Jason X", 2001, false);
        Pelicula peliculaCinco = new Pelicula("The Marvels", 2023, true);
        listaPeliculas.add(peliculaUno);
        listaPeliculas.add(peliculaDos);
        listaPeliculas.add(peliculaTres);
        listaPeliculas.add(peliculaCuatro);
        listaPeliculas.add(peliculaCinco);


    }

    public static void Ingreso()
    {
        
        
        try (Scanner input = new Scanner(System.in)) {
            CrearPorPrimeraVezTXT();
            PeliculasOriginales();
            CargarPeliculasDelArchivo();

            String nombreUsuario = "grupo3";
            String clave = "1234";
            boolean loggedIn = false;
      

            Msj(lila_background + colorBlancoBrillante + "Bienvenido al sistema de gestión de películas del cine de Grupo 3"+ resetColor);

            while (true)
            {
                try
                {
                    if(!loggedIn)
                    {           
                        MsjMismaLinea(colorVioleta + "Ingrese su usuario:" + resetColor);
                        String usuarioIngresado = input.nextLine();
                        MsjMismaLinea(colorVioleta+"Ingrese su contraseña:"+resetColor);
                        String claveIngresada = input.nextLine();
                        
                        if (usuarioIngresado.equals(nombreUsuario)&&(claveIngresada.equals(clave)))
                        {
                            loggedIn = true;
                            Msj("");
                            Msj(colorVerde+"SESIÓN INICIADA CON ÉXITO."+resetColor);
                            Msj("");
                            
                        } else
                        {
                            Msj(colorBlancoBrillante + rojo_background +"USUARIO Y/O CONTRASEÑA INCORRECTOS. INTENTE NUEVAMENTE"+resetColor);
                            Msj("");
                        }

                    }else
                    { 
                        Msj(subrayado  + colorBlancoBrillante + lila_background +"Usted está viendo el Menú Principal:"+resetColor);
                        Msj( colorNegrita + colorCyan + "1." + resetColor + colorBlancoBrillante + "Mostrar listado de películas" + resetColor);
                        Msj( colorNegrita + colorCyan + "2." + resetColor + colorBlancoBrillante + "Agregar película" +resetColor);
                        Msj( colorNegrita + colorCyan + "3." + resetColor + colorBlancoBrillante + "Editar película en exhibición" + resetColor);
                        Msj( colorNegrita + colorCyan + "4." + resetColor + colorBlancoBrillante + "Eliminar película" + resetColor);
                        Msj( colorNegrita + colorCyan + "5." + resetColor + colorBlancoBrillante + "Salir y guardar películas" + resetColor);
                        Msj("");
                        MsjMismaLinea( colorCyan + "»»------( Seleccione una opción )------««:" + resetColor);
                            
                        
                
                        int opcion = input.nextInt();

                            switch (opcion) 
                            {
                                case 1:         //MUESTRA LISTADO PELICULAS PRECARGADAS
                                        Msj("");
                                        Msj(colorVioleta + "*****---LISTADO DE PELÍCULAS---*****" + resetColor);
                                        for(Pelicula p : listaPeliculas)
                                        {
                                            System.out.println(p);
                                        }

                                        Msj(colorVioleta +  "*****-------------------------*****" + resetColor);
                                        GuardarPeliculasEnUnArchivo();
                                        Msj("");
                                        break;

                                case 2:         //PUEDE AGREGAR PELICULA A LA LISTA
                                        input.nextLine();
                                        MsjMismaLinea(colorAzul + "Ingrese el nombre de la película que quiere agregar:" + resetColor);
                                        String nuevoNombre = input.nextLine();
                                        MsjMismaLinea(colorAzul +"Ingrese el año de estreno de la película (Solamente ingrese números):"+ resetColor);
                                        int nuevoAño = input.nextInt();
                                        MsjMismaLinea(colorAzul + "Indique si está exhibida o no (Ingrese solamente True o False):" + resetColor);
                                        boolean exhibidoONo = input.nextBoolean();
                                        Pelicula nuevaPelicula = new Pelicula (nuevoNombre, nuevoAño, exhibidoONo);
                                        listaPeliculas.add(nuevaPelicula);
                                        Msj("");
                                        Msj(colorVerde + "PELÍCULA AGREGADA CON ÉXITO" + resetColor);
                                        GuardarPeliculasEnUnArchivo();
                                        Msj("");
                                        break;

                                case 3:         //MODIFICA LA LISTA DE PELICULAS
                                        input.nextLine(); 
                                        MsjMismaLinea(colorAzul + "Ingrese el nombre de la película que desee modificar su uso:" + resetColor);
                                        String modificar = input.nextLine();
                                        Pelicula peliculaAModificar = null;
                                    
                                        for (Pelicula p : listaPeliculas) 
                                        {
                                            if (p.getNombre().equalsIgnoreCase(modificar))
                                            {
                                                peliculaAModificar = p;
                                                break; 
                                            }
                                        }


                                        if (peliculaAModificar != null)
                                        {
                                            
                                            MsjMismaLinea(colorCyan + "Usted seleccionó - " + colorNegroBrillante +  peliculaAModificar + resetColor);
                                            Msj("");
                                            MsjMismaLinea(colorAzul + "¿Desea cambiar el estado de exhibición? (Coloque solamente true o false):" + resetColor);
                                            boolean estaONO = input.nextBoolean();
                                            peliculaAModificar.setExhibidoONo(estaONO);
                                            Msj("");
                                            Msj(colorVerde + "ESTADO DE EXHIBICIÓN CAMBIADO CON ÉXITO" + resetColor);
                                            Msj("");
                                        } else 
                                        {
                                            Msj("");
                                            Msj(colorBlancoBrillante + rojo_background + "LA PELÍCULA NO FUE ENCONTRADA. INTENTE NUEVAMENTE" + resetColor);
                                            Msj("");
                                        }
                                        GuardarPeliculasEnUnArchivo();
                                        break;

                                case 4:         //ELIMINA PELICULA DE LA LISTA

                                        input.nextLine();
                                        Pelicula peliculaAEliminar = null;
                                        MsjMismaLinea(colorVioleta + "Ingrese su contraseña:" + resetColor);
                                        String claveIngresada = input.nextLine();
                                        
                                        if (claveIngresada.equals(clave)) 
                                        {
                                            MsjMismaLinea(colorAzul + "Ingrese el nombre de la película que desea eliminar:" + resetColor);
                                            String peliculaEliminada = input.nextLine();
                                    
                                            for (Pelicula p : listaPeliculas) 
                                            {
                                                if (p.getNombre().equalsIgnoreCase(peliculaEliminada)) 
                                                {
                                                    peliculaAEliminar = p;
                                                    break;
                                                }
                                            }
                                    
                                            if (peliculaAEliminar != null) 
                                            {
                                                listaPeliculas.remove(peliculaAEliminar);
                                                Msj("");
                                                Msj(colorVerde + "PELÍCULA ELIMINADA CON ÉXITO");
                                            } else 
                                            {
                                                Msj("");
                                                Msj(colorBlancoBrillante + rojo_background + "PELÍCULA NO ENCONTRADA" + resetColor);
                                            }
                                    
                                            Msj("");
                                        } else 
                                        {
                                            Msj("");
                                            Msj(colorBlancoBrillante + rojo_background + "CONTRASEÑA INCORRECTA. INGRESELA NUEVAMENTE" + resetColor);
                                            Msj("");
                                        }
                                        GuardarPeliculasEnUnArchivo();
                                        break;
                                                                                                 
                                            
                                case 5: 
                                        
                                        GuardarPeliculasEnUnArchivo();
                                        Msj(colorAzul + "▓▓▓▓▓▓▓▓▓▓▓▓▓ Saliendo del sitio del cine ¡Gracias por visitarnos! ▓▓▓▓▓▓▓▓▓▓▓▓▓" + resetColor);
                                        System.exit(0);
                                        break;
                            
                            
                                default:

                                        Msj(colorBlancoBrillante + rojo_background + "OPCIÓN NO VÁLIDA. INTENTE NUEVAMENTE" + resetColor);
                                        Msj("");
                                        break;
                                    
                            }
                                    
                    }

                }
                catch(Exception e)
                {
                    Msj("");
                    Msj(colorBlancoBrillante + rojo_background + "¡¡DEBE INGRESAR UNA OPCIÓN VÁLIDA!!" + resetColor);
                    input.nextLine();
                    Msj("");
                }

            }
        }
      
    }


    //CREAR POR PRIMERA VEZ UN ARCHIVO TXT
    public static void CrearPorPrimeraVezTXT()
    {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            Msj(colorBlancoBrillante + rojo_background + "ERROR AL CARGAR PELÍCULAS" + resetColor);
        }
    }


    //ESCRIBIR PELICULAS DESDE UN ARCHIVO
    public static void GuardarPeliculasEnUnArchivo() {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(FILE_PATH))) {
            ArrayList<String> peliculasGuardadas = new ArrayList<>(); // Para almacenar nombres de películas ya guardadas

            for (Pelicula p : listaPeliculas) {
                // Verificar si la película ya está en la lista de películas guardadas
                if (!peliculasGuardadas.contains(p.getNombre())) {
                    escritor.println(p.getNombre() + "," + p.getAño() + "," + p.getexhibidoONo());
                    peliculasGuardadas.add(p.getNombre()); // Agregar el nombre de la película a la lista de películas guardadas
                }
            }

            Msj(colorVerde + "Películas guardadas en el archivo: " + FILE_PATH + resetColor);

        } catch (IOException e) {
            Msj(rojo_background + "ERROR AL INTENTAR GUARDAR PELICULAS EN EL ARCHIVO" + resetColor);
        }
    }

    

    //LEER PELICULAS DESDE UN ARCHIVO
    public static void CargarPeliculasDelArchivo()
    {
        try(BufferedReader lector = new BufferedReader(new FileReader(FILE_PATH)))
        {
            String linea;
            while((linea = lector.readLine()) != null)
            {
                String[] partes = linea.split(",");
                String nombre = partes[0];
                int año = Integer.parseInt(partes[1]);
                boolean exhibidoONo = Boolean.parseBoolean(partes[2]);

                Pelicula p = new Pelicula(nombre, año, exhibidoONo);

                //Verificar si la pelicula ya existe en la lista antes de agregarla
                if(! existePeliculaEnLista(p)){
                    listaPeliculas.add(p);

                }
                //listaPeliculas.add(p);

            }

            Msj(colorVerde + "PELÍCULAS CARGADAS DEL ARCHIVO: " + FILE_PATH + resetColor);

        }catch(IOException e)
        {
            Msj(colorBlancoBrillante + rojo_background + "ERROR AL CARGAR PELÍCULAS" + resetColor);
        }

    }

    //Método auxiliar para verificar si una película ya existe en la lista
    private static boolean existePeliculaEnLista(Pelicula pelicula) {
        for (Pelicula p : listaPeliculas) {
            if (p.getNombre().equalsIgnoreCase(pelicula.getNombre())) {
                return true;
            }
        }
        return false;
    }

   

}