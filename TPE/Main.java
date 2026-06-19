package TPE;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        CSVReader reader = new CSVReader();

        List<Camion> camiones = reader.cargarCamiones("TPE\\Camiones.csv");

        List<Paquete> paquetes = reader.cargarPaquetes("TPE\\Paquetes.csv");

        System.out.println(
                "Camiones cargados: "
                + camiones.size()
        );

        System.out.println(
                "Paquetes cargados: "
                + paquetes.size()
        );
    }
}
