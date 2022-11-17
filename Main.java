import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        List<List<String>> listLines = new ArrayList<>();
        File file=new File("C:\\Users\\toshiba\\Desktop\\Scoala\\AN 3\\LFTC\\laboratory3\\file.csv");
        //Creates a file instance fileReaderom which we will be reading fileReaderom

        FileReader fileReader = new FileReader(file);
        //Reads the file

        BufferedReader buffer = new BufferedReader(fileReader);
        StringBuffer StringBuilder = new StringBuffer();
        //Creates a string buffer with no characters

        String line;

        while((line=buffer.readLine())!=null) {

            String[] splitted = line.split(",");
            //Gets each character from the file between ","

            List<String> everyLine = new ArrayList<>();
            for (String s : splitted){
                everyLine.add(s);
            }

            listLines.add(everyLine);

        }

        String finalState = "The final states : ";

        List<String> stateList = new ArrayList<>();
        List<String> alphabet = new ArrayList<>();

        System.out.println("Transitions : ");


        for (List<String> elem : listLines){
            for(String s : elem) {
                if (s.equals("final"))
                    finalState = finalState + " " + elem.get(0);
            }

            if(!stateList.contains(elem.get(0))){
                stateList.add(elem.get(0));
            }

            if(!stateList.contains(elem.get(elem.size()-1)) && stateList.size()>=3){
                stateList.add(elem.get(elem.size()-1));
            }

            if(!alphabet.contains(elem.get(1)) && elem.size()>=3){
                alphabet.add(elem.get(1));
            }

            if(elem.size()>=3){
                System.out.println(" [ " + elem.get(0) + " ; "+ elem.get(1) + " ] " + " = " + elem.get(2));
            }

        }

        System.out.println();
        //Prints the Transitions

        String states = "States : ";

        for(String i : stateList)
            states = states + " " + i;

        System.out.println(states);

        System.out.println();

        System.out.println(finalState);

        System.out.println();
        //Prints the final states

        String characters = "Alphabet : ";

        for (String elem : alphabet)
            characters  = characters + " " + elem;

        System.out.println(alphabet);
        //Prints the alphabet
    }
}
