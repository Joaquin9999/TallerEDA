public class Agente {
    private int id;
    private int tiempoOcupado;
    public boolean ocupacion;

    public Agente(int id) {
        this.id = id;
        this.tiempoOcupado = 0;
        this.ocupacion=false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTiempoOcupado(int tiempoOcupado) {
        this.tiempoOcupado = tiempoOcupado;
    }


    public boolean isOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(boolean ocupacion) {
        this.ocupacion = ocupacion;
    }
    public void atenderPersona(Persona persona, int tiempoActual, int tiempoMaximo) {
        int tiempoServicio = Math.min(persona.tiempoServicio, tiempoMaximo - tiempoActual);
        persona.setTiempoEspera(tiempoActual - persona.tiempoLlegada);
        this.tiempoOcupado += tiempoServicio;
        ocupacion = true;
        // Simular tiempo de servicio
        tiempoActual += tiempoServicio;

        ocupacion = false;
    }

    public void permanecerEnStandby() {
        // Simular standby por un segundo
        tiempoOcupado++;
    }
    public int obtenerTiempoOcupado() {
        return tiempoOcupado;
    }

    @Override
    public String toString() {
        return "Agente{" +
                "id=" + id +
                ", tiempoOcupado=" + tiempoOcupado +
                ", ocupacion=" + ocupacion +
                '}';
    }

    private int calcularTiempoEspera(int tiempoLlegada) {
        return tiempoOcupado - tiempoLlegada;
    }

    public int getTiempoOcupado() {
        return tiempoOcupado;
    }
}
