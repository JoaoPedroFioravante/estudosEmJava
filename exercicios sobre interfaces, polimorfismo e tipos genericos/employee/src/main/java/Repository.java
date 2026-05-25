public interface Repository<T, V> {
    boolean register(T e); //TODO não precisará de boolean quando aprendermos exception.
    T findById(V id);
}
