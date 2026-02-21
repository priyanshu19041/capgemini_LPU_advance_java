package com.assignment6;


import java.util.List;

public class UniversityService {

    private final InstructorDAO instructorDAO = new InstructorDAO();
    private final CourseDAO courseDAO = new CourseDAO();
    private final EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
    private final InstructorProfileDAO profileDAO = new InstructorProfileDAO();

    public void createInstructorWithProfile(Instructor i, InstructorProfile p) {
        profileDAO.saveProfile(p);
        instructorDAO.saveInstructor(i);

        Instructor managed = instructorDAO.findInstructor(i.getId());
        managed.setInstructorProfile(p);
        instructorDAO.updateInstructor(managed);
    }

    public void addCoursesToInstructor(Instructor i, List<Course> courses) {
        for (Course c : courses) {
            courseDAO.saveCourse(c);
        }
        Instructor managed = instructorDAO.findInstructor(i.getId());
        managed.setCourses(courses);
        instructorDAO.updateInstructor(managed);
    }

    public void addEnrollmentToCourse(Enrollment e) {
        Course c = e.getCourse();
        courseDAO.saveCourse(c);
        enrollmentDAO.saveEnrollment(e);
    }

    public void updateEnrollmentGrade(Long id, String grade) {
        enrollmentDAO.updateGrade(id, grade);
    }

    public Instructor fetchInstructor(Long id) {
        return instructorDAO.findInstructor(id);
    }

    public void deleteInstructor(Long id) {
        instructorDAO.deleteInstructor(id);
    }
}