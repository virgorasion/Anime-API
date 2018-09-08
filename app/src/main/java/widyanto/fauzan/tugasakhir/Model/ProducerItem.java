package widyanto.fauzan.tugasakhir.Model;

import com.google.gson.annotations.SerializedName;

public class ProducerItem{

	@SerializedName("name")
	private String name;

	@SerializedName("mal_id")
	private int malId;

	@SerializedName("type")
	private String type;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setMalId(int malId){
		this.malId = malId;
	}

	public int getMalId(){
		return malId;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}