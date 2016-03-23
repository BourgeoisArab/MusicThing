package core;

public abstract class ParameterNote extends Note {

	public ParameterNote(int pitch, float duration) {
		super(pitch, duration);
	}

	public static class TimeChange extends ParameterNote {

		private int[] timeSignature;

		public TimeChange(int p, float d, int[] ts) {
			super(p, d);
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

		public KeyChange(int pitch, float duration, Key key) {
			super(pitch, duration);
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
