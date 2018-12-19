package by.iba.crearec.ward;

import by.iba.crearec.entity.Person;

public interface HospitalWard {

	boolean deletePeople(String id);

	boolean addPeople(Person person);

	boolean isFree();

	int getCost();
}
