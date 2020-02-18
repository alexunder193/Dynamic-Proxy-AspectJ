# Input Java files (components).
JAVA_FILES = Main.java \
	Attic.java \
	DiningRoom.java \
	Hall.java \
	LivingRoom.java \
	Office.java \
	House.java \
	HousePart.java \
	HousePartPrintVisitor.java \
	HousePartProxy.java \
	HousePartVisitor.java \

default: ${JAVA_FILES}
	@javac ${JAVA_FILES}

run: default
	@java Main

clean:
	$(RM) *.class