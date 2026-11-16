
public class Automovel {

    
    public static final int CILINDRADA_POR_OMISSAO = 1000;

    
    private String matricula;
    private String marca;
    private int cilindrada;

    
    private static int quantidadeInstancias = 0;

    public Automovel(String matricula, String marca, int cilindrada) {

        this.matricula = matricula;
        this.marca = marca;

        if (cilindrada > 0) {
            this.cilindrada = cilindrada;
        } else {
            this.cilindrada = CILINDRADA_POR_OMISSAO;
        }

        quantidadeInstancias++;
    }

    
    public Automovel(String matricula, String marca) {
        this(matricula, marca, CILINDRADA_POR_OMISSAO);
    }

    
    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    
    public boolean setMatricula(String matricula) {

        if (matricula == null || matricula.isEmpty()) {
            return false;
        }

        this.matricula = matricula;
        return true;
    }

    
    public boolean setMarca(String marca) {

        if (marca == null || marca.isEmpty()) {
            return false;
        }

        this.marca = marca;
        return true;
    }

    
    public boolean setCilindrada(int cilindrada) {

        if (cilindrada <= 0) {
            return false;
        }

        this.cilindrada = cilindrada;
        return true;
    }

   
    public String toString() {

        return "O automóvel com matrícula " + matricula
                + " é um " + marca
                + " e tem cilindrada de " + cilindrada + " cc.";
    }

    // Diferenca entre cilindradas
    public int diferencaCilindrada(Automovel outro) {

        return Math.abs(this.cilindrada - outro.cilindrada);
    }

    // Verifica se a cilindrada e superior
    public boolean temCilindradaSuperior(Automovel outro) {

        return this.cilindrada > outro.cilindrada;
    }

    // Contador de instancias
    public static int getQuantidadeInstancias() {

        return quantidadeInstancias;
    }

    
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Automovel outro = (Automovel) obj;

        return matricula != null && matricula.equals(outro.matricula);
    }

    
    public int hashCode() {

        return java.util.Objects.hash(matricula);
    }
}
