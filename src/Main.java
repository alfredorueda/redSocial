import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.*;

public class Main extends RedSocial{

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("Hello World!");


        Persona cristina = new Persona(1L, "Cristina", "Lopez", 21);
        Persona juan = new Persona(2L, "Juan", "Fernandez", 25);
        Persona pedro = new Persona(3L, "Pedro", "Rodriguez", 22);
        Persona julia = new Persona(4L, "Julia", "Iglesias", 20);
        Persona carol = new Persona(5L, "Carol", "Hernandez", 19);
        Persona ana = new Persona(6L, "Ana", "Sanchez", 24);
        Persona antonio = new Persona(7L, "Antonio", "Vega", 25);
        Persona marc = new Persona(8L, "Marc", "Martinez", 19);

        RedSocial redSocial=new RedSocial();
        redSocial.añadirPersona(cristina);
        redSocial.añadirPersona(juan);
        redSocial.añadirPersona(pedro);
        redSocial.añadirPersona(julia);
        redSocial.añadirPersona(carol);
        redSocial.añadirPersona(ana);
        redSocial.añadirPersona(antonio);
        redSocial.añadirPersona(marc);

        System.out.println("Consultar personas por ID:");
        System.out.println("Id 1: " +redSocial.getPersona(1L));

        System.out.println("Consultar personas por nombre: ");
        System.out.println("Datos:"  +redSocial.getPersona("Julia"));

        redSocial.añadirPareja(cristina,juan);
        redSocial.añadirPareja(pedro,antonio);
        redSocial.añadirPareja(ana,marc);

        redSocial.añadirAmigo(cristina,pedro);
        redSocial.añadirAmigo(julia,pedro);
        redSocial.añadirAmigo(julia,carol);
        redSocial.añadirAmigo(julia,ana);
        redSocial.añadirAmigo(juan,antonio);
        redSocial.añadirAmigo(juan,marc);
        redSocial.añadirAmigo(marc,antonio);
        redSocial.añadirAmigo(ana,antonio);

        System.out.println("Map de amigos:");

        System.out.println("amigos de julia");
        System.out.println( redSocial.getAmigos(julia));
        System.out.println("amigos de la pareja de julia");
        System.out.println(redSocial.getAmigosDePareja(julia));
        System.out.println("parejas de los amigos de julia");
        System.out.println(redSocial.getParejasDeAmigos(julia));
        System.out.println("cola de popularidad");
        System.out.println(redSocial.getColaDePopularidad());



    }

}