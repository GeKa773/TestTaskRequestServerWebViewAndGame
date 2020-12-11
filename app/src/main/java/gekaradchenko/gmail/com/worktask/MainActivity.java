package gekaradchenko.gmail.com.worktask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences firstRun;
    private final String FIRST_RUN = "first_run";
    private final String WEB_VIEW_ACTIVITY = "vebViewActivity";
    private final String GAME_ACTIVITY = "gameActivity";
    private final String MAIN_ACTIVITY = "mainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstRun = getSharedPreferences(FIRST_RUN, MODE_PRIVATE);

        // Сделать первый запуск
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.getBoolean("isFirstStart")) {
                firstRun.edit().putBoolean("firstRun", true).commit();
            }
        }

        wasActivityWorking();
        isFirstRun();

    }

    // Получаем ответ от сервера
    private class GetServerAsyncTask extends AsyncTask<String, Void, String> {
        public static final String PATH = "https://java-test-server.herokuapp.com/";
        public static final String PATH_FALSE = "https://java-test-server.herokuapp.com/false";
        public static final String PATH_TRUE = "https://java-test-server.herokuapp.com/true";
        private Intent intent;

        @Override
        protected void onPostExecute(String bool) {
            super.onPostExecute(bool);
            System.out.println(bool + "   >>>>>>>>>>>>>>>");
            if (bool.trim().equals("true")) {
                firstRun.edit().putString("wasActivityWorking", WEB_VIEW_ACTIVITY).commit();
                intent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent);

            } else if (bool.trim().equals("false")) {
                firstRun.edit().putString("wasActivityWorking", GAME_ACTIVITY);
                Toast.makeText(MainActivity.this, "FALSE", Toast.LENGTH_SHORT).show();

                firstRun.edit().putString("wasActivityWorking", GAME_ACTIVITY);
                intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
            } else Toast.makeText(MainActivity.this, "BEDA", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected String doInBackground(String... strings) {
            String bool = getBool(PATH);

            return bool;
        }

        // Получение ответа от сервера
        private String getBool(String path) {
            try {
                URL url = new URL(path);
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(10000);
                connection.connect();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "No connected";
        }
    }

    // Проверка на первый запуск
    private void isFirstRun() {
        if (firstRun.getBoolean("firstRun", true)) {
            new GetServerAsyncTask().execute();

            wasActivityWorking();
            firstRun.edit().putBoolean("firstRun", false).commit();
        }

    }

    // Проверка на поледнее запущенное приложение
    private void wasActivityWorking() {
        if (firstRun.getString("wasActivityWorking", MAIN_ACTIVITY).equals(MAIN_ACTIVITY)) {
            System.out.println("MainActivity +>>>>>>>>>>>>>>>>>>");

        } else if (firstRun.getString("wasActivityWorking", MAIN_ACTIVITY).equals(WEB_VIEW_ACTIVITY)) {
            System.out.println("WebView +>>>>>>>>>>>>>>>>>>");
            startActivity(new Intent(MainActivity.this, WebViewActivity.class));


        } else if (firstRun.getString("wasActivityWorking", MAIN_ACTIVITY).equals(GAME_ACTIVITY)) {
            System.out.println("GameAcitvtiy +>>>>>>>>>>>>>>>>>>");
            startActivity(new Intent(MainActivity.this, GameActivity.class));

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}