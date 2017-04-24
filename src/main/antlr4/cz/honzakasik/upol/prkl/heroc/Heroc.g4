grammar Heroc;
import LexerTokens;

primaryExpression : ID
                   | NUMBER
                   | '(' expression ')' ;

postfixExpression : primaryExpression
                  | postfixExpression '[' expression ']'
                  | postfixExpression '(' ')'
                  | postfixExpression '(' argumentExpressionList ')'
                  | postfixExpression INC_OP
                  | postfixExpression DEC_OP ;

argumentExpressionList : assignmentExpression
                       | argumentExpressionList ',' assignmentExpression ;

unaryExpression : postfixExpression
                 | INC_OP unaryExpression
                 | DEC_OP unaryExpression
                 | unary_operator unaryExpression
                 | SIZEOF unaryExpression
                 | SIZEOF '(' typeName ')' ;

unary_operator : '&'
               | '*'
               | '+'
               | '-'
               | '~'
               | '!' ;

multiplicativeExpression : unaryExpression
                        	| multiplicativeExpression '*' unaryExpression
                        	| multiplicativeExpression '/' unaryExpression
                        	| multiplicativeExpression '%' unaryExpression ;

additiveExpression : multiplicativeExpression
                  	| additiveExpression '+' multiplicativeExpression
                  	| additiveExpression '-' multiplicativeExpression ;

shiftExpression : additiveExpression
                 | shiftExpression LEFT_OP additiveExpression
                 | shiftExpression RIGHT_OP additiveExpression ;

relationalExpression : shiftExpression
                    	| relationalExpression '<' shiftExpression
                    	| relationalExpression '>' shiftExpression
                    	| relationalExpression LE_OP shiftExpression
                    	| relationalExpression GE_OP shiftExpression ;

equalityExpression : relationalExpression
                  	| equalityExpression EQ_OP relationalExpression
                  	| equalityExpression NE_OP relationalExpression ;

andExpression : equalityExpression
               | andExpression '&' equalityExpression ;


exclusiveOrExpression : andExpression
               	        | exclusiveOrExpression '^' andExpression ;

inclusiveOrExpression : exclusiveOrExpression
               	        | inclusiveOrExpression '|' exclusiveOrExpression ;

logicalAndExpression : inclusiveOrExpression
               	       | logicalAndExpression AND_OP inclusiveOrExpression ;

logicalOrExpression : logicalAndExpression
               	      | logicalOrExpression OR_OP logicalAndExpression ;

conditionalExpression : logicalOrExpression
               	       | logicalOrExpression '?' expression ':' conditionalExpression ;

assignmentExpression : conditionalExpression
               	      | unaryExpression assignmentOperator assignmentExpression ;

assignmentOperator : '='
                   	| MUL_ASSIGN
                   	| DIV_ASSIGN
                   	| MOD_ASSIGN
                   	| ADD_ASSIGN
                   	| SUB_ASSIGN
                   	| LEFT_ASSIGN
                   	| RIGHT_ASSIGN
                   	| AND_ASSIGN
                   	| XOR_ASSIGN
                   	| OR_ASSIGN ;

expression : assignmentExpression
           | expression ',' assignmentExpression ;

constantExpression : conditionalExpression ;

declaration : declarationSpecifiers ';'
            | declarationSpecifiers initDeclaratorList ';'	;

declarationSpecifiers : typeSpecifier
                       | typeSpecifier declarationSpecifiers ;

initDeclaratorList : initDeclarator
               	     | initDeclaratorList ',' initDeclarator ;

initDeclarator : declarator
               	| declarator '=' initializer ;

typeSpecifier : LONG
               	| enumSpecifier ;

enumSpecifier : ENUM '{' enumeratorList '}'
             	 | ENUM ID '{' enumeratorList '}'
             	 | ENUM ID ;

enumeratorList : enumerator
               	| enumeratorList ',' enumerator ;

enumerator : ID
           | ID '=' constantExpression	;

declarator : pointer directDeclarator
           | directDeclarator ;

directDeclarator : ID
                 	| '(' declarator ')'
                 	| directDeclarator '[' constantExpression ']'
                 	| directDeclarator '[' ']'
                 	| directDeclarator '(' parameterTypeList ')'
                 	| directDeclarator '(' identifierList ')'
                 	| directDeclarator '(' ')' ;

pointer : '*'
       	| '*' pointer ;

parameterTypeList : parameterList
                   	| parameterList ',' ELLIPSIS	;

parameterList : parameterDeclaration
               | parameterList ',' parameterDeclaration ;

parameterDeclaration : declarationSpecifiers declarator
                     	| declarationSpecifiers abstractDeclarator
                     	| declarationSpecifiers ;

identifierList : ID
               	| identifierList ',' ID ;


specifierQualifierList
	: typeSpecifier specifierQualifierList
	| typeSpecifier ;

typeName: specifierQualifierList
         	| specifierQualifierList abstractDeclarator ;

abstractDeclarator : pointer
                   	| directAbstractDeclarator
                   	| pointer directAbstractDeclarator ;

directAbstractDeclarator : '(' abstractDeclarator ')'
                           	| '[' ']'
                           	| '[' constantExpression ']'
                           	| directAbstractDeclarator '[' ']'
                           	| directAbstractDeclarator '[' constantExpression ']'
                           	| '(' ')'
                           	| '(' parameterTypeList ')'
                           	| directAbstractDeclarator '(' ')'
                           	| directAbstractDeclarator '(' parameterTypeList ')' ;

initializer : assignmentExpression
           	| '{' initializerList '}'
           	| '{' initializerList ',' '}' ;

initializerList : initializer
                 | initializerList ',' initializer ;

statement : labeledStatement
         	| compoundStatement
         	| expressionStatement
         	| selectionStatement
         	| iterationStatement
         	| jumpStatement ;

labeledStatement : ID ':' statement
                 	| CASE constantExpression ':' statement
                 	| DEFAULT ':' statement	;

compoundStatement : '{' '}'
                 	 | '{' statementList '}'
                 	 | '{' declarationList '}'
                 	 | '{' declarationList statementList '}' ;

declarationList : declaration
               	 | declarationList declaration ;

statementList : statement
               | statementList statement	;

expressionStatement : ';'
               	     | expression ';' ;

selectionStatement : IF '(' expression ')' statement
                   	| IF '(' expression ')' statement ELSE statement
                   	| SWITCH '(' expression ')' statement ;

iterationStatement : WHILE '(' expression ')' statement
                   	| DO statement WHILE '(' expression ')' ';'
                   	| FOR '(' expressionStatement expressionStatement ')' statement
                   	| FOR '(' expressionStatement expressionStatement expression ')' statement ;

jumpStatement : CONTINUE ';'
             	 | BREAK ';'
             	 | RETURN ';'
             	 | RETURN expression ';' ;

translationUnit : externalDeclaration
               	| translationUnit externalDeclaration ;

externalDeclaration : functionDefinition
                   	 | declaration ;

functionDefinition : declarationSpecifiers declarator declarationList compoundStatement
                   	| declarationSpecifiers declarator compoundStatement
                   	| declarator declarationList compoundStatement
                   	| declarator compoundStatement ;
