package main;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// Hello from netbeans
                Timeline t = new Timeline();
                List<Note> l = new ArrayList<>();
                for(int i = 0;i < 5;i++)
                    l.add(new Note(1,1,1));
                t.AppendNote(l);
	}

}
