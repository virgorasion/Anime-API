package widyanto.fauzan.tugasakhir.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TopAnime {

	@SerializedName("top")
	private List<TopAnimeItem> top;

	public void setTop(List<TopAnimeItem> top){
		this.top = top;
	}

	public List<TopAnimeItem> getTop(){
		return top;
	}
}