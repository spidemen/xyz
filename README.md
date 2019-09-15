# xyz
didi OA

## get test data from webpage  Node.JS ##
1.  make sure you have install node  
2.  npm install  
3.  node index  
4.  check execution directory test.txt file  

##  main programm word   JAVA ##
1. make sure install java SDK, JVM  
2. in the runme.sh script, just run execute java file   
   first one is the main program which handle all word anagram  
   second one is the 3 testcase, just test the programm work correctly or not  
   Command:   
     java  DiDi.Test  -f false  
    false: mean do not generate output file , which means do not generate all the word anagrams from test.txt  
    since this is really huge really a lot of time to run it..
## test file ##
  Test.java is mostly three testcase
   input : a  --> a
           aA-->aA  Aa
           abc-->abc  acb  bac  bca  cab  cba

## something need to know if run on codepade.io ##
 1.  copy past code from wordAnagram.java  
 2. line 13 " public class wordAnagram { "  change it into   
      " class wordAnagram { "  , just remove public  
3.   line 70:  " 	List<String> output=new wordAnagram().Anagram(input); " change into :  
        List<String> output=new Solution().Anagram(input);  

Finally, if there is any question, contact me: xingyuan15@gmail.com  
