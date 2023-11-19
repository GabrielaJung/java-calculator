package br.devGabriela;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // criando variáveis de button e textview com os nomes dos ids
     private Button num_zero, one, two, three, four, five, six, seven, eight, nine,
            comma, sum, sub, multiply, div, equal, history, clear;

    private TextView txt_expressao, txt_resultado;

    // ArrayList que irá conter valores em String para colocar no histórico
    public ArrayList<String> historicCalc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitComponents();

        /**
         * Ao clicar em um botão, aciona o evento onclick, passando o próprio elemento
         * como parâmetro para a função
         */
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
        history.setOnClickListener(this);

        /**
         * Limpa valores de expressão e resultado ao clicar no Button clear
         * */
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_expressao.setText("");
                txt_resultado.setText("");
            }
        });

        /**
         *  Ao clicar no botão de igual, os cálculos são realizados por meio da biblioteca
         *  objecthunter implementada.
         */
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // constrói a expressão
                    Expression expression = new ExpressionBuilder(txt_expressao.getText().toString()).build();

                    // retorna resultado
                    double result = expression.evaluate();
                    long longResult = (long) result;

                    // grava expressao antes de apagar
                    String expressao = txt_expressao.getText().toString();

                    // limpa campo de expressão
                    txt_expressao.setText("");

                    if(result == (double) longResult){
                        txt_resultado.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        txt_resultado.setText((CharSequence) String.valueOf(result));
                    }

                    // adiciona valor no arrayList do histórico de cálculos
                    String resultHistoric = expressao + " = " + txt_resultado.getText();
                    historicCalc.add(resultHistoric);

                } catch (Exception e){
                    Toast.makeText(
                            getBaseContext(),
                            "erro " + e,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * Seta valores para variáveis iniciais conforme o elemento encontrado pelo seu id
     */
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

    /**
     * Função que adiciona uma expressão conforme os valores digitados pelo usuário
     * @param string valor digitado
     * @param cleanData true l false
     */
    public void AddExpression(String string, boolean cleanData){
        if(txt_resultado.getText().equals("")){
            txt_expressao.setText(" ");
        }

        if(cleanData){
            txt_resultado.setText(" ");
            txt_expressao.append(string);
        }else{
            txt_expressao.append(txt_resultado.getText());
            txt_expressao.append(string);
            txt_resultado.setText(" ");
        }
    }

    /**
     * Esta função emite um Toast de info
     * @param v
     */
    public void infoFn(View v){
        Toast.makeText(
                getBaseContext(),
                "Desenvolvido por Gabriela Jung",
                Toast.LENGTH_LONG).show();
    }

    /**
     * Função de onclick dos botões
     * @param view O view que foi clicado.
     */
    @Override
    public void onClick(View view) {
        // compara o id do botão clicado com o id de botões específicos
        if (view.getId() == R.id.num_zero){
            // adiciona o valor do número clicado na expresão
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
            AddExpression(".", true);
        } else if (view.getId() == R.id.sum){
            AddExpression("+", false);
        } else if (view.getId() == R.id.sub){
            AddExpression("-", false);
        } else if (view.getId() == R.id.multiply){
            AddExpression("*", false);
        } else if (view.getId() == R.id.div){
            AddExpression("/", false);
        } else if (view.getId() == R.id.history){
            // envia para a tela de histórico, passando o arrayList de histórico como extra
            Intent it = new Intent (getBaseContext(), HistoricActivity.class);
            it.putStringArrayListExtra("historicCalc", historicCalc);
            startActivity(it);
        }

    }
}