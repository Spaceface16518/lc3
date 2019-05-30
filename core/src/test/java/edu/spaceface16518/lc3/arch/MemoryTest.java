package edu.spaceface16518.lc3.arch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MemoryTest {

    private Memory memory;

    @BeforeEach
    void setUp() {
        memory = new Memory();
    }

    @Test
    @DisplayName("MemSet test")
    void MemSetTest() {
        short[] arr = new short[memory.mem.length];
        Random rng = new Random();
        // Fill memory with random numbers
        for (int i = 0; i < memory.mem.length; i++) {
            short r = (short) rng.nextInt();
            arr[i] = r;
            memory.memSet(i, r);
        }

        // Assert every location returns the correct value
        for (int i = 0; i < memory.mem.length; i++) {
            assertEquals(arr[i], memory.mem[i]);
        }
    }

    @Test
    @DisplayName("MemAt test")
    void MemAtTest() {
        Random rng = new Random();
        // Fill memory with random numbers
        for (int i = 0; i < memory.mem.length; i++) {
            memory.mem[i] = (short) rng.nextInt();
        }

        // Assert every location returns the correct value
        for (int i = 0; i < memory.mem.length; i++) {
            assertEquals(memory.mem[i], memory.memAt(i));
        }
    }

    @Test
    @DisplayName("RegSet test")
    void RegSetTest() {
        short[] arr = new short[memory.registers.length];
        Random rng = new Random();
        // Fill memory with random numbers
        for (int i = 0; i < memory.registers.length; i++) {
            short r = (short) rng.nextInt();
            arr[i] = r;
            memory.regSet(i, r);
        }

        // Assert every location returns the correct value
        for (int i = 0; i < memory.registers.length; i++) {
            assertEquals(arr[i], memory.registers[i]);
        }
    }

    @Test
    @DisplayName("RegAt test")
    void RegAtTest() {
        Random rng = new Random();
        // Fill memory with random numbers
        for (int i = 0; i < memory.registers.length; i++) {
            memory.registers[i] = (short) rng.nextInt();
        }

        // Assert every location returns the correct value
        for (int i = 0; i < memory.registers.length; i++) {
            assertEquals(memory.registers[i], memory.regAt(i));
        }
    }

    @Test
    @DisplayName("UpdateFlags test")
    void UpdateFlagsTest() {
        memory.regSet(0, (short) 0b1100);
        memory.regSet(1, (short) 0b1000000000001100);
        memory.regSet(2, (short) 0);
        memory.updateFlags(0);
        assertEquals(Memory.FlagPositive, memory.registers[Memory.COND], "Positive register yielded incorrect flag");
        memory.updateFlags(1);
        assertEquals(Memory.FlagNegative, memory.registers[Memory.COND], "Negative register yielded incorrect flag");
        memory.updateFlags(2);
        assertEquals(Memory.FlagZero, memory.registers[Memory.COND], "Zeroed register yielded incorrect flag");
    }

    @Test
    @DisplayName("Equals1 test")
    void Equals1Test() {
        Memory other = new Memory();

        other.memSet(0, (short) 1);
        other.regSet(0, (short) 1);
        assertNotEquals(memory, other);

        memory.memSet(0, (short) 1);
        memory.regSet(0, (short) 1);
        assertEquals(memory, other);
    }
}