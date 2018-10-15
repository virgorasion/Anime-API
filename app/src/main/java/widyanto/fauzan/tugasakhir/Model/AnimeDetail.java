package widyanto.fauzan.tugasakhir.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AnimeDetail{

	@SerializedName("title_japanese")
	private String titleJapanese;

	@SerializedName("title")
	private String title;

	@SerializedName("favorites")
	private int favorites;

	@SerializedName("broadcast")
	private String broadcast;

	@SerializedName("studio")
	private List<StudioItem> studio;

	@SerializedName("rating")
	private String rating;

	@SerializedName("scored_by")
	private int scoredBy;

	@SerializedName("premiered")
	private String premiered;

	@SerializedName("title_synonyms")
	private String titleSynonyms;

	@SerializedName("source")
	private String source;

	@SerializedName("type")
	private String type;

	@SerializedName("duration")
	private String duration;

	@SerializedName("score")
	private double score;

	@SerializedName("popularity")
	private int popularity;

	@SerializedName("members")
	private int members;

	@SerializedName("genre")
	private List<GenreItem> genre;

	@SerializedName("title_english")
	private String titleEnglish;

	@SerializedName("rank")
	private int rank;

	@SerializedName("airing")
	private boolean airing;

	@SerializedName("episodes")
	private int episodes;

	@SerializedName("aired")
	private Aired aired;

	@SerializedName("image_url")
	private String imageUrl;

	@SerializedName("mal_id")
	private int malId;

	@SerializedName("synopsis")
	private String synopsis;

	@SerializedName("aired_string")
	private String airedString;

	@SerializedName("trailer_url")
	private String trailerUrl;

	@SerializedName("background")
	private String background;

	@SerializedName("producer")
	private List<ProducerItem> producer;

	@SerializedName("status")
	private String status;

	public String getTitleJapanese() {
		return titleJapanese;
	}

	public void setTitleJapanese(String titleJapanese) {
		this.titleJapanese = titleJapanese;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getFavorites() {
		return favorites;
	}

	public void setFavorites(int favorites) {
		this.favorites = favorites;
	}

	public String getBroadcast() {
		return broadcast;
	}

	public void setBroadcast(String broadcast) {
		this.broadcast = broadcast;
	}

	public List<StudioItem> getStudio() {
		return studio;
	}

	public void setStudio(List<StudioItem> studio) {
		this.studio = studio;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getScoredBy() {
		return scoredBy;
	}

	public void setScoredBy(int scoredBy) {
		this.scoredBy = scoredBy;
	}

	public String getPremiered() {
		return premiered;
	}

	public void setPremiered(String premiered) {
		this.premiered = premiered;
	}

	public String getTitleSynonyms() {
		return titleSynonyms;
	}

	public void setTitleSynonyms(String titleSynonyms) {
		this.titleSynonyms = titleSynonyms;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

	public List<GenreItem> getGenre() {
		return genre;
	}

	public void setGenre(List<GenreItem> genre) {
		this.genre = genre;
	}

	public String getTitleEnglish() {
		return titleEnglish;
	}

	public void setTitleEnglish(String titleEnglish) {
		this.titleEnglish = titleEnglish;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public boolean isAiring() {
		return airing;
	}

	public void setAiring(boolean airing) {
		this.airing = airing;
	}

	public int getEpisodes() {
		return episodes;
	}

	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}

	public Aired getAired() {
		return aired;
	}

	public void setAired(Aired aired) {
		this.aired = aired;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getMalId() {
		return malId;
	}

	public void setMalId(int malId) {
		this.malId = malId;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getAiredString() {
		return airedString;
	}

	public void setAiredString(String airedString) {
		this.airedString = airedString;
	}

	public String getTrailerUrl() {
		return trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public List<ProducerItem> getProducer() {
		return producer;
	}

	public void setProducer(List<ProducerItem> producer) {
		this.producer = producer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}