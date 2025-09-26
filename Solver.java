import java.util.Scanner;

class Pet{
    private int energyMax, hungryMax, cleanMax;
    private int energy, hungry, clean;
    private int diamonds;
    private int age;
    private boolean alive;

    void setEnergy(int value){
        if(value <= 0){
            this.energy = 0;
            System.out.println("fail: pet morreu de fraqueza");
            this.alive = false;
        }
        else if(value > this.energyMax)
            this.energy = this.energyMax;
        else
            this.energy = value;
    }
    public void setHungry(int value){
        if(value <=0){
            this.hungry=0;
            System.out.println("fail: pet morreu de fome");
            this.alive = false;
        }
        else if(value>this.hungryMax)
            this.hungry = this.hungryMax;
            else
                this.hungry = value;
    }
    void setClean(int value){
        if(value<=0){
            this.clean =0;
                System.out.println("fail: pet morreu de sujeira");
                this.alive=false;
            }
            else if(value >this.cleanMax)
                this.clean = this.cleanMax;
            else
                this.clean = value;
            
        }

    public Pet(int energy, int hungry, int clean) {
        this.energyMax = energy;
        this.hungryMax = hungry;
        this.cleanMax = clean;
        this.energy = energy;
        this.hungry = hungry;
        this.clean = clean;
        this.alive = true;
        this.age = 0;
        this.diamonds = 0;
    }
        
    public String toString(){
        return 
            "E:" + energy + "/" + energyMax +
            ", S:" + hungry + "/" + hungryMax +
            ", L:" + clean + "/" + cleanMax +
            ", D:" + diamonds +
            ", I:" + age;
    }
    
    private boolean testAlive(){
        if(!this.alive){
            System.out.println("fail: pet esta morto");
            return false;
        }
        return true;
    }
    // Invoca o método testAlive para verificar se o pet esta vivo
    // Se estiver vivo, altere os atributos utilizando os métodos set e get
    public void play(){
        if(!testAlive())
            return;
        setEnergy(getEnergy() - 2);
        setHungry(getHungry() - 1);
        setClean(getClean() - 3);
        diamonds += 1;
        age += 1;
    }
    public void shower(){
        if(!testAlive())
        return;
        setEnergy(getEnergy() - 3);
        setHungry(getHungry() - 1);
        setClean(cleanMax);
        age +=2;
        
    }
    public void eat(){
        if(!testAlive())
        return;
        setEnergy(getEnergy() - 1);
        setHungry(getHungry() + 4);
        setClean(getClean() - 2);
        age += 1;
    }
    public void sleep(){
        if(!testAlive())
            return;
        if(getEnergy() > energyMax - 5){
            System.out.println("fail: nao esta com sono");
            return;
        }
        setEnergy(energyMax);
        setHungry(getHungry() - 1);
        age += 5;
    }
    //Métodos GET
    int getClean() { return this.clean; }
    int getHungry() { return this.hungry; }
    int getEnergy() { return this.energy; }
    int getEnergyMax() { return this.energyMax; }
    int getCleanMax() { return this.cleanMax; }
    int getHungryMax() { return this.hungryMax; }
}

    

class Solver{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pet pet = new Pet(0, 0, 0);
        while(true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("show")) {
                System.out.println(pet.toString());
            } else if(ui[0].equals("init")) {
                int energy = Integer.parseInt(ui[1]);
                int hungry = Integer.parseInt(ui[2]);
                int shower = Integer.parseInt(ui[3]);
                pet = new Pet(energy, hungry, shower);
            } else if(ui[0].equals("play")) {
                pet.play();
            } else if(ui[0].equals("eat")) {
                pet.eat();
            } else if(ui[0].equals("clean")) {
                pet.shower();
            } else if(ui[0].equals("sleep")) {
                pet.sleep();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}