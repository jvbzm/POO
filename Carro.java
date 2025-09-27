public class Carro {
    private String modelo;
    private int ano;
    private float velocidade;

    
    public Carro(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
        this.velocidade = 0; 
    }

    public String getModelo(){return this.modelo;}
    public int getAno(){return this.ano;}
    public float getVelocidade(){return this.velocidade;}

    public void acelerar(float km){
        if(km > 0){
            this.velocidade += km;
            if(this.velocidade > 200){
                System.out.println("Velocidade maxima alcançada, fusca esta morrendo");
            } else {
                System.out.println("Acelerou "+ km + "KM/H");
            }

        }


    }

    public void frear(float freando) {
        if (freando > 0) {
            this.velocidade -= freando;
            if (this.velocidade < 0) {
                this.velocidade = 0;
                System.out.println("O Fusca parou.");
            } else {
                System.out.println("Freou -" + freando + " KM/h");
            }
        }
    }
    
    public void mostrarInfo(){
        System.out.println("Modelo "+ this.modelo);
        System.out.println("Ano "+this.ano);
        System.out.println("Velocidade atual eh "+this.velocidade+"KM/h");

    }



    public static void main(String[] args) {
        Carro fusca = new Carro("Fusca", 1976);

        fusca.mostrarInfo();
        fusca.acelerar(50);
        fusca.mostrarInfo();
        fusca.acelerar(100);
        fusca.mostrarInfo();
        fusca.frear(30);
        fusca.mostrarInfo();
        fusca.frear(300);
        fusca.mostrarInfo();
    }
}