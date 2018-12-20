package by.iba.crearec.decorator;

import by.iba.crearec.entity.Color;
import by.iba.crearec.entity.Person;
import by.iba.crearec.entity.Setting;

import java.util.List;

public class EyeDecorator extends BabyDecorator {

	public EyeDecorator(Patient patient) {
		super(patient);
	}

	@Override
	public List<Patient> afterSpawn(List<Patient> patients) {
		patients.forEach(item -> {
			Setting setting = patient.getSetting();
			if (setting != null) {
				Color eyeColor = setting.getEyeColor();
				if (eyeColor != null) {
					((Person) item).setEyeColor(eyeColor);
				}
			}
		});
		return patients;
	}
}
