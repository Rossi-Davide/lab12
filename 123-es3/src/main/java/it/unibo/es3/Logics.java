package it.unibo.es3;

import java.util.List;

public interface Logics {

    void hit(Pair<Integer,Integer> pair);

    List<Pair<Integer, Integer>> hitRandomPoints(int i);

    List<Pair<Integer, Integer>> animate();

    boolean toQuit();

}
