package com.example.timezone;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    TextView txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
    }

    private void Init() {
        try {
            txtTime = findViewById(R.id.txtTime);
            TimeZone tz = TimeZone.getDefault();
            String ourZone = tz.getDisplayName(false, TimeZone.SHORT);

            Calendar calendarTurkey = new GregorianCalendar(TimeZone.getTimeZone("America/Bahia_Banderas"));
            calendarTurkey.set(Calendar.HOUR, 4);
            calendarTurkey.set(Calendar.MINUTE, 30);
            calendarTurkey.set(Calendar.SECOND, 0);

            Calendar calendarOur = new GregorianCalendar(TimeZone.getTimeZone(ourZone));
            calendarOur.setTimeInMillis(calendarTurkey.getTimeInMillis());

            txtTime.setText(calendarOur.get(Calendar.HOUR) + " " + calendarOur.get(Calendar.MINUTE));
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
