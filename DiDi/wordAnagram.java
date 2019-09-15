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
	  
	  public void outputAll(String file) throws IOException {
		// Open the file
		  FileInputStream fstream = null;
		  fstream = new FileInputStream("textfile.txt");
		  BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		  String strLine;
		  FileWriter f0 = new FileWriter("output.txt");  // output file
		  //Read File Line By Line
		  while ((strLine = br.readLine()) != null)   {
		    // Print the content on the console
			List<String> singleAnagrams=this.Anagram(strLine);
			for(String s: singleAnagrams) {
				f0.append("\t"+s);
			}  
			f0.append("\n");
		  }
		  //Close the input output stream
		  fstream.close();
		  f0.close();
	  }
	  public List<String> Anagram(String input) {
		   char[] nums=input.toCharArray();
	        List<String> res = new ArrayList<>();
	        if(nums==null || nums.length==0) return res;
	        boolean[] used = new boolean[nums.length];
	        List<Character> list = new ArrayList<Character>();
	        Arrays.sort(nums);
	        backtrack(nums, used, list, res);
	        return res;
	 }
	public void backtrack(char [] nums,boolean [] used, List<Character> list, List<String > res){
         if(list.size()==nums.length){
             StringBuilder sb = new StringBuilder();
             for (char s : list)
             {
                 sb.append(s);
             }
             res.add(sb.toString());
             return ;
         }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;   // if used, then continue, not store same anagram twice
           if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;   // remote dulipcate
            used[i]=true;
            list.add(nums[i]);
            backtrack(nums,used,list,res);
            list.remove(list.size()-1);
            used[i]=false;
        }
   }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="aA";
		List<String> output=new wordAnagram().Anagram(input);
		for(String s: output) {
			System.out.println(s);
		}
		System.out.println("Hello world!  word Anagram ");
	}
}
