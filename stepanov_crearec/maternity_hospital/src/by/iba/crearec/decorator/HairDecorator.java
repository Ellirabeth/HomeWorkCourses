package by.iba.crearec.decorator;

import by.iba.crearec.entity.Color;
import by.iba.crearec.entity.Person;
import by.iba.crearec.entity.Setting;

import java.util.List;

public class HairDecorator extends BabyDecorator {

	public HairDecorator(Patient patient) {
		super(patient);
	}

	@Override
	public List<Patient> afterSpawn(List<Patient> patients) {
		patients.forEach(item -> {
			Setting setting = patient.getSetting();
			if (setting != null) {
				Color hairColor = setting.getHairColor();
				if (hairColor != null) {
					((Person) item).setHairColor(hairColor);
				}
			}
		});
		return patients;
	}
}
