package com.zee.zee5app.dto;

import lombok.Data;

@Data

public class Episode implements Comparable<Episode>{
	
	public Episode(String id,String serId, String name, int length, String trailer, String location) {
		// TODO Auto-generated constructor stub
		
		super();
		this.id=id;
		this.serId= serId;
		this.name = name;
		this.length = length;
		this.location = location;
		this.trailer = trailer;
		
	}
	
	private String id;
	private String serId;
	private String name;
	private int length;
	private String location;
	private String trailer;
	
	
	@Override
	public int compareTo(Episode o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.getId());
	}

}
