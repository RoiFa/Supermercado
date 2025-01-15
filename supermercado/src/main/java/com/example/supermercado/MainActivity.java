package com.example.supermercado;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    boolean first = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.landscape);
        }else{
            setContentView(R.layout.activity_main);
        }
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Spinner spinner=findViewById(R.id.spinner);
            ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.lenguages, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
            return insets;
        });
    }


    public void changeRec(View view){Intent intent = new Intent(this,Recuperacion.class); startActivity(intent);}

    public void changeReg(View view){Intent intent = new Intent(this,Registro.class);startActivity(intent);}

    public void log(View view){Intent intent = new Intent(this,LoginCorrecto.class);startActivity(intent);}

    public void login(View view){
        TextView editText1 = findViewById(R.id.editText1);
        TextView editText2 = findViewById(R.id.editText2);
        if(editText1.getText().toString().equals("RoiFA")&&editText2.getText().toString().equals("abc123.")){
            log(view);
        }
        if(!editText1.getText().toString().equals("RoiFA")){
            editText1.setText("");
            editText2.setText("");
        }else if(!editText2.getText().toString().equals("abc123.")){
            editText2.setText("");
        }
    }

    public void google(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")));
    }

    public void facebook(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/")));
    }

    public void ocult(View view){
        ImageView btn = findViewById(R.id.icono5);
        EditText btn2 = findViewById(R.id.editText2);
        if(btn2.getTransformationMethod()==null){
            btn2.setTransformationMethod(new PasswordTransformationMethod());
            int res = getResources().getIdentifier("screenshot_from_2024_11_20_20_48_55","drawable",this.getPackageName());
            btn.setImageResource(res);
        }else{
            btn2.setTransformationMethod(null);
            int res = getResources().getIdentifier("screenshot_from_2024_11_20_20_49_03","drawable",this.getPackageName());
            btn.setImageResource(res);
        }
    }

    public void keepAccount(View view){
        Button btn = findViewById(R.id.Button03);
        if(btn.getText().toString().equals("X")){
            btn.setText("");
        }else{
            btn.setText("X");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(first){
            String idiom = adapterView.getItemAtPosition(i).toString();
            Locale myLocale=null;
            Resources res;
            DisplayMetrics dm;
            Configuration conf;
            Intent refresh;
            switch (idiom){
                case "Español":
                    myLocale = new Locale("es");
                    res = getResources();
                    dm = res.getDisplayMetrics();
                    conf = res.getConfiguration();
                    conf.locale = myLocale;
                    res.updateConfiguration(conf, dm);
                    refresh = new Intent(this, MainActivity.class);
                    finish();
                    startActivity(refresh);
                    break;
                case "Français":
                    myLocale = new Locale("fr");
                    res = getResources();
                    dm = res.getDisplayMetrics();
                    conf = res.getConfiguration();
                    conf.locale = myLocale;
                    res.updateConfiguration(conf, dm);
                    refresh = new Intent(this, MainActivity.class);
                    finish();
                    startActivity(refresh);
                    break;
                case "English":
                    myLocale = new Locale("en");
                    res = getResources();
                    dm = res.getDisplayMetrics();
                    conf = res.getConfiguration();
                    conf.locale = myLocale;
                    res.updateConfiguration(conf, dm);
                    refresh = new Intent(this, MainActivity.class);
                    finish();
                    startActivity(refresh);
                    break;
                default:
                    break;
            }
        }else{
            first=true;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}