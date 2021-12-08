package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    void parseT(String[] args, MoveDirection[] correct){
        MoveDirection[] tested = new OptionsParser(args).parse();

        assertEquals(tested.length, correct.length);

        for(int i=0;i<tested.length;i++) {
            assertEquals(tested[i], correct[i]);
        }
    }

    @Test
    void parseTest(){
        parseT(new String[]{"f", "b", "l", "r"}, new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT});
        parseT(new String[]{}, new MoveDirection[]{});
        parseT(new String[]{"forward", "backward", "left", "right"}, new MoveDirection[]{MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.RIGHT});
        parseT(new String[]{"", "k", "p"}, new MoveDirection[]{});

        parseT(new String[]{"f", "g", "", "backward", "r"}, new MoveDirection[]{MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.RIGHT});
    }

}
