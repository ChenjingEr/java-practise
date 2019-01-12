package pro.jing.demo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InstrumentGenerator {

	private final static List<String> instrumentType = new ArrayList<String>();

	static {
		instrumentType.add("Percussion");
		instrumentType.add("Intonation");
		instrumentType.add("Woodwinds");
		instrumentType.add("Saxophone");
		instrumentType.add("Brasses");
		instrumentType.add("Strings");
		instrumentType.add("Keyboard");
		instrumentType.add("Organ");
		instrumentType.add("Piano");
		instrumentType.add("Electric");
	}

	public static List<Instrument> instrumentList(int len) {

		if (len < 0)
			return null;
		Random random = new Random();
		List<Instrument> lists = new ArrayList<>(len);
		int i = 0;
		while (i < len) {
			int nextInt = random.nextInt(instrumentType.size());
			lists.add(new Instrument(instrumentType.get(nextInt), i++));
		}

		return lists;
	}
}
