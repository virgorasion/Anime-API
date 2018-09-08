package widyanto.fauzan.tugasakhir.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AnimeDetail{

	@SerializedName("title_japanese")
	private String titleJapanese;

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

	public void setTitleJapanese(String titleJapanese){
		this.titleJapanese = titleJapanese;
	}

	public String getTitleJapanese(){
		return titleJapanese;
	}

	public void setFavorites(int favorites){
		this.favorites = favorites;
	}

	public int getFavorites(){
		return favorites;
	}

	public void setBroadcast(String broadcast){
		this.broadcast = broadcast;
	}

	public String getBroadcast(){
		return broadcast;
	}

	public void setStudio(List<StudioItem> studio){
		this.studio = studio;
	}

	public List<StudioItem> getStudio(){
		return studio;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	public void setScoredBy(int scoredBy){
		this.scoredBy = scoredBy;
	}

	public int getScoredBy(){
		return scoredBy;
	}

	public void setPremiered(String premiered){
		this.premiered = premiered;
	}

	public String getPremiered(){
		return premiered;
	}

	public void setTitleSynonyms(String titleSynonyms){
		this.titleSynonyms = titleSynonyms;
	}

	public String getTitleSynonyms(){
		return titleSynonyms;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setDuration(String duration){
		this.duration = duration;
	}

	public String getDuration(){
		return duration;
	}

	public void setScore(double score){
		this.score = score;
	}

	public double getScore(){
		return score;
	}

	public void setPopularity(int popularity){
		this.popularity = popularity;
	}

	public int getPopularity(){
		return popularity;
	}

	public void setMembers(int members){
		this.members = members;
	}

	public int getMembers(){
		return members;
	}

	public void setGenre(List<GenreItem> genre){
		this.genre = genre;
	}

	public List<GenreItem> getGenre(){
		return genre;
	}

	public void setTitleEnglish(String titleEnglish){
		this.titleEnglish = titleEnglish;
	}

	public String getTitleEnglish(){
		return titleEnglish;
	}

	public void setRank(int rank){
		this.rank = rank;
	}

	public int getRank(){
		return rank;
	}

	public void setAiring(boolean airing){
		this.airing = airing;
	}

	public boolean isAiring(){
		return airing;
	}

	public void setEpisodes(int episodes){
		this.episodes = episodes;
	}

	public int getEpisodes(){
		return episodes;
	}

	public void setAired(Aired aired){
		this.aired = aired;
	}

	public Aired getAired(){
		return aired;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setMalId(int malId){
		this.malId = malId;
	}

	public int getMalId(){
		return malId;
	}

	public void setSynopsis(String synopsis){
		this.synopsis = synopsis;
	}

	public String getSynopsis(){
		return synopsis;
	}

	public void setAiredString(String airedString){
		this.airedString = airedString;
	}

	public String getAiredString(){
		return airedString;
	}

	public void setTrailerUrl(String trailerUrl){
		this.trailerUrl = trailerUrl;
	}

	public String getTrailerUrl(){
		return trailerUrl;
	}

	public void setBackground(String background){
		this.background = background;
	}

	public String getBackground(){
		return background;
	}

	public void setProducer(List<ProducerItem> producer){
		this.producer = producer;
	}

	public List<ProducerItem> getProducer(){
		return producer;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}