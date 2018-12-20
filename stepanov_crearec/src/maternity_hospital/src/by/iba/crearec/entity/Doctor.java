package by.iba.crearec.entity;

import by.iba.crearec.builder.BabyBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Doctor {

	private BabyBuilder babyBuilder;

	public Person constructBaby() {
		babyBuilder.createNewBaby();
		babyBuilder.setRace();
		babyBuilder.setEyeColor();
		babyBuilder.setHairColor();
		return babyBuilder.getPerson();
	}
}
