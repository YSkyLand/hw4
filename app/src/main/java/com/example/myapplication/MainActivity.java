package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText , editText2 , editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews(){
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
    }

    private boolean isValid(EditText editText){
        String pattern = "1[0]{2}|[0-9]{1,2}";
        String text = editText.getText().toString();
        if (!text.matches(pattern)){
            editText.setError("0 ~ 100");
            return false;
        }
        else {
            return true;
        }
    }

    public void OnSubClick(View view){
        boolean isValid =
                isValid(editText) & isValid(editText2) & isValid(editText3);
        if (!isValid) {
            return;
        }

        int programming = Integer.parseInt(editText.getText().toString());
        int dataStructure = Integer.parseInt(editText2.getText().toString());
        int algorithm = Integer.parseInt(editText3.getText().toString());

        Intent intent = new Intent(this,showActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("programming",programming);
        bundle.putInt("dataStructure",dataStructure);
        bundle.putInt("algorithm",algorithm);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
