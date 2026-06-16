package TPE;

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
    public Camion(int id, String patente, boolean refrigerado, int capacidadMaxima, int capacidadDisponible,
            List<Paquete> paquetesAsignados) {
        this.id = id;
        this.patente = patente;
        this.refrigerado = refrigerado;
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadDisponible = capacidadDisponible;
        this.paquetesAsignados = paquetesAsignados;
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

    
}