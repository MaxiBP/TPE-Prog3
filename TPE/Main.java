package TPE;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader();

        Backtracking backtracking = new Backtracking();
        Greedy greedy = new Greedy();
        
        System.out.println("\u001B[35m" + "BACKTRACKING"+ "\u001B[0m");
        // backtracking puro - sin poda
        List<Camion> camiones1 = reader.cargarCamiones("TPE\\Camiones.csv");
        List<Paquete> paquetes1 = reader.cargarPaquetes("TPE\\Paquetes.csv");
        System.out.println("\u001B[32m"+"BACKTRACKING PURO - SIN PODA"+"\u001B[0m");
        Solucion s1 = backtracking.asignar(camiones1, paquetes1, false, false);
        System.out.println("Estados:"+ s1.getMetrica());

        // backtracking con poda - sin ordenar
        List<Camion> camiones2 = reader.cargarCamiones("TPE\\Camiones.csv");
        List<Paquete> paquetes2 = reader.cargarPaquetes("TPE\\Paquetes.csv");
        System.out.println("\u001B[32m"+"BACKTRACKING CON PODA - SIN ORDENAR"+"\u001B[0m");
        Solucion s2 = backtracking.asignar(camiones2, paquetes2, false, true);
        System.out.println("Estados:"+ s2.getMetrica());

        // backtracking con poda y lista ordenada
        List<Camion> camiones3 = reader.cargarCamiones("TPE\\Camiones.csv");
        List<Paquete> paquetes3 = reader.cargarPaquetes("TPE\\Paquetes.csv");
        System.out.println("\u001B[32m"+"BACKTRACKING CON PODA Y LISTA ORDENADA"+"\u001B[0m");
        Solucion s3 = backtracking.asignar(camiones3, paquetes3, true, true);
        System.out.println("Estados:"+ s3.getMetrica());

        // Greedy
        System.out.println("\u001B[35m" + "GREEDY"+ "\u001B[0m");
        List<Camion> camionesG = reader.cargarCamiones("TPE\\Camiones.csv");
        List<Paquete> paquetesG = reader.cargarPaquetes("TPE\\Paquetes.csv");
        Solucion gSolucion = greedy.asignar(camionesG, paquetesG);
        System.out.println("Estados:"+ gSolucion.getMetrica());
    }
}
