public class Tempo {




    private int hora;
    private int minuto;
    private int segundo;

    // Construtor sem parametros
    public Tempo() {
        this(0, 0, 0);
    }

    // Construtor com hora
    public Tempo(int hora) {
        this(hora, 0, 0);
    }

    // Construtor com hora e minuto
    public Tempo(int hora, int minuto) {
        this(hora, minuto, 0);
    }

    // Construtor completo
    public Tempo(int hora, int minuto, int segundo) {

        this.hora = (hora >= 0 && hora <= 23) ? hora : 0;

        this.minuto = (minuto >= 0 && minuto <= 59) ? minuto : 0;

        this.segundo = (segundo >= 0 && segundo <= 59) ? segundo : 0;
    }
    public Tempo(String texto) {
        if (texto != null && texto.length() == 6) {
            // Corta a string em pedaços de 2 caracteres
            String strH = texto.substring(0, 2); // "01"
            String strM = texto.substring(2, 4); // "30"
            String strS = texto.substring(4, 6); // "05"


            // Converte para inteiro e valida usando os teus métodos set
            this.hora = 0;
            this.minuto = 0;
            this.segundo = 0;


            try {
                setHora(Integer.parseInt(strH));
                setMinuto(Integer.parseInt(strM));
                setSegundo(Integer.parseInt(strS));
            } catch (NumberFormatException e) {
                // Se vierem letras em vez de números, fica a 0
                this.hora = 0;
                this.minuto = 0;
                this.segundo = 0;
            }
        } else {
            this.hora = 0;
            this.minuto = 0;
            this.segundo = 0;
        }
    }

public String Hhmmss() {
        return String.format("%02d:%02d:%02d", this.hora, this.minuto, this.segundo);  }

    // Getters
    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    // Alterar hora
    public boolean setHora(int hora) {

        if (hora < 0 || hora > 23) {
            return false;
        }

        this.hora = hora;
        return true;
    }

    // Alterar minuto
    public boolean setMinuto(int minuto) {

        if (minuto < 0 || minuto > 59) {
            return false;
        }

        this.minuto = minuto;
        return true;
    }

    // Alterar segundo
    public boolean setSegundo(int segundo) {

        if (segundo < 0 || segundo > 59) {
            return false;
        }

        this.segundo = segundo;
        return true;
    }

    // Metodo auxiliar para colocar dois digitos
    private String doisDigitos(int numero) {

        if (numero < 10) {
            return "0" + numero;
        }

        return String.valueOf(numero);
    }

    // Converter para HHMMSS
    public String paraHhmmss() {

        return doisDigitos(hora)
                + doisDigitos(minuto)
                + doisDigitos(segundo);
    }

    // Converter para formato AM/PM
    public String paraAmPm() {

        int h = hora % 12;

        if (h == 0) {
            h = 12;
        }

        String periodo;

        if (hora < 12) {
            periodo = "AM";
        } else {
            periodo = "PM";
        }

        return doisDigitos(h) + ":"
                + doisDigitos(minuto) + ":"
                + doisDigitos(segundo) + " "
                + periodo;
    }

    // Acrescentar um segundo
    public void acrescentarSegundo() {

        segundo++;

        if (segundo > 59) {

            segundo = 0;
            minuto++;

            if (minuto > 59) {

                minuto = 0;
                hora++;

                if (hora > 23) {
                    hora = 0;
                }
            }
        }
    }

    // Converter horario em segundos
    public int emSegundos() {

        return hora * 3600 + minuto * 60 + segundo;
    }

    // Criar um Tempo a partir dos segundos
    public static Tempo deSegundos(int total) {

        total = total % 86400;

        if (total < 0) {
            total += 86400;
        }

        int h = total / 3600;
        int m = (total % 3600) / 60;
        int s = total % 60;

        return new Tempo(h, m, s);
    }

    // Calcular diferenca entre dois tempos
    public Tempo diferenca(Tempo outro) {

        int diferenca = Math.abs(
                this.emSegundos() - outro.emSegundos()
        );

        return Tempo.deSegundos(diferenca);
    }

    // Converter para texto
    @Override
    public String toString() {

        return doisDigitos(hora) + ":"
                + doisDigitos(minuto) + ":"
                + doisDigitos(segundo);
    }

    // Comparar dois tempos
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Tempo outro = (Tempo) obj;

        return hora == outro.hora
                && minuto == outro.minuto
                && segundo == outro.segundo;
    }

    // Calcular hashCode
    @Override
    public int hashCode() {

        return java.util.Objects.hash(hora, minuto, segundo);
    }
}
