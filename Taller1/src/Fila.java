import java.util.*;

public class Fila implements Iterable<Persona> {
    private Queue<Persona> fila;

    public Fila() {
        fila = new LinkedList<>();
    }
    @Override
    public Iterator<Persona> iterator() {
        return fila.iterator();
    }


    public void agregarPersona(Persona persona) {

        fila.add(persona);
    }
    public void organizar() {
        List<Persona> listaPersonas = new LinkedList<>(fila);
        listaPersonas.sort(null); // Utiliza el orden natural definido en compareTo de Persona
        fila.clear();
        fila.addAll(listaPersonas);
    }


    public Persona obtenerPersona() {
        return fila.poll();
    }





    public int tamanoFila() {
        return fila.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fila de personas:\n");
        for (Persona persona : fila) {
            stringBuilder.append(persona.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public Persona poll() {
        return fila.poll();
    }
}

