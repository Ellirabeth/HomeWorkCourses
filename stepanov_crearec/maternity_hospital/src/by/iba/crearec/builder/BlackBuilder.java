package by.iba.crearec.builder;

import by.iba.crearec.entity.Color;
import by.iba.crearec.entity.Race;

public class BlackBuilder extends BabyBuilder {

	@Override
	public void setRace() {
		person.setRace(Race.BLACK);
	}

	@Override
	public void setEyeColor() {
		person.setEyeColor(Color.LIGHT_GRAY);
	}

	@Override
	public void setHairColor() {
		person.setHairColor(Color.GRAY);
	}
}
