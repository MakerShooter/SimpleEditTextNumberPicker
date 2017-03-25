package com.example.android.numberpicker;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textResult;
    private EditText editInput;
    private Button buttonChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          textResult =  (TextView) findViewById(R.id.text_result);
          editInput = (EditText) findViewById(R.id.text_input);
          buttonChange = (Button) findViewById(R.id.button_change);
        buttonChange.setText("zobacz co się stanie!!");

        //this enable the focus on the editText, hide also the keyboard
        editInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

//this show small pop up at the button of the page, to nadpisuje metodę onClick
        buttonChange.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String str = editInput.getText().toString();
                Toast msg = Toast.makeText(getBaseContext(),str,Toast.LENGTH_LONG);
                msg.show();
                textResult.setText(str);

            }
        });


    }
    /**
     *@param view this show message on the Text Box
     * */

    public void showEditTextContent(View view) {
        String strEditText = editInput.getText().toString();
        textResult.setText(strEditText);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
//-----------------------------------------------------------------------------------




}
