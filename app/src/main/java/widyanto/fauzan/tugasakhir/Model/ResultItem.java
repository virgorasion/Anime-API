package widyanto.fauzan.tugasakhir.Model;

import com.google.gson.annotations.SerializedName;

public class ResultItem{

	@SerializedName("score")
	private double score;

	@SerializedName("image_url")
	private String imageUrl;

	@SerializedName("members")
	private int members;

	@SerializedName("description")
	private String description;

	@SerializedName("mal_id")
	private int malId;

	@SerializedName("title")
	private String title;

	@SerializedName("type")
	private String type;

	@SerializedName("url")
	private String url;

	@SerializedName("episodes")
	private int episodes;

	public void setScore(double score){
		this.score = score;
	}

	public double getScore(){
		return score;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setMembers(int members){
		this.members = members;
	}

	public int getMembers(){
		return members;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setMalId(int malId){
		this.malId = malId;
	}

	public int getMalId(){
		return malId;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setEpisodes(int episodes){
		this.episodes = episodes;
	}

	public int getEpisodes(){
		return episodes;
	}
}