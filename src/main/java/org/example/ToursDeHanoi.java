package org.example;

/**
 * Interface pour résoudre le problème des tours de Hanoï
 */
public interface ToursDeHanoi {
    /**
     * Résolution du problème
     * @param nombreAnneaux le nombre d'anneaux sur la tour 1 au début
     * @return chaine permettant d'afficher les étapes
     */
    String resolutionProbleme(int nombreAnneaux);
}
