package lc3.arch;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Program implements Iterable<Short> {
    List<Short> bytecode;

    public Program(File file) throws IOException {
        DataInputStream stream = new DataInputStream(new FileInputStream(file));
        bytecode = new ArrayList<>((int) (file.length() >> 2));
        while (stream.available() > 0) {
            bytecode.add(stream.readShort());
        }
    }

    public Program(List<Short> bytecode) {
        this.bytecode = bytecode;
    }

    @Override
    public Iterator<Short> iterator() {
        return bytecode.iterator();
    }

    public List<Short> getBytecode() {
        return bytecode;
    }

    public void setBytecode(List<Short> bytecode) {
        this.bytecode = bytecode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Program)) return false;

        Program shorts = (Program) o;

        return Objects.equals(bytecode, shorts.bytecode);
    }
}
