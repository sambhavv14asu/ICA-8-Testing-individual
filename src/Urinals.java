// Author name - Sambhav Kapoor

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Urinals {

    public static boolean checkValidString(String s) {
        if(s.contains("11")) {
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0' && s.charAt(i)!='1'){
                return false;
            }
        }
        return true;
    }

    public static int countFreeUrinals(String s) {
        if(!checkValidString(s)){
            return -1;
        }
        StringBuilder sb = new StringBuilder(s);
        int count=0;
        if(s.length() == 1){
            if(s.charAt(0) == '0'){
                return 1;
            }else{
                return 0;
            }
        }
        for(int i=0;i<sb.length();i++){
            char c = sb.charAt(i);
            if(c=='0') {
                if (i == 0 && sb.charAt(i + 1) == '0') {
                    sb.setCharAt(i, '1');
                    count += 1;
                } else if (i == sb.length() - 1 && sb.charAt(i - 1) == '0') {
                    sb.setCharAt(i, '1');
                    count += 1;
                } else if(i>0 && i<sb.length()-1){
                    if(sb.charAt(i-1) == '0' && sb.charAt(i+1) == '0'){
                        sb.setCharAt(i, '1');
                        count+=1;
                    }
                }
            }

        }
        return count;
    }

    public static List<String> readStringsFromFile(String filename) throws IOException, FileNotFoundException {
        List<String> inputList = new ArrayList<>();
        String currentPath = new java.io.File(".").getCanonicalPath();
        File file = new File(currentPath, filename);
        Scanner myReader = new Scanner(file);
        return inputList;
    }
    public static void main(String[] args) throws IOException {

    }
}