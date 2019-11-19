package pattern.lazySingletonsafePattern;

public class ExecutorThread implements Runnable {
    @Override
    public void run() {
        LazySimpleSingleton singeton = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+":"+singeton);
    }
}
