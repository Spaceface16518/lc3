package edu.spaceface16518.lc3.arch;

import java.util.Arrays;

public class Memory {
    public static final int R0 = 0;
    public static final int R1 = 1;
    public static final int R2 = 2;
    public static final int R3 = 3;
    public static final int R4 = 4;
    public static final int R5 = 5;
    public static final int R6 = 6;
    public static final int R7 = 7;
    public static final int PC = 8;
    public static final int COND = 9;
    // TODO: memory mapped registers
    public static final int FlagPositive = 1;
    public static final int FlagZero = 1 << 1;
    public static final int FlagNegative = 1 << 2;
    short[] registers = new short[10];
    short[] mem = new short[65536];

    public Memory() {
    }

    public short memAt(int idx) throws IndexOutOfBoundsException {
        if (idx < 0 || idx >= 65536) throw new IndexOutOfBoundsException(idx);
        return this.mem[idx];
    }

    public void memSet(int idx, short val) throws IndexOutOfBoundsException {
        if (idx < 0 || idx >= 65536) throw new IndexOutOfBoundsException(idx);
        this.mem[idx] = val;
    }

    public short regAt(int idx) throws IndexOutOfBoundsException {
        if (idx < 0 || idx >= this.registers.length)
            throw new IndexOutOfBoundsException(idx);
        return this.registers[idx];
    }

    public void regSet(int idx, short val) throws IndexOutOfBoundsException {
        if (idx < 0 || idx >= this.registers.length)
            throw new IndexOutOfBoundsException(idx);
        this.registers[idx] = val;
    }

    public void updateFlags(int idx) throws IndexOutOfBoundsException {
        if (idx >= this.registers.length - 2)
            throw new IndexOutOfBoundsException(idx);
        if (registers[idx] == 0) {
            registers[COND] = FlagZero;
        } else if (registers[idx] >>> 15 != 0) {
            registers[COND] = FlagNegative;
        } else {
            registers[COND] = FlagPositive;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Memory)) return false;
        Memory memory = (Memory) o;
        return Arrays.equals(mem, memory.mem) &&
                Arrays.equals(registers, memory.registers);
    }
}
