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
    int x = 0;

    public HiloLlamada() {
        miLlamada = new Thread(this);
        miLlamada.run();
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
    }

    @Override
    public void run() {
        while(this.miLlamada.isAlive()){
            System.out.println("hola " + x);
            x++;
        }
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
