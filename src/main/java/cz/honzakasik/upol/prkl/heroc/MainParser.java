package cz.honzakasik.upol.prkl.heroc;

import cz.honzakasik.upol.prkl.heroc.model.TranslationUnit;
import cz.honzakasik.upol.prkl.heroc.tree.TranslationUnitVisitor;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Path;

class MainParser {

    TranslationUnit getTranslationUnit(Path filePath) throws IOException {
        CharStream charStream = CharStreams.fromPath(filePath);
        HerocLexer herocLexer = new HerocLexer(charStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(herocLexer);
        HerocParser herocParser = new HerocParser(commonTokenStream);

        ANTLRErrorListener antlrErrorListener = new ErrorListener();
        herocLexer.addErrorListener(antlrErrorListener);

        TranslationUnitVisitor translationUnitVisitor = new TranslationUnitVisitor();
        return herocParser.translationUnit().accept(translationUnitVisitor);
    }
}
