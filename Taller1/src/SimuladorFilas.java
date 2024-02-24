import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class SimuladorFilas{

    Fila fila=new Fila();
    int tiempoMaximo;



    ArrayList<Agente> agentes;

    public SimuladorFilas(int tiempoMaximo, int numAgentes, int numPersonas) {
        this.tiempoMaximo = tiempoMaximo;
        this.fila = new Fila();
        this.agentes = new ArrayList<>();


        //se anaden los agentes a la lista de agentes
        for (int i=1;i<=numAgentes;i++){
            this.agentes.add(new Agente(i));}

            //se anaden personas
            for (int j=1;j<=numPersonas;j++){
                Persona persona=new Persona(j);

                this.fila.agregarPersona(persona);
            }
            fila.organizar();
    }




    public void mostrarAgentes() {
        System.out.println("Lista de Agentes:");
        for (int i = 0; i < agentes.size(); i++) {
            Agente agente = agentes.get(i);
            System.out.println("Agente " + (i + 1) + ": " + agente.getId());
        }
    }



    public void correrSimulacion() {
        int tiempoActual = 0;

        while (tiempoActual < tiempoMaximo && (!fila.isEmpty() || hayAgentesOcupados())) {
            // Atender a las personas por parte de los agentes
            for (Agente agente : agentes) {
                if (!agente.ocupacion && !fila.isEmpty()) {
                    Persona personaActual = fila.poll();
                    agente.atenderPersona(personaActual,tiempoActual,tiempoMaximo);
                } else if (!agente.ocupacion) {
                    // Si el agente está desocupado y la cola está vacía, permanece en standby
                    agente.permanecerEnStandby();
                }
            }

            tiempoActual++;
        }

        // Mostrar resultados al final de la simulación
        mostrarResultados();
    }




    private boolean hayAgentesOcupados() {
        for (Agente agente : agentes) {
            if (agente.isOcupacion()) {
                return true;
            }
        }
        return false;
    }

    private void mostrarResultados() {
        // Calcular y mostrar %Tiempo ocupado de cada Agente
        for (int i = 0; i < agentes.size(); i++) {
            Agente agente = agentes.get(i);
            double porcentajeTiempoOcupado = ((double) agente.obtenerTiempoOcupado() / tiempoMaximo) * 100;
            System.out.println("Agente " + (i + 1) + ": %Tiempo ocupado = " + porcentajeTiempoOcupado + "%");
        }

        // Calcular y mostrar tiempo promedio de espera de las personas en la fila
        int totalTiempoEspera = 0;
        int totalPersonasAtendidas = 0;

        for (Agente agente : agentes) {
            for (Persona persona : fila) {
                totalTiempoEspera += persona.getTiempoEspera();
                totalPersonasAtendidas++;
            }
        }
        for (Persona persona : fila) {
            totalTiempoEspera += persona.getTiempoEspera();
            totalPersonasAtendidas++;
        }
        double tiempoPromedioEspera = totalPersonasAtendidas > 0 ? ((double) totalTiempoEspera / totalPersonasAtendidas) : 0;

        System.out.println("Tiempo promedio de espera de las personas en la fila: " + tiempoPromedioEspera + " seg");


}}