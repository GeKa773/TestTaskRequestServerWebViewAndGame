package gekaradchenko.gmail.com.worktask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameActivityViewModel extends ViewModel {
    private int score = 0;
    private MutableLiveData<Integer> integerMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<Integer> setScore() {
        integerMutableLiveData.setValue(score);
        return integerMutableLiveData;
    }

    public int getScore() {
        return score;
    }

    public void getIncreasedValue() {
        ++score;
        integerMutableLiveData.setValue(score);
    }

    public void getDecreasedValue() {
        score -= 2;
        if (score < 0) score = 0;
        integerMutableLiveData.setValue(score);

    }

    public void getBeginValue() {
        score = 0;
        integerMutableLiveData.setValue(score);
    }
}
