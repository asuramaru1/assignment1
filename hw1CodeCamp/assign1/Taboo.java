/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/
package assign1;

import java.util.*;

public class Taboo<T> {
	private HashMap<T  , HashSet<T> > map;
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		map = new HashMap<>();
		for(int i = 0 ; i<rules.size()-1 ; i++){
			if(rules.get(i)!=null && rules.get(i+1)!=null){
				if(map.containsKey(rules.get(i))){
					map.get(rules.get(i)).add(rules.get(i+1));
				}else{
					HashSet<T>  set = new HashSet<>();
					set.add(rules.get(i+1));
					map.put(rules.get(i) , set);
				}
			}

		} 
	}

	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		Set<T> result = new HashSet<>() ;
		if(map.containsKey(elem)) {
			for (T tmp : map.get(elem)) {
				result.add(tmp);
			}
			return result;
		}else{
			return Collections.emptySet();
		}

	}

	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		int i = 0 ;
		while(i<list.size()-1){
			if(list.get(i)!=null && list.get(i+1)!=null && map.containsKey(list.get(i))) {
				if (map.get(list.get(i)).contains(list.get(i + 1))) {
					list.remove(i + 1);

				}else{
					i++;
				}
			}else{
				i++;
			}
		}

	}
}