public class CalcularRecursivo {
    private static double MONTO_BASE = 55.0;
    private static double MONTO_DEPENDIENTE = 15.0;
    private static double FACTOR_RURAL = 1.15;

    private static double CalcularRecursivo(int dependientes, boolean esRural) {

        if (dependientes < 0) {
            throw new IllegalArgumentException("dependientes no puede ser negativo");
        }

        if (dependientes == 0) {
            return esRural ? MONTO_BASE * FACTOR_RURAL : MONTO_BASE;
        }
        double montoAnterior = CalcularRecursivo(dependientes - 1, esRural);

        double adicional = esRural ? MONTO_DEPENDIENTE * FACTOR_RURAL : MONTO_DEPENDIENTE;

        return montoAnterior + adicional;
    }

    public static void main(String[] args) {
        System.out.println("Caso 1: Zona Urbana: " + CalcularRecursivo(0, false));
        System.out.println("Caso 2: Zona Urbana: " + CalcularRecursivo(3, false));
        System.out.println("Caso 3: Zona Rural: " + CalcularRecursivo(3, true));
    }
}
