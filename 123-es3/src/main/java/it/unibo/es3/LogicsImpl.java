package it.unibo.es3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

public class LogicsImpl implements Logics {


    private final Set<Pair<Integer,Integer>> active = new HashSet<>();
    private final int width;

    public LogicsImpl(int width) {
        this.width = width;
    }

    private boolean isPointInGrid(Pair<Integer,Integer> point){
        return point.getX()>= 0 && point.getX() < width && point.getY() >= 0 && point.getY() < width;
    }

    @Override
    public void hit(Pair<Integer, Integer> point) {
        if(isPointInGrid(point)) {
            active.add(point);
        }
    }

    @Override
    public List<Pair<Integer, Integer>> hitRandomPoints(int nPoints) {
        List<Pair<Integer,Integer>> points = new ArrayList<>();

        for(int i = 0; i < nPoints; i++){
            RandomGenerator random = RandomGenerator.getDefault();
            int x = random.nextInt(this.width);
            int y = random.nextInt(this.width);

            points.add(new Pair<Integer,Integer>(x, y));
        }

        points.forEach(this::hit);

        return points;
    }

    @Override
    public List<Pair<Integer, Integer>> animate() {
        List<Pair<Integer,Integer>> newPoints = active.stream().flatMap(point ->getPointAndNeighbours(point).stream()).toList();
        newPoints.forEach(this::hit);
        return newPoints;
    }

    private List<Pair<Integer,Integer>> getPointAndNeighbours(Pair<Integer,Integer> point) {
        List<Pair<Integer,Integer>> points = new ArrayList<>();

        for(int i = -1 ; i <= 1; i++){
            for(int j = -1; j <= 1; j++){

                Pair<Integer,Integer> newPoint = new Pair<Integer,Integer>(point.getX()+i, point.getY()+j);

                if(isPointInGrid(newPoint)){
                    points.add(newPoint);
                }
            }
        }
        

        return points;
    }

    @Override
    public boolean toQuit() {
        return active.size() == (width * width);
    }



    
}
