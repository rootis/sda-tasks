package lt.sdacademy.advanced;

import java.util.function.Function;

interface TextProcessor {

    String process(String text);    // s ->
}

class TextProcessorImpl implements TextProcessor {

    @Override
    public String process(String text) {
        return "Class implementation: " + text;
    }
}

public class Lambda {

    public static void method(TextProcessor processor) {
        System.out.println(processor.process("Some text"));
    }

    public static void method2(Function<String, String> fn) {
        System.out.println(fn.apply("Some magic"));
    }

    public static String transform(String text) {
        return "Static method: " + text;
    }

    public String transformText(String text) {
        return "Instance method: " + text;
    }

    public static void main(String[] args) {
        method(s -> "Tekstas: " + s);
        method(new TextProcessorImpl());
        method(Lambda::transform);
        method(new Lambda()::transformText);
        System.out.println("---");
        method2(s -> "Tekstas: " + s);
        method2(Lambda::transform);
        method2(new Lambda()::transformText);
    }
}
