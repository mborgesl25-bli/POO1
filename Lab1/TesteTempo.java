public class TesteTempo {

    public static void main(String[] args) {

        
        Tempo t1 = new Tempo(25, 70, 80);

        System.out.println("Hora: " + t1);

        
        System.out.println("Alterar hora para 10: "
                + t1.setHora(10));

        System.out.println("Alterar minuto para 30: "
                + t1.setMinuto(30));

        System.out.println("Alterar segundo para 65: "
                + t1.setSegundo(65));

        System.out.println("Tempo atual: " + t1);

        // b) Converter para HHMMSS
        Tempo t2 = new Tempo("013005");

        System.out.println("HHMMSS: " + t2.Hhmmss());

        // c) Converter para AM/PM
        System.out.println("AM/PM: " + t2.paraAmPm());

        Tempo t3 = new Tempo(13, 5, 0);

        System.out.println("AM/PM: " + t3.paraAmPm());

        // d) Acrescentar um segundo
        Tempo t4 = new Tempo(10, 59, 59);

        System.out.println("Antes: " + t4);

        t4.acrescentarSegundo();

        System.out.println("Depois: " + t4);

        // Testar passagem da meia-noite
        Tempo t5 = new Tempo(23, 59, 59);

        t5.acrescentarSegundo();

        System.out.println("Meia-noite: " + t5);

        // e) Calcular diferenca
        Tempo t6 = new Tempo(9, 30, 5);

        Tempo t7 = new Tempo(7, 45, 50);

        Tempo resultado = t6.diferenca(t7);

        System.out.println("Diferenca: " + resultado);

        // Converter para segundos
        System.out.println("Segundos: " + t6.emSegundos());

    }
}

    
