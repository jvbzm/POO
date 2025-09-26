import java.util.Scanner;

class Time {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    // construtor que já valida os valores iniciais
    public Time(int hour, int minute, int second){
        this.setHour(hour);
        this.setMinute(minute);
        this.setSecond(second);
    } // todo 

    public void setHour(int hour){
        if(hour < 0 || hour > 23){  // hora válida: 0–23
            System.out.println("fail: hora invalida");
        } else {
            this.hour = hour;
        }
    } // todo 

    public void setMinute(int minute){
        if(minute < 0 || minute > 59){  // minuto válido: 0–59
            System.out.println("fail: minuto invalido");
        } else {
            this.minute = minute;
        }
    } // todo 

    public void setSecond(int second){
        if(second < 0 || second > 59){  // segundo válido: 0–59
            System.out.println("fail: segundo invalido");
        } else {
            this.second = second;
        }
    } // todo 

    public int getHour(){
        return this.hour;
    }// todo 

    public int getMinute(){
        return this.minute;
    } // todo 

    public int getSecond(){
        return this.second;
    } // todo 

    // avança o tempo em um segundo
    public void nextSecond(){
        this.second += 1;
        if(this.second >= 60){
            this.second = 0;
            this.minute += 1;
        }
        if(this.minute >= 60){
            this.minute = 0;
            this.hour += 1;
        }
        if(this.hour > 23){
            this.hour = 0;
        }
        
        // isso tem que ser feito para que quando atinja o limite do horário, 
        // o próximo campo aumente em +1 (respeitando os horários naturais)
    } // todo 

    // retorna a string formatada no estilo 00:00:00
    public String toString() {
        return String.format("%02d", hour) + ":" + 
               String.format("%02d", minute) + ":" + 
               String.format("%02d", second);
    }
}


class Relogio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Time time = new Time(0, 0, 0);
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);

            String[] ui = line.split(" ");
            String cmd = ui[0];

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("set")) {
                time.setHour(Integer.parseInt(ui[1]));
                time.setMinute(Integer.parseInt(ui[2]));
                time.setSecond(Integer.parseInt(ui[3]));
            } else if (cmd.equals("show")) {
                System.out.println(time);
            } else if (cmd.equals("next")) {
                time.nextSecond();
            } else {
                System.out.println("fail: comando inválido");
            }
        }

        scanner.close();
    }
}
