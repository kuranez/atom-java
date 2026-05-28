public class Main {
    public static void main(String[] args) {
        
        // System.out.println("Test!");

        Atom hydrogen = new Atom(
            "Wasserstoff", 
            1, 
            1
        );

        double energy = 
            hydrogen.calculateEnergyLevel(1);

        System.out.println(
            hydrogen.getName()
            + " : Energie in der ersten Schale : " + energy + " eV"
            );

    }

}