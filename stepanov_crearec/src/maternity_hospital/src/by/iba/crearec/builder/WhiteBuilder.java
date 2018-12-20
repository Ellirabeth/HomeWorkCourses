package by.iba.crearec.builder;

import by.iba.crearec.entity.Color;
import by.iba.crearec.entity.Race;

public class WhiteBuilder extends BabyBuilder {

	@Override
	public void setRace() {
		person.setRace(Race.WHITE);
	}

	@Override
	public void setEyeColor() {
		person.setEyeColor(Color.GREEN);
	}

	@Override
	public void setHairColor() {
		person.setHairColor(Color.WHITE);
	}
}
