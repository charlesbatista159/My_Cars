
/**Editado por Adilson Pereira de Araujo
 * Deus é bom o tempo todo
 * Edição Final 20/10/2019
 */
package com.example.my_cars_sqlite.crud;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.my_cars_sqlite.pojo.Carro;
import com.example.my_cars_sqlite.R;
import com.example.my_cars_sqlite.MainActivity;
import com.example.my_cars_sqlite.utils.Message;



public class EditRecord extends AppCompatActivity {


    TextView id;
    EditText modelo, ano, cor;
    Button btSalvar;

    SQLiteDatabase db;
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // Mostra um botão na Barra Superior para voltar
        getSupportActionBar().setTitle("MY_Cars_SqLite2 - Edição");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

       id = findViewById(R.id.id);
       modelo = findViewById(R.id.modelo);
       ano = findViewById(R.id.ano);
       cor = findViewById(R.id.cor);
       btSalvar = findViewById(R.id.btSalvar);


        final Intent itCarro = getIntent();
        final Carro carro = (Carro) itCarro.getExtras().getSerializable("objCarro");
        id.setText(String.valueOf(carro.getId()));
        modelo.setText(carro.getModelo());
        ano.setText(carro.getAno());
        cor.setText(carro.getCor());

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Coleta os dados digitados nos campos
                ContentValues values = new ContentValues();
                values.put("modelo", modelo.getText().toString());
                values.put("ano", ano.getText().toString());
                values.put("cor", cor.getText().toString());


                Carro novosDados = new Carro();
                novosDados.setModelo(modelo.getText().toString());
                novosDados.setAno(ano.getText().toString());
                novosDados.setCor(cor.getText().toString());

                // Atualiza os dados na tabela
               db = openOrCreateDatabase("db_carro", Context.MODE_PRIVATE, null );
               db.execSQL("UPDATE carro SET " +
                        "modelo='" + novosDados.getModelo() +"',"+
                        "ano='" + novosDados.getAno() + "',"+
                        "cor='" + novosDados.getCor() + "' " +
                       "WHERE id =" + carro.getId()

                 );

                // Cria uma caixa de mensagem e mostra os dados incluídos
                Message message = new Message(EditRecord.this);
                message.show(
                        "Dados Atualizados com Sucesso!",
                        novosDados.getDados(),
                        R.drawable.ic_add);

                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);


            }
        });
    }


        // Configura o botão (seta) na ActionBar (Barra Superior)
        public boolean onOptionsItemSelected (MenuItem item){
            switch (item.getItemId()) {
                case android.R.id.home:
                    this.finish();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }
    }
