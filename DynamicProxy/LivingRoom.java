//package gr.dit.homework1;

public class LivingRoom implements HousePart {

  @Override
  public void accept(HousePartVisitor housePartVisitor) {
    housePartVisitor.visit(this);
  }
}
