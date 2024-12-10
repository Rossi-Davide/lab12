package it.unibo.es2;

import java.util.ArrayList;
import java.util.List;

public class LogicsImpl implements Logics{
    
    final List<List<Boolean>> grid = new ArrayList<>();

    public LogicsImpl(final int size) {
        for(int i = 0; i < size; i++) {
            List<Boolean> row= new ArrayList<>();
            for(int j = 0; j < size; j++) {
                row.add(false);
            }
        }
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    @Override
    public List<List<Boolean>> values() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'values'");
    }

    @Override
    public boolean toQuit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toQuit'");
    }

    @Override
    public boolean hit(Pair<? extends Integer, ? extends Integer> position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hit'");
    }

    @Override
    public boolean getValue(Pair<? extends Integer, ? extends Integer> position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValue'");
    }


}
