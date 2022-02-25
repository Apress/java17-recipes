package org.java17recipes.chapter03.recipe03_12;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegexExamples {

    public static void main(String[] args) {
        findMatches();
        patternAndMatches();

    }
 
    public static void findMatches() {
        String str = "Here is a long String...let's find a match!";

// This will result in a "true" since it is an exact match
        boolean result = str.matches("Here is a long String...let's find a match!");

        System.out.println(result);

// This will result in "false" since the entire String does not match
        result = str.matches("Here is a long String...");

        System.out.println(result);

        str = "true";

// This will test against both upper & lower case "T"...this will be TRUE
        result = str.matches("[Tt]rue");

        System.out.println(result);

// This will test for one or the other
        result = str.matches("[Tt]rue|[Ff]alse]");

        System.out.println(result);

// This will test to see if any numbers are present, in this case the
// person writing this String would be able to like any Java release!

        str = "I love Java 8!";

        result = str.matches("I love Java [0-9]!");
        System.out.println(result);

// This will test "true" as well...
        str = "I love Java 7!";

        result = str.matches("I love Java [0-9]!");
        System.out.println(result);

// The following will test "true" for any language that contains
// only one word for a name.  This is because it tests for
// any alphanumeric combination.  Notice the space character
// between the numeric sequence...
        result = str.matches("I love .*[ 0-9]!");
        System.out.println(result);

// The following String also matches.
        str = "I love Jython 2.5.4!";
        result = str.matches("I love .*[ 0-9]!");

        System.out.println(result);


    }

    /**
     * This method pertains to Recipe 2-8, Solution #2
     */
    public static void patternAndMatches() {
        String str = "I love Java 17!";
        boolean result;

        Pattern pattern = Pattern.compile("I love .*[ 0-9]!");
        Matcher matcher = pattern.matcher(str);
        result = matcher.matches();

        System.out.println(result);
    }

    
}
