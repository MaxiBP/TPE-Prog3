package TPE;

public class Paquete {

    private int id;
    private String codigo;
    private int peso;
    private boolean contieneAlimentos;
    private int urgencia;
    
    //constructor
    public Paquete(int id, String codigo, int peso, boolean contieneAlimentos, int urgencia) {
        this.id = id;
        this.codigo = codigo;
        this.peso = peso;
        this.contieneAlimentos = contieneAlimentos;
        this.urgencia = urgencia;
    }

    //getters y setters
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    public boolean isContieneAlimentos() {
        return contieneAlimentos;
    }

    public void setContieneAlimentos(boolean contieneAlimentos) {
        this.contieneAlimentos = contieneAlimentos;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }
    
}