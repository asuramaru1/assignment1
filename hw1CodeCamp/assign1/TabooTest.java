// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class TabooTest {
    private List<String> stringToList(String s) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++)
            list.add(String.valueOf(s.charAt(i)));
        return list;
    }
    private HashSet<String> stringToSet(String s) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++)
            set.add(String.valueOf(s.charAt(i)));
        return set;
    }

    @Test
    public void NoFollowTest1(){
        List<String> testList = stringToList("abacadadcd");
        HashSet<String> a = stringToSet("bcd");
        HashSet<String> b = stringToSet("a");
        HashSet<String> c = stringToSet("ad");
        HashSet<String> emptySet= stringToSet("");

        Taboo<String> t = new Taboo<>(testList);

        assertEquals(emptySet,t.noFollow("brr"));
        assertEquals(a,t.noFollow("a"));
        assertEquals(b,t.noFollow("b"));
        assertEquals(c,t.noFollow("c"));

    }
    @Test
    public void NoFollowTest2(){
        List<String> testList = stringToList("");
        List<String> testList2 = stringToList("ab");

        HashSet<String> a = stringToSet("");
        HashSet<String> b = stringToSet("b");

        Taboo<String> t1 = new Taboo<>(testList);
        Taboo<String> t2 = new Taboo<>(testList2);

        assertEquals(a,t1.noFollow("a"));
        assertEquals(b,t2.noFollow("a"));
        assertEquals(a,t2.noFollow("b"));
    }
    @Test
    public void NoFollowTest3(){
        List<Integer> test = Arrays.asList(1, 2, 1, 3, 1, 4, 1,1 , 4,1);
        Set<Integer> test1 = new HashSet<>(Arrays.asList(1,2,3,4));
        Set<Integer> test4 = new HashSet<>(Arrays.asList(1));

        Taboo<Integer> t1 = new Taboo<>(test);
        assertEquals(test1 , t1.noFollow(1));
        assertEquals(test4 , t1.noFollow(4));


    }
    @Test
    public void reduceTest1(){
        List<String> testList = stringToList("acab");
        List<String> beforeList =stringToList("acbxca");
        List<String> afterList = stringToList("axc");

        Taboo<String> t = new Taboo<>(testList);
        t.reduce(beforeList);
        assertEquals(afterList , beforeList);

    }
    @Test
    public void reduceTEst2(){
        //check if works with nulls
        List<Integer> testList = Arrays.asList(null , 1 , 2 ,null , 3 , 4 , null , null);
        List<Integer> testList2 = Collections.emptyList();
        Taboo<Integer> t1 = new Taboo<>(testList);
        Taboo<Integer> t2 = new Taboo<>(testList2);
        List<Integer> test11 = new ArrayList<Integer>(Arrays.asList(1 , 2 , 6 , 2 , 3 , 5 ,3 , 4));

        t2.reduce(test11);
        assertEquals(test11 , Arrays.asList(1 , 2 , 6 , 2 , 3 , 5 ,3 , 4));

        t1.reduce(test11);
        assertEquals(test11 , Arrays.asList(1 , 6 ,2 ,3 ,5 , 3 ));

    }

}