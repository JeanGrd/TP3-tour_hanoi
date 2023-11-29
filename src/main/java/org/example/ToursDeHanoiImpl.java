package org.example;

/**
 * https://www.sanfoundry.com/java-program-implement-solve-tower-of-hanoi-using-stacks/
 */
public class ToursDeHanoiImpl implements ToursDeHanoi{
    private Tours tours;
    private String affichage;

    public ToursDeHanoiImpl(Tours tours) {
        this.tours = tours;
    }

    @Override
    public String resolutionProbleme(int nombreAnneaux) {
        tours.initialiserTours(nombreAnneaux);
        affichage = tours.afficherTours();
        deplacer(nombreAnneaux, 1, 2, 3);
        return affichage;
    }

    private void deplacer(int n, int a, int b, int c) {
        if (n > 0)
        {
            deplacer(n-1, a, c, b);
            tours.deplacerAnneau(a, c);
            affichage += tours.afficherTours();
            deplacer(n-1, b, a, c);
        }
    }
}
