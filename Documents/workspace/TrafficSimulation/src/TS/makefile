JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

all: $(CLASSES)
	$(JC) $(JFLAGS) $(CLASSES)

CLASSES = \
        Car.java \
        Lane.java \
        Light.java \
        TrafficSystem.java \
        Simulation.java

default: classes

classes: $(CLASSES:.java=.class)

test: AllTests.class
	java junit.textui.TestRunner AllTests

clean:
	$(RM) *.class