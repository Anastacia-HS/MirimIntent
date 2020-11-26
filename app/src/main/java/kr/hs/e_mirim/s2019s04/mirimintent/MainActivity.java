package kr.hs.e_mirim.s2019s04.mirimintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText editNum1, editNum2;
    RadioGroup radioGroup;
    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNum1 = findViewById(R.id.edit1);
        editNum2 = findViewById(R.id.edit2);
        radioGroup = findViewById(R.id.radiogroup);
        btnResult = findViewById(R.id.btn_result);
        btnResult.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("input1", editNum1.getText().toString());
            intent.putExtra("input2", editNum2.getText().toString());

            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.radio_plus:
                    intent.putExtra("calc", "+");
                    break;

                case R.id.radio_minus:
                    intent.putExtra("calc", "-");
                    break;

                case R.id.radio_multiple:
                    intent.putExtra("calc", "*");
                    break;

                case R.id.radio_division:
                    intent.putExtra("calc", "/");
                    break;
            }

            startActivity(intent);
        }
    };
}