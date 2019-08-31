package br.com.treinamento.listaproduto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.treinamento.listaproduto.model.Pedido;
import br.com.treinamento.listaproduto.model.Produto;

public class MainActivity extends AppCompatActivity {

    EditText txtCliente, txtData, txtProduto, txtValor;
    ListView listTela;
    List<Produto> lista = new ArrayList<Produto>();
    List<HashMap<String, String>> listaHashMap = new ArrayList<HashMap<String, String>>();
    long id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mascaraData = (TextView) findViewById(R.id.txtData);
        //Criar mascara pra colocar numero telefonico
        SimpleMaskFormatter smf = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher mtw = new MaskTextWatcher(mascaraData, smf);
        mascaraData.addTextChangedListener(mtw);

        Button btnLimpar = (Button) findViewById(R.id.btnLimpa);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtCliente.setText("");
                txtData.setText("");
                txtProduto.setText("");
                txtValor.setText("");

                Toast.makeText(getApplicationContext(), "Área limpa", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void adicionar(View view) {

        //Pegar campos da tela

        txtCliente = findViewById(R.id.txtCliente);
        txtData = findViewById(R.id.txtData);
        txtProduto = findViewById(R.id.txtProduto);
        txtValor = findViewById(R.id.txtValor);


        // Extrair dados do EditText

        String cliente, data, produto;

//        BigDecimal bd = new BigDecimal(minhaString);
//        String s = meuBigDecimal.toString();


        cliente = txtCliente.getText().toString();
        data = txtData.getText().toString();
        produto = txtProduto.getText().toString();
        BigDecimal bd = new BigDecimal(txtValor.getText().toString());


        Pedido pedido = new Pedido(id, cliente, data, bd);


        //Adicionar objeto aluno na lista
        //lista.add(aluno);
        //double a; String b; b = String.valueOf(a);

        // Criando mapa de valores
        String idS = "" + id++;
        String bigdecialS = bd.toString();

        HashMap<String, String> map = new HashMap<>();
        map.put("ID", idS);
        map.put("cliente", cliente);
        map.put("data", data);
        map.put("produto", produto);
        map.put("valor", bigdecialS);

        //Adicionar map na lista.
        listaHashMap.add(map);

        // fazer mapeamento DE-PARA
        String[] de = {"ID", "cliente", "data", "produto", "valor"};
        int[] para = {R.id.labelID, R.id.labelCliente, R.id.labelData, R.id.labelProduto, R.id.labelValor};

        //Buscar a referencia da listView
        listTela = findViewById(R.id.listTela);

        //chamar o simple adapter para "juntar" os dados

        SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext(), listaHashMap, R.layout.item, de, para);

        Toast.makeText(getApplicationContext(), "Pedido " + idS + " inserido com sucesso ! \nCliente:" + cliente + "\nData: " + data + "\nProduto: " + produto + "\nValor: " + bigdecialS, Toast.LENGTH_SHORT).show();

        //Jogar dados na listView
        listTela.setAdapter(simpleAdapter);
    }
}
