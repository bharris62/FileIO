import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Questionnaire {
    String question;
    String answer;
    List<Questionnaire> questionAnswers = new ArrayList<>();

    public Questionnaire(){

    }

    public Questionnaire(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public void saveFile() throws IOException {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("questionAnswers").serialize(questionAnswers);

        File f = new File("questionnaire.json");
        FileWriter fw = new FileWriter(f);

        fw.write(json);
        fw.close();
    }

    public static Questionnaire loadQuestionnaire() throws FileNotFoundException {
        File f = new File("questionnaire.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();
        s.close();

        JsonParser p = new JsonParser();
        return p.parse(contents, Questionnaire.class);
    }

    public void printFile(){
        for (Questionnaire q : questionAnswers) {
            System.out.printf("Question: %s\nAnswer: %s\n", q.question,q.answer);
        }
    }

    public void storeQuestionAndAnswer(Questionnaire q) {
        questionAnswers.add(q);
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


    public List<Questionnaire> getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(List<Questionnaire> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }
}
