package edu.spaceface16518.lc3.asmtools.instruction;

import java.util.Objects;

public abstract class Instruction {
    protected int lineNumber;
    protected String line;
    protected String label;

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        int result = lineNumber;
        result = 31 * result + line.hashCode();
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instruction)) return false;

        Instruction that = (Instruction) o;

        if (lineNumber != that.lineNumber) return false;
        if (!line.equals(that.line)) return false;
        return Objects.equals(label, that.label);
    }
}
