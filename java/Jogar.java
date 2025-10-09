import java.util.Scanner;
import java.util.Locale;

class Jogo {

    private int numJogadores;
    private int[] armadilha;
    private int[] posicao;
    private boolean[] podeJogar;
    private int numArmadilha = 0;
    private int numCasas;
    private int prox;
    private boolean fimDoJogo = false;

    public Jogo(int numJogadores, int numCasas) {
        this.numJogadores = numJogadores;
        this.numCasas = numCasas;
        this.posicao = new int[numJogadores + 1];
        this.podeJogar = new boolean[numJogadores + 1];
        this.armadilha = new int[3]; 
        this.prox = 1;

        for (int i = 1; i <= numJogadores; i++) {
            posicao[i] = 0;
            podeJogar[i] = true;
        }
    }

    public void addArmadilha(int t) {
        if (numArmadilha < 3) {
            armadilha[numArmadilha] = t;
            numArmadilha++;
        }
    }

    public void addMove(int d1, int d2) {
        // lógica ainda será implementada depois
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numJogadores; i++) {
            sb.append("PosJogador[").append(i).append("] = ").append(posicao[i]);
            if (i < numJogadores)
                sb.append("\n");
        }
        return sb.toString();
    }
}

public class Jogar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        Jogo jogo = new Jogo(0, 0);

        while (true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if (ui[0].equals("init")) {
                jogo = new Jogo(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            } else if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("addArmadilha")) {
                jogo.addArmadilha(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("addMove")) {
                int d1 = Integer.parseInt(ui[1]);
                int d2 = Integer.parseInt(ui[2]);
                jogo.addMove(d1, d2);
            } else if (ui[0].equals("show")) {
                System.out.println(jogo);
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
