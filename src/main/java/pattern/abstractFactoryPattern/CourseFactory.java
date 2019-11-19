package pattern.abstractFactoryPattern;

public interface CourseFactory {

    INote createNote();

    IVideo createVideo();
}
