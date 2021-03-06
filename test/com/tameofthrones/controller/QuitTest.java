package com.tameofthrones.controller;

import com.tameofthrones.controller.actions.Quit;
import com.tameofthrones.model.Universe;
import com.tameofthrones.view.IO;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class QuitTest {
    private static final String THANK_YOU = "Thank you for your time";

    @Test
    void displayThankYouMessage() {
        Quit quit = new Quit();
        IO consoleIO = mock(IO.class);

        quit.execute(mock(Universe.class), consoleIO);

        verify(consoleIO).display(THANK_YOU);
    }
}
