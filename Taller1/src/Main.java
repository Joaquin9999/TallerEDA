public class Main {
    public static void main(String[] args) {
        /*SimuladorFilas simulador=new SimuladorFilas(2000,2,3);
        simulador.mostrarAgentes();
        System.out.println(simulador.fila.toString());*/
        int tiempoMaximo = 28800; // Tiempo máximo en segundos
        int agentes = 2; // Número de personas
        int personas = 40;


        SimuladorFilas simulador = new SimuladorFilas(tiempoMaximo, agentes, personas);
        System.out.println(simulador.fila.toString());
        simulador.correrSimulacion();
        System.out.println(simulador.fila.toString());



    }
}
