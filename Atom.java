public class Atom {

    //Eigenschaften
    //Phase 1: Zunächst nur 
    // Name, Protonenzahl, Elektronenzahl

    private String name;
    private int protonNumber;
    private int electronCount;

    //Konstruktor
    public Atom(String name, int protonNumber, int electronCount) {
        this.name = name;
        this.protonNumber = protonNumber;
        this.electronCount = electronCount;
    }

    //Methoden
    public double calculateEnergyLevel(int n) {
        //Bohrmodell: E_n = -13.6 eV / n^2, wobei n die Hauptquantenzahl ist
        return -13.6 / (n * n); 
    }

    //Getter
    public String getName() {
        return name;
    }

    public int getProtonNumber() {
        return protonNumber;
    }

    public int getElectronCount() {
        return electronCount;
    }

}