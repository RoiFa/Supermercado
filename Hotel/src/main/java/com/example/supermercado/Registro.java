package com.example.supermercado;

import static com.example.supermercado.MainActivity.nombres;
import static com.example.supermercado.MainActivity.passwd;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void change(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void changeRec(View view){Intent intent = new Intent(this,Recuperacion.class); startActivity(intent);}

    public void changeReg(View view){Intent intent = new Intent(this,Registro.class);startActivity(intent);}

    public void log(View view){Intent intent = new Intent(this,MainActivity.class);startActivity(intent);}

    public void login(View view){
        TextView editText1 = findViewById(R.id.editText1);
        TextView editText2 = findViewById(R.id.editText2);
        nombres = editText1.getText().toString();
        passwd = editText2.getText().toString();
        log(view);
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
}