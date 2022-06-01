public abstract class Task <T> {
    T t;

    Task (T t) {
        this.t = t;
    }

    public T getContent(){
        return t;
    }
}
