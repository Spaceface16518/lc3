package lc3.arch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {
    private Program program;

    @BeforeEach
    void setUp() {
        program = new Program(Arrays.asList((short) 0b0001000000100011, (short) 0b0001001000100001));
    }

    @Test
    @DisplayName("Iterator test")
    void IteratorTest() {
        Iterator<Short> iterator = program.iterator();
        assertTrue(iterator.hasNext());
        assertEquals((short) 0b0001000000100011, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals((short) 0b0001001000100001, iterator.next());
    }

    @Test
    @DisplayName("GetBytecode test")
    void GetBytecodeTest() {
        assertEquals(program.bytecode, program.getBytecode());
    }

    @Test
    @DisplayName("SetBytecode test")
    void SetBytecodeTest() {
        List<Short> l = Arrays.asList((short) 0b0001001000100001, (short) 0b0001000000100011); // Same thing, just flipped
        program.setBytecode(l);
        assertEquals(l, program.bytecode);
    }

    @Test
    @DisplayName("Equals1 test")
    void Equals1Test() {
        List<Short> l = Arrays.asList((short) 0b0001001000100001, (short) 0b0001000000100011); // Same thing, just flipped
        Program other = new Program(l);
        assertNotEquals(other, l);
        other = new Program(Arrays.asList((short) 0b0001000000100011, (short) 0b0001001000100001));
        assertEquals(other, program);
    }
}