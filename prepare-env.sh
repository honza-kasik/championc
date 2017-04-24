#!/usr/bin/env bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
ANTLR_PATH="${DIR}/antlr-dist/"
ANTLR_VER="4.7"
ANTLR_JAR="antlr-${ANTLR_VER}-complete.jar"
ANTLR_JAR_PATH=${ANTLR_PATH}${ANTLR_JAR}

mkdir -p "${ANTLR_PATH}"
pushd "${ANTLR_PATH}"

if [ ! -f "${ANTLR_JAR}" ]; then
    curl -O "http://www.antlr.org/download/${ANTLR_JAR}"
fi

export CLASSPATH=".:${ANTLR_JAR_PATH}:${DIR}/target/classes/cz/honzakasik/upol/prkl/heroc:$CLASSPATH"

alias antlr4="java -Xmx500M -cp \"${ANTLR_JAR_PATH}:$CLASSPATH\" org.antlr.v4.Tool"
alias grun='java org.antlr.v4.gui.TestRig'

popd
