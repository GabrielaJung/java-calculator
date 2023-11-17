package br.devGabriela;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button num_zero, one, two, three, four, five, six, seven, eight, nine,
            comma, sum, sub, multiply, div, equal, history, clear;

    private TextView txt_expressao, txt_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitComponents();

        num_zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        comma.setOnClickListener(this);
        sub.setOnClickListener(this);
        sum.setOnClickListener(this);
        multiply.setOnClickListener(this);
        div.setOnClickListener(this);
    }

    private void InitComponents(){

        num_zero = findViewById(R.id.num_zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        comma = findViewById(R.id.comma);
        history = findViewById(R.id.history);
        clear = findViewById(R.id.clear);
        div = findViewById(R.id.div);
        multiply = findViewById(R.id.multiply);
        sum = findViewById(R.id.sum);
        sub = findViewById(R.id.sub);
        equal = findViewById(R.id.equal);
        txt_expressao = findViewById(R.id.txt_expressao);
        txt_resultado = findViewById(R.id.txt_resultado);

    }

    public void AddExpression(String string, boolean cleanData){
        if(txt_resultado.getText().equals("")){
            txt_expressao.setText("");
        }

        if(cleanData){
            txt_resultado.setText("");
            txt_expressao.append(string);
        }else{
            txt_expressao.append(txt_resultado.getText());
            txt_expressao.append(string);
            txt_resultado.setText("");
        }
    }

    public void infoFn(View v){
        Toast.makeText(
                getBaseContext(),
                "Desenvolvido por Gabriela Jung",
                Toast.LENGTH_LONG).show();
    }

    public void openHistory(View v){
        Intent it = new Intent (getBaseContext(), History.class);
        startActivity(it);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.num_zero){
            AddExpression("0", true);
        } else if (view.getId() == R.id.one){
            AddExpression("1", true);
        } else if (view.getId() == R.id.two){
            AddExpression("2", true);
        } else if (view.getId() == R.id.three){
            AddExpression("3", true);
        } else if (view.getId() == R.id.four){
            AddExpression("4", true);
        } else if (view.getId() == R.id.five){
            AddExpression("5", true);
        } else if (view.getId() == R.id.six){
            AddExpression("6", true);
        } else if (view.getId() == R.id.seven){
            AddExpression("7", true);
        } else if (view.getId() == R.id.eight){
            AddExpression("8", true);
        } else if (view.getId() == R.id.nine){
            AddExpression("9", true);
        } else if (view.getId() == R.id.comma){
            AddExpression(",", true);
        } else if (view.getId() == R.id.sum){
            AddExpression("+", false);
        } else if (view.getId() == R.id.sub){
            AddExpression("-", false);
        } else if (view.getId() == R.id.multiply){
            AddExpression("*", false);
        } else if (view.getId() == R.id.div){
            AddExpression("/", false);
        }

    }
}