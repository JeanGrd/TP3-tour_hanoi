package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class StackTestMock {
    // La stack
    Stack stack;

    // La liste qui sera mockée
    // on crée le mock ici à cause du warning
    @SuppressWarnings("unchecked")
    List<Integer> list = (List<Integer>)mock(List.class);

    @BeforeEach
    public void setUp() throws Exception {
        // on l'utilise quand on crée la stack
        stack = new SimpleStack(list);
    }

    @Test
    public void testIsEmpty() {
        // When a freshly stack is created
        // Ici on indique que quand on appellera isEmpty sur la liste mockée ça doit renvoyer true
        when(list.isEmpty()).thenReturn(true);
        // Then... (oracle)
        assertTrue(stack.isEmpty(), "A new stack should be empty");
        // on vérifie que la méthode isEmpty() de la liste a bien été appelée
        verify(list).isEmpty();
    }

    @Test
    public void testPeekOnEmptyStack() {
        // Given an empty stack
        // mocking
        when(list.isEmpty()).thenReturn(true);
        // When we « peek » the stack
        try {
            stack.peek(); // should throws an EmptyStackException.
            // on ne doit pas passer ici
            fail();
        } catch(EmptyStackException e) {
            // on vérifie
            verify(list).isEmpty();
        }
    }
}