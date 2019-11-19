package lexicalAnalyzer;

public class SimpleCalculator {

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();

        //测试变量声明语句的解析
        String script = "int a = b+3;";
        System.out.println("解析变量声明语句："+script);
        SimpleLexer lexer = new SimpleLexer();
        TokenReader tokens = lexer.tokenize(script);
        try {
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
