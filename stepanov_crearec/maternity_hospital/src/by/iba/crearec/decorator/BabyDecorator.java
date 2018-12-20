package by.iba.crearec.decorator;

import by.iba.crearec.entity.Setting;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public abstract class BabyDecorator implements Patient {

	protected Patient patient;

	public abstract List<Patient> afterSpawn(List<Patient> patients);

	@Override
	public List<Patient> spawn() {
		return afterSpawn(patient.spawn());
	}

	@Override
	public Setting getSetting() {
		return patient.getSetting();
	}
}
