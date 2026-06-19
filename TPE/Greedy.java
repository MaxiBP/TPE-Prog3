package TPE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Greedy {


    /*
    * La estrategia Greedy (desarrollada en la función asignar) elegida busca minimizar el peso de los paquetes no asignados,
    * para ello se buscó priorizar los paquetes mas pesados primero e intentar asignarle a cada paquete el mejor
    * camión posible, o descartarlo de ser necesario. Entonces:
    * Primero se ordenan los paquetes, luego para cada paquete se buscan los camiones compatibles y de ellos se selecciona
    * el que menos espacio libre deje, si ningún camión puede con el paquete, éste queda sin asignar y su peso suma al peso no asignado
    */
    public Solucion asignar(List<Camion> camiones, List<Paquete> paquetes) {

        // Ordenamos los paquetes de mayor a menor peso
        paquetes.sort((a, b) -> Integer.compare(b.getPeso(),a.getPeso()));

        HashMap<Camion, List<Paquete>> asignacion = new HashMap<>();

        for (Camion camion : camiones) {
            asignacion.put(camion,new ArrayList<>());
        }

        int pesoNoAsignado = 0;
        int estadosGenerados = 0;

        // Por cada paquete buscamos el mejor camión para asignarlo
        for (Paquete paquete : paquetes) {

            Camion mejorCamion = null;

            int menorEspacioLibre =Integer.MAX_VALUE;

            for (Camion camion : camiones) {
                
                // tantos estados como candidatos para cada paquete
                estadosGenerados ++;

                if (camion.puedeTransportar(paquete)) {

                    int espacioLibre = camion.getCapacidadDisponible() - paquete.getPeso();

                    // el mejor camión para el paquete es aquel que deja menos espacio libre
                    if (espacioLibre < menorEspacioLibre) {

                        menorEspacioLibre = espacioLibre;

                        mejorCamion = camion;
                    }
                }
            }

            // si encontró el mejor camión lo asigna
            if (mejorCamion != null) {

                mejorCamion.asignarPaquete(paquete);

                asignacion.get(mejorCamion).add(paquete);

                // si no, el paquete no se asigna y se suma su peso al peso no asignado
            } else {

                pesoNoAsignado += paquete.getPeso();
            }
        }

        return new Solucion(asignacion,pesoNoAsignado,estadosGenerados);
    }
}