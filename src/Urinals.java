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

        return count;
    }

    public static void main(String[] args) throws IOException {


    }
}