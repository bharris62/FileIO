import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Questionnaire {
    String question;
    String answer;


    public Questionnaire(){

    }

    public Questionnaire(String question, String answer) {
        this.question = question;
        this.answer = answer;

    }

    public void saveFile() throws IOException {
        QuestionAndAnswer qa = new QuestionAndAnswer();
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("questionAnswers").serialize(qa);

        File f = new File("questionnaire.json");
        FileWriter fw = new FileWriter(f);

        fw.write(json);
        fw.close();
    }

    public static QuestionAndAnswer loadQuestionnaire() throws FileNotFoundException {

        File f = new File("questionnaire.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();
        s.close();

        JsonParser p = new JsonParser();
        return p.parse(contents, QuestionAndAnswer.class);
    }

    public void printFile(){
        for (Questionnaire q : QuestionAndAnswer.questionAnswers) {
            System.out.printf("Question: %s\nAnswer: %s\n", q.question,q.answer);
        }
    }

    public void storeQuestionAndAnswer(Questionnaire q) {
        QuestionAndAnswer.questionAnswers.add(q);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public static boolean updateAnswers(Scanner scanner) {
        boolean isTrue = true;
        System.out.println("What number would you like to change?");
        int numToChange = Integer.parseInt(scanner.nextLine());
        System.out.println("What would you like to chagne it to? ");
        String userInput = scanner.nextLine();
        Questionnaire updatedAnswer = QuestionAndAnswer.questionAnswers.get(numToChange - 1);
        updatedAnswer.answer = userInput;
        System.out.println("Would you like to change anythign else? [y/n]");
        String userResp = scanner.nextLine().toLowerCase();
        if(userResp.equals("n")){
            isTrue = false;
        }
        return isTrue;
    }
}