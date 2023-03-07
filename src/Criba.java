
/**
 * Clase Criba:
 * Obtiene los números primos entre un número dado haciendo uso de la criba de Erastótenes.
 *
 * @author Ryszard Tarnowski
 */
public class Criba {

    /**
     * Este es el método principal utilizado para obtener los números primos, obtenidos en forma de array de enteros
     * haciendo uso de un entero dado.
     *
     * @param numParaLaCriba Es el entero utilizado como valor máximo para la criba.
     * @return Un array de enteros con los números primos entre el dos y el número entero del parámetro.
     */
    public static int[] generarPrimos(int numParaLaCriba) {

        if (numParaLaCriba >= 2) {
// Declaraciones

            int cantidadDePrimos = 0;
            int tamanoArray = numParaLaCriba + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[tamanoArray];

            inicializarArray(tamanoArray, esPrimo);

            quitarCeroYUno(esPrimo);

            buclesParaLaCriba(tamanoArray, esPrimo);

            cantidadDePrimos = contarCantidadDePrimos(cantidadDePrimos, tamanoArray, esPrimo);

            return rellenarArrayDePrimos(cantidadDePrimos, tamanoArray, esPrimo);

        } else { // numParaLaCriba < 2
            // Vector vacío
            return new int[0];

        }
    }

    /**
     * Inicializa el array de booleanos que determinará si un número es primo o no.
     *
     * @param tamanoArray Valor entero que determinará el tamaño del array.
     * @param esPrimo     Array de booleanos que almacena si un número es primo o no.
     */
    private static void inicializarArray(int tamanoArray, boolean[] esPrimo) {
        int i;
        for (i = 0; i < tamanoArray; i++)
            esPrimo[i] = true;
    }

    /**
     * Método que establece el valor 0 y 1 del array de booleanos a false, ya que no son primos.
     *
     * @param esPrimo Array de booleanos que almacena si un número es primo o no.
     */
    private static void quitarCeroYUno(boolean[] esPrimo) {
        esPrimo[0] = esPrimo[1] = false;
    }

    /**
     * Busca los números primos desde el 2 hasta el número dado por parámetro haciendo uso de la criba de Erastótenes.
     *
     * @param tamanoArray Valor entero, utilizado para determinar la duracion de los bucles de la criba.
     * @param esPrimo     Array de booleanos que almacena si un número es primo o no.
     */
    private static void buclesParaLaCriba(int tamanoArray, boolean[] esPrimo) {

        int i;
        int j;
        for (i = 2; i < Math.sqrt(tamanoArray) + 1; i++) {
            if (esPrimo[i]) {

                for (j = 2 * i; j < tamanoArray; j += i)
                    esPrimo[j] = false;
            }
        }
    }

    /**
     * Cálcula la cantidad de números primos que hay y la devuelve como entero.
     *
     * @param contadorDePrimos La variable integer que almacenará la cantidad de números primos.
     * @param tamanoArray      Tamaño del array donde buscar los números primos.
     * @param esPrimo          Array de booleanos que almacena si un número es primo o no.
     * @return Devuelve la cantidad de números primos que hay como entero.
     */
    private static int contarCantidadDePrimos(int contadorDePrimos, int tamanoArray, boolean[] esPrimo) {
        int i;
        for (i = 0; i < tamanoArray; i++) {
            if (esPrimo[i])
                contadorDePrimos++;
        }
        return contadorDePrimos;
    }

    /**
     * Rellena el array de números primos con los números que son primos.
     *
     * @param contadorDePrimos Cantidad de números primos existentes.
     * @param tamanoArray Integer utilizado para la duración de los bucles internos.
     * @param esPrimo Array con los números que son primos.
     * @return Array con los números que son primos.
     */
    private static int[] rellenarArrayDePrimos(int contadorDePrimos, int tamanoArray, boolean[] esPrimo) {
        int i;
        int j;
        int[] primos = new int[contadorDePrimos];
        for (i = 0, j = 0; i < tamanoArray; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    /**
     * Método que imprime por consola el vector completo del número introducido para la criba.
     * @param numeroIntroducido Valor entero al que realizar la criba.
     * @param vector Array que almacena los números de la criba.
     */
    public static void printVectorInicial(int numeroIntroducido, int[] vector) {
        System.out.println("\nVector inicial hasta :" + numeroIntroducido);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
    }
    /**
     * Método que imprime por consola el vector con los números primos del número introducido tras la criba.
     * @param numeroIntroducido Valor entero al que realizar la criba.
     * @param vector Array que almacena los números de la criba.
     */
    public static void printVectorDePrimos(int numeroIntroducido, int[] vector) {
        System.out.println("\n\nVector de primos hasta:" + numeroIntroducido);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }
}
