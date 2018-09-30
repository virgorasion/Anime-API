package widyanto.fauzan.tugasakhir.Model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

public class SearchAnime{

	@SerializedName("result")
	private List<ResultItem> result;

	@SerializedName("request_hash")
	private String requestHash;

	@SerializedName("request_cached")
	private boolean requestCached;

	@SerializedName("request_cache_expiry")
	private int requestCacheExpiry;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	public void setRequestHash(String requestHash){
		this.requestHash = requestHash;
	}

	public String getRequestHash(){
		return requestHash;
	}

	public void setRequestCached(boolean requestCached){
		this.requestCached = requestCached;
	}

	public boolean isRequestCached(){
		return requestCached;
	}

	public void setRequestCacheExpiry(int requestCacheExpiry){
		this.requestCacheExpiry = requestCacheExpiry;
	}

	public int getRequestCacheExpiry(){
		return requestCacheExpiry;
	}
}