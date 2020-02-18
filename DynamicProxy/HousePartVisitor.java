//package gr.dit.homework1;

public interface HousePartVisitor {
  public void visit(House house);

  public void visit(Hall hall);

  public void visit(LivingRoom livingRoom);

  public void visit(DiningRoom diningRoom);

  public void visit(Office office);

  public void visit(Attic attic);
}
