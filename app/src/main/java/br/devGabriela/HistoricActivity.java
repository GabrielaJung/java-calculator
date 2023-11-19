package br.devGabriela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoricActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // busca valor do arrayList com o histórico passado pelo extra
        Intent intent = getIntent();
        ArrayList<String> historicCalc = intent.getStringArrayListExtra("historicCalc");

        // Busca o elemento do tipo ListView existente neste contexto
        ListView listView = findViewById(R.id.listViewHistoric);

        // Adapta o array de strings, colocando cada valor em um item diferente do listView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, historicCalc);
        listView.setAdapter(adapter);
    }

    // volta para a calculadora
    public void backToCalculator(View v){
        finish();
    }
}