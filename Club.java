import java.util.ArrayList;
import java.util.Iterator;
/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    // Define any necessary fields here ...
    private ArrayList<Membership> miembros;
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // Initialise any fields here ...
        miembros = new ArrayList<Membership>();
        int[]mienbrosEnMes = new int[12];
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        miembros.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return miembros.size();
    }

    /** 
     * Calcula el numero de socios que se dieron de alta en un mes determinado. 
     * El año no nos importa. En caso de que el parametro contenga un valor 
     * no valido se muestra por pantalla el error.
     * @param month El mes en el que estamos interesados
     * @return El numero de socios que se dieron de alta dicho mes
     */
    public int joinedMonth(int month )
    {
        int contador = 0;
        if (month < 1 || month > 12){
            System.out.println("error mes no compatible introducir un valor entre 1-12");
            contador = -1;
        }
        else {

            for (Membership member : miembros){
                if (member.getMonth()== month){
                    contador ++;
                }

            }

        }
        return contador;
    }

    /** 
     * Todos los socios que se han dado de alta un determinado mes de un determinado año se
     * dan de baja. En caso de que el parametro month contenga un valor no valido se muestra 
     * por pantalla el error.
     * @param month El mes en el que estamos interesados
     * @param year El año en el que estamos interesados
     * @return Una coleccion con los socios que se han dado de baja del club
     */
    public ArrayList<Membership> purge (int month , int year)
    {
        ArrayList<Membership> dadosDeBaja = null;
        if (month >= 1 && month <= 12) {
            dadosDeBaja = new ArrayList<>();
            Iterator<Membership> it = miembros.iterator();
            while (it.hasNext()) {
                Membership miembro = it.next();
                if (miembro.getMonth() == month && miembro.getYear() == year) {
                    dadosDeBaja.add(miembro);
                    it.remove();
                    
                }
            }
        }
        else {
            System.out.println("datos mal introducidos");
        }
        return dadosDeBaja;
    }
}
