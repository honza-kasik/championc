lexer grammar LexerTokens;

//keywords
SIZEOF : 'sizeof';
WHILE : 'while';
FOR : 'for';
DO : 'do';
LONG : 'long';
CASE : 'case';
SWITCH : 'switch';
DEFAULT : 'default';
IF : 'if';
ELSE : 'else';
BREAK : 'brak';
RETURN : 'return';
CONTINUE : 'continue';
ENUM : 'enum';

INC_OP : '++' ;
DEC_OP : '--' ;

AND_OP : '&&';
OR_OP : '||';

LE_OP : '<=';
GE_OP : '>=';
EQ_OP : '==';
NE_OP : '!=';

LEFT_OP : '<<';
RIGHT_OP : '>>';

MUL_ASSIGN :'*=';
DIV_ASSIGN : '/=';
MOD_ASSIGN : '%=';
ADD_ASSIGN : '+=';
SUB_ASSIGN : '-=';
LEFT_ASSIGN : '<<=';
RIGHT_ASSIGN : '>>=';
AND_ASSIGN : '&=';
XOR_ASSIGN : '^=';
OR_ASSIGN : '|=';

ELLIPSIS : '...';

//whitespace
WS : [ \n\t]+ -> skip ;

//number
NUMBER
    : DEC
    | HEX
    | OCT
    ;

fragment DIGIT : [0-9];
fragment FIXNUM : DIGIT+;
fragment HEXDIGIT : DIGIT | |[a-fA-F];
fragment HEXFIXNUM : '0'[xX]HEXDIGIT+;

fragment DEC : FIXNUM;
fragment HEX : HEXFIXNUM;
fragment OCT : '0'[0-7]+;

//id
ID : ('_'| LETTER )( DIGIT | '_' | LETTER )*;

fragment LETTER : [a-zA-Z];



