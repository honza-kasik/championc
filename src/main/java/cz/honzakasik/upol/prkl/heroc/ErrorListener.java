package cz.honzakasik.upol.prkl.heroc;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorListener extends BaseErrorListener {

    private static final Logger log = LoggerFactory.getLogger(ErrorListener.class);

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        String errorFormatted = "Neco jsi podelal na radku %d, sloupec %d:(.Details:%n%s)";
        String errorMessage = String.format(errorFormatted, line, charPositionInLine, msg);
        log.error(errorMessage);
    }
}
