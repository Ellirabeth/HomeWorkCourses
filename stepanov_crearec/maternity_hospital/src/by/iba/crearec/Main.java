package by.iba.crearec;

import by.iba.crearec.decorator.Patient;
import by.iba.crearec.entity.Color;
import by.iba.crearec.entity.Gender;
import by.iba.crearec.entity.Person;
import by.iba.crearec.entity.Race;
import by.iba.crearec.entity.Setting;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Person male1 = new Person();
		male1.setRace(Race.WHITE);
		male1.setGender(Gender.MALE);
		male1.setAge(30);
		male1.setEyeColor(Color.GREEN);
		male1.setHairColor(Color.BLACK);

		Person female1 = new Person();
		female1.setRace(Race.BLACK);
		female1.setGender(Gender.FEMALE);
		female1.setAge(25);
		female1.setEyeColor(Color.DARK_GRAY);
		female1.setHairColor(Color.BLUE);
		female1.setPair(male1);

		Setting setting1 = new Setting();
		setting1.setAdditional(3000);
		setting1.setEyeColor(Color.ORANGE);
//	    setting1.setHairColor(Color.ORANGE);
		female1.setSetting(setting1);


		AdmissionDepartment.enter(female1);

		List<Patient> patients = AdmissionDepartment.callSpawn(female1);
		patients.forEach(patient -> {
			Person person = (Person) patient;
			System.out.println(person);
		});
	}
}
