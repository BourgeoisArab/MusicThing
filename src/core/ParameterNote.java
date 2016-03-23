package core;

public abstract class ParameterNote extends Note {

	public ParameterNote(int pitch, float duration, int velocity) {
		super(pitch, duration, velocity);
	}

	public static class TimeChange extends ParameterNote {

		private int[] timeSignature;

		public TimeChange(int p, float d, int v, int[] ts) {
			super(p, d, v);
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

		public KeyChange(int p, float d, int v, Key key) {
			super(p, d, v);
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
