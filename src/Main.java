
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Questionnaire questionnaire = new Questionnaire();
        QuestionAndAnswer qa = new QuestionAndAnswer();
        Scanner scanner = new Scanner(System.in);
        String[] questions = {
                "What is your favorite product?",
                "Why is this product your favorite?",
                "If you could change one thing, what would it be?",
                "In what ways do you find yourself using the product?",
                "Do you want to delete this product immediately?"
        };

        try{
            Questionnaire.loadQuestionnaire();
            int count = 1;
            for(Questionnaire q : QuestionAndAnswer.questionAnswers) {
                System.out.printf("Q%d: %s\n",count, q.getQuestion());
                System.out.printf("A%d: %s\n",count, q.getAnswer());
                System.out.println();
                count++;
            }
        }catch(Exception e){
            System.out.println("I see you have not done this survey before.");
        }

        System.out.println("Would you like to change any answers?");

        String userAnswer = scanner.nextLine().toLowerCase();
        if(userAnswer.equals("y")) {
            boolean isTrue = true;
            while(isTrue) {
                isTrue = Questionnaire.updateAnswers(scanner);
            }
        }else{
            for (String q : questions) {

                System.out.println(q);
                String answer = scanner.nextLine();
                Questionnaire qA = new Questionnaire(q, answer);
                questionnaire.storeQuestionAndAnswer(qA);
            }
        }

        System.out.println("Would you like to save your answers? [y/n] ");
        String a = scanner.nextLine();
        if(a.equals("y")) {
            questionnaire.saveFile();
        }
    }
}