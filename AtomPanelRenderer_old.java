// AtomPanel.java
// Klasse zur grafischen Darstellung eines Atoms im Bohr'schen Atommodell

// Importieren der benötigten Klassen für GUI
import javax.swing.JPanel; // Für die Erstellung eines benutzerdefinierten Panels
import java.awt.Graphics; // Für die grafische Darstellung auf dem Panel
import java.awt.Graphics2D; // Für erweiterte grafische Funktionen
import java.awt.Color; // Für die Verwendung von Farben in der Darstellung
import java.awt.Font; // Für die Verwendung von Schriftarten in der Darstellung
import java.util.Locale; // Für die Formatierung von Zahlen in der deutschen Lokalisierung

public class AtomPanelRenderer extends JPanel {

    // Konstante für die Schriftart
    private static final Font TITLE_FONT =
        new Font(Font.MONOSPACED, Font.BOLD, 20);

    // Atom-Objekt, das in diesem Panel dargestellt werden soll
    private Atom atom;

    // Allgemeiner Konstruktor, der ein Atom-Objekt als Parameter erwartet
    public AtomPanelRenderer(Atom atom) {
        this.atom = atom; // Zuweisung des übergebenen Atom-Objekts zur Instanzvariable
        this.setBackground(Color.BLACK); // Hintergrundfarbe des Panels auf Schwarz setzen
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 =
            (Graphics2D) g;

        // Mittelpunkt definieren
        int centerX = 400;
        int centerY = 400;

        // Name des Atoms anzeigen
        g2.setColor(Color.WHITE);
        g2.setFont(TITLE_FONT);
        g2.drawString(
            atom.getName(),
            centerX - 350,
            centerY - 350
            );

        // Elektronenkonfiguration anzeigen
        String[] configurationLines = 
            atom.getConfigurationText().split(System.lineSeparator());
        
            int configurationY = centerY - 320;

        for (String line : configurationLines) {
            g2.drawString(line, centerX - 350, configurationY);
            configurationY += g2.getFontMetrics().getHeight();
        }

        // Energie der ersten Schale unten rechts anzeigen
        String energyText = String.format(
            Locale.GERMAN,
            "Energie n=1: %.1f eV",
            atom.calculateEnergyLevel(atom.getProtonNumber(), 1)
        );

        int energyTextWidth = g2.getFontMetrics().stringWidth(energyText);
        int energyX = getWidth() - energyTextWidth - 40;
        int energyY = getHeight() - 40;

        g2.drawString(energyText, energyX, energyY);

        // Kern zeichnen
        g2.setColor(Color.WHITE);
        g2.fillOval(
            centerX - 10,
            centerY - 10,
            20,
            20
            );

        int radius = 60;

        // Alle Shells zeichnen
        
        for (Shell shell : atom.getShells()) {

            if (shell.getCurrentElectrons()>0) {
                
                g2.setColor(Color.WHITE);

                g2.drawOval(

                    centerX - radius,
                    centerY - radius,

                    radius * 2,
                    radius * 2
                );
            
            // Elektronen in der aktuellen Schale zeichnen
            
            for (int i = 0; i < shell.getCurrentElectrons(); i++) {
                g2.setColor(Color.RED);

                double angle =
                    2 * Math.PI * i / shell.getCurrentElectrons();

                int electronX =
                    centerX + (int)(radius * Math.cos(angle));

                int electronY =
                    centerY + (int)(radius * Math.sin(angle));

                 g2.fillOval(
                    electronX - 5,
                    electronY - 5,
                    10,
                    10
                    );
                }

            // Abstand zum nächsten Shell erhöhen
            radius += 60;
            }

        }
    }

}
