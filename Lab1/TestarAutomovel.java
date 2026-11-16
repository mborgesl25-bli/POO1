public class TestarAutomovel {


    public static void main(String[] args) {

        
        Automovel a1 = new Automovel("11-11-AA", "Toyota", 1400);

       
        System.out.println(a1);

        
        System.out.println(a1.getMatricula());

        
        a1.setCilindrada(1800);

       
        System.out.println(a1);

        
        System.out.println(Automovel.getQuantidadeInstancias());

        
        Automovel a2 = new Automovel("22-22-BB", "Audi");

       
        System.out.println(a2);

        
        System.out.println(Automovel.getQuantidadeInstancias());

        
        boolean resultado = a2.setCilindrada(-2000);

        System.out.println("Cilindrada -2000 aceite? " + resultado);

        
        System.out.println(a2);

        
        a2.setCilindrada(2000);

        
        System.out.println(a2);

        
        System.out.println(a1.diferencaCilindrada(a2));
    }
}

    
