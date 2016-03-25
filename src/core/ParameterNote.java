package core;

import java.util.HashSet;

public class ParameterNote extends Note {

	public enum Type {
		TIME, KEY, TEMPO;
	}

	public final HashSet<Type> types = new HashSet<Type>();
	private Object[] data = new Object[3];

	public ParameterNote(int pitch, float duration, int velocity, Type... t) {
		super(pitch, duration, velocity);
		for (Type i : t) {
			types.add(i);
		}
	}

	public ParameterNote setData(Object... objects) {
		for (Object o : objects) {
			if (o instanceof int[]) {
				data[0] = o;
			} else if (o instanceof Key) {
				data[1] = o;
			} else if (o instanceof Integer) {
				data[2] = o;
			} else {
				throw new IllegalArgumentException();
			}
		}
		return this;
	}

	public Object getData(Type t) {
		if (!types.contains(t)) {
			System.out.println("ParameterNote object is not of type " + t);
			return null;
		} else {
			return data[t.ordinal()];
		}

	}

}
