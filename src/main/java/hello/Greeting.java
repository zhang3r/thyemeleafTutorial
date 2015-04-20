package hello;

import java.util.ArrayList;
import java.util.List;

public class Greeting {

	private long id;
	private String content;

	private List<String> names;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getNames() {
		if (names == null) {
			names = new ArrayList<>(); 	
		}
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

}
