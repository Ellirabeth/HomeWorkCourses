package by.country;


import by.educationCenter.course.Course;

public class Country {
    private static Country country;
    private String name;
    private LiberationType liberationType;

    private Country(String countryName, LiberationType liberationType) {
        name = countryName;
        this.liberationType = liberationType;
    }

    public static Country getInstance() {
        if(country == null) {
            //Правильный Одиночка (thread-safe) - требуется синхронизировать потоки при создании объекта-Одиночки.
            synchronized (Course.class) {
                country = new Country("Belarus", LiberationType.Low);
            }
        }
        return country;
    }

    public String getName() {
        return name;
    }

    public LiberationType getLiberationType() {
        return liberationType;
    }
}
