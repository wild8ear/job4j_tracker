package ru.job4j.map;

import java.util.Optional;
import java.util.Map;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student student : students.keySet()) {
            if (student.account().equals(account)) {
                rsl = Optional.of(student);
                break;
            }
        }
        return rsl;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> subjectOptional = Optional.empty();
        Optional<Student> studentOptional = findByAccount(account);
        if (studentOptional.isPresent()) {
            for (Subject sub : students.get(studentOptional.get())) {
                if (sub.name().equals(name)) {
                    subjectOptional = Optional.of(sub);
                    break;
                }
            }
        }
        return subjectOptional;
    }

    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );
        College college = new College(students);
        Optional<Student> student = college.findByAccount("000001");
        System.out.println("Найденный студент: " + student.get());
        Optional<Subject> english = college.findBySubjectName("000001", "English");
        System.out.println("Оценка по найденному предмету: " + english.get().score());
    }
}