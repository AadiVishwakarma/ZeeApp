package com.zee.zee5app.dto;

import java.net.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="movie",uniqueConstraints = {@UniqueConstraint(columnNames="name")})
public class Movie implements Comparable<Movie>{
	

	@Id
	@Column(name="movieId")
	private String id;
	
	@NotBlank
	private String name;
	
	@NotNull
	private float length;
	
	@NotBlank
	private String genre;
	
	@NotBlank
	private String releaseDate;
	
//	@Lob//stands for large object binaries : for holding binary content like images , video etc
//	private byte[] trailer;
	
	private String trailer;
	
	@NotBlank
	private String cast;
	
	@Max(value=70)
	private int ageLimit;
	
	@NotBlank
	private String language;
	
	
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}
