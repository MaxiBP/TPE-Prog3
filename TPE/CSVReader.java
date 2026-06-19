package TPE;

import java.io.*;
import java.util.*;

public class CSVReader {

    public List<Paquete> cargarPaquetes(String path) throws IOException {

        List<Paquete> paquetes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            int cantidadEsperada = Integer.parseInt(br.readLine());

            String linea;

            while ((linea = br.readLine()) != null) {
                paquetes.add(parsearPaquete(linea));
            }

            if (paquetes.size() != cantidadEsperada) {
                throw new RuntimeException(
                        "Cantidad de paquetes inválida");
            }
        }

        return paquetes;
    }

    public List<Camion> cargarCamiones(String path) throws IOException {

        List<Camion> camiones = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            int cantidadEsperada = Integer.parseInt(br.readLine());

            String linea;

            while ((linea = br.readLine()) != null) {
                camiones.add(parsearCamion(linea));
            }

            if (camiones.size() != cantidadEsperada) {
                throw new RuntimeException(
                        "Cantidad de camiones inválida");
            }
        }

        return camiones;
    }

    private Paquete parsearPaquete(String linea) {

        String[] datos = linea.split(";");

        return new Paquete(
                Integer.parseInt(datos[0]),
                datos[1],
                Integer.parseInt(datos[2]),
                datos[3].equals("1"),
                Integer.parseInt(datos[4])
        );
    }

    private Camion parsearCamion(String linea) {

        String[] datos = linea.split(";");

        return new Camion(
                Integer.parseInt(datos[0]),
                datos[1],
                datos[2].equals("1"),
                Integer.parseInt(datos[3]), null
        );
    }
}