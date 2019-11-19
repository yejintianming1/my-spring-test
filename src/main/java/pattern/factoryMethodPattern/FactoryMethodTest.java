package pattern.factoryMethodPattern;

public class FactoryMethodTest {

    public static void main(String[] args) {
        ICourseFactory courseFactory = new PythonCourseFactory();
        ICourse course = courseFactory.create();
        course.record();

        courseFactory = new JavaCourseFactory();
        course = courseFactory.create();
        course.record();
    }
}
