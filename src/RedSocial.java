import com.google.common.collect.*;

import java.util.*;

public class RedSocial {

    private Map<Long,Persona> personasID=new HashMap<>();
    private Map<String,Persona>personasNombre=new HashMap<>();
    private BiMap<Persona,Persona> parejas= HashBiMap.create();
    private TreeMultimap<Persona, Persona> personasAmistad= TreeMultimap.create();


    public void añadirPersona(Persona persona){

        personasID.put(persona.getiD(),persona);
        personasNombre.put(persona.getNombre(),persona);
    }

    public Persona getPersona (Long iD){
        return personasID.get(iD);
    }

    public Persona getPersona (String nombre){
        return personasNombre.get(nombre);
    }

    public Persona añadirPareja(Persona p1,Persona p2){

        comprobarPareja(p1);
        comprobarPareja(p2);

        return parejas.put(p1,p2);}

    private void comprobarPareja(Persona p1) {
        if (parejas.containsKey(p1)|| parejas.containsValue(p1))
        {
            System.out.println("La persona " +p1.getNombre() +" ya tiene pareja");
            throw new RuntimeException("La persona " +p1.getNombre() +" ya tiene pareja");
        }
    }

    public Persona getPareja(Persona persona) {

        Persona pareja = parejas.get(persona);

        if (pareja != null)
            return pareja;
        else {
            pareja = parejas.inverse().get(persona);
            return pareja;
        }
    }

    public Set<Persona> getAmigos(Persona persona){return personasAmistad.get(persona);}

    public void añadirAmigo(Persona p1, Persona p2){
        //comprobarAmigos(p1,p2);

        personasAmistad.put(p1,p2);
        personasAmistad.put(p2,p1);
    }

    private void comprobarAmigos(Persona p1,Persona p2) {
        if ((personasAmistad.containsKey(p1)&& personasAmistad.containsValue(p2))||(personasAmistad.containsKey(p2)&&personasAmistad.containsValue(p1)))
        {
            throw new RuntimeException("Las personas introducidas ya son amigas");
        }
    }

    public Set<Persona> getAmigosDePareja(Persona persona){

        Persona pareja=parejas.get(persona);
        Set<Persona> amigosDePareja;

        if (pareja==null){
            amigosDePareja= new HashSet<Persona>();
        }else{
            amigosDePareja= personasAmistad.get(pareja);
        }
        return amigosDePareja;
    }

    public Set<Persona>getParejasDeAmigos(Persona persona){

        Set<Persona> amigos=personasAmistad.get(persona);
        Set<Persona>parejasDeAmigos = new HashSet<>();

        for (Persona amigo:amigos)
        {
            parejasDeAmigos.add(getPareja(amigo));
        }
        return parejasDeAmigos;
    }

    public List<Persona> getColaDePopularidad(){

        List<Persona>personaList=new ArrayList<>(personasNombre.values());
        TreeSet<Persona> popularidad=new TreeSet<>();

        Collections.sort(personaList, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {

                Integer num1=getAmigos(p1).size();
                Integer num2=getAmigos(p2).size();

             return num2.compareTo(num1);
            }
        });
        return personaList;
    }

    public int getGradoConexion(Persona p1,Persona p2)
    {

        return 0;
    }
    public SortedSet<Persona>  getCaminoGradoConexion (Persona p1, Persona p2){return null;}
}
