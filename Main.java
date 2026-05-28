import java.text.DecimalFormat;


public class Main {
    public static void main(String[] args) {
        
        // System.out.println("Test!");
        
        // Dezimalstellen anzeigen: 2
        DecimalFormat df =
            new DecimalFormat("#.##");

        // Erstellen von Atom-Objekten und Ausgabe ihrer Eigenschaften
        // Energie für Wasserstoffähnliche Kerne: Z = 1, 2, 8, ...
        // Verteilung der Elektronen auf die Schalen und Ausgabe der Elektronenkonfiguration

        // Wasserstoff
        Atom hydrogen = new Atom(
            "Wasserstoff", 
            1, 
            1 
        );

        System.out.println(
            hydrogen.getName() + " (Z = " + hydrogen.getProtonNumber() + ") : "
            );

        System.out.println(
            "Energie in der ersten Schale : " 
            + df.format(hydrogen.calculateEnergyLevel(1, 1)) 
            + " eV" + " (H)"
            );
        
        System.out.println(
            "Verteilung der Elektronen in " + hydrogen.getName() + " : "
            );
        
            hydrogen.distributeElectrons();
            hydrogen.printConfiguration();

        System.out.println();

        // Helium
        Atom helium = new Atom(
            "Helium", 
            2, 
            2 
        );

        System.out.println(
            helium.getName() + " (Z = " + helium.getProtonNumber() + ") : "
            );
        
        System.out.println(
            "Energie in der ersten Schale : " 
            + df.format(helium.calculateEnergyLevel(2, 1)) 
            + " eV" + " (He+)"
            );
        
        System.out.println(
            "Verteilung der Elektronen in " + helium.getName() + " : "
            );
        
            helium.distributeElectrons();
            helium.printConfiguration();

        System.out.println();
        
        // Lithium
        Atom lithium = new Atom(
            "Lithium", 
            3, 
            3 
        );

        System.out.println(
            lithium.getName() + " (Z = " + lithium.getProtonNumber() + ") : "
            );
        
        System.out.println(
            "Energie in der ersten Schale : " 
            + df.format(lithium.calculateEnergyLevel(3, 1)) 
            + " eV" + " (Li2+)"
            );
        
        System.out.println(
            "Verteilung der Elektronen in " + lithium.getName() + " : "
            );
        
            lithium.distributeElectrons();
            lithium.printConfiguration();

        System.out.println();

        // Beryllium
        Atom beryllium = new Atom(
            "Beryllium", 
            4, 
            4 
        );

        System.out.println(
            beryllium.getName() + " (Z = " + beryllium.getProtonNumber() + ") : "
            );
        
        System.out.println(
            "Energie in der ersten Schale : " 
            + df.format(beryllium.calculateEnergyLevel(4, 1)) 
            + " eV" + " (Be3+)"
            );
        
        System.out.println(
            "Verteilung der Elektronen in " + beryllium.getName() + " : "
            );
        
            beryllium.distributeElectrons();
            beryllium.printConfiguration();

        System.out.println();

        // Sauerstoff
        Atom oxygen = new Atom(
            "Sauerstoff", 
            8, 
            8 
        );

        System.out.println(
            oxygen.getName() + " (Z = " + oxygen.getProtonNumber() + ") : "
            );

        System.out.println(
            "Energie in der ersten Schale : " 
            + df.format(oxygen.calculateEnergyLevel(8, 1)) 
            + " eV" + " (O7+)"
            );

        System.out.println(
            "Verteilung der Elektronen in " + oxygen.getName() + " : "
            );
        
            oxygen.distributeElectrons();
            oxygen.printConfiguration();

        System.out.println();
        System.out.println(
        "Hauptquantenzahl n : aktuelle Elektronen / maximale Elektronen"
        );
    }

}