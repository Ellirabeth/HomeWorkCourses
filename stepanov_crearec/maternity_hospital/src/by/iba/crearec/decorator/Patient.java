package by.iba.crearec.decorator;

import by.iba.crearec.entity.Setting;

import java.util.List;

public interface Patient {
	Setting getSetting();

	List<Patient> spawn();
}
