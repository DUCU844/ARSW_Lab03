package classroomManagement;

import java.util.HashMap;
import java.util.Map;

/**
 * This class saves all classrooms in memory (no database).
 * We use a Map to find classrooms fast by their ID (like "E301").
 */
public class ClassroomRepository {

    private Map<String, Classroom> classrooms = new HashMap<>();

    /**
     * When we create this repository, we add 4 classrooms.
     * E301 and E304 start as available (true).
     * E302 and E303 start as reserved (false).
     */
    public ClassroomRepository(){
        classrooms.put("E301", new Classroom("E301", true));
        classrooms.put("E302", new Classroom("E302", false));
        classrooms.put("E303", new Classroom("E303", false));
        classrooms.put("E304", new Classroom("E304", true));
    }

    /**
     * Find a classroom by its ID.
     * If the ID does not exist, this returns null.
     *
     * @param classroomId the ID of the classroom, for example "E303"
     * @return the Classroom object, or null if not found
     */
    public Classroom findByClassroomId(String classroomId){
        return classrooms.get(classroomId);
    }

    /**
     * Reserve a classroom.
     * We change available to false, then save it in the map.
     *
     * @param classroom the classroom we want to reserve
     */
    public void reserveClassroom(Classroom classroom){
        classroom.setAvailable(false);
        classrooms.put(classroom.getClassroomId(), classroom);
    }

    /**
     * Release a classroom so other people can use it.
     * We change available to true, then save it in the map.
     *
     * @param classroom the classroom we want to release
     */
    public void releaseClassroom(Classroom classroom){
        classroom.setAvailable(true);
        classrooms.put(classroom.getClassroomId(), classroom);
    }
}
