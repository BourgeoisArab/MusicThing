package output;

import output.midi.*;
import java.io.*;
import javax.sound.midi.*;

public class Output {
	// Middle layer between data structure and TrackClass
	// Dealing with parameter notes
    public static File write(MidiSequence m,String dir) throws IOException {
        File f = new File(dir);
        MidiSystem.write(m.sequence, 1, f);
        System.out.println("File written to: " + dir);
        return f;
    }
}
