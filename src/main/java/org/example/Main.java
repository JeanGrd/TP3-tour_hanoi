package org.example;

public class Main {
    public static void main(String[] args) {
        Stack pile1 = new SimpleStack();
        Stack pile2 = new SimpleStack();
        Stack pile3 = new SimpleStack();
        Tours tours = new ToursImpl(pile1, pile2, pile3);
        ToursDeHanoi toursDeHanoi = new ToursDeHanoiImpl(tours);
        System.out.println(toursDeHanoi.resolutionProbleme(3));
    }
}
