package TPE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Servicios { 

    private HashMap<String, Paquete> paquetesPorCodigo;
    private List<Paquete> paquetesConAlimentos;
    private List<Paquete> paquetesSinAlimentos;
    private ArrayList<Paquete>[] paquetesPorUrgencia;
    private List<Camion> camiones;



 
    
    // Complejidad temporal O(p + c)
    //siendo p la cantidad de paquetes
    //siendo c la cantidad de camiones
    public Servicios(String pathCamiones, String pathPaquetes) {

        try {

            CSVReader reader = new CSVReader();
            
            //o(p)
            List<Paquete> paquetes = reader.cargarPaquetes(pathPaquetes);
            
            //o(c)
            this.camiones =  reader.cargarCamiones(pathCamiones);
            
            //o(1)
            inicializarEstructuras();
            
            //o(p)
            indexarPaquetes(paquetes);
            
        } catch (IOException e) {
            
            throw new RuntimeException(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void inicializarEstructuras() {
        
        paquetesPorCodigo = new HashMap<>();
        
        paquetesConAlimentos = new ArrayList<>();
        paquetesSinAlimentos = new ArrayList<>();
        
        paquetesPorUrgencia = new ArrayList[101];
        
        for (int i = 0; i <= 100; i++) {
            paquetesPorUrgencia[i] = new ArrayList<>();
        }
    }
    
    private void indexarPaquetes(List<Paquete> paquetes) {
        
        for (Paquete p : paquetes) {
            
            paquetesPorCodigo.put(p.getCodigo(),p);
            
            if (p.isContieneAlimentos()) {
                paquetesConAlimentos.add(p);
            } else {
                paquetesSinAlimentos.add(p);
            }

            paquetesPorUrgencia[ p.getUrgencia()].add(p);
        }
    }
    
    
    
    // Complejidad temporal O(1)
    // el paquete se almacena en un HashMap por código, 
    // acceder al paquete por el código es un o(1)
    public Paquete servicio1(String codigoPaquete) {
        return paquetesPorCodigo.get(codigoPaquete); 
        //HashMap devuelve null si se intenta acceder a una clave no almacenada
    } 
    
    // Complejidad temporal O(1) 
    // En vez de buscar uno por uno en los paquetes almacenados (O(n) siendo n la cant. de paquetes)
    // llevo dos listas que almacenan todos los paquetes que contienen o no alimentos
    // y devuelvo en función del boolean contieneAlimentos
    public List<Paquete> servicio2(boolean contieneAlimentos) {
        if (contieneAlimentos){
            return this.paquetesConAlimentos;
        }
        return this.paquetesSinAlimentos;
    } 
    
    
    // complejidad temporal o(k)
    // siendo k la cantidad de paquetes copiados
    // si hubiera estado almacenado en una lista normal sería o(p) siendo p la cantidad de paquetes totales
    // igualmente k puede ser igual a p (k=p) si el rango de urgencia es de 1 a 100 (peor caso)
    // aunque la notación Big O toma el peor escenario, conviene usar el algoritmo que devuelve o(k)
    public List<Paquete> servicio3(int urgenciaMinima, int urgenciaMaxima) {
        List<Paquete> resultado = new ArrayList<>();
        for (int i = urgenciaMinima; i < urgenciaMaxima; i++) {
            resultado.addAll(paquetesPorUrgencia[i]);
        }
        return resultado; 
    } 
    
    public List<Camion> getCamiones() {
        return camiones;
    }
} 