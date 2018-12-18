package Factory;

import by.student.MiddleStudent;

public class MiddleCommunityImpl extends CommunityBase {
    MiddleStudent middleStudent;

    @Override
    public void createStudent(int uid) {
        middleStudent = new MiddleStudent(uid);
    }
}
