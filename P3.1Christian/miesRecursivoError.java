public class CalcularRecursivo {

    private static double MONTO_BASE = 55.0;
    private static double MONTO_DEPENDIENTE = 15.0;
    private static double FACTOR_RURAL = 1.15;

    private static double CalcularRecursivo_bug(int dependientes, boolean esRural) {

        if (dependientes < -1) {
            return esRural ? MONTO_BASE * FACTOR_RURAL : MONTO_BASE;
        }

        double montoAnterior = CalcularRecursivo_bug(dependientes - 1, esRural);
        double adicional = esRural ? MONTO_DEPENDIENTE * FACTOR_RURAL : MONTO_DEPENDIENTE;

        return montoAnterior + adicional;
    }

    public static void main(String[] args) {

        System.out.println("Provocando StackOverflowError...");
        
        System.out.println(CalcularRecursivo_bug(1, false));
    }
}
