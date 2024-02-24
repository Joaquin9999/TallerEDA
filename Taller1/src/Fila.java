import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    private Queue<Persona> fila;

    public Fila() {
        fila = new LinkedList<>();
    }

    
    public void agregarPersona(Persona persona) {
        fila.add(persona);
        ordenarFila();
    }

    
    public Persona obtenerPersona() {
        return fila.poll();
    }

    
    private void ordenarFila() {
        Queue<Persona> nuevaFila = new LinkedList<>();
        while (!fila.isEmpty()) {
            Persona persona = fila.poll();
            if (nuevaFila.isEmpty() || persona.getTiempoLlegada() >= nuevaFila.peek().getTiempoLlegada()) {
                nuevaFila.add(persona);
            } else {
                while (!nuevaFila.isEmpty() && persona.getTiempoLlegada() < nuevaFila.peek().getTiempoLlegada()) {
                    fila.add(nuevaFila.poll());
                }
                nuevaFila.add(persona);
            }
        }
        fila = nuevaFila;
    }

   
    public int tamanoFila() {
        return fila.size();
    }
}
