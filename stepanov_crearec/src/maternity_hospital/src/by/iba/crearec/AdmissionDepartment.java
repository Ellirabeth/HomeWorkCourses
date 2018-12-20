package by.iba.crearec;

import by.iba.crearec.decorator.EyeDecorator;
import by.iba.crearec.decorator.HairDecorator;
import by.iba.crearec.decorator.Patient;
import by.iba.crearec.entity.Gender;
import by.iba.crearec.entity.Person;
import by.iba.crearec.entity.Setting;
import by.iba.crearec.ward.HospitalWard;

import java.util.List;

public class AdmissionDepartment {

	public static boolean enter(Person person) {
		if (person.getGender() == Gender.FEMALE) {
			Setting setting = person.getSetting();
			HospitalWard hospitalWard = MaternityHospital.getInstance().getHospitalWardByCost(setting == null ? 0 : setting.getWard());
			return hospitalWard.addPeople(person);
		} else {
			throw new RuntimeException("Only female can enter to hospital");
		}
	}

	public static List<Patient> callSpawn(Person person) {
		List<Patient> spawn;
		Setting setting = person.getSetting();
		Patient patientDecorated = null;
		if (setting != null) {
			int money = setting.getAdditional();
			if (money >= 1000) {
				patientDecorated = new EyeDecorator(person);
				money -= 1000;
			}
			if (money >= 500) {
				patientDecorated = new HairDecorator(patientDecorated == null ? person : patientDecorated);
				money -= 500;
			}
		}
		if (patientDecorated == null) {
			spawn = person.spawn();
		} else {
			spawn = patientDecorated.spawn();
		}

		MaternityHospital.getInstance().deletePerson(person);

		return spawn;
	}
}
