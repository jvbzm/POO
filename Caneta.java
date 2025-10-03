public class Caneta {
    String modelo;
    String cor;
    float ponta;
    int carga;
    boolean tampado;

    void status() {
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Uma caneta " + this.cor);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Carga: " + this.carga + "%");
        System.out.println("Está tampado? " + this.tampado);
    }
    
    void rabiscar() {
        if (this.tampado) {
            System.out.println("Não posso rabiscar, a caneta está tampada!");
        } else {
            System.out.println("A caneta está rabiscando...");
        }
    }

    void tampar() {
        this.tampado = true;
    }

    void destampar() {
        this.tampado = false;
    }

    public static void main(String[] args) {
        Caneta c1 = new Caneta();

        c1.modelo = "BIC Cristal";
        c1.cor = "Azul";
        c1.ponta = 0.7f;
        c1.carga = 80;
        c1.tampar();

        c1.status();
        c1.rabiscar();

        c1.destampar();
        c1.rabiscar();
    }
}
