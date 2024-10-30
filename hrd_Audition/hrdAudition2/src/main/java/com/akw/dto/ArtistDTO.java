package com.akw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArtistDTO {
	private String artist_id;
	private String artist_name;
	private String artist_birth;
	private String artist_gender;
	private String talent;
	private String agency;
}
