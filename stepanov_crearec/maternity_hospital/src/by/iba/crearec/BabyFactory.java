package by.iba.crearec;

import by.iba.crearec.builder.AsianBuilder;
import by.iba.crearec.builder.BabyBuilder;
import by.iba.crearec.builder.BlackBuilder;
import by.iba.crearec.builder.WhiteBuilder;
import by.iba.crearec.entity.Doctor;
import by.iba.crearec.entity.Person;

public class BabyFactory {

	public static Person getBaby(Person female) {
		BabyBuilder babyBuilder;
		switch (female.getPair().getRace()) {
			case ASIAN:
				babyBuilder = new AsianBuilder();
				break;
			case BLACK:
				babyBuilder = new BlackBuilder();
				break;
			case WHITE:
				babyBuilder = new WhiteBuilder();
				break;
			default:
				throw new IllegalArgumentException("Incorrect parameter");
		}
		Doctor doctor = new Doctor(babyBuilder);
		return doctor.constructBaby();
	}
}
