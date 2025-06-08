package semana2;

public class ex03_circulo {
    private double raio;

    final static double PI = 3.141592653589793;

    public ex03_circulo(double raio) {
        this.raio = raio;
    }

    public double calcularPerimetro() {
        return 2 * PI * this.raio;
    }

    public static void main(String[] args) {
        ex03_circulo meuCirculo = new ex03_circulo(5);

        double perimetro = meuCirculo.calcularPerimetro();
        System.out.println("O perímetro do círculo é: " + perimetro);
    }
}
