package by.iba.crearec.builder;

import by.iba.crearec.entity.Person;

public abstract class BabyBuilder {

	protected Person person;

	public void createNewBaby() {
		person = new Person();
	}

	public Person getPerson() {
		return person;
	}

	public abstract void setRace();

	public abstract void setEyeColor();

	public abstract void setHairColor();

}
