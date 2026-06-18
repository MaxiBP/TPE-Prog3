package TPE;

import java.util.List;

public class Solucion {

    private List<Camion> camiones;

    private int pesoNoAsignado;

    private long metrica;

    public Solucion(List<Camion> camiones,int pesoNoAsignado,long metrica) {
        this.camiones = camiones;
        this.pesoNoAsignado = pesoNoAsignado;
        this.metrica = metrica;
    }

    public void setMetrica(long metrica) {
        this.metrica = metrica;
    }
}
