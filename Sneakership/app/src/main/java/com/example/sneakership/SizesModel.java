package com.example.sneakership;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SizesModel implements Serializable {

	@SerializedName("size")
	private int size;

	@SerializedName("id")
	private int id;

	public int getSize(){
		return size;
	}

	public int getId(){
		return id;
	}
}