package com.ggm.example.speldemo.parser;

import com.ggm.example.speldemo.data.User;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ExpressionParserDemo {

    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();

        writingAndParsingDemo(parser);
        evaluationContextDemo(parser);
    }

    public static void evaluationContextDemo(SpelExpressionParser parser) {
        StandardEvaluationContext ec1 = new StandardEvaluationContext();
        ec1.setVariable("greeting", "Hello USA");
        Expression exp1 = parser.parseExpression("#greeting.substring(6)");
        System.out.println(exp1.getValue(ec1));

        User user = new User("Armenia", "AM");
        StandardEvaluationContext userContext = new StandardEvaluationContext(user);
        parser.parseExpression("country").setValue(userContext, "Armenia");
        parser.parseExpression("language").setValue(userContext, "AM");
        parser.parseExpression("timeZone").setValue(userContext, "Armenia/Yerevan");
        System.out.println(user);

        StandardEvaluationContext propsContext = new StandardEvaluationContext();
        propsContext.setVariable("systemProperties", System.getProperties());
        Expression expCountry = parser.parseExpression("#systemProperties['user.country']");
        parser.parseExpression("country").setValue(userContext, expCountry.getValue(propsContext));
        System.out.println(user.getCountry());

        Expression expLanguage = parser.parseExpression("#systemProperties['user.language']");
        parser.parseExpression("language").setValue(userContext, expLanguage.getValue(propsContext));
        System.out.println(user.getLanguage());

        Expression expTimeZone = parser.parseExpression("#systemProperties['user.timezone']");
        parser.parseExpression("timeZone").setValue(userContext, expTimeZone.getValue(propsContext));
        System.out.println(user.getTimeZone());
    }

    public static void writingAndParsingDemo(SpelExpressionParser parser) {
        Expression exp1 = parser.parseExpression("'Hello World'");
        System.out.println(exp1.getValue());

        Expression exp2 = parser.parseExpression("'Hello World'.length()");
        System.out.println(exp2.getValue());

        Expression exp3 = parser.parseExpression("'Hello World'.length() * 10");
        System.out.println(exp3.getValue());

        Expression exp4 = parser.parseExpression("'Hello World'.length() > 10");
        System.out.println(exp4.getValue());

        Expression exp5 = parser.parseExpression("'Hello World'.length() > 10 and 'Hello World'.length() < 20");
        System.out.println(exp5.getValue());
    }
}
