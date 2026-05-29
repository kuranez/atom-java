# Schalenmodell - Architektur in Java

```yaml
Main
│
├── Atom (Atom.java)
│     ├── - name: String
│     ├── - protonNumber: int
│     ├── - electronCount: int
│     ├── - shells: ArrayList<Shell>
│     ├── + getConfiguration()            # verteilt Elektronen auf Schalen
│     ├── + getConfigurationText()        # gibt Konfiguration als mehrzeiligen String zurück
│     ├── + printConfiguration()          # Console-Ausgabe der Konfiguration
│     └── + calculateEnergyLevel(Z,n)     # Berechnung E_n = -13.6 * Z^2 / n^2
│
├── Shell (Shell.java)
│     ├── - n: int
│     ├── - maxElectrons: int
│     ├── - currentElectrons: int
│     ├── + addElectron()                 # erhöht currentElectrons bis max
│     ├── + getN()
│     ├── + getCurrentElectrons()
│     └── + getMaxElectrons()
│
└── AtomPanelRenderer (AtomPanelRenderer.java)
	├── + paintComponent()
	├── + drawAtom()
	├── + drawNucleus()
	├── + drawShells()
	├── + drawShell()
	├── + drawElectrons()
	├── + drawElectron()
	├── + drawAtomTitle()
	├── + drawConfigurationText()
	└── + drawEnergyText()

Optional:
	- Main.java: erstellt ein Atom-Objekt, ruft getConfiguration() auf und öffnet ein JFrame mit new AtomPanelRenderer(atom)
```

## Mermaid-Diagramm

```mermaid
classDiagram
		class Main {
			+ static void main(String[] args)
		}

		class Atom {
			- String name
			- int protonNumber
			- int electronCount
			- ArrayList~Shell~ shells
			+ getConfiguration()
			+ getConfigurationText()
			+ printConfiguration()
			+ calculateEnergyLevel(int Z, int n)
		}

		class Shell {
			- int n
			- int maxElectrons
			- int currentElectrons
			+ addElectron()
			+ getN()
			+ getCurrentElectrons()
			+ getMaxElectrons()
		}

		class AtomPanelRenderer {
			+ paintComponent(Graphics)
			+ drawAtom(Graphics2D)
			+ drawNucleus(Graphics2D)
			+ drawShells(Graphics2D)
			+ drawShell(Graphics2D, Shell, int)
			+ drawElectrons(Graphics2D, Shell, int)
			+ drawElectron(Graphics2D, int, int)
			+ drawAtomTitle(Graphics2D)
			+ drawConfigurationText(Graphics2D)
			+ drawEnergyText(Graphics2D)
		}

		Main --> Atom : creates
		Main --> AtomPanelRenderer : shows
		Atom o-- "0..*" Shell : shells
		AtomPanelRenderer ..> Atom : reads
		AtomPanelRenderer ..> Shell : draws
```

---

**Author** : kuranez