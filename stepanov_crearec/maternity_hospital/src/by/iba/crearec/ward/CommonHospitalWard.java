package by.iba.crearec.ward;

import by.iba.crearec.entity.Person;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class CommonHospitalWard implements HospitalWard {

	private List<Person> people = new ArrayList<>();
	private int maxPeopleCount;
	private int cost;

	public CommonHospitalWard(int maxPeopleCount, int cost) {
		this.maxPeopleCount = maxPeopleCount;
		this.cost = cost;
	}

	@Override
	public boolean addPeople(Person person) {
		if (people.size() < maxPeopleCount) {
			people.add(person);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deletePeople(String id) {
		Optional<Person> first = people.stream().filter(person -> person.getId().equals(id)).findFirst();
		return first.map(person -> people.remove(person)).orElse(false);
	}

	@Override
	public boolean isFree() {
		return people.size() < maxPeopleCount;
	}
}
