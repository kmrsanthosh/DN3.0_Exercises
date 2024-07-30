package com.mvcpatternexample;

public class Main {
    public static void main(String[] args) {
        Student model = new Student("John Doe", 1001, 'B');
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        System.out.println("Initial Student Details:");
        controller.updateView();

        controller.setStudentName("Jane Smith");
        controller.setStudentId(1002);
        controller.setStudentGrade('A');

        System.out.println("\nUpdated Student Details:");
        controller.updateView();
    }
}