package widyanto.fauzan.tugasakhir.Model;

import com.google.gson.annotations.SerializedName;

public class Aired{

	@SerializedName("from")
	private String from;

	@SerializedName("to")
	private String to;

	public Aired() {
	}

	public Aired(String from, String to) {
		this.from = from;
		this.to = to;
	}

	public void setFrom(String from){
		this.from = from;
	}

	public String getFrom(){
		return from;
	}

	public void setTo(String to){
		this.to = to;
	}

	public String getTo(){
		return to;
	}
}