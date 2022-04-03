package moudule2.AccessModifier_StaticMethod_StaticProperty;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();

        System.out.println(student.name);
        System.out.println(student.classes);

        student.setName("Chau");
        student.setClasses("Japanese");

        System.out.println(student.name);
        System.out.println(student.classes);
    }
}
