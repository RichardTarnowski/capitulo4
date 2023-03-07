import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Introduce el número para la criba de Erastótenes:");
        Scanner teclado = new Scanner(System.in);
        int numeroIntroducido = teclado.nextInt();
        int[] vector = new int[numeroIntroducido];

        Criba.printVectorInicial(numeroIntroducido,vector);

        vector = Criba.generarPrimos(numeroIntroducido);

        Criba.printVectorDePrimos(numeroIntroducido, vector);
    }




}