import java.util.Queue;
import java.util.concurrent.BlockingDeque;

public class TaskStringExecutor implements TaskExecutor<TaskString>{

    class ThreadTask extends Thread {

        private BlockingDeque<TaskString> taskQueue;

        public void addInQueue(TaskString  task) {
            taskQueue.push(task);
        }

        @Override
        public void run() {
            TaskString task = taskQueue.pop();
            //тут запись на диск
        }
    }

    TaskStringExecutor.ThreadTask thread = new TaskStringExecutor.ThreadTask(); //очередь нужна из concurrency

    public TaskStringExecutor () {
        thread.start();
    }

    @Override
    public void execute(TaskString t) {
        thread.addInQueue(t);
    }
}
