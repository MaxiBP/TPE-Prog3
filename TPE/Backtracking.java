package TPE;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    private Solucion mejorSolucion;
    private int mejorPesoNoAsignado;
    private long estadosGenerados;

    public Solucion resolver(List<Camion> camiones,  List<Paquete> paquetes) {

        mejorPesoNoAsignado = Integer.MAX_VALUE;
        estadosGenerados = 0;
        mejorSolucion = null;

        paquetes.sort((a, b) -> Integer.compare(b.getPeso(),a.getPeso()));

        backtracking(0,paquetes,camiones,0);

        mejorSolucion.setMetrica(estadosGenerados);

        return mejorSolucion;
    }

    private void backtracking(int indice,List<Paquete> paquetes,List<Camion> camiones,int pesoNoAsignadoActual) {

        if (pesoNoAsignadoActual >= mejorPesoNoAsignado) {
            return;
        }

        if (indice == paquetes.size()) {

            estadosGenerados++;

            if (pesoNoAsignadoActual < mejorPesoNoAsignado) {

                mejorPesoNoAsignado = pesoNoAsignadoActual;

                mejorSolucion = copiarSolucion(camiones,pesoNoAsignadoActual);
            }

            return;
        }

        Paquete paqueteActual = paquetes.get(indice);

        for (Camion camion : camiones) {

            if (camion.puedeTransportar(paqueteActual)) {

                camion.asignarPaquete(paqueteActual);

                backtracking(indice + 1,paquetes,camiones,pesoNoAsignadoActual);

                camion.quitarPaquete(paqueteActual);
            }
        }

        backtracking(indice + 1,paquetes,camiones,pesoNoAsignadoActual + paqueteActual.getPeso());
    }

    private Solucion copiarSolucion(List<Camion> camiones,int pesoNoAsignado) {

        return new Solucion(copiarCamiones(camiones),pesoNoAsignado,estadosGenerados);
    }

    private List<Camion> copiarCamiones(List<Camion> originales) {

        List<Camion> copia = new ArrayList<>();

        for (Camion c : originales) {
            copia.add(new Camion(c));
        }

        return copia;
    }
}