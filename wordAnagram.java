package DiDi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class wordAnagram {

	public HashSet<String> set = new HashSet<String>(); // hash set to store whole dictionary
	public HashSet<String> out = new HashSet<String>(); // store output word

	public void outputAll(String file) throws IOException { // handle input dictionary
		// Open the file
		FileInputStream fstream = null;
		fstream = new FileInputStream("oupt.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			set.add(strLine);
		}
		// Close the input output stream
		fstream.close();
	}

	public List<String> Anagram(String input) { // first find all possible permutation, then check each one
												// find the permutation containing words from dictionary
		char[] nums = input.toCharArray();
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		boolean[] used = new boolean[nums.length];
		List<Character> list = new ArrayList<Character>();
		Arrays.sort(nums);
		backtrack(nums, used, list, res, 0, "");
		return res;
	}

	public String listToString(List<Character> list, int startIndex, int endIndex) { // convert list character into
																						// string
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			if (i >= startIndex && i <= endIndex)
				sb.append(list.get(i));
		}
		return sb.toString();
	}

	public void backtrack(char[] nums, boolean[] used, List<Character> list, List<String> res, int currentIndex,
			String word) {
		String tmp = word;
		int startIndex = tmp.replaceAll(" ", "").length();
		if (set.contains(this.listToString(list, startIndex, currentIndex))) { // 1. check exit or not and then get word
																				// from dictionary
			word += " " + this.listToString(list, startIndex, currentIndex);
		}
		if (list.size() == nums.length) {
			tmp = word; // get update word
			String[] splitword = tmp.split(" ");
			int count = 0;
			for (int i = 0; i < splitword.length; i++) // remove duplicate combine word like test me vs me test, is the
														// same
			{
				if (out.contains(splitword[i]))
					count++;
				else
					out.add(splitword[i]);
			}
			startIndex = tmp.replaceAll(" ", "").length(); // get length
			if (startIndex >= nums.length - 1 && count < splitword.length) {
				res.add(word);
			}
			word = ""; // reset
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i])
				continue; // if used, then continue, not store same anagram twice
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
				continue; // remote dulipcate
			used[i] = true;
			list.add(nums[i]);
			backtrack(nums, used, list, res, currentIndex + 1, word);
			list.remove(list.size() - 1);
			used[i] = false;
		}

	}

	public void testHashSet() {
		set.add("tile");
		set.add("me");
		set.add("seem");
		set.add("test");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "tlieemstte";
		System.out.println("Input   " + input + "   output:  ");
		wordAnagram wordAnagram = new wordAnagram();
		wordAnagram.testHashSet();
		List<String> output = wordAnagram.Anagram(input);
		for (String s : output) {
			System.out.println(s);
		}

	}
}
