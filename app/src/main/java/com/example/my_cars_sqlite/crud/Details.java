/**Editado por Adilson Pereira de Araujo
 * Deus é bom o tempo todo
 * Edição Final 20/10/2019
 */

package com.example.my_cars_sqlite.crud;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.my_cars_sqlite.pojo.Carro;
import com.example.my_cars_sqlite.R;

public class Details extends AppCompatActivity {
    Button btEditar;
    TextView id, modelo, ano, cor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Mostra um botão na Barra Superior para voltar
        getSupportActionBar().setTitle("MY_Cars_SqLite2 - Detalhes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        id = findViewById(R.id.id);
        modelo = findViewById(R.id.modelo);
        ano = findViewById(R.id.ano);
        cor = findViewById(R.id.cor);
        btEditar = findViewById(R.id.btSalvar);

        Intent itCarro = getIntent();
        final Carro carro = (Carro) itCarro.getExtras().getSerializable("objCarro");
        id.setText(String.valueOf(carro.getId()));
        modelo.setText(carro.getModelo());
        ano.setText(carro.getAno());
        cor.setText(carro.getCor());

        btEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                Intent editar = new Intent(getApplicationContext(), EditRecord.class);
                editar.putExtra("objCarro", carro);
                startActivity(editar);
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
    }