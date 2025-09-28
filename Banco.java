public class Banco {
    
    private int numConta;
    private String titular;
    private float saldo;

    public Banco(int numConta, String DonoConta, float saldoInicial){
        this.numConta = numConta;
        this.titular = DonoConta;
        this.saldo = saldoInicial;
    }

    public void depositar(float valor){
        if(valor > 0){
            saldo+=valor;
            System.out.println("O deposito de "+ valor + " foi efetuado");
        }
        else{
            System.out.println("Valor invalido");
        }

    }

    public void sacar(float valor){
        if(valor > 0 && valor <=saldo){
            saldo-=valor;
            System.out.println("Saque de "+ valor +" efetuado");
        }
        else{
            System.out.println("Valor invalido");
        }

    }

    public void mostrarDados(){
        System.out.println("Conta: "+ numConta);
        System.out.println("Titular da conta: "+ titular);
        System.out.println("Saldo: "+ saldo);
    
    }

    public static void main(String[] args){
        Banco c1 = new Banco(871, "Bruno", 78692.00f);
        Banco c2 = new Banco(7244, "Janaina", 8900.00f);
        

        c1.depositar(200);
        c1.sacar(970);
        c1.mostrarDados();


        c2.depositar(1200);
        c2.sacar(700);
        c2.mostrarDados();
    }

}
