package by.iba.crearec.ward;

import by.iba.crearec.entity.Person;
import lombok.Data;

@Data
public class PrivateHospitalWard implements HospitalWard {

	private Person person = null;
	private int cost;

	public PrivateHospitalWard(int cost) {
		this.cost = cost;
	}

	@Override
	public boolean addPeople(Person person) {
		if (this.person == null) {
			this.person = person;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deletePeople(String id) {
		if (person.getId().equals(id)) {
			person = null;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isFree() {
		return person == null;
	}
}
