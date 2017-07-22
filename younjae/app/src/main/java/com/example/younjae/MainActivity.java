package com.example.younjae;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    EditText et;
    String sfName;
    ImageButton save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.editText);
        save = (ImageButton) findViewById(R.id.save);

        SharedPreferences sf = getSharedPreferences(sfName,0);
        String str = sf.getString("name","");
        et.setText(str);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sf = getSharedPreferences(sfName, 0);
                SharedPreferences.Editor editor = sf.edit();
                String str = et.getText().toString();
                editor.putString("name", str);
                editor.commit();
            } });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.red :
                et.setTextColor(Color.RED);
                return true;
            case R.id.green :
                et.setTextColor(Color.GREEN);
                return true;
            case R.id.blue :
                et.setTextColor(Color.BLUE);
                return true;
            case R.id.share :
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"내용");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
