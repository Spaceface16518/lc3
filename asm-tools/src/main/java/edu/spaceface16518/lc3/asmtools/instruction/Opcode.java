package edu.spaceface16518.lc3.asmtools.instruction;

import edu.spaceface16518.lc3.asmtools.IllegalInstructionException;

public interface Opcode {
    default byte opCode() {
        return opCode(this.opName());
    }

    default byte opCode(String opName) throws IllegalInstructionException {
        byte result;
        switch (opName.toUpperCase()) {
            case "ADD":
                result = 0b0001;
                break;
            case "AND":
                result = 0b0101;
                break;
            case "BR":
                result = 0b0000;
                break;
            case "JMP":
            case "RET":
                result = 0b1100;
                break;
            case "JSRR":
                result = 0b0100;
                break;
            case "LD":
                result = 0b0010;
                break;
            case "LDI":
                result = 0b1010;
                break;
            case "LDR":
                result = 0b0110;
                break;
            case "LEA":
                result = 0b1110;
                break;
            case "NOT":
                result = 0b1001;
                break;
            case "RTI":
                result = 0b1000;
                break;
            case "ST":
                result = 0b0011;
                break;
            case "STI":
                result = 0b1011;
                break;
            case "STR":
                result = 0b0111;
                break;
            case "TRAP":
                result = 0b1111;
                break;
            case "RES":
                result = 0b1101;
                break;
            default:
                throw new IllegalInstructionException(opName);
        }
        return result;
    }

    String opName();
}
