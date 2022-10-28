// Author name - Sambhav Kapoor

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Urinals {

    static int number=0;
    public static boolean checkValidString(String s) {
        if(s.length() > 20 || s.length()<1 || s.contains("11")) {
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

    public static List<String> readStringsFromFile(String filename) throws Exception {
        List<String> inputList = new ArrayList<>();
        String currentPath = new java.io.File(".").getCanonicalPath();
        File file = new File(currentPath, filename);
        Scanner myReader = new Scanner(file);
        int count=0;
        while (myReader.hasNextLine() ) {
            count+=1;
            String s = myReader.nextLine();
            if(s.equals("-1")){
                break;
            }
            inputList.add(s);
        }
        if(count==0){
            throw new Exception("Empty File Exception");
        }
        myReader.close();
        return inputList;
    }

    public static void writeToFile(List<Integer> outputs, String currentPath, String filename) throws Exception {
        if(!filename.equals("rule.txt")){
            throw new Exception("Bad Filename");
        }
        File file = new File(currentPath, filename);
        while(file.exists()) {
            filename = "rule" + (++number) +".txt";
            file = new File(currentPath, filename);
        }
        FileWriter fr = null;
        fr = new FileWriter(file);
        for(int i=0;i<outputs.size();i++){
            fr.write(String.valueOf(outputs.get(i)));
            fr.write("\n");
        }
        fr.close();
    }
    public static void main(String[] args) throws Exception {
            System.out.println("Press 1 for keyboard input, 2 for file and 3 for exit");
            Scanner scn =new Scanner(System.in);
            String s = scn.nextLine();
            switch (s){
                case "1":
                    System.out.println("Enter multiple inputs, enter -1 to stop");
                    ArrayList<String> keyboardInputs = new ArrayList<>();
                    while (scn.hasNextLine())
                    {
                        String  keyboardInput = scn.nextLine();
                        if(keyboardInput.equals("-1")){
                            break;
                        }
                        keyboardInputs.add(keyboardInput);
                    }

                    scn.close();
                    for(String j : keyboardInputs){
                        System.out.println(countFreeUrinals(j));
                    }
                    break;
                case "2":
                    System.out.println("Using the urinal.dat file for input");
                    List<String> inputs=readStringsFromFile("urinal.dat");
                    List<Integer> outputs= new ArrayList<>();
                    for(String input: inputs){
                        if(!checkValidString(input)){
                            outputs.add(-1);
                        }else{
                            outputs.add(countFreeUrinals(input));
                        }
                    }
                    String currentPath = new java.io.File(".").getCanonicalPath();
                    writeToFile(outputs, currentPath, "rule.txt");
                    break;
                default:
                    System.out.println("Selected a wrong option");
            }
    }
}