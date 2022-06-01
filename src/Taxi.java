class ServiceXmlParse {
    public static int getNbFromMessage(String msg) {
        return 0;
    }
}

public class Taxi {
    private Telephone[] phones;
    private TaskExecutor[] executors;

    volatile long id = 0;

    public synchronized long call(String message) {//можно выбросить исключение, если nb неправильный
        int nb = ServiceXmlParse.getNbFromMessage(message);//тут надо распарсить номер таски из xml

        Task<String> task = new TaskString(message);
        executors[nb].execute(task);
        return id++;
    }
}
