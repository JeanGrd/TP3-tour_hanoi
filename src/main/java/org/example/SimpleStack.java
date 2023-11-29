package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A simple stack based on an ArrayList
 */
public class SimpleStack implements Stack {
    private final List<Integer> liste;

    /**
     * Constructor
     */
    public SimpleStack() {
        liste = new ArrayList<>();
    }

    /**
     * Ajouté pour les mocks
     * @param liste la liste utilisée par la pile
     */
    public SimpleStack(List<Integer> liste) {
        this.liste = liste;
    }

    @Override
    public boolean isEmpty() {
        return liste.isEmpty();
    }

    @Override
    public int getSize() {
        return liste.size();
    }

    @Override
    public void push(int item) {
        // adds at the beginning of the list
        liste.add(0, item);
    }

    @Override
    public int peek() throws EmptyStackException {
        // if the list is empty
        if(liste.isEmpty())
            throw new EmptyStackException(); // throw an exception
        // return the first element of the list
        return liste.get(0);
    }

    @Override
    public int pop() throws EmptyStackException {
        // if the list is empty
        if(liste.isEmpty())
            throw new EmptyStackException(); // throw an exception
        // remove and return the first element of the list
        return liste.remove(0);
    }

    @Override
    public int peek(int index) throws NoSuchElementException {
        // if the list hasn't enought elements
        if(liste.size() < index+1)
            throw new NoSuchElementException(); // throw an exception
        // return the nth element of the list
        return liste.get(liste.size()-index-1);
    }
}
