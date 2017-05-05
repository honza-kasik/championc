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

//number
NUMBER
    : DEC
    | HEX {setText(String.valueOf(Long.parseLong(getText().substring(2), 16)));}
    | OCT {setText(String.valueOf(Long.parseLong(getText(), 8)));}
    ;

fragment DIGIT : [0-9];
fragment FIXNUM : DIGIT+;
fragment HEXDIGIT : DIGIT | [a-fA-F];
fragment HEXFIXNUM : '0'[xX]HEXDIGIT+;

fragment DEC : FIXNUM;
fragment HEX : HEXFIXNUM;
fragment OCT : '0'[0-7]+;

//id
ID : ('_'| LETTER )( DIGIT | '_' | LETTER )*;

fragment LETTER : [a-zA-Z];

CHAR_CONSTANT:          '\'' CHAR_SYMBOL '\'';
STRING:                 '\\"' (CHAR_SYMBOL | ESCAPE)* '\\"';
fragment ESCAPE:        '\\' CHAR_SYMBOL;
fragment CHAR_SYMBOL:   '\u0000' .. '\u007F';

//ignore
NEWLINE :   '\r'? '\n' -> skip;
COMMENT :   '/*' .*? '*/' -> skip;
WS      :   [ \n\t]+ -> skip ;