package TPE;

import java.util.*;

public class Backtracking {

    private Solucion mejorSolucion;
    private int mejorPesoNoAsignado;
    private long estadosGenerados;
    private boolean poda;

    public Solucion asignar(List<Camion> camiones,List<Paquete> paquetes, boolean ordenar, boolean podar) {

        // el atributo poda sirve para activar o desactivar la poda, para comparar eficiencias de distintas estrategias
        this.poda = podar;

        // será el peso minimo de los paquetes que no se asignan (condición del ejercicio)
        this.mejorPesoNoAsignado = Integer.MAX_VALUE;

        // representa la cantidad de decisiones tomadas (ramas recorridas)
        this.estadosGenerados = 0;

        this.mejorSolucion = null;

        // ordenar sirve para activar y desactivar el ordenamiento, para comparar las eficiencias
        if(ordenar){
            // ordenar los paquetes por el peso es una decisión que se toma pensando en la poda, para que cortar las ramas antes
            paquetes.sort((a,b) ->Integer.compare(b.getPeso(),a.getPeso()));
        }

        HashMap<Camion,List<Paquete>> asignacionActual = new HashMap<>();

        for(Camion c : camiones) {
            asignacionActual.put(c,new ArrayList<>());
        }

        // llamamos a backtracking con indice = 0 ==> primer paquete
        backtracking(0,paquetes,camiones,asignacionActual,0);

        return mejorSolucion;
    }

    private void backtracking(int indice,List<Paquete> paquetes,List<Camion> camiones,HashMap<Camion,List<Paquete>> asignacionActual,int pesoNoAsignadoActual) {

        // cada llamada recursiva suma a estadosGenerados (recorremos otro camino del arbol)
        estadosGenerados++;

        // si todos los paquetes fueron tenidos en cuenta (no necesariamente asignados)
        if(indice == paquetes.size()) {

            // si el peso de los paquetes que no fueron asignados hasta ahora es menor al menor histórico
            if (pesoNoAsignadoActual < mejorPesoNoAsignado) {
                mejorPesoNoAsignado = pesoNoAsignadoActual;
                mejorSolucion = new Solucion(copiarAsignacion(asignacionActual),pesoNoAsignadoActual,estadosGenerados);
            }

        }else{

            //          si el peso de los paquetes que no fueron asignados hasta ahora es mayor al menor histórico no es necesario seguir recorriendo, poda
            if( !poda || (pesoNoAsignadoActual < mejorPesoNoAsignado)){

                Paquete paqueteActual =paquetes.get(indice);
        
                // intento asignar el paquete en todos los camiones
                for(Camion camion : camiones) {
        
                    if(camion.puedeTransportar(paqueteActual)) {
        
                        //lo asigno al camion
                        camion.asignarPaquete(paqueteActual);
                        asignacionActual.get(camion).add(paqueteActual);
        
                        // siguiente paquete                                 como el paquete fue agregado, el peso no asignado se mantiene
                        backtracking(indice + 1,paquetes,camiones,asignacionActual,pesoNoAsignadoActual);
        
                        // lo saco del camion
                        List<Paquete> camionList = asignacionActual.get(camion);
                        camionList.remove(camionList.size() - 1);
                        camion.quitarPaquete(paqueteActual);
                    }
                }
        
                // siguiente paquete sin haberlo agregado                  como el paquete no fue agregado se suma al peso no asignado
                backtracking(indice + 1,paquetes,camiones,asignacionActual,pesoNoAsignadoActual + paqueteActual.getPeso());
            }
        }

    }

    private HashMap<Camion,List<Paquete>> copiarAsignacion(HashMap<Camion,List<Paquete>>original) {

        HashMap<Camion,List<Paquete>> copia =new HashMap<>();

        for(Camion camion :original.keySet()) {

            copia.put(camion,new ArrayList<>( original.get(camion) ));
        }

        return copia;
    }
}