public class MyArrayList {
    private Cow[] elems;
	private int size;

	public MyArrayList() {
		elems = (Cow[]) new Object[10];
		size = 0;
	}

	public MyArrayList(int capacity) {
		elems = (Cow[]) new Object[capacity];
		size = 0;
	}

	public void add(Cow c) {
		if (size >= elems.length){
			Cow[] bigger = (Cow[]) new Object[elems.length * 2];
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
