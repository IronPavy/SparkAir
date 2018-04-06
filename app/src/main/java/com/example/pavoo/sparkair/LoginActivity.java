package com.example.pavoo.sparkair;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.orm.SugarContext;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    Button login, register;
    EditText emailText, passText;
    public int id;
    public String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SugarContext.init(this);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        register = findViewById(R.id.registerBtn);
        emailText = findViewById(R.id.emailText);
        passText = findViewById(R.id.passText);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !passText.getText().toString().equals("") && !emailText.getText().toString().equals("")){ //Lozinka i korisnicko moraju biti popunjeni
                    if(checkLogin()==true){
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                        String store = preferences.getString("lllogin", "");
                        if(store.equalsIgnoreCase(""))
                        {
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("lllogin",""+id);
                            editor.commit();
                        }
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("id", id);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Korisničko ime/lozinka ne postoji/netocno.", Toast.LENGTH_SHORT).show();
                        passText.setText("");
                        emailText.setText("");
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Niste unijeli korsnicko ime/lozinku.", Toast.LENGTH_SHORT).show();
                }
            }

        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }

    public boolean checkLogin(){

        List<usersugar> allUsers = usersugar.listAll(usersugar.class);

        boolean rtrn = false;
        if(allUsers.isEmpty()){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();

        }else{

            for(int i = 0;i<allUsers.size();i++) {

                String a = allUsers.get(i).getLogin();
                String b = allUsers.get(i).getPassword();

                if ((a.equals(emailText.getText().toString())) && (b.equals(passText.getText().toString()))) {
                    email = a;
                    password = b;
                    id = Integer.parseInt(String.valueOf(allUsers.get(i).getId()));
                    rtrn = true;
                    Toast.makeText(this, "Uspjesno ulogirani!", Toast.LENGTH_SHORT).show();
                }
            }
        }
        return rtrn;
    }
}
