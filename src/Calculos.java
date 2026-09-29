/**
 * LABORATORIO: Metodos en Java - Medicion y facturacion de energia electrica.
 *
 * Version A
 */
public class Calculos {

    // ===============================================================
    // CONSTANTES - VERSION A
    // ===============================================================

    public static final double VOLTAJE_MIN = 108;
    public static final double VOLTAJE_MAX = 132;
    public static final double TARIFA_BASE = 0.15;
    public static final double LIMITE_BAJO = 100;
    public static final double LIMITE_MEDIO = 300;


    // ===============================================================
    // NIVEL 1 - Declaracion y retorno
    // ===============================================================

    public static double calcularPotencia(double voltaje, double corriente) {
        return voltaje * corriente;
    }


    public static boolean esVoltajeSeguro(double voltaje) {
        return voltaje >= VOLTAJE_MIN && voltaje <= VOLTAJE_MAX;
    }


    public static void imprimirEncabezado(String cliente) {
        System.out.println("=== FACTURA DE ENERGIA ===");
        System.out.println("Cliente: " + cliente);
    }


    public static String clasificarConsumo(double kwh) {

        if (kwh < LIMITE_BAJO) {
            return "BAJO";
        } else if (kwh < LIMITE_MEDIO) {
            return "MEDIO";
        } else {
            return "ALTO";
        }
    }


    // ===============================================================
    // NIVEL 2 - Paso de parametros y arreglos
    // ===============================================================

    public static double promedio(double[] lecturas) {

        if (lecturas.length == 0) {
            return 0;
        }

        double total = 0;

        for (double lectura : lecturas) {
            total += lectura;
        }

        return total / lecturas.length;
    }


    public static void aplicarFactor(double[] lecturas, double factor) {

        for (int i = 0; i < lecturas.length; i++) {
            lecturas[i] = lecturas[i] * factor;
        }
    }


    public static double[] copiaEscalada(double[] lecturas, double factor) {

        double[] copia = new double[lecturas.length];

        for (int i = 0; i < lecturas.length; i++) {
            copia[i] = lecturas[i] * factor;
        }

        return copia;
    }


    public static int contarSobreUmbral(double[] lecturas, double umbral) {

        int contador = 0;

        for (double lectura : lecturas) {

            if (lectura > umbral) {
                contador++;
            }
        }

        return contador;
    }


    // ===============================================================
    // NIVEL 3 - Sobrecarga
    // ===============================================================

    public static double calcularCosto(double kwh) {
        return kwh * TARIFA_BASE;
    }


    public static double calcularCosto(double kwh, double tarifa) {
        return kwh * tarifa;
    }


    public static double calcularCosto(int dias, double kwhPorDia, double tarifa) {
        return dias * kwhPorDia * tarifa;
    }


    // ===============================================================
    // NIVEL 5 - Varargs y recursion
    // ===============================================================

    public static double resistenciaSerie(double... resistencias) {

        double total = 0;

        for (double resistencia : resistencias) {
            total += resistencia;
        }

        return total;
    }


    public static double resistenciaParalelo(double... resistencias) {

        if (resistencias.length == 0) {
            return 0;
        }

        double sumaInversos = 0;

        for (double resistencia : resistencias) {
            sumaInversos += 1 / resistencia;
        }

        return 1 / sumaInversos;
    }


    public static double sumaRecursiva(double[] datos, int n) {

        if (n <= 0) {
            return 0;
        }

        return datos[n - 1] + sumaRecursiva(datos, n - 1);
    }
}
