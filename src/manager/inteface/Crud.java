package manager.inteface;

public interface Crud <T> {
    void create();

    void update();

    void display();

    T findById();
}
