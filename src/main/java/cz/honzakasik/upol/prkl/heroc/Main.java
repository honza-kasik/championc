package cz.honzakasik.upol.prkl.heroc;

import cz.honzakasik.upol.prkl.heroc.model.TranslationUnit;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        TranslationUnit translationUnit = new MainParser().getTranslationUnit(parsePathFromArguments(args));

        StringBuilder stringBuilder = new StringBuilder();
        OutputBuilder outputBuilder = new OutputBuilder(stringBuilder);

        translationUnit.appendStringRepresentationToBuilder(outputBuilder, 0);

        System.out.println(stringBuilder.toString());
    }

    private static Path parsePathFromArguments(String[] args) {
        return Paths.get(args[0]);
    }
}
