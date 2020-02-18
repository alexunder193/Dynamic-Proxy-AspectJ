//package gr.dit.homework1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HousePartProxy implements InvocationHandler {

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) {
    if (args.length != 1) {
      System.err.println("Do not pass a parameter");
      return null;
    }
    if (!method.getName().equals("visit")) {
      System.err.println("Unsupported operation: " + method.getName());
      return null;
    }

    if (args[0] instanceof Attic) {
      // Attic attic = (Attic) args[0];
      System.out.println("Displaying Attic.");
    } else if (args[0] instanceof DiningRoom) {
      // DiningRoom diningRoom = (DiningRoom) args[0];
      System.out.println("Displaying Dining Room.");
    } else if (args[0] instanceof Hall) {
      // Hall hall = (Hall) args[0];
      System.out.println("Displaying Hall.");
    } else if (args[0] instanceof LivingRoom) {
      // LivingRoom livingRoom = (LivingRoom) args[0];
      System.out.println("Displaying Living Room.");
    } else if (args[0] instanceof Office) {
      // Office office = (Office) args[0];
      System.out.println("Displaying Office.");
    } else if (args[0] instanceof House) {
      // House house = (House) args[0];
      System.out.println("Displaying House.");
    } else {
      System.err.println("Unsupported operation: " + method.getName());
    }
    return null;


  }

}
