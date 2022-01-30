
public class Datas<E> {
	private E item;
	private int count;
	
	public Datas(E item) {
		this.setItem(item);
		setCount(1);
	}

	public E getItem() {
		return item;
	}

	public void setItem(E item) {
		this.item = item;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public void increase() {
		
		this.count++;
	
	}
	public void decrease() {
		this.count--;
	}
	
	
}
