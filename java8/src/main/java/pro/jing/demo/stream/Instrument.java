package pro.jing.demo.stream;

import lombok.Data;

@Data
public class Instrument {

	private String type;
	private Integer seq;
	public Instrument(String type, Integer seq) {
		this.type = type;
		this.seq = seq;
	}
	
	
}
