
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Questionnaire questionnaire = new Questionnaire();
        QuestionAndAnswer qa = new QuestionAndAnswer();
        Scanner scanner = new Scanner(System.in);

        try{
            Questionnaire.loadQuestionnaire();
            Questionnaire.printQuestionAndAnswers(scanner);

            System.out.println("Would you like to change any answers?");
            String userAnswer = scanner.nextLine().toLowerCase();
            if(userAnswer.equals("y")) {
                boolean isTrue = true;
                while(isTrue) {
                    isTrue = Questionnaire.updateAnswers(scanner);
                }
            }
        }catch(Exception e){
            System.out.println("I see you have not done this survey before.");
            questionnaire.answerSurveyQuestions(scanner);

        }
        System.out.println("Would you like to save your answers? [y/n] ");
        String a = scanner.nextLine();
        if(a.equals("y")) {
            questionnaire.saveFile();
        }
    }
}