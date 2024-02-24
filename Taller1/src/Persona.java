import java.util.Random;

public class Persona {
    private int id;
    private int tiempoLlegada;
    private int tiempoServicio;
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

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }
}
