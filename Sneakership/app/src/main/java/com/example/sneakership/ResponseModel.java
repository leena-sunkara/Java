package com.example.sneakership;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseModel implements Serializable {

	@SerializedName("sizes")
	private List<SizesModel> sizes;

	@SerializedName("releaseDate")
	private String releaseDate;

	@SerializedName("year")
	private int year;

	@SerializedName("styleId")
	private String styleId;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("media")
	private MediaModel media;

	@SerializedName("brand")
	private String brand;

	@SerializedName("retailPrice")
	private int retailPrice;

	@SerializedName("shoe")
	private String shoe;

	@SerializedName("colours")
	private List<ColoursModel> colours;

	public List<SizesModel> getSizes(){
		return sizes;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public int getYear(){
		return year;
	}

	public String getStyleId(){
		return styleId;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public MediaModel getMedia(){
		return media;
	}

	public String getBrand(){
		return brand;
	}

	public int getRetailPrice(){
		return retailPrice;
	}

	public String getShoe(){
		return shoe;
	}

	public List<ColoursModel> getColours(){
		return colours;
	}
}