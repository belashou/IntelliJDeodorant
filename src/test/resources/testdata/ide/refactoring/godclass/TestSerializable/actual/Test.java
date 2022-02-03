package TestSerializable.actual;

import java.io.Serializable;

public class Test implements Serializable {
    private TestProduct testProduct = new TestProduct();
    private static final long serialVersionUID = 1L;
    private transient int c;

    public void fun1() {
        testProduct.setA(testProduct.getA() + 1);
        testProduct.setB(testProduct.getB() + 1);
        c += 1;
    }

    public void fun2() {
        testProduct.fun2();
    }

}