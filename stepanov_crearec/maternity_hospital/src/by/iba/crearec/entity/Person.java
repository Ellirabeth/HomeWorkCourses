package by.iba.crearec.entity;

import by.iba.crearec.BabyFactory;
import by.iba.crearec.decorator.Patient;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Data
public class Person implements Patient {

	private String id = UUID.randomUUID().toString();

	private Race race;
	private Gender gender;
	private int age;
	private Color eyeColor;
	private Color hairColor;

	private Setting setting;

	private Person pair;

	public Person() {
		Random random = new Random();
		if (random.nextBoolean()) {
			gender = Gender.MALE;
		} else {
			gender = Gender.FEMALE;
		}
	}

	@Override
	public List<Patient> spawn() {
		Random random = new Random();
		List<Patient> people = new ArrayList<>();
		for (int i = 0; i < random.nextInt(2) + 1; i++) {
			Person baby = BabyFactory.getBaby(this);
			people.add(baby);
		}
		return people;
	}
}
