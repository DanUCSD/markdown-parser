//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        String[] lines = markdown.split("\n");
        for (String s: lines){
            int openParentheses = s.indexOf("(");
            int closeParentheses = s.length()-1;
            toReturn.add(s.substring(openParentheses + 1, closeParentheses));
        }
        return toReturn;
        
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
