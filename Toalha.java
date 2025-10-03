public class Toalha {
    private String cor;
    private int tamanho;
    private int umidade; 

    public Toalha(String cor, int tamanho) {
        this.cor = cor;
        this.tamanho = tamanho;
        this.umidade = 0;
    }

    public void enxugar(int quantidade) {
        this.umidade += quantidade;
        System.out.println("A toalha absorveu " + quantidade + " de umidade.");
    }

    public void torcer() {
        if (this.umidade > 0) {
            this.umidade /= 2;
            System.out.println("Toalha torcida. Umidade atual: " + this.umidade);
        } else {
            System.out.println("A toalha já está seca.");
        }
    }

    public boolean seca() {
        return this.umidade == 0;
    }

    public void mostrar() {
        System.out.println("Toalha [cor=" + this.cor + ", tamanho=" + this.tamanho + ", umidade=" + this.umidade + "]");
    }
}
