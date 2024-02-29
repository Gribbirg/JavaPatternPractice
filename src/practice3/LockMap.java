package practice3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMap<K, V> implements Map<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private final Lock lock = new ReentrantLock();

    @Override
    public int size() {
        lock.lock();
        int size = map.size();
        lock.unlock();
        return size;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        boolean isEmpty = map.isEmpty();
        lock.unlock();
        return isEmpty;
    }

    @Override
    public boolean containsKey(Object key) {
        lock.lock();
        boolean containsKey = map.containsKey(key);
        lock.unlock();
        return containsKey;
    }

    @Override
    public boolean containsValue(Object value) {
        lock.lock();
        boolean containsValue = map.containsValue(value);
        lock.unlock();
        return containsValue;
    }

    @Override
    public V get(Object key) {
        lock.lock();
        V value = map.get(key);
        lock.unlock();
        return value;
    }

    @Override
    public V put(K key, V value) {
        lock.lock();
        V resValue = map.put(key, value);
        lock.unlock();
        return resValue;
    }

    @Override
    public V remove(Object key) {
        lock.lock();
        V value = map.remove(key);
        lock.unlock();
        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        lock.lock();
        map.putAll(m);
        lock.unlock();
    }

    @Override
    public void clear() {
        lock.lock();
        map.clear();
        lock.unlock();
    }

    @Override
    public Set<K> keySet() {
        lock.lock();
        Set<K> keySet = map.keySet();
        lock.unlock();
        return keySet;
    }

    @Override
    public Collection<V> values() {
        lock.lock();
        Collection<V> values = map.values();
        lock.unlock();
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        lock.lock();
        Set<Entry<K, V>> entrySet = map.entrySet();
        lock.unlock();
        return entrySet;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");

        lock.lock();
        for (var entry : entrySet()) {
            res.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append(", ");
        }
        lock.unlock();

        res.delete(res.length() - 2, res.length())
                .append("}");
        return res.toString();
    }

    public static void main(String[] args) {
        LockMap<Integer, Integer> map = new LockMap<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                map.put(i, i * i);
            }
            for (int i = 0; i < 10; i++) {
                map.remove(i * 2);
            }
            System.out.println(map);
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                map.put(i, i * 100);
            }
            for (int i = 0; i < 9; i++) {
                map.remove(i * i);
            }
            System.out.println(map);
        });

        thread1.start();
        thread2.start();
    }
}
