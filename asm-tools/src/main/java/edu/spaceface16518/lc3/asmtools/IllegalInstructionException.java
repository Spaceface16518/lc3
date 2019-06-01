package edu.spaceface16518.lc3.asmtools;

public class IllegalInstructionException extends IllegalArgumentException {

    public IllegalInstructionException(String opName) {
        super(opName);
    }
}
