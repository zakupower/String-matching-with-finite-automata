import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Tomov on 31.3.2017 г..
 */

public class StringAutomata {
    private char[] automata;
    private ArrayList<Integer> matchedIndexes;
    private ArrayList<String> matchedStrings;
    private final char WILDCARD = '*';

    public StringAutomata(String stringToSearch){
        automata = stringToSearch.toCharArray();
    }

    public boolean search(String textToSearch) {

        matchedIndexes = new ArrayList<Integer>();
        matchedStrings = new ArrayList<String>();
        int pointer=0;
        for(int i = 0; i < textToSearch.length(); i++) {

            if(charsMatch(automata[pointer],textToSearch.charAt(i))) {
                pointer++;
            } else {
                pointer=0;
                if (charsMatch(automata[pointer],textToSearch.charAt(i))) {
                    pointer++;
                }
            }
            if(pointer==automata.length) {
                matchedIndexes.add(i - (automata.length-1));
                matchedStrings.add(textToSearch.substring(i - (automata.length-1),i+1));
                pointer=0;
            }
        }

        return !(matchedIndexes.size()==0);
    }
    private boolean charsMatch(char textChar, char searchChar) {
        if(searchChar==textChar) return true;
        if(textChar==WILDCARD) return true;
        return false;
    }
    public boolean search(File file) throws IOException {
        return search(makeStringFromFile(file));
    }
    private static String makeStringFromFile(File file) throws IOException {
        StringBuilder string = new StringBuilder();
        Scanner sc = new Scanner(new FileReader(file));
        while(sc.hasNextLine()) {
            string.append(sc.nextLine());
            string.append("\n");
        }
        return string.toString();
    }
    public int getCount() {
        return matchedIndexes.size();
    }
    public ArrayList<Integer> getMatchedIndexes() {
        return matchedIndexes;
    }
    public ArrayList<String> getMatchedStrings() {
        return matchedStrings;
    }

}
