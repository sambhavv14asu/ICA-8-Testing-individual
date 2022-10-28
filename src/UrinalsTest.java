import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
