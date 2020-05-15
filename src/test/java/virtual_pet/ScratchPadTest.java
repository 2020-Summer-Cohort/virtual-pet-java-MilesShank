package virtual_pet;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScratchPadTest {
    @Test
    public void oneIsEqualToOne() {
        //action
        int result = addNumbers(1,1);
        //arrange - setup for the unit test
        //action
        assertEquals(2, result); //assertion
    }


    @Test
    public int addNumbers(int baseNumber, int numberToAdd){
           int result = baseNumber + numberToAdd; //action
        return result;
    }
}

