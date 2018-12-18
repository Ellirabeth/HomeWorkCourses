package Factory;

import by.student.AdultStudent;

public class AdultCommunityImpl extends CommunityBase {
    AdultStudent adultStudent;

    @Override
    public void createStudent(int uid) {
         adultStudent = new AdultStudent(uid);
    }
}
