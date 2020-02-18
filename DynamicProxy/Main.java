//package gr.dit.homework1;

import java.lang.reflect.Proxy;

public class Main {

  public static void main(String[] args) {
    Attic attic = new Attic();

    Class<?>[] interfaces = new Class[1];
    interfaces[0] = HousePartVisitor.class;
    HousePartVisitor proxy = (HousePartVisitor) Proxy
        .newProxyInstance(Main.class.getClassLoader(), interfaces, new HousePartProxy());
    proxy.visit(attic);
  }

}
