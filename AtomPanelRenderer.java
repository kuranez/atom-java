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
    private final Atom atom;

    // Layout Konstanten
    private static final int CENTER_X = 400;
    private static final int CENTER_Y = 400;

    // Atom- und Shell-Darstellung Konstanten
    private static final int NUCLEUS_SIZE = 20;
    private static final int SHELL_SPACING = 60;
    private static final int FIRST_SHELL_RADIUS = 60;

    // Allgemeiner Konstruktor 
    public AtomPanelRenderer(Atom atom) {
        this.atom = atom;
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        drawAtom(g2);
    }

    // =========================================
    // MAIN DRAW METHOD
    // =========================================

    private void drawAtom(Graphics2D g2) {

        drawAtomTitle(g2);

        drawConfigurationText(g2);

        drawEnergyText(g2);

        drawNucleus(g2);

        drawShells(g2);
    }

    // =========================================
    // TEXT RENDERING
    // =========================================

    private void drawAtomTitle(Graphics2D g2) {

        g2.setColor(Color.WHITE);
        g2.setFont(TITLE_FONT);

        g2.drawString(
            atom.getName(),
            CENTER_X - 350,
            CENTER_Y - 350
        );
    }

    private void drawConfigurationText(Graphics2D g2) {

        String[] lines =
            atom.getConfigurationText()
                .split(System.lineSeparator());

        int y = CENTER_Y - 320;

        for (String line : lines) {

            g2.drawString(line, CENTER_X - 350, y);

            y += g2.getFontMetrics().getHeight();
        }
    }

    private void drawEnergyText(Graphics2D g2) {

        String energyText = String.format(
            Locale.GERMAN,
            "Energie n=1: %.1f eV",
            atom.calculateEnergyLevel(
                atom.getProtonNumber(),
                1
            )
        );

        int width =
            g2.getFontMetrics()
                .stringWidth(energyText);

        int x = getWidth() - width - 40;
        int y = getHeight() - 40;

        g2.drawString(energyText, x, y);
    }

    // =========================================
    // ATOM DRAWING
    // =========================================

    // Step 1: Kern zeichnen
    private void drawNucleus(Graphics2D g2) {

        g2.setColor(Color.WHITE);

        g2.fillOval(
            CENTER_X - NUCLEUS_SIZE / 2,
            CENTER_Y - NUCLEUS_SIZE / 2,
            NUCLEUS_SIZE,
            NUCLEUS_SIZE
        );
    }

    // Step 2: Alle Shells zeichnen
    private void drawShells(Graphics2D g2) {

        int radius = FIRST_SHELL_RADIUS;

        for (Shell shell : atom.getShells()) {

            if (shell.getCurrentElectrons() > 0) {

                drawShell(g2, shell, radius);

                radius += SHELL_SPACING;
            }
        }
    }

    // Step 3: Einzelne Shell zeichnen
    private void drawShell(
        Graphics2D g2,
        Shell shell,
        int radius
    ) {

        g2.setColor(Color.WHITE);

        g2.drawOval(
            CENTER_X - radius,
            CENTER_Y - radius,
            radius * 2,
            radius * 2
        );

        drawElectrons(g2, shell, radius);
    }

    // Step 4: Elektronen zeichnen
    private void drawElectrons(
        Graphics2D g2,
        Shell shell,
        int radius
    ) {

        int electronCount =
            shell.getCurrentElectrons();

        for (int i = 0; i < electronCount; i++) {

            double angle =
                2 * Math.PI * i / electronCount;

            int x =
                CENTER_X +
                (int)(radius * Math.cos(angle));

            int y =
                CENTER_Y +
                (int)(radius * Math.sin(angle));

            drawElectron(g2, x, y);
        }
    }

    // Step 5: Einzelnes Elektron zeichnen
    private void drawElectron(
        Graphics2D g2,
        int x,
        int y
    ) {

        g2.setColor(Color.RED);

        g2.fillOval(
            x - 5,
            y - 5,
            10,
            10
        );
    }
}
