import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Persona implements Comparable<Persona>{
    private int id;
    public int tiempoLlegada;
    public int tiempoServicio;
    private int tiempoEspera;

    public Persona(int id) {
        this.id = id;
        this.tiempoLlegada = new Random().nextInt(28801); 
        this.tiempoServicio = new Random().nextInt(3301) + 300; 
        this.tiempoEspera = 0;
    }

    

    public int getId() {
        return id;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public int getTiempoServicio() {
        return tiempoServicio;
    }


    @Override
    public int compareTo(Persona otraPersona) {
        return Integer.compare(this.tiempoLlegada, otraPersona.tiempoLlegada);
    }
    public static void organizarQueue(Queue<Persona> colaPersonas) {
        LinkedList<Persona> listaPersonas = new LinkedList<>(colaPersonas);
        listaPersonas.sort(null); // Utiliza el orden natural definido en compareTo
        colaPersonas.clear();
        colaPersonas.addAll(listaPersonas);
    }
    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", tiempoLlegada=" + tiempoLlegada +
                ", tiempoServicio=" + tiempoServicio +
                ", tiempoEspera=" + tiempoEspera +
                '}';
    }
}
