public class Student {
    String name;
    double grade;

    Student(String name, double grade)
    {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString()
    {
        return name + "," + grade;
    }
}
