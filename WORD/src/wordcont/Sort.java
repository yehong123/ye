package wordcont;

import wordcont.Sort;

public class Sort implements Comparable<Sort>{
	@Override
	public int compareTo(Sort o) {
		int cmp = count.intValue() - o.count.intValue();
		return (cmp == 0 ? key.compareTo(o.key) : -cmp);
	}

	
	private String key;
	private Integer count;

	public Sort ( String key,Integer count) {
		this.key = key;
		this.count = count;
	}

	public Sort(){

	}

	@Override
	public String toString() {
		return key + " 出现的次数为：" + count;
	}

	public String getKey() {
		return key;
	}

	public Integer getCount() {
		return count;
	}
}

