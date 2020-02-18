//package gr.dit.homework1;

public class Hall implements HousePart {

  @Override
  public void accept(HousePartVisitor housePartVisitor) {
    housePartVisitor.visit(this);
  }
}
