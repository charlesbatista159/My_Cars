/**Editado por Adilson Pereira de Araujo
 * Deus é bom o tempo todo
 * Edição Final 20/10/2019
 */
package com.example.my_cars_sqlite.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_cars_sqlite.pojo.Carro;
import com.example.my_cars_sqlite.R;
import com.example.my_cars_sqlite.utils.Message;

public class Insert extends AppCompatActivity {
    EditText modelo, ano, cor;
    Button btInsert;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        // Abertura ou criação do Banco de Dados
        db = openOrCreateDatabase("db_carro", Context.MODE_PRIVATE, null);

        // Cria a tabela se não existir, senão carrega a tabela para uso
        db.execSQL("CREATE TABLE IF NOT EXISTS carro(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "modelo VARCHAR NOT NULL, " +
                "ano VARCHAR NOT NULL, " +
                "cor VARCHAR NOT NULL);");

        // Mostra um botão na Barra Superior para voltar
        getSupportActionBar().setTitle("MY_Cars_SqLite2 - Inserir");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        modelo= findViewById(R.id.editModelo);
        ano = findViewById(R.id.editAno);
        cor = findViewById(R.id.editCor);
        btInsert = findViewById(R.id.btInsert);

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Cria um objeto Carro para receber os dados
                Carro carro = new Carro();
                carro.setModelo(modelo.getText().toString());
                carro.setAno(ano.getText().toString());
                carro.setCor(cor.getText().toString());

                // Coleta os dados digitados nos campos
                ContentValues values = new ContentValues();
                values.put("modelo", carro.getModelo());
                values.put("ano", carro.getAno());
                values.put("cor", carro.getCor());


                // Insere os dados na tabela
                db.insert("carro", null, values);

                // Cria uma caixa de mensagem e mostra os dados incluídos
                Message message = new Message(Insert.this);
                message.show(

                        "Dados Atualizados com Sucesso!!!",
                         carro.getDados(),
                         R.drawable.ic_add);


                // Limpa os campos de entrada
                clearText();
            }
        });
    }

    // Configura o botão (seta) na ActionBar (Barra Superior)
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Limpa os campos de entrada e fecha o teclado
     */
    public void clearText() {
        modelo.setText("");
        ano.setText("");
        cor.setText("");
        modelo.requestFocus();

        // fecha o teclado virtual
        ((InputMethodManager) Insert.this.getSystemService(
                Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                getCurrentFocus().getWindowToken(), 0);
    }
}
