# Schalenmodell - Implementierung in Java - Theorie

## Welche Eigenschaften hat das Atom?

**Phase 1** zunächst nur:

 - Name
 - Protonenzahl
 - Elektronenzahl

## Was will ich im 1. Schritt berechnen?

**Energieniveaus!**

Mit Hilfe folgender Formel (Bohrmodell):

$E_n = -\frac{13.6\,\mathrm{eV}}{n^2}$

In Code sieht das wie folgt aus:

```
-13.6 / (n * n)
```

## Erweiterung auf andere Atome

Skalierung mit $Z^2$ für wasserstoffähnliche Kerne.

```
-13.6 (Z * Z) / (n * n)
```

-13.6 : Grundenergie von Wasserstoff
Z : Atomzahl
n : Anzahl von Elektronen
