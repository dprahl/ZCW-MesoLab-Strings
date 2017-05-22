package prahl.daniel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );

        App app = new App();
        app.start();
    }

    public void start(){
        testSplit();
    }

    public void regexExample(){
        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();
        // or Statically a one-shot
        boolean bool = Pattern.matches("a*b", "aaaaab");
    }

    public void testSplit(){
        String input = "every,good,boy,does,fine";
        String regex = ",";
        String[] list = input.split(regex, -1);
        for (String s: list) {
            System.out.println(s);
        }
    }

}
