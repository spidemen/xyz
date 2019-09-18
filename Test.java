package DiDi;

import java.util.List;
import DiDi.wordAnagram;

import java.io.IOException;
import java.util.*;
import java.util.ArrayList;

public class Test {
	public wordAnagram instance = new wordAnagram();

	public boolean test(String input, HashSet<String> expect) {
		List<String> output = instance.Anagram(input);

		for (String s : output) {

			if (!expect.contains(s)) {
				System.out.println("Test  Fail, output: " + s + " do not exit in expect word anagrams ");
				return false;
			}
		}
		return true;
	}

	public void makeTest() throws Exception {
		// test case 1
		String input = "a";
		instance.set.add("a");
		HashSet<String> expect = new HashSet<String>();
		expect.add(" a");
		if (this.test(input, expect)) {
			System.out.println("Test 1 Pass ");
		} else {
			System.out.println("Test 1 Fail ");
		}
		// test case 2
		instance.set.add("word");
		instance.set.add("Test");
		input = "wrodTste";
		expect.clear();
		expect.add(" word Test");
		expect.add(" Test word");
		if (this.test(input, expect)) {
			System.out.println("Test 2 Pass ");
		} else {
			System.out.println("Test 2 Fail ");
		}
		// test case 3:
		input = "basue";  // from text.txt file
		expect.clear();
		expect.add(" abuse");
		if (this.test(input, expect)) {
			System.out.println("Test 3 Pass ");
		} else {
			System.out.println("Test 3 Fail ");
		}
		// test case 3:

		// instance.outputAll("../test.txt");

	}

	public static void main(String[] args) throws Exception {
		new Test().makeTest();

	}

}
