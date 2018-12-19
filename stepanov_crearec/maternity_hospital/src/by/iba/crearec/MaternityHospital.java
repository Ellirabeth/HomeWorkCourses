package by.iba.crearec;

import by.iba.crearec.entity.Person;
import by.iba.crearec.ward.CommonHospitalWard;
import by.iba.crearec.ward.HospitalWard;
import by.iba.crearec.ward.PrivateHospitalWard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaternityHospital {

	List<HospitalWard> hospitalWards = new ArrayList<>();

	private static MaternityHospital instance;

	public static MaternityHospital getInstance() {
		if (instance == null) {
			instance = new MaternityHospital();
		}
		return instance;
	}

	private MaternityHospital() {
		hospitalWards.add(new PrivateHospitalWard(1000));
		hospitalWards.add(new CommonHospitalWard(2, 700));
		hospitalWards.add(new CommonHospitalWard(4, 500));
		hospitalWards.add(new CommonHospitalWard(6, 300));
		hospitalWards.add(new CommonHospitalWard(8, 0));
	}

	public HospitalWard getHospitalWardByCost(int cost) {
		return hospitalWards.stream().filter(item -> item.isFree() && item.getCost() <= cost).max(Comparator.comparing(HospitalWard::getCost)).orElse(null);
	}

	public void deletePerson(Person person) {
		deletePerson(person.getId());
	}

	public void deletePerson(String id) {
		hospitalWards.forEach(hospitalWard -> hospitalWard.deletePeople(id));
	}
}
