import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UrinalsTest {

    @Test
    void testCheckValidString1()
    {
        assertEquals( false ,
                Urinals.checkValidString("====== Sambhav Kapoor == TEST ONE EXECUTED ======="));
        System.out.println("====== Sambhav Kapoor == TEST ONE EXECUTED =======");
    }
    @Test
    void testCheckValidString2()
    {
        assertEquals( true , Urinals.checkValidString("10101"));
        System.out.println("====== Sambhav Kapoor == TEST TWO EXECUTED =======");
    }
    @Test
    void testCheckValidString3()
    {
        assertEquals( false , Urinals.checkValidString("011"));
        System.out.println("====== Sambhav Kapoor == TEST THREE EXECUTED =======");
    }

    @Test
    void countFreeUrinals1()
    {
        assertEquals( -1 , Urinals.countFreeUrinals("abcd"));
        System.out.println("====== Sambhav Kapoor == TEST FOUR EXECUTED =======");
    }

    @Test
    void countFreeUrinals2()
    {
        assertEquals( 1 , Urinals.countFreeUrinals("0"));
        System.out.println("====== Sambhav Kapoor == TEST FIVE EXECUTED =======");
    }

    @Test
    void countFreeUrinals3()
    {
        assertEquals( 2 , Urinals.countFreeUrinals("00001"));
        System.out.println("====== Sambhav Kapoor == TEST SIX EXECUTED =======");
    }

    @Test
    void readStringsFromFileNotFoundException(){
        Assertions.assertThrows(FileNotFoundException.class
                , () -> Urinals.readStringsFromFile("gibberish.dat"));
        System.out.println("====== Sambhav Kapoor == TEST SEVEN EXECUTED =======");
    }

    @Test
    void readStringsFromFileEmptyFileException(){
        Exception exception = Assertions.assertThrows(Exception.class
                , () -> Urinals.readStringsFromFile("TestEmptyFile.dat"));
        assertEquals("Empty File Exception", exception.getMessage());
        System.out.println("====== Sambhav Kapoor == TEST EIGHT EXECUTED =======");
    }

    @Test
    void readStringsFromFileIOException(){
        Assertions.assertThrows(IOException.class
                , () -> Urinals.readStringsFromFile("ioException.dat"));
        System.out.println("====== Sambhav Kapoor == TEST NINE EXECUTED =======");
    }

    @Test
    void writeToFileBadFilenameException(){
        Exception exception = Assertions.assertThrows(Exception.class
                , () -> Urinals.writeToFile(new ArrayList<>(), "badname.file"));
        assertEquals("Bad Filename", exception.getMessage());
        System.out.println("====== Sambhav Kapoor == TEST TEN EXECUTED =======");
    }

    //Even if we pass rule.txt multiple times, it would create filename by incrementing the number
    @Test
    void writeToFileDuplicateName() throws Exception {
        ArrayList<Integer> one = new ArrayList();
        one.add(1);
        one.add(2);
        ArrayList<Integer> two = new ArrayList();
        two.add(3);
        two.add(4);
        Urinals.writeToFile(one, "rule.txt");
        Urinals.writeToFile(two, "rule.txt");
        String currentPath = new java.io.File(".").getCanonicalPath();
        File file1 = new File(currentPath, "rule" + (Urinals.number) +".txt");
        File file2 = new File(currentPath, "rule" + (++Urinals.number-1) +".txt");
        Assertions.assertTrue(file1.exists());
        Assertions.assertTrue(file2.exists());
    }

}
