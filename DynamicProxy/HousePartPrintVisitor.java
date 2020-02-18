//package gr.dit.homework1;

public class HousePartPrintVisitor implements HousePartVisitor {

  @Override
  public void visit(House house) {
    System.out.println("Displaying House.");
  }

  @Override
  public void visit(Hall hall) {
    System.out.println("Displaying Hall.");
  }

  @Override
  public void visit(LivingRoom livingRoom) {
    System.out.println("Displaying Living Room.");
  }

  @Override
  public void visit(DiningRoom diningRoom) {
    System.out.println("Displaying Dining Room.");
  }

  @Override
  public void visit(Office office) {
    System.out.println("Displaying Office.");
  }

  @Override
  public void visit(Attic attic) {
    System.out.println("Displaying Attic.");
  }

}
