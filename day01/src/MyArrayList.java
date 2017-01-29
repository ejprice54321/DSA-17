public class MyArrayList {
    private Cow[] elems;
	private int size;

	public MyArrayList() {
		elems = new Cow[10];
		size = 0;
	}

	public MyArrayList(int capacity) {
		elems = new Cow[capacity];
		size = 0;
	}

	public void add(Cow c) {
		if (size >= elems.length){
			Cow[] bigger = new Cow[elems.length * 2];
			System.arraycopy(elems, 0, bigger, 0, elems.length);
			elems = bigger;
		}
		elems[size] = c;
		size++;
	}

	public int size() {
		return this.size;
	}

	public Cow get(int index) {
		if(index<0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		return elems[index];
	}

	public Cow remove(int index) {
		if (size <= elems.length / 4){
			Cow[] smaller = new Cow[elems.length / 2];
			System.arraycopy(elems, 0, smaller, 0, elems.length);
			elems = smaller;
		}
		Cow c = get(index);
		for (int i = index; i < size-1; i++){
			elems[i] = elems[i+1];
		}
		size--;
		return c;
	}

	public void add(int index, Cow c) {
		if (index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		}
		add(c);
		for (int i = size-1; i > index; i--){
			elems[i] = elems[i-1];
		}
		elems[index] = c;
	}
}
