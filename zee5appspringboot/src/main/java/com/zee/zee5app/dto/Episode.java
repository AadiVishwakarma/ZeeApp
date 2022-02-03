package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="episode")

public class Episode implements Comparable<Episode>{
	
//	public Episode(String id,String serId, String name, int length, String trailer, String location) {
//		// TODO Auto-generated constructor stub
//		
//		super();
//		this.id=id;
//		this.serId= serId;
//		this.name = name;
//		this.length = length;
//		this.location = location;
//		this.trailer = trailer;
//		
//	}
	
	@Id
	@Column(name="episodeId")
	private String id;
	
	
	
	@NotBlank
	private String name;
	
	@NotNull
	private int length;
	
	@NotBlank
	private String location;
	
	@NotBlank
	private String trailer;
	
	
	@Override
	public int compareTo(Episode o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.getId());
	}
	
	@ManyToOne
	//this episode table should have a FK-- seriesId
	
	
	@JoinColumn(name="id")//help to create FK
	private Series series;//should take series id and this column should act as a FK.
}
