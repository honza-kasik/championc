import cz.honzakasik.upol.prkl.heroc.HerocLexer;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.io.IOException;

public class TestRigTreeTestCase {

    @Test
    public void showTree() throws IOException {
        // Create an input stream that receives text from the terminal
        ANTLRInputStream input = new ANTLRInputStream("long i = z+5;");

        // Create an Lexer that receives the char stream
        HerocLexer lexer = new HerocLexer(input);

        // Create a token stream from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create a parser that receives the token stream
        HerocParser parser = new HerocParser(tokens);

        // Create a parser tree starting from the first rule
        HerocParser.TranslationUnitContext tree = parser.translationUnit();

        //Generates the GUI
        //tree.
    }
}
