package it.unibo.es2;

import java.util.List;

public interface Logics {

    int getSize();

    List<List<Boolean>> values();

    boolean toQuit();

    boolean hit(Pair<? extends Integer,? extends Integer> position);

    boolean getValue(Pair<? extends Integer,? extends Integer> position);
}
