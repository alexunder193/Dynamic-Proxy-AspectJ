//package gr.dit.homework1;

public class House implements HousePart {

  HousePart[] parts;

  public House() {
    parts =
        new HousePart[] {new Hall(), new LivingRoom(), new DiningRoom(), new Office(), new Attic()};
  }

  @Override
  public void accept(HousePartVisitor housePartVisitor) {
    for (int i = 0; i < parts.length; i++) {
      parts[i].accept(housePartVisitor);
    }
    housePartVisitor.visit(this);
  }

  public HousePart[] getParts() {
    return parts;
  }

  public void setParts(HousePart[] parts) {
    this.parts = parts;
  }


}
