package widyanto.fauzan.tugasakhir.Model;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

public class TopAnimeItem {

	@SerializedName("score")
	private double score;

	@SerializedName("end_date")
	private String end_date;

	@SerializedName("image_url")
	private String imageUrl;

	@SerializedName("start_date")
	private String start_date;

	@SerializedName("members")
	private int members;

	@SerializedName("rank")
	private int rank;

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

	public double getScore() {
		return score;
	}

	public String getEnd_date() {
		return end_date;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getStart_date() {
		return start_date;
	}

	public int getMembers() {
		return members;
	}

	public int getRank() {
		return rank;
	}

	public int getMalId() {
		return malId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public int getEpisodes() {
		return episodes;
	}

}