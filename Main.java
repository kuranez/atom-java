import java.text.DecimalFormat;


public class Main {
    public static void main(String[] args) {
        
        // System.out.println("Test!");
        
        // Dezimalstellen anzeigen: 2
        DecimalFormat df =
            new DecimalFormat("#.##");

        // Erstellen von Atom-Objekten
        // Wasserstoffähnliche Kerne: Z = 1, 2, 8, ...

        Atom hydrogen = new Atom(
            "Wasserstoff (H)", 
            1, 
            1 
        );

        Atom helium = new Atom(
            "Helium (He+)", 
            2, 
            2 
        );

        Atom lithium = new Atom(
            "Lithium (Li2+)", 
            3, 
            3 
        );

        Atom beryllium = new Atom(
            "Beryllium (Be3+)", 
            4, 
            4 
        );

        Atom oxygen = new Atom(
            "Sauerstoff (O7+)", 
            8, 
            8 
            // maximale Elektronenzahl kann hier eingetragen werden, 
            // aber für die Energie-Berechnung im Bohrmodell ist sie nicht relevant
        );

        // Ausgabe der Atom-Informationen
        // Berechnung der Energie für die erste Schale (n = 1) und Ausgabe der Ergebnisse
        double energy = 
            hydrogen.calculateEnergyLevel(1, 1);

        System.out.println(
            hydrogen.getName()
            + " : Energie in der ersten Schale : " + df.format(energy) + " eV"
            );

        double heliumEnergy = 
        // Berechnung der Energie für Helium in der ersten Schale
        // Helium hat 2 Protonen, daher Z = 2
        // Hauptquantenzahl n = 1 für die erste Schale
            helium.calculateEnergyLevel(2, 1);

        System.out.println(
            helium.getName()
            + " : Energie in der ersten Schale : " + df.format(heliumEnergy) + " eV"
            );
        
        double lithiumEnergy = 
            lithium.calculateEnergyLevel(3, 1);
        
        System.out.println(
            lithium.getName()
            + " : Energie in der ersten Schale : " + df.format(lithiumEnergy) + " eV"
            );
        
        double berylliumEnergy = 
            beryllium.calculateEnergyLevel(4, 1);
        
        System.out.println(
            beryllium.getName()
            + " : Energie in der ersten Schale : " + df.format(berylliumEnergy) + " eV"
            );

        double oxygenEnergy = 
            oxygen.calculateEnergyLevel(8, 1);

        System.out.println(
            oxygen.getName()
            + " : Energie in der ersten Schale : " + df.format(oxygenEnergy) + " eV"
            );
    }

}