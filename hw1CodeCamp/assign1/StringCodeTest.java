// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringCodeTest {
	//
	// blowup
	//
	@Test
	public void testBlowup1() {
		// basic cases
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}

	@Test
	public void testBlowup2() {
		// things with digits

		// digit at end
		assertEquals("axxx", StringCode.blowup("a2x3"));

		// digits next to each other
		assertEquals("a33111", StringCode.blowup("a231"));

		// try a 0
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}

	@Test
	public void testBlowup3() {
		// weird chars, empty string
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));

		// string with only digits
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
	}
	@Test
	public void testBlowup4() {
		// weird chars, empty string
		assertEquals("   ", StringCode.blowup("   "));
		assertEquals("-", StringCode.blowup("-1"));

		// string with only digits
		assertEquals("1111111111", StringCode.blowup("911"));
		assertEquals("b", StringCode.blowup("b"));
		assertEquals("b", StringCode.blowup("b1"));

	}
	@Test
	public void testBlowup5() {
		// all 1
		assertEquals("111", StringCode.blowup("1111"));
	}



	//
	// maxRun
	//
	@Test
	public void testRun1() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}

	@Test
	public void testRun2() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
	}

	@Test
	public void testRun3() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}
	@Test
	public void testRun4() {
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(6, StringCode.maxRun("aaaaaa"));
		assertEquals(1, StringCode.maxRun("babababababa"));
		assertEquals(2, StringCode.maxRun("^$$@&%"));
	}
	@Test
	public void testClass() {
		StringCode v = new StringCode();
		assertEquals(0, v.maxRun(""));
		assertEquals(6, v.maxRun("aaaaaa"));
		assertEquals(1, v.maxRun("babababababa"));
		assertEquals(2, v.maxRun("^$$@&%"));
	}

	@Test
	public void testIntersect1(){

		assertEquals(true , StringCode.stringIntersect("abcd" , "bc" , 2));
		assertEquals(false , StringCode.stringIntersect("abcd" , "bc" , 3));
		assertEquals(true , StringCode.stringIntersect("aabcd" , "bcd" , 3));
		assertEquals(false , StringCode.stringIntersect("aaaaaaaa" , "aa" , 3));

	}
	@Test
	public void testIntersect2(){
		//len> s.length
		assertEquals(false , StringCode.stringIntersect("abc" , "abc" , 100));
		assertEquals(false , StringCode.stringIntersect("abc" , "abc" , 4));
	}
	@Test
	public void testIntersect3(){
		//same strings
		assertEquals(true , StringCode.stringIntersect("abcde" , "abcde" , 1));
		assertEquals(true , StringCode.stringIntersect("abcde" , "abcde" , 2));
		assertEquals(true , StringCode.stringIntersect("abcde" , "abcde" , 3));
		assertEquals(true , StringCode.stringIntersect("abcde" , "abcde" , 4));
		assertEquals(true , StringCode.stringIntersect("abcde" , "abcde" , 5));

	}
	@Test
	public void testIntersect4(){
		// empty string
		assertEquals(false , StringCode.stringIntersect("" , "a" , 1));
		assertEquals(false , StringCode.stringIntersect("aa" , "" , 2));
		assertEquals(false , StringCode.stringIntersect("" , "" , 3));
	}
	@Test
	public void testIntersect5(){
		//intersections on edges
		assertEquals(true , StringCode.stringIntersect("ABCqwerty" , "ploABC" , 3));
		assertEquals(false , StringCode.stringIntersect("ABCcvbcvbcvb" , "zxcasdABC" , 4));
		assertEquals(true , StringCode.stringIntersect("!@#$#@$@#!@%^&^%&%^" , "!@#$@#" , 1));
	}

}