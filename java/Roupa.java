import java.util.Scanner;

public class Roupa {
    private String tamanho;


    public Roupa() {
        this.tamanho = ""; 
    }


    public boolean setTamanho(String tamanho) {
    switch (tamanho.toUpperCase()) {
        case "PP":
        case "P":
        case "M":
        case "G":
        case "GG":
        case "XG":
            this.tamanho = tamanho.toUpperCase();
            return true;
        default:
            System.out.println("Valor inválido! Tamanhos permitidos: PP, P, M, G, GG, XG.");
            return false;
        }
    }


    public String getTamanho() {
        return this.tamanho;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Roupa r = new Roupa();

        while (true) {
            System.out.print("Informe o tamanho da roupa (PP, P, M, G, GG, XG): ");
            String entrada = sc.nextLine();

            if (r.setTamanho(entrada)) {
                break;
            }
        }

        System.out.println("Tamanho escolhido: " + r.getTamanho());
        sc.close();
    }
}
