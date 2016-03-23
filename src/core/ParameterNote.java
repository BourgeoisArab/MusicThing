package core;

public abstract class ParameterNote extends Note {

	public ParameterNote(int pitch, float frequency, float duration) {
		super(pitch, frequency, duration);
	}

	public static class TimeChange extends ParameterNote {

		private int[] timeSignature;

		public TimeChange(int p, float f, float d, int[] ts) {
			super(p, f, d);
			timeSignature = ts;
		}

		public int[] GetTimeSig() {
			return timeSignature;
		}

		public void SetTimeSig(int[] ts) {
			timeSignature = ts;
		}
	}

	public static class KeyChange extends ParameterNote {

		private Key key;

		public KeyChange(int pitch, float frequency, float duration, Key key) {
			super(pitch, frequency, duration);
			this.key = key;
		}

		public Key GetKey() {
			return key;
		}

		public void SetKey(Key k) {
			key = k;
		}
	}

}
