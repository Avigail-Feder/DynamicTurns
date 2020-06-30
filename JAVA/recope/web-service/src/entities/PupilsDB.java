package entities;

import java.util.ArrayList;
import java.util.List;

public class PupilsDB {
	
	public static List<Pupil> pupils = new ArrayList<>();
	
	static{		
		pupils.add(new Pupil(1, "Shoshana"));
		pupils.add(new Pupil(2, "Rachel"));
		pupils.add(new Pupil(3, "Miriam"));

	}

}
