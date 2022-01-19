package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Series {
	
	private String seriesName;
	private String length;
	private String id;
	private String genre;
	private String releaseDate;
	private String trailer;
	private String Cast[];
	private String ageLimit;
}
