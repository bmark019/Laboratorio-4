public class Medidor {

    private String id;
    private double lecturaAnterior;
    private double lecturaActual;

    public Medidor(String id, double lecturaInicial) {
        if (lecturaInicial < 0) {
            throw new IllegalArgumentException("La lectura inicial no puede ser negativa");
        }

        this.id = id;
        this.lecturaAnterior = lecturaInicial;
        this.lecturaActual = lecturaInicial;
    }

    public Medidor(String id) {
        this(id, 0);
    }

    public String getId() {
        return id;
    }

    public double getLecturaActual() {
        return lecturaActual;
    }

    public boolean registrarLectura(double nuevaLectura) {
        if (nuevaLectura < lecturaActual) {
            return false;
        }

        lecturaAnterior = lecturaActual;
        lecturaActual = nuevaLectura;

        return true;
    }

    public double consumoKwh() {
        return lecturaActual - lecturaAnterior;
    }

    public double calcularFactura() {
        return Calculos.calcularCosto(consumoKwh());
    }
}
