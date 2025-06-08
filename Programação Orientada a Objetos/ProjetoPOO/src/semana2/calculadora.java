package semana2;

public class calculadora {
    public static double sqrt(double valor) {
        return Math.sqrt(valor);
    }

    public static double log(double valor) {
        return Math.log(valor);
    }

    public static void main(String[] args) {
        int x = 25;
        int y = 100;

        double raiz = calculadora.sqrt(x);
        double logaritmo = calculadora.log(y);

        System.out.printf("Raiz quadrada de %d: %f \n", x, raiz);
        System.out.printf("Logaritmo de %d: %f \n", y, logaritmo);
    }
}
