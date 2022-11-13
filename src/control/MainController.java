package control;

import model.Exam;
import model.Stack;

/**
 * Created by Jean-Pierre on 01.11.2016.
 */
public class MainController {

     //TODO: 02 - Sobald der Stack implementiert ist, wird der Controller um die Datenstruktur erweitert.
    private Stack<Exam> stackOfUncorrected;
    private Exam currentCorrection;
    private Stack<Exam> stackOfCorrected;
    private char pupilName;


    /**
     * Ein Objekt der Klasse MainController wird erstellt. Die Schüler beginnen mit dem Buchstaben A.
     * Zwei Stacks werden inistialisert.
     */
    public MainController(){
        pupilName = 'A';
        stackOfUncorrected = new Stack<>();
        stackOfCorrected = new Stack<>();
        //TODO: 03 - Hier muss später eine Initialisierung der Stacks stattfinden.
    }

    /**
     *
     * @return String-Array mit allen Informationen zu den unkorrigierten Klausuren.
     */
    public String[] showUncorrectedExams(){
        //TODO: 05 - Bei einem Stack ist es unüblich, auf alle Daten innerhalb des Stacks zuzugreifen. Gerade das ist hier aber nötig! Hier muss mit einem "Trick" gearbeitet werden, ohne die Klasse Stack zu überarbeiten.
        String[] output;
        if(stackOfUncorrected.isEmpty()){
            output = new String[1];
            output[0] = "Stapel ist leer.";
        }else{
            Stack<Exam> helpStack = new Stack<>();
            int stackSize = 0;
            while (!stackOfUncorrected.isEmpty()){
                stackSize++;
                helpStack.push(stackOfUncorrected.top());
                stackOfUncorrected.pop();
            }

            output = new String[stackSize];
            for(int i = 0; i< stackSize ; i++){
                output[i] = helpStack.top().toString();
                stackOfUncorrected.push(helpStack.top());
                helpStack.pop();
            }
        }
        return output;
        /*String[] output = new String[1];
        if(stackOfUncorrected != null){
            output[0] = stackOfUncorrected.toString();
        }else{
            output[0] = "Stapel ist leer.";
        }
        return output;*/
    }

    /**
     *
     * @return Informationen zur Klausur, die aktuell korrigiert wird, sofern eine Klausur vorhanden ist.
     */
    public String showCurrentCorrection(){
        if(currentCorrection != null){
            return currentCorrection.toString();
        }
        return "Aktuell keine Korrektur.";
    }

    /**
     *
     * @return String-Array mit allen Informationen zu den korrigierten Klausuren.
     */
    public String[] showCorrectedExams(){
        //TODO: 08 - siehe die Methode showUncorrectedExams!
        String[] output;
        if(stackOfCorrected.isEmpty()){
            output = new String[1];
            output[0] = "Stapel ist leer.";
        }else{
            Stack<Exam> helpStack = new Stack<>();
            int stackSize = 0;
            while (!stackOfCorrected.isEmpty()){
                stackSize++;
                helpStack.push(stackOfCorrected.top());
                stackOfCorrected.pop();
            }

            output = new String[stackSize];
            for(int i = 0; i< stackSize ; i++){
                output[i] = helpStack.top().toString();
                stackOfCorrected.push(helpStack.top());
                helpStack.pop();
            }
        }
        return output;
        /*String[] output = new String[1];
        if(stackOfCorrected != null){
            output[0] = stackOfCorrected.toString();
        }else{
            output[0] = "Stapel ist leer.";
        }
        return output;*/
    }

    /**
     * Eine neue Klausur wird auf den Stapel der unkorrigierten Klausuren gelegt.
     * @return Informationen zur neuen, unkorrigierten Klausur.
     */
    public String addNewExam(){
        //TODO: 04 - Hinzufügen von Objekten auf den Stack.
        Exam newExam = new Exam(String.valueOf(pupilName));
        stackOfUncorrected.push(newExam);
        pupilName++;
        return stackOfUncorrected.toString();
    }

    /**
     * Die oberste Klausur des unkorrigierten Stapels soll korrigiert werden, falls eine unkorrigierte vorhanden ist und gerade keine korrigiert wird.
     * @return true, falls keine Klausur gerade korrigiert wird und eine unkorrigierte Klausur vorahnden ist, sonst false.
     */
    public boolean startCorrection(){
        //TODO: 06 - Entfernen des obersten Objekts eines Stack.
        if(!stackOfUncorrected.isEmpty() && currentCorrection == null){
            currentCorrection = stackOfCorrected.top();
            stackOfUncorrected.pop();
            return true;
        }
        return false;
        /*if(currentCorrection == null && stackOfUncorrected != null){
            currentCorrection = stackOfUncorrected;
            stackOfUncorrected = null;
            return true;
        }
        return false;*/
    }

    /**
     * Die aktuelle Klausur wurde fertig korrigiert und wird auf den Stapel der bereits korrigierten Klausuren gelegt.
     * @return Informationen zur korrigierten Klausur, falls vorhanden, sonst ein Hinweis, dass keine Klausur korrigiert wurde.
     */
    public String endCorrection(){
        //TODO: 07 - Hinzufügen von Objekten auf den Stack.
        if(currentCorrection != null){
            stackOfCorrected.push(currentCorrection);
            currentCorrection = null;
            return  stackOfCorrected.toString();
        }
        return "keine Klausur";
        /*if(currentCorrection != null){
            stackOfCorrected = currentCorrection;
            currentCorrection = null;
            return stackOfCorrected.toString();
        }
        return "keine Klausur";*/
    }
}
