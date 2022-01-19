package com.zee.zee5app.dto;

import java.net.URL;

import lombok.Data;

@Data
public class Movie {
	private String movieName;
	private String length;
	private String id;
	private String genre;
	private String releaseDate;
	private URL trailer;
	private String Cast[];
	private String ageLimit;
}
