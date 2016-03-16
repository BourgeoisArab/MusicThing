package main;
import java.util.*;

public class Note {

	/**
	 * Relative note value to the key (0 - 6)
	 */
	private int pitch;

	/**
	 * Absolute frequency
	 */
	private double freq;

	/**
	 * Duration, relative to that of a semi-breve <br>
	 * eg. crotchet = 1/4, minim = 1/2
	 */
	private double duration;

	public Note(int pitch, double freq, double duration) {
		if (pitch < 0 || pitch > 6 || freq < 0 || duration < 0) {
			throw new IllegalArgumentException();
		}
		this.pitch = pitch;
		this.freq = freq;
		this.duration = duration;
	}
        
        // A get method for all properties. 
        public List<Object> getList()
        {
            return new ArrayList<>(Arrays.asList(pitch,freq,duration));
        }
        
	public double getFrequency() {
		return freq;
	}

	public double getDuration() {
		return duration;
	}

	public Note setFrequency(double freq) {
		this.freq = freq;
		return this;
	}

	public Note setDuration(double duration) {
		this.duration = duration;
		return this;
	}

	public int getPitch() {
		return pitch;
	}

	public void setPitch(int pitch) {
		this.pitch = pitch;
	}
}
