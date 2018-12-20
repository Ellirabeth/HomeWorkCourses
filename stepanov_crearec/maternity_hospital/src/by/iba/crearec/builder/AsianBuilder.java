package by.iba.crearec.builder;

import by.iba.crearec.entity.Color;
import by.iba.crearec.entity.Race;

public class AsianBuilder extends BabyBuilder {

	@Override
	public void setRace() {
		person.setRace(Race.ASIAN);
	}

	@Override
	public void setEyeColor() {
		person.setEyeColor(Color.DARK_GRAY);
	}

	@Override
	public void setHairColor() {
		person.setHairColor(Color.BLACK);
	}
}
