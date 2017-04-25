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
    | postfixExpression '(' ')'
    | postfixExpression '(' argumentExpressionList ')'
    | postfixExpression INC_OP
    | postfixExpression DEC_OP
    ;

argumentExpressionList
    : assignmentExpression
    | argumentExpressionList ',' assignmentExpression
    ;

unaryExpression
    : postfixExpression
    | INC_OP unaryExpression
    | DEC_OP unaryExpression
    | unaryOperator unaryExpression
    | SIZEOF unaryExpression
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

multiplicativeExpression
    : unaryExpression
    | multiplicativeExpression '*' unaryExpression
    | multiplicativeExpression '/' unaryExpression
    | multiplicativeExpression '%' unaryExpression
    ;

additiveExpression
    : multiplicativeExpression
    | additiveExpression '+' multiplicativeExpression
    | additiveExpression '-' multiplicativeExpression
    ;

shiftExpression
    : additiveExpression
    | shiftExpression LEFT_OP additiveExpression
    | shiftExpression RIGHT_OP additiveExpression
    ;

relationalExpression
    : shiftExpression
    | relationalExpression '<' shiftExpression
    | relationalExpression '>' shiftExpression
    | relationalExpression LE_OP shiftExpression
    | relationalExpression GE_OP shiftExpression
    ;

equalityExpression
    : relationalExpression
    | equalityExpression EQ_OP relationalExpression
    | equalityExpression NE_OP relationalExpression
    ;

andExpression
    : equalityExpression
    | andExpression '&' equalityExpression
    ;


exclusiveOrExpression
    : andExpression
    | exclusiveOrExpression '^' andExpression
    ;

inclusiveOrExpression
    : exclusiveOrExpression
    | inclusiveOrExpression '|' exclusiveOrExpression
    ;

logicalAndExpression
    : inclusiveOrExpression
    | logicalAndExpression AND_OP inclusiveOrExpression
    ;

logicalOrExpression
    : logicalAndExpression
    | logicalOrExpression OR_OP logicalAndExpression
    ;

conditionalExpression
    : logicalOrExpression
    | logicalOrExpression '?' expression ':' conditionalExpression
    ;

assignmentExpression
    : conditionalExpression
    | unaryExpression assignmentOperator assignmentExpression ;

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
    : assignmentExpression (',' assignmentExpression)*
    ;

constantExpression
    : conditionalExpression
    ;

declaration
    : initDeclaratorList
    ;

initDeclaratorList
    : initDeclarator (',' initDeclarator)*
    ;

initDeclarator
    : declarator ('=' initializer)?
    ;

typeSpecifier
    : LONG
    ;

declarator
    : pointer? directDeclarator
    ;

directDeclarator
    : ID
    | '(' declarator ')'
    | directDeclarator '[' constantExpression ']'
    | directDeclarator '[' ']'
    | directDeclarator '(' parameterTypeList ')'
    | directDeclarator '(' identifierList ')'
    | directDeclarator '(' ')'
    ;

pointer
    : '*'+
    ;

parameterTypeList
    : parameterList (',' ELLIPSIS)?
    ;

parameterList
    : parameterDeclaration (',' parameterDeclaration)*
    ;

parameterDeclaration
    : typeSpecifier+ (declarator | abstractDeclarator)?
    ;

identifierList
    : ID (',' ID)*
    ;


specifierQualifierList
	: typeSpecifier+
	;

typeName
    : specifierQualifierList abstractDeclarator?
    ;

abstractDeclarator
    : pointer? directAbstractDeclarator
    ;

directAbstractDeclarator
    : '(' abstractDeclarator ')'
    | '[' ']'
    | '[' constantExpression ']'
    | directAbstractDeclarator '[' ']'
    | directAbstractDeclarator '[' constantExpression ']'
    | '(' ')'
    | '(' parameterTypeList ')'
    | directAbstractDeclarator '(' ')'
    | directAbstractDeclarator '(' parameterTypeList ')'
    ;

initializer
    : assignmentExpression
    | '{' initializerList '}'
    | '{' initializerList ',' '}'
    ;

initializerList
    : initializer (',' initializer)*
    ;

statement
    : labeledStatement
    | compoundStatement
    | expressionStatement
    | selectionStatement
    | iterationStatement
    | jumpStatement
    ;

labeledStatement
    : ID ':' statement
    | CASE constantExpression ':' statement
    | DEFAULT ':' statement
    ;

compoundStatement
    : '{' declaration* statement* '}'
    ;

expressionStatement
    : expression? ';'
    ;

selectionStatement
    : IF '(' expression ')' statement (ELSE statement)?
   	| SWITCH '(' expression ')' statement
   	;

iterationStatement
    : WHILE '(' expression ')' statement
    | DO statement WHILE '(' expression ')' ';'
    | FOR '(' expressionStatement expressionStatement expression? ')' statement
    ;

jumpStatement
    : CONTINUE ';'
    | BREAK ';'
    | RETURN ';'
    | RETURN expression ';' ;

translationUnit
    : (functionDefinition | declaration)*
    ;

functionDefinition
    : typeSpecifier* declarator declaration* compoundStatement
    ;
