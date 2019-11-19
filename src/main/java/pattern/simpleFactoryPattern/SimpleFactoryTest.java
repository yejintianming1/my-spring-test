package pattern.simpleFactoryPattern;

public class SimpleFactoryTest {

//    public static void main(String[] args) {
//        CourseFactory courseFactory = new CourseFactory();
//        ICourse course = courseFactory.create("java");;
//        course.record();
//    }

//    public static void main(String[] args) {
//        CourseFactory courseFactory = new CourseFactory();
//        ICourse course = courseFactory.create("pattern.simpleFactoryPattern.JavaCourse");;
//        course.record();
//    }

    public static void main(String[] args) {
        CourseFactory courseFactory = new CourseFactory();
        ICourse course = courseFactory.create(JavaCourse.class);;
        course.record();
    }
}
