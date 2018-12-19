package by.iba.crearec.entity;

import lombok.Data;

@Data
public class Setting {

	private int ward;
	private int doctor;
	private int additional;

	private int babyCount = 1;

	private Race race;
	private Gender gender;
	private Color eyeColor;
	private Color hairColor;

}
