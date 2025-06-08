package semana2;

public class ex02_calculadora {
    public static double sqrt(double valor) {
        return Math.sqrt(valor);
    }

    public static double log(double valor) {
        return Math.log(valor);
    }

    public static void main(String[] args) {
        int x = 25;
        int y = 100;

        double raiz = ex02_calculadora.sqrt(x);
        double logaritmo = ex02_calculadora.log(y);

        System.out.printf("Raiz quadrada de %d: %f \n", x, raiz);
        System.out.printf("Logaritmo de %d: %f \n", y, logaritmo);
    }
}
