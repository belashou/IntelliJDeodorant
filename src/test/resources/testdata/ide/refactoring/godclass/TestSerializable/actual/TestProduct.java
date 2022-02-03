package TestSerializable.actual;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestProduct {
    private int a;
    private int b;
    private int d;
    private int e;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
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