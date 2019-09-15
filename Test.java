package DiDi;
import java.util.List;
import DiDi.wordAnagram;

import java.io.IOException;
import java.util.*; 
import java.util.ArrayList;
public class Test {
    public wordAnagram instance=new wordAnagram();
    public boolean test(String input, HashSet<String> expect) {
    	     List<String> output=instance.Anagram(input);
    	     if(output.size()!=expect.size()) {
    	    	    System.out.println("Test  Fail, size not equal to expect size");
    	    	    return false;
    	     }
    	     for(String s: output) {
    	    	     if(!expect.contains(s)) {
    	    	    	  System.out.println("Test  Fail, output: "+s+" do not exit in expect word anagrams ");
    	    	    	    return false;
    	    	     }
    	     }
    	     return true;
    }
    public void makeTest() throws Exception {
    	    // test case 1
    	     String input="a";
   	     HashSet<String> expect=new HashSet<String>();
   	     expect.add("a");
   	     if(this.test(input, expect)) {
   	        System.out.println("Test 1 Pass ");
   	     } else {
   	         System.out.println("Test 1 Fail ");
   	     }
   	     // test case 2
 
   	     input="aA";
	     expect.clear();
	     expect.add("aA");
	     expect.add("Aa");
	     if(this.test(input, expect)) {
	        System.out.println("Test 2 Pass ");
	     } else {
	         System.out.println("Test 2 Fail ");
	     }
	     // test case 3
	     input="abc";
   	     expect.clear();
   	     expect.add("abc");
   	     expect.add("acb");
   	     expect.add("bac");
	     expect.add("bca");
	     expect.add("cab");
	     expect.add("cba");
   	     if(this.test(input, expect)) {
 	        System.out.println("Test 3 Pass ");
 	     } else {
 	         System.out.println("Test 3 Fail ");
 	     }
   	     
   	    instance.outputAll("test.txt");
    	
    }
    
	public static void main(String[] args) throws Exception {
		   new Test().makeTest();
		 
    }
	
}
