all: compile

compile:
	mvn -q compile
	java org.antlr.v4.runtime.misc.TestRig Heroc translation_unit -gui < test_input
	#antlr4 src/Heroc.g4 -visitor 
	#javac src/Heroc*.java -d target

debug: compile
	java org.antlr.v4.runtime.misc.TestRig Heroc forms -gui -encoding utf8

clean:
	rm -f target/*.class

distclean: clean
	pushd src; rm -f *.tokens; popd
