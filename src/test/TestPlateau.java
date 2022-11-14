package test;

import game.Plateau;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestPlateau {
    @Test
    void test() {
        final int taille = 4;
        Plateau p = new Plateau(taille);
        assertEquals(taille, p.taille());

        System.out.println(p);
        assertEquals(
                " A B C D\n" +
                        "1 . . . .\n" +
                        "2  . . . .\n" +
                        "3   . . . .\n" +
                        "4    . . . .\n", p.toString());
    }
}