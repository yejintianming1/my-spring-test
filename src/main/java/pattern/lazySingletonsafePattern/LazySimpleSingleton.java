package pattern.lazySingletonsafePattern;

public class LazySimpleSingleton {

    private LazySimpleSingleton() {
    }

    private static LazySimpleSingleton lazy = null;

    public synchronized static LazySimpleSingleton getInstance() {
        if (lazy == null) {
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }
}
