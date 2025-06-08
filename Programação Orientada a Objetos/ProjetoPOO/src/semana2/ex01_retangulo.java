package semana2;

public class ex01_retangulo {
    float altura;
    float largura;

    public ex01_retangulo(float alt, float larg) {
        altura = alt;
        largura = larg;
    }
    float calcularPerimetro() {
        float pm;
        pm = 2 * altura + 2 * largura;
        return pm;
    }
    void imprimirDados() {
        float p;
        p = calcularPerimetro();
        System.out.println("Retângulo: ");
        System.out.println("- altura:    " + altura);
        System.out.println("- largura:   " + largura);
        System.out.println("- perimetro: " + p);
    }
    public static void main(String[] args) {
        System.out.println("Mundo dos retângulos");

        ex01_retangulo retg1;
        retg1 = new ex01_retangulo(10, 20);
        retg1.imprimirDados();

        ex01_retangulo retg2;
        retg2 = new ex01_retangulo(5, 15);
        retg2.imprimirDados();
    }
}