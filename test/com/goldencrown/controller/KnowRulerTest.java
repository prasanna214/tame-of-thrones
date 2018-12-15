package com.goldencrown.controller;

import com.goldencrown.controller.actions.KnowRuler;
import com.goldencrown.model.Kingdom;
import com.goldencrown.model.Universe;
import com.goldencrown.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class KnowRulerTest {
    private KnowRuler knowRuler;

    @BeforeEach
    void setUp() {
        knowRuler = new KnowRuler();
    }

    @Test
    void doNothingWhenUniverseIsNull() {
        try {
            IO consoleIO = mock(IO.class);
            knowRuler.execute(null, consoleIO);
        } catch (NullPointerException exception) {
            fail("Exception thrown");
        }
    }

    @Test
    void doNothingWhenIOIsNull() {
        try {
            Universe universe = mock(Universe.class);
            knowRuler.execute(universe, null);
        } catch (NullPointerException exception) {
            fail("Exception thrown");
        }
    }

    @Test
    void doNothingWhenUniverseAndIOAreNull() {
        try {
            knowRuler.execute(null, null);
        } catch (NullPointerException exception) {
            fail("Exception thrown");
        }
    }

    @Test
    void displayNoneWhenUniverseHasNoRuler() {
        Universe universe = mock(Universe.class);
        IO consoleIO = mock(IO.class);

        knowRuler.execute(universe, consoleIO);

        verify(consoleIO).display("Ruler Name : None");
        verify(consoleIO).display("Allies of Ruler : None");
    }

    @Test
    void displayRulerNameAndAlliesOnConsoleWhenUniverseHasRuler() {
        Universe universe = mock(Universe.class);
        Kingdom ruler = mock(Kingdom.class);
        Kingdom ally1 = mock(Kingdom.class);
        when(ally1.getName()).thenReturn("ally1");
        Kingdom ally2 = mock(Kingdom.class);
        when(ally2.getName()).thenReturn("ally2");
        IO consoleIO = mock(IO.class);
        when(universe.getRuler()).thenReturn(ruler);
        when(ruler.getName()).thenReturn("kingdom");
        when(ruler.getAllies()).thenReturn(new HashSet<Kingdom>() {{
            add(ally1);
            add(ally2);
        }});

        knowRuler.execute(universe, consoleIO);

        verify(consoleIO).display("Ruler Name : kingdom");
        verify(consoleIO).display("Allies of Ruler : ally1, ally2");
    }

    @Test
    void displayNoneWhenRulerHasNoAllies() {
        Universe universe = mock(Universe.class);
        Kingdom ruler = mock(Kingdom.class);
        IO consoleIO = mock(IO.class);
        when(universe.getRuler()).thenReturn(ruler);
        when(ruler.getName()).thenReturn("kingdom");

        knowRuler.execute(universe, consoleIO);

        verify(consoleIO).display("Ruler Name : kingdom");
        verify(consoleIO).display("Allies of Ruler : None");
    }
}
