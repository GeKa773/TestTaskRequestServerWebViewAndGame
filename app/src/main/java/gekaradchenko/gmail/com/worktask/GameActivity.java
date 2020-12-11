package gekaradchenko.gmail.com.worktask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private int score = -1;
    private TextView titleTextView;
    private TextView scoreTextView;

    private Button oneButtonRowCount1, twoButtonRowCount1, threeButtonRowCount1, forButtonRowCount1;
    private Button oneButtonRowCount2, twoButtonRowCount2, threeButtonRowCount2, forButtonRowCount2;
    private Button oneButtonRowCount3, twoButtonRowCount3, threeButtonRowCount3, forButtonRowCount3;
    private Button oneButtonRowCount4, twoButtonRowCount4, threeButtonRowCount4, forButtonRowCount4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        init();
        setEnabledFalseAndVisibilityInvisible();

    }

    private void init() {


        titleTextView = findViewById(R.id.titleTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        oneButtonRowCount1 = findViewById(R.id.oneButtonRowCount1);
        twoButtonRowCount1 = findViewById(R.id.twoButtonRowCount1);
        threeButtonRowCount1 = findViewById(R.id.threeButtonRowCount1);
        forButtonRowCount1 = findViewById(R.id.forButtonRowCount1);
        oneButtonRowCount2 = findViewById(R.id.oneButtonRowCount2);
        twoButtonRowCount2 = findViewById(R.id.twoButtonRowCount2);
        threeButtonRowCount2 = findViewById(R.id.threeButtonRowCount2);
        forButtonRowCount2 = findViewById(R.id.forButtonRowCount2);
        oneButtonRowCount3 = findViewById(R.id.oneButtonRowCount3);
        twoButtonRowCount3 = findViewById(R.id.twoButtonRowCount3);
        threeButtonRowCount3 = findViewById(R.id.threeButtonRowCount3);
        forButtonRowCount3 = findViewById(R.id.forButtonRowCount3);
        oneButtonRowCount4 = findViewById(R.id.oneButtonRowCount4);
        twoButtonRowCount4 = findViewById(R.id.twoButtonRowCount4);
        threeButtonRowCount4 = findViewById(R.id.threeButtonRowCount4);
        forButtonRowCount4 = findViewById(R.id.forButtonRowCount4);

        oneButtonRowCount1.setOnClickListener(this);
        twoButtonRowCount1.setOnClickListener(this);
        threeButtonRowCount1.setOnClickListener(this);
        forButtonRowCount1.setOnClickListener(this);
        oneButtonRowCount2.setOnClickListener(this);
        twoButtonRowCount2.setOnClickListener(this);
        threeButtonRowCount2.setOnClickListener(this);
        forButtonRowCount2.setOnClickListener(this);
        oneButtonRowCount3.setOnClickListener(this);
        twoButtonRowCount3.setOnClickListener(this);
        threeButtonRowCount3.setOnClickListener(this);
        forButtonRowCount3.setOnClickListener(this);
        oneButtonRowCount4.setOnClickListener(this);
        twoButtonRowCount4.setOnClickListener(this);
        threeButtonRowCount4.setOnClickListener(this);
        forButtonRowCount4.setOnClickListener(this);
    }

// клик по кнопкам
    @Override
    public void onClick(View v) {
        score++;
        scoreTextView.setText(score+"");

        setEnabledFalseAndVisibilityInvisible();
        setVisibilityAndEnable();
    }

    //
    private void setEnabledFalseAndVisibilityInvisible() {
        oneButtonRowCount1.setEnabled(false);
        twoButtonRowCount1.setEnabled(false);
        threeButtonRowCount1.setEnabled(false);
        forButtonRowCount1.setEnabled(false);
        oneButtonRowCount2.setEnabled(false);
        twoButtonRowCount2.setEnabled(false);
        threeButtonRowCount2.setEnabled(false);
        forButtonRowCount2.setEnabled(false);
        oneButtonRowCount3.setEnabled(false);
        twoButtonRowCount3.setEnabled(false);
        threeButtonRowCount3.setEnabled(false);
        forButtonRowCount3.setEnabled(false);
        oneButtonRowCount4.setEnabled(false);
        twoButtonRowCount4.setEnabled(false);
        threeButtonRowCount4.setEnabled(false);
        forButtonRowCount4.setEnabled(false);

        oneButtonRowCount1.setVisibility(View.INVISIBLE);
        twoButtonRowCount1.setVisibility(View.INVISIBLE);
        threeButtonRowCount1.setVisibility(View.INVISIBLE);
        forButtonRowCount1.setVisibility(View.INVISIBLE);
        oneButtonRowCount2.setVisibility(View.INVISIBLE);
        twoButtonRowCount2.setVisibility(View.INVISIBLE);
        threeButtonRowCount2.setVisibility(View.INVISIBLE);
        forButtonRowCount2.setVisibility(View.INVISIBLE);
        oneButtonRowCount3.setVisibility(View.INVISIBLE);
        twoButtonRowCount3.setVisibility(View.INVISIBLE);
        threeButtonRowCount3.setVisibility(View.INVISIBLE);
        forButtonRowCount3.setVisibility(View.INVISIBLE);
        oneButtonRowCount4.setVisibility(View.INVISIBLE);
        twoButtonRowCount4.setVisibility(View.INVISIBLE);
        threeButtonRowCount4.setVisibility(View.INVISIBLE);
        forButtonRowCount4.setVisibility(View.INVISIBLE);
    }

    // рандом выберает кнопку
    private void setVisibilityAndEnable() {
        Random random = new Random();
        int i = random.nextInt(15) + 1;
        switch (i) {
            case 1: {
                oneButtonRowCount1.setEnabled(true);
                oneButtonRowCount1.setVisibility(View.VISIBLE);
                break;
            }
            case 2: {
                twoButtonRowCount1.setEnabled(true);
                twoButtonRowCount1.setVisibility(View.VISIBLE);
                break;
            }
            case 3: {
                threeButtonRowCount1.setEnabled(true);
                threeButtonRowCount1.setVisibility(View.VISIBLE);
                break;
            }
            case 4: {
                forButtonRowCount1.setEnabled(true);
                forButtonRowCount1.setVisibility(View.VISIBLE);
                break;
            }
            case 5: {
                oneButtonRowCount2.setEnabled(true);
                oneButtonRowCount2.setVisibility(View.VISIBLE);
                break;
            }
            case 6: {
                twoButtonRowCount2.setEnabled(true);
                twoButtonRowCount2.setVisibility(View.VISIBLE);
                break;
            }
            case 7: {
                threeButtonRowCount2.setEnabled(true);
                threeButtonRowCount2.setVisibility(View.VISIBLE);
                break;
            }
            case 8: {
                forButtonRowCount2.setEnabled(true);
                forButtonRowCount2.setVisibility(View.VISIBLE);
                break;
            }
            case 9: {
                oneButtonRowCount3.setEnabled(true);
                oneButtonRowCount3.setVisibility(View.VISIBLE);
                break;
            }
            case 10: {
                twoButtonRowCount3.setEnabled(true);
                twoButtonRowCount3.setVisibility(View.VISIBLE);
                break;
            }
            case 11: {
                threeButtonRowCount3.setEnabled(true);
                threeButtonRowCount3.setVisibility(View.VISIBLE);
                break;
            }
            case 12: {
                forButtonRowCount3.setEnabled(true);
                forButtonRowCount3.setVisibility(View.VISIBLE);
                break;
            }
            case 13: {
                oneButtonRowCount4.setEnabled(true);
                oneButtonRowCount4.setVisibility(View.VISIBLE);
                break;
            }
            case 14: {
                twoButtonRowCount4.setEnabled(true);
                twoButtonRowCount4.setVisibility(View.VISIBLE);
                break;
            }
            case 15: {
                threeButtonRowCount4.setEnabled(true);
                threeButtonRowCount4.setVisibility(View.VISIBLE);
                break;
            }
            case 16: {
                forButtonRowCount4.setEnabled(true);
                forButtonRowCount4.setVisibility(View.VISIBLE);
                break;
            }


        }
    }

    // промах по кнопке
    public void missClick(View view) {
        score -= 2;
        if (score<0)score = 0;
        scoreTextView.setText(score+"");
    }

    // запуск таймера
    public void runTimer(View view) {
        score=0;
        titleTextView.setEnabled(false);
        setEnabledFalseAndVisibilityInvisible();
        setVisibilityAndEnable();
        MyTimer myTimer = new MyTimer(30000,1000);
        myTimer.start();

    }

    // таймер
    private class MyTimer extends CountDownTimer{


        public MyTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int seconds = (int) (millisUntilFinished/1000);
            if (seconds<10) titleTextView.setText("00:0" +seconds);
            else titleTextView.setText("00:"+seconds);

        }

        @Override
        public void onFinish() {

            setEnabledFalseAndVisibilityInvisible();
            titleTextView.setEnabled(true);
            titleTextView.setText("Баллы: "+score );
            Toast.makeText(GameActivity.this, "Finish", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // Делаем первый запуск
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "ajaahhaha", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(GameActivity.this, MainActivity.class);
        intent.putExtra("isFirstStart",true);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}