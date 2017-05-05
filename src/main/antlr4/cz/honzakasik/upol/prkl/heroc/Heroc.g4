grammar Heroc;
import LexerTokens;

primaryExpression
    : ID
    | NUMBER
    | '(' expression ')'
    ;

postfixExpression
    : primaryExpression
    | postfixExpression '[' expression ']'
    | postfixExpression INC_OP
    | postfixExpression DEC_OP
    ;

unaryExpression
    : postfixExpression
    | INC_OP unaryExpression
    | DEC_OP unaryExpression
    | unaryOperator unaryExpression
    | SIZEOF '(' typeName ')'
    ;

unaryOperator
    : '&'
    | '*'
    | '+'
    | '-'
    | '~'
    | '!'
    ;

assignmentOperator
    : '='
    | MUL_ASSIGN
    | DIV_ASSIGN
    | MOD_ASSIGN
    | ADD_ASSIGN
    | SUB_ASSIGN
    | LEFT_ASSIGN
    | RIGHT_ASSIGN
    | AND_ASSIGN
    | XOR_ASSIGN
    | OR_ASSIGN
    ;

expression
    : primaryExpression                                     #PrimaryExpressionL
    | expression cmd=('*'|'/'|'%')              expression  #MultiplicativeExpression
    | expression cmd=('+'|'-')                  expression  #AdditiveExpression
    | expression cmd=(LEFT_OP | RIGHT_OP)       expression  #ShiftExpression
    | expression cmd=('<' | '>' | LE_OP | GE_OP)expression  #RelationalExpression
    | expression cmd=(EQ_OP | NE_OP)            expression  #EqualityExpression
    | expression cmd='&'                        expression  #AndExpression
    | expression cmd='^'                        expression  #ExclusiveOrExpression
    | expression cmd='|'                        expression  #InclusiveOrExpression
    | expression cmd=AND_OP                     expression  #LogicalAndExpression
    | expression cmd=OR_OP                      expression  #LogicalOrExpression
    | expression '?' expression ':' expression              #ConditionalExpression
    | unaryExpression                                       #UnaryExpressionL
    | expression cmd=assignmentOperator expression          #AssignmentExpression
    ;

declaration
    : initDeclarator (',' initDeclarator)* ';'
    ;

initDeclarator
    : LONG? declarator ('=' initializer)?
    ;

declarator
    : pointer? directDeclarator
    ;

directDeclarator
    : ID #SimpleVariableDeclaration
//    | '(' declarator ')'
    | ID ('[' expression? ']')+ #ArrayDeclaration
//    | directDeclarator '(' parameterDeclaration (',' parameterDeclaration)* ')'
//    | directDeclarator '(' ID (',' ID)* ')'
//    | directDeclarator '(' ')'
    ;

functionArgumentList
    : '(' (ID (',' ID)*)? ')'
    ;

pointer
    : '*'+
    ;

parameterDeclaration
    : LONG (declarator | abstractDeclarator)?
    ;

typeName
    : LONG abstractDeclarator?
    ;

abstractDeclarator
    : pointer? directAbstractDeclarator
    ;

directAbstractDeclarator
    : '(' abstractDeclarator ')'
    | '[' ']'
    | '[' expression ']'
    | directAbstractDeclarator '[' ']'
    | directAbstractDeclarator '[' expression ']'
    | '(' ')'
    | '(' parameterDeclaration (',' parameterDeclaration)* ')'
    | directAbstractDeclarator '(' ')'
    | directAbstractDeclarator '(' parameterDeclaration (',' parameterDeclaration)* ')'
    ;

initializer
    : expression
    | '{' initializer (',' initializer)* ','? '}'
    ;

statement
    : compoundStatement
    | expressionStatement
    | selectionStatement
    | iterationStatement
    | jumpStatement
    | functionCallStatement
    ;

functionCallStatement
    : ID functionCallArgumentList ';'
    ;

functionCallArgumentList
    : (expression? (',' expression)*)
    ;

compoundStatement
    : '{' declaration* statement* '}'
    ;

expressionStatement
    : expression? ';'
    ;

selectionStatement
    : IF '(' expression ')' statement (ELSE statement)?
   	;

iterationStatement
    : WHILE '(' expression ')' statement
    | DO statement WHILE '(' expression ')' ';'
    | FOR '(' expression? ';' expression? ';' expression? ')' statement
    ;

jumpStatement
    : CONTINUE ';'
    | BREAK ';'
    | RETURN expression? ';'
    ;

translationUnit
    : (functionDefinition | declaration)*
    ;

functionDefinition
    : functionName=ID functionArgumentList functionBody=compoundStatement
    ;
