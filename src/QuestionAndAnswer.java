import java.util.ArrayList;
import java.util.List;

/**
 * Created by BHarris on 2/8/17.
 */
public class QuestionAndAnswer {
    static List<Questionnaire> questionAnswers = new ArrayList<>();

    public QuestionAndAnswer(){

    }

    public List<Questionnaire> getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(List<Questionnaire> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }
}
