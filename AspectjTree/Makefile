# Input Java files (components).
JAVA_FILES=Main.java Tree.java Node.java
# Aspect in AspectJ language.
AJ_ASPECT=AspectTree.aj

ASPECTJRT=/usr/share/java/aspectjrt.jar

aspectJCompile: ${JAVA_FILES} ${JAVA_ASPECT} ${AJ_ASPECT}
	@ajc -source 1.8 ${JAVA_FILES} ${AJ_ASPECT}

aspectJRun: aspectJCompile
	@echo "== Running with AspectJ =="
	@java -cp ${ASPECTJRT}:. Main
