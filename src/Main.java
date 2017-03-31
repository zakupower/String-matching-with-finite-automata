import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to search for: ");
        StringAutomata searcher = new StringAutomata(sc.next());
        //System.out.println(searcher.search(new File("text.txt")));
        System.out.println(searcher.search(new File("links.txt")));
        //System.out.println(searcher.search("Hello dear friends how are you doing nenoneno nano nennni"));
        System.out.println(searcher.getMatchedIndexes());
        System.out.println(searcher.getMatchedStrings());
    }


}
