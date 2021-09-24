package com.example.sneakership;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ColoursModel implements Serializable {

	@SerializedName("color")
	private String color;

	@SerializedName("id")
	private int id;

	public String getColor(){
		return color;
	}

	public int getId(){
		return id;
	}
}