public class Agente {
    private int id;
    private int tiempoOcupado;
    private Fila filaActual; 

    public Agente(int id) {
        this.id = id;
        this.tiempoOcupado = 0;
        this.filaActual = null;
    }

    
    public void asignarFila(Fila fila) {
        this.filaActual = fila;
    }

    
    public void atenderPersona() {
        if (filaActual != null && filaActual.tamanoFila() > 0) {
            Persona personaActual = filaActual.obtenerPersona();
            int tiempoEspera = calcularTiempoEspera(personaActual.getTiempoLlegada());
            personaActual.setTiempoEspera(tiempoEspera);
            tiempoOcupado += personaActual.getTiempoServicio();
            System.out.println("Agente " + id + " atiende a Persona " + personaActual.getId() +
                    " - Tiempo de espera: " + tiempoEspera + " - Tiempo de servicio: " + personaActual.getTiempoServicio());
        } else {
            System.out.println("Agente " + id + " en standby por 1 segundo");
            tiempoOcupado++;
        }
    }

    private int calcularTiempoEspera(int tiempoLlegada) {
        return tiempoOcupado - tiempoLlegada;
    }

    public int getTiempoOcupado() {
        return tiempoOcupado;
    }
}
