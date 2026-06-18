package TPE;

import java.util.ArrayList;
import java.util.List;

public class Camion {
    private int id;
    private String patente;
    private boolean refrigerado;
    private int capacidadMaxima;

    // para parte 2
    private int capacidadDisponible;
    private List<Paquete> paquetesAsignados;
    
    //constructor
    public Camion(int id, String patente, boolean refrigerado, int capacidadMaxima, int capacidadDisponible, List<Paquete> paquetesAsignados) {
        this.id = id;
        this.patente = patente;
        this.refrigerado = refrigerado;
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadDisponible = capacidadDisponible;
        this.paquetesAsignados = paquetesAsignados;
    }
    public Camion(Camion otro) {
        this.id = otro.id;
        this.patente = otro.patente;
        this.refrigerado = otro.refrigerado;
        this.capacidadMaxima = otro.capacidadMaxima;
        this.capacidadDisponible = otro.capacidadDisponible;
        this.paquetesAsignados =new ArrayList<>(otro.paquetesAsignados);
}
    
    //getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPatente() {
        return patente;
    }
    public void setPatente(String patente) {
        this.patente = patente;
    }
    public boolean isRefrigerado() {
        return refrigerado;
    }
    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    public int getCapacidadDisponible() {
        return capacidadDisponible;
    }
    public void setCapacidadDisponible(int capacidadDisponible) {
        this.capacidadDisponible = capacidadDisponible;
    }
    public List<Paquete> getPaquetesAsignados() {
        return paquetesAsignados;
    }
    public void setPaquetesAsignados(List<Paquete> paquetesAsignados) {
        this.paquetesAsignados = paquetesAsignados;
    }

    public boolean puedeTransportar(Paquete p) {

        if (capacidadDisponible < p.getPeso())
            return false;

        if (p.isContieneAlimentos() && !refrigerado)
            return false;

        return true;
    }

    public void asignarPaquete(Paquete p) {

        paquetesAsignados.add(p);

        capacidadDisponible -= p.getPeso();
    }

    public void quitarPaquete(Paquete p) {

        paquetesAsignados.remove(p);

        capacidadDisponible += p.getPeso();
    }

}