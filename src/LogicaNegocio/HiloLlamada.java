package LogicaNegocio;

public class HiloLlamada implements Runnable {

    private Thread miLlamada;
    private String placa;
    private String modelo;
    private String marca;
    private boolean colision;
    private boolean fallaDesconocida;
    private boolean faltaCombustible;
    private String descripcion;
    private String motot;
    private String cliente;
    private String tipoVehiculo;
    private boolean requiereRepuesto;
    private float distancia;
    private float tiempoLlegada;
    private float tiempoAtencion;
    private String[][] mecanicos;
    private int idLlamada;

    public HiloLlamada(int contLlamadas) {
        miLlamada = new Thread(this);
        miLlamada.run();
        mecanicos = new String[50][2];
        llenarMecanicos();
        idLlamada=contLlamadas;
    }

    public HiloLlamada(Thread miLlamada, String placa, String modelo, String marca, boolean colision, boolean fallaDesconocida, boolean faltaCombustible, String descripcion, String motot, String cliente, String tipoVehiculo, boolean requiereRepuesto, float distancia, float tiempoLlegada, float tiempoAtencion) {
        this.miLlamada = miLlamada;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.colision = colision;
        this.fallaDesconocida = fallaDesconocida;
        this.faltaCombustible = faltaCombustible;
        this.descripcion = descripcion;
        this.motot = motot;
        this.cliente = cliente;
        this.tipoVehiculo = tipoVehiculo;
        this.requiereRepuesto = requiereRepuesto;
        this.distancia = distancia;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoAtencion = tiempoAtencion;
        this.mecanicos = mecanicos = new String[50][2];
        llenarMecanicos();
    }

    @Override
    public void run() {
        while (this.miLlamada.isAlive()) {
            System.out.println("Llamada # : " + idLlamada);
        }
    }

    public String buscarMecanico(String tipoMotor) {
        String aux1, aux2, mecanico="";
        boolean encontrado= false;
        for (int i = 0; i < this.getMecanicos().length; i++) {
            aux1 = this.getMecanicos()[i][0];
            aux2 = this.getMecanicos()[i][1];
            if (aux1.equalsIgnoreCase(tipoMotor) && aux2.equalsIgnoreCase("Disponible")) {
                mecanico = "Si hay mecánico : " + i; 
                encontrado=true;
            }
        }if (!encontrado) {
            mecanico= "No hay mecánico disponible "+ "-1";
        }
        return mecanico;
    }
    
    public void llenarMecanicos(){
        String aux1="Gasolina/Diesel",aux2="Electronico",aux3="Alta Gama";
        String[][] mecaTemp= new String[this.getMecanicos().length][2];
        for (int i = 0; i < this.getMecanicos().length; i++) {
            if (i<17) {
                mecaTemp[i][0]=aux1;                
            }else if (i>=17&&i<34) {
                mecaTemp[i][0]=aux2;
            }else if (i>=34) {
                mecaTemp[i][0]=aux3;
            }
            mecaTemp[i][1]="Disponible";
        }
        this.setMecanicos(mecaTemp);
    }
    
    public String[][] getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(String[][] mecanicos) {
        this.mecanicos = mecanicos;
    }

    public Thread getMiLlamada() {
        return miLlamada;
    }

    public void setMiLlamada(Thread miLlamada) {
        this.miLlamada = miLlamada;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isColision() {
        return colision;
    }

    public void setColision(boolean colision) {
        this.colision = colision;
    }

    public boolean isFallaDesconocida() {
        return fallaDesconocida;
    }

    public void setFallaDesconocida(boolean fallaDesconocida) {
        this.fallaDesconocida = fallaDesconocida;
    }

    public boolean isFaltaCombustible() {
        return faltaCombustible;
    }

    public void setFaltaCombustible(boolean faltaCombustible) {
        this.faltaCombustible = faltaCombustible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMotot() {
        return motot;
    }

    public void setMotot(String motot) {
        this.motot = motot;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public boolean isRequiereRepuesto() {
        return requiereRepuesto;
    }

    public void setRequiereRepuesto(boolean requiereRepuesto) {
        this.requiereRepuesto = requiereRepuesto;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public float getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(float tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public float getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(float tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }
}
