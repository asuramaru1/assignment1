package assign1;

import java.util.*;

public class Appearances {

	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	private static <T> void countELems(Collection<T> a  , HashMap< T, Integer> map){
		Iterator<T> iterator = a.iterator();

		while (iterator.hasNext()) {
			T tmp = iterator.next();
			if(map.containsKey(tmp)){
				map.put(tmp , map.get(tmp)+1);
			}else{
				map.put(tmp,1);
			}
		}
	}
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		HashMap< T, Integer> map1 = new HashMap<T, Integer>();
		HashMap< T, Integer> map2 = new HashMap<T, Integer>();
		countELems(a,map1);
		countELems(b,map2);
		int result = 0 ;
		for ( T tmp : map1.keySet()){
			if(map2.containsKey(tmp))
				result += (map2.get(tmp).intValue() == map1.get(tmp).intValue()) ? 1 : 0;
		}
		return result;

	}

}