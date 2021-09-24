package com.example.sneakership;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class MediaModel implements Serializable {

	@SerializedName("imageUrl")
	private String imageUrl;

	public String getImageUrl(){
		return imageUrl;
	}
}