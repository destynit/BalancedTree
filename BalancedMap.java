/**
 * Program 2
 * CS310-01
 * November 2, 2018
 * @ Destyni Ta @ Christina Tran
 */

package edu.sdsu.cs.datastructures;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class BalancedMap<K extends Comparable<K>, V> implements IMap<K, V> {
    Map<K, V> contents;

    // @param <K> The object type to use as the Key
    // @param <V> The generic object type to use as Values

    //The default constructor takes no parameters and initializes
    //the data structure to an empty state.
    public BalancedMap() {
        contents = new TreeMap<K, V>();
    }

    //The copy constructor takes an IMap as its single parameter and initializes
    //the new data structure with each of the entries in the parameter object.
    public BalancedMap(IMap<K, V> map) {

        contents = new TreeMap<K, V>();
        //Iterates through the keys and values
        Iterator<K> kIter = map.keyset().iterator();
        Iterator<V> vIter = map.values().iterator();
        //Associates the specified value with the specified key in this map
        while ((kIter.hasNext()) && (vIter.hasNext())) {
            contents.put(kIter.next(), vIter.next());
        }
    }

    /**
     * Indicates if the map contains the object identified by the key inside.
     *
     * @param key
     *            The object to compare against
     * @return true if the parameter object appears in the structure
     */

    @Override
    public boolean contains(K key) {
        return contents.containsKey(key);
    }

    /**
     * Adds the given key/value pair to the dictionary.
     *
     * @param key
     * @param value
     * @return false if the dictionary is full, or if the key is a duplicate.
     *         Returns true if addition succeeded.
     */

    @Override
    public boolean add(K key, V value) {

        if (contains(key)) {
            return false;
        }
        else {
            contents.put(key, value);
        }
        return true;
    }

    /**
     * Deletes the key/value pair identified by the key parameter.
     *
     * @param key
     * @return The previous value associated with the deleted key or null if not
     *         present.
     */

    @Override
    public V delete(K key) {
        if (contains(key)) {
            V variable = contents.get(key);
            contents.remove(key);
            return variable;
        }
        else {
            return null;
        }

    }

    /**
     * Retrieves, but does not remove, the value associated with the provided key.
     *
     * @param key
     *            The key to identify within the map.
     * @return The value associated with the indicated key.
     */

    @Override
    public V getValue(K key) {
        return contents.get(key);
    }

    /**
     * Returns a key in the map associated with the provided value.
     * @param value The value to find within the map.
     * @return The first key found associated with the indicated value.
     */

    @Override
    public K getKey(V value) {
        Iterator<K> kIter = contents.keySet().iterator();
        Iterator<V> vIter = contents.values().iterator();

        while (kIter.hasNext() && vIter.hasNext()) {
            if (((Comparable<V>) vIter.next()).compareTo(value) == 0) {
                return kIter.next();
            }
            else {
                kIter.next();
            }
        }
        return null;
    }


    /**
     * Returns all keys associated with the indicated value contained within the
     * map.
     * @param value The value to locate within the map.
     * @return An iterable object containing all keys associated with the
     * provided value.
     */

    @Override
    public Iterable<K> getKeys(V value) {

        LinkedList<K> list = new LinkedList<K>();
        Iterator<K> kIter = contents.keySet().iterator();

        while (kIter.hasNext()) {
            K currentKey = kIter.next();
            V currentValue = getValue(currentKey);

            if (((Comparable<V>) currentValue).compareTo(value) == 0)
                list.add(currentKey);
        }
        return list;
    }


    /**
     * Indicates the count of key/value entries stored inside the map.
     *
     * @return A non-negative number representing the number of entries.
     */

    @Override
    public int size() {
        return contents.size();
    }

    /**
     * Indicates if the dictionary contains any items.
     *
     * @return true if the dictionary is empty, false otherwise.
     */

    @Override
    public boolean isEmpty() {
        return contents.isEmpty();
    }

    /***
     * Returns the map to an empty state ready to accept new entries.
     */

    @Override
    public void clear() {
        contents.clear();
    }

    /**
     * Provides an Iterable object of the keys in the dictionary.
     * <p>
     * The keys provided by this method must appear in their natural, ascending,
     * order.
     *
     * @return An iterable set of keys.
     */

    @Override
    public Iterable<K> keyset() {
        return contents.keySet();
    }

    /**
     * Provides an Iterable object of the keys in the dictionary.
     * <p>
     * The values provided by this method must appear in an order matching the
     * keyset() method. This object may include duplicates if the data structure
     * includes duplicate values.
     *
     * @return An iterable object of all the dictionary's values.
     */

    @Override
    public Iterable<V> values() {
        return contents.values();
    }

}


