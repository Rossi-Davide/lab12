package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

	private static final int INITIAL_VALUE = 0;
	final List<Integer> values = new ArrayList<>();


	public LogicsImpl(int size) {
		for(int i = 0; i < size; i++) {
			values.add(INITIAL_VALUE);
		}
	}

	@Override
	public int size() {
		return values.size();
	}

	@Override
	public List<Integer> values() {
		return List.copyOf(values);
	}

	@Override
	public List<Boolean> enablings() {
		return values.stream().map( i -> i < values.size()).toList();
	}

	@Override
	public int hit(final int elem) {
		if ( elem < 0 || elem >= values.size()) {
			throw new IllegalArgumentException("Index out of bound");
		}

		if (values.get(elem) < values.size()) {
			values.set(elem, values.get(elem) + 1);
		}

		return values.get(elem);
	}

	@Override
	public String result() {
		return values
			.stream()
			.map(i -> i.toString())
			.collect(Collectors.joining("|", "<<", ">>"));
	}

	@Override
	public boolean toQuit() {
		return values
			.stream()
			.allMatch(i -> i.equals(values.get(0)));
	}
}
