import java.util.*;

/**
 * Implementation of a HashMap using a collection of MyLinearMap and
 * resizing when there are too many or too few entries.
 *
 * @author downey
 * @param <K>
 * @param <V>
 *
 */
public class MyHashMap<K, V> implements Map<K, V> {

	// average number of entries per map before we grow the map
	private static final double ALPHA = 1.0;
	// average number of entries per map before we shrink the map
	private static final double BETA = .25;

	// resizing factor: (new size) = (old size) * (resize factor)
	private static final double SHRINK_FACTOR = 0.5, GROWTH_FACTOR = 2.0;

	private static final int MIN_MAPS = 16;

	// list of maps
	protected List<MyLinearMap<K,V>> maps;
	private int size = 0;

	public MyHashMap() {
		makeMaps(MIN_MAPS);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Initialize maps
	 */
	protected void makeMaps(int size) {
		maps = new ArrayList<MyLinearMap<K,V>>(size);
		for (int i=0; i<size; i++){
			maps.add(new MyLinearMap<K, V>());
		}
	}

	protected MyLinearMap<K, V> chooseMap(Object key) {
		/*if key is null, chose sub-map w/ index = 0, otherwise it
		uses key.hashcode to get an integer and applies it to maps.size
		to make sure it stays w/in 0 and size*/
		int index = key == null ? 0: key.hashCode() % maps.size();
		return maps.get(index);
	}

	@Override
	public boolean containsKey(Object key) {
		MyLinearMap<K,V> map = chooseMap(key);
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {

	}

	protected void rehash(double growthFactor) {
		// TODO: Implement this method
	}

	@Override
	public V get(Object key) {
		MyLinearMap<K,V> map = chooseMap(key);
		return map.get(key);
	}

	@Override
	public V put(K key, V value) {
		V oldValue = put(key, value);
		//check if there are too many submaps
		if (size() > maps.size()*ALPHA){
			rehash(ALPHA);
		}
		return oldValue;
	}

	@Override
	public V remove(Object key) {
		MyLinearMap<K,V> map = chooseMap(key);

	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	public void clear() {
		for (int i=0; i<maps.size(); i++) {
			maps.get(i).clear();
		}
		size = 0;
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<>();
		for (MyLinearMap<K,V> map : maps) {
			set.addAll(map.keySet());
		}
		return set;
	}

	@Override
	public Collection<V> values() {
		Collection<V> ll = new LinkedList<>();
		for (MyLinearMap<K,V> map : maps) {
			ll.addAll(map.values());
		}
		return ll;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K,V>> set = new HashSet<>();
		for (MyLinearMap<K,V> map : maps) {
			set.addAll(map.getEntries());
		}
		return set;
	}
}
