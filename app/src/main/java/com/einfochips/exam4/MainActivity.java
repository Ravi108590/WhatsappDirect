package com.einfochips.exam4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.einfochips.exam4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(mainBinding.getRoot());

        mainBinding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number =  mainBinding.number.getText().toString();
                //String Whatsapp = forWhatsapp.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plane");
                intent.setPackage("com.whatsapp");
                intent.putExtra(Intent.EXTRA_TEXT,"Chandan Kumar");
                startActivity(Intent.createChooser(intent,"Suggest ot Friends"));
            }
        });

        mainBinding.r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Custom_message f1 = new Custom_message();
                loadFragment(f1);
            }
        });
        mainBinding.r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bydefault f2 = new Bydefault();
                loadFragment(f2);
            }
        });


    }




    public void loadFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,fragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mainmanu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.settings:
                Intent i = new Intent(this,SetMessage.class);
                startActivity(i);
                break;
            case R.id.share:
                String Whatsapp = "Hello, I'm chandan kumar!,app testing";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plane");
                intent.setPackage("com.whatsapp");
                intent.putExtra(Intent.EXTRA_TEXT,Whatsapp);
                startActivity(Intent.createChooser(intent,"Suggest ot Friends"));
                break;
            case R.id.Disclaimer:
                Toast.makeText(getApplicationContext(),"Disclaimer",Toast.LENGTH_SHORT).show();
                break;
            case R.id.privacyPolicy:
                Toast.makeText(getApplicationContext(),"Privacy Policy",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Terms:
                Toast.makeText(getApplicationContext(),"Terms and Condition",Toast.LENGTH_SHORT).show();
                break;
            case R.id.OtherApp:
                Toast.makeText(getApplicationContext(),"Other Apps",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}