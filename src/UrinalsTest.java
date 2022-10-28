import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class UrinalsTest {

    @Test
    void testCheckValidString1()
    {
        Assertions.assertEquals( false ,
                Urinals.checkValidString("====== Sambhav Kapoor == TEST ONE EXECUTED ======="));
        System.out.println("====== Sambhav Kapoor == TEST ONE EXECUTED =======");
    }
    @Test
    void testCheckValidString2()
    {
        Assertions.assertEquals( true , Urinals.checkValidString("10101"));
        System.out.println("====== Sambhav Kapoor == TEST TWO EXECUTED =======");
    }
    @Test
    void testCheckValidString3()
    {
        Assertions.assertEquals( false , Urinals.checkValidString("011"));
        System.out.println("====== Sambhav Kapoor == TEST THREE EXECUTED =======");
    }

    @Test
    void countFreeUrinals1()
    {
        Assertions.assertEquals( -1 , Urinals.countFreeUrinals("abcd"));
        System.out.println("====== Sambhav Kapoor == TEST FOUR EXECUTED =======");
    }

    @Test
    void countFreeUrinals2()
    {
        Assertions.assertEquals( 1 , Urinals.countFreeUrinals("0"));
        System.out.println("====== Sambhav Kapoor == TEST FIVE EXECUTED =======");
    }

    @Test
    void countFreeUrinals3()
    {
        Assertions.assertEquals( 2 , Urinals.countFreeUrinals("00001"));
        System.out.println("====== Sambhav Kapoor == TEST SIX EXECUTED =======");
    }

    @Test
    void readStringsFromFileNotFoundException(){
        Assertions.assertThrows(FileNotFoundException.class
                , () -> Urinals.readStringsFromFile("gibberish.dat"));
        System.out.println("====== Sambhav Kapoor == TEST SEVEN EXECUTED =======");
    }
}
