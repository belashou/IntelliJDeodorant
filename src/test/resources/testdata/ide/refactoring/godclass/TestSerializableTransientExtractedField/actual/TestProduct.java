package TestSerializableTransientExtractedField.actual;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestProduct {
    private Integer a;
    private Integer b;
    private transient Integer d;
    private Integer e;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        d = stream.read();
        a = stream.read();
        stream.defaultReadObject();
    }

    public void fun2() {
        d += 1;
        e += 1;
    }

    public void writeObject(ObjectOutputStream stream) throws IOException {
        stream.writeObject(e);
        stream.writeObject(b);
        stream.defaultWriteObject();
    }
}