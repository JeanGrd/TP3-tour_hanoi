package org.example;

/**
 * https://www.sanfoundry.com/java-program-implement-solve-tower-of-hanoi-using-stacks/
 */
public class ToursImpl implements Tours {
    private Stack tour1;
    private Stack tour2;
    private Stack tour3;
    private int nombreAnneaux;

    public ToursImpl(Stack tour1, Stack tour2, Stack tour3) {
        this.tour1 = tour1;
        this.tour2 = tour2;
        this.tour3 = tour3;
    }

    @Override
    public void initialiserTours(int nombreAnneaux) {
        this.nombreAnneaux = nombreAnneaux;
        // vidons les tours
        while(!tour1.isEmpty()) {
            tour1.pop();
        }
        while(!tour2.isEmpty()) {
            tour2.pop();
        }
        while(!tour3.isEmpty()) {
            tour3.pop();
        }
        // plaçons les anneaux sur la première tour
        for(int i=nombreAnneaux; i>0; i--) {
            tour1.push(i);
        }
    }

    @Override
    public String afficherTours() {
        StringBuilder str = new StringBuilder("  A  |  B  |  C\n");
        str.append("---------------\n");
        for(int i = nombreAnneaux - 1; i >= 0; i--)
        {
            String d1, d2, d3;
            try
            {
                d1 = String.valueOf(tour1.peek(i));
            }
            catch (Exception e){
                d1 = " ";
            }
            try
            {
                d2 = String.valueOf(tour2.peek(i));
            }
            catch(Exception e){
                d2 = " ";
            }
            try
            {
                d3 = String.valueOf(tour3.peek(i));
            }
            catch (Exception e){
                d3 = " ";
            }
            str.append("  ").append(d1).append("  |  ").append(d2).append("  |  ").append(d3).append('\n');
        }
        str.append('\n');
        return str.toString();
    }

    @Override
    public void deplacerAnneau(int tourDepart, int tourArrivee) throws DeplacementImpossible {
        try {
            int anneauADeplacer;
            // on tente d'enlever un anneau de la tour de départ
            switch(tourDepart) {
                case 1:
                    anneauADeplacer = tour1.pop();
                    break;
                case 2:
                    anneauADeplacer = tour2.pop();
                    break;
                case 3:
                    anneauADeplacer = tour3.pop();
                    break;
                default:
                    throw new DeplacementImpossible();
            }
            // on tente de le mettre sur la tour d'arrivée
            switch(tourArrivee) {
                case 1:
                    tour1.push(anneauADeplacer);
                    break;
                case 2:
                    tour2.push(anneauADeplacer);
                    break;
                case 3:
                    tour3.push(anneauADeplacer);
                    break;
                default:
                    throw new DeplacementImpossible();
            }
        } catch (EmptyStackException e) {
            throw new DeplacementImpossible();
        }
    }
}
