package lexicalAnalyzer;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Test {

    private SimpleToken token = null;   //当前正在解析的Token
    private StringBuffer tokenText = null;  //临时保存token的文本
    private List<Token> tokens = null;      //保存解析出来的Token

    public void initToken(char ch) {

        DfaState newState = DfaState.Initial;
        if (isAlpha(ch)) {  //第一个字符是字母
            newState = DfaState.Id;
            token.type = TokenType.Identifier;
            tokenText.append(ch);
        } else if (isDigit(ch)) {   //第一个字符是数字
            newState = DfaState.IntLiteral;
            token.type = TokenType.IntLiteral;
            tokenText.append(ch);
        } else if (ch == '>') {     //第一个字符是>
            newState = DfaState.GT;
            token.type = TokenType.GT;
            tokenText.append(ch);
        }
    }

    public void tokenize(String code) {
        tokens = new ArrayList<>();
        CharArrayReader reader = new CharArrayReader(code.toCharArray());
        tokenText = new StringBuffer();
        token = new SimpleToken();
//        int i

    }

    //是否是数字
    private boolean isDigit(int ch) {
        return ch >= '0' && ch <= '9';
    }

    //是否是字母
    private boolean isAlpha(int ch) {
        return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
    }



    private final class SimpleToken implements Token {
        //Token类型
        private TokenType type = null;

        //文本值
        private String text = null;

        @Override
        public TokenType getType() {
            return type;
        }

        @Override
        public String getText() {
            return text;
        }
    }

    /**
     * 有限状态机的各种状态
     */
    private enum DfaState{
        Initial,//初始
        Id,//标识符
        GT,//大于
        GE,//大于等于
        IntLiteral//数字字面量
    }
}
