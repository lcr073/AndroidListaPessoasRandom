package com.calculadoraaula.lucianoermilivitch.listviewcomdb;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
    // Vinculando o botao da View ao codigo
    @BindView(R.id.btnAtualizaLista)
    Button btnAtualizaLista;

    @BindView(R.id.tvDebug)
    TextView tvDebug;

    @BindView(R.id.ivDebug)
    ImageView ivDebug;

    // Lista de pessoas para serem exibidas
    ArrayList<Pessoa> listaPessoas;

    // Metodo para se der algum problema na requisição
    public void ErroAoAtualizar(Exception error) {
        //Método executado caso um erro de carregamento aconteça
        Toast.makeText(this, "Algo deu errado!", Toast.LENGTH_SHORT).show();
    }

    // Metodo para atualizar os campos se deu td certo na atualização
    public void AtualizarDados(String dados) {
        ColocarDadosNaInterface(dados);
    }

    //Método para extrair os dados do JSON e colocar eles na interface gráfica
    private void ColocarDadosNaInterface(String dadosJson){
        try {
            // Pegamos o objeto inteiro json retornado pelo site
            JSONObject jsonResult = new JSONObject(dadosJson);

            // Abre o Json pelo campo result o qual contem todos
             JSONArray pessoasResult  = jsonResult.getJSONArray("results");

             // Limpando a lista de contatos anterior antes de por novos
            listaPessoas.clear();

             // Abrindo a lista de resultados onde esse for vai para o numero de pessoas encontrados
            for(int i = 0; i < pessoasResult.length(); i++){
                // Retorna o conjunto inteiro de uma pessoa
                JSONObject pessoa = pessoasResult.getJSONObject(i);

                // Pegando o nome do usuario
                JSONObject nomeInteiro = pessoa.getJSONObject("name");
                //Toast.makeText(this, nomeInteiro.getString("first"), Toast.LENGTH_LONG).show();
                //Toast.makeText(this, nomeInteiro.getString("last"), Toast.LENGTH_LONG).show();

                // Pegando o sexo do usuario
                //Toast.makeText(this, pessoa.getString("gender"), Toast.LENGTH_LONG).show();

                // Pegando o email do usuario
//                    Toast.makeText(this, pessoa.getString("email"), Toast.LENGTH_LONG).show();

                // Pegando o url da foto do usuario
                JSONObject urlFoto = pessoa.getJSONObject("picture");
                //Toast.makeText(this, urlFoto.getString("thumbnail"), Toast.LENGTH_LONG).show();

                // Chamando o picasso para carregar uma imagem pela url
                Picasso.get().load("https://randomuser.me/api/portraits/women/19.jpg").into(ivDebug);

                // Cria uma nova pessoa
                Pessoa p4 = new Pessoa(nomeInteiro.getString("first"),nomeInteiro.getString("last"),pessoa.getString("gender"),pessoa.getString("email"),urlFoto.getString("large"));
                listaPessoas.add(p4);

            }
            Toast.makeText(this, jsonResult.getString("results"), Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(this, "Algo deu errado na colocacao da interface!", Toast.LENGTH_SHORT).show();
        }
    }

    // Chamando metodo do botao
    @OnClick(R.id.btnAtualizaLista)
    public void atualizaLista(){
        // Criando uma fila de requisições vazias para o volley
        RequestQueue queueWeb = Volley.newRequestQueue(this);

        // Criando uma string para representar a URL p/ 10 usuarios
        String url = "https://randomuser.me/api/?results=10";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        tvDebug.setText("Deu Bom");
                        AtualizarDados(response);
                    }
                }, new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError error){
                            tvDebug.setText("Deu Ruim");
                            ErroAoAtualizar(error);
                        }
                    }
        );
        // Acrescenta a requisição na fila
        queueWeb.add(stringRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        listaPessoas = new ArrayList<Pessoa>();


        // Adicionando alguns elementos a lista de pessoas para testar
        //        Pessoa p1 = new Pessoa("Clay", "Ton", "male","baubau@bau.com","sadasda");
        //        Pessoa p2 = new Pessoa("Vas", "Con", "male","sasdada@dsadas","asassa");
        //        Pessoa p3 = new Pessoa("Bau","Beef", "female","asdsadasd@sadas","sadas");

        // Adicionando as pessoas a lista de pessoas
       // listaPessoas.add(p1);
        //listaPessoas.add(p2);
        //listaPessoas.add(p3);

        // Mapeando a lista de pessoas da View para o controller
        ListView listaDePessoas = (ListView) findViewById(R.id.lvPessoas);

        // Criando um adapter para converter nossos dados em views
        //ArrayAdapter<Pessoa> adapter = new ArrayAdapter<Pessoa>(this,android.R.layout.simple_list_item_1,listaPessoas);
        custonAdapter adapter = new custonAdapter(listaPessoas,this);

        // Indicando ao listView referenciado qual sera o adapter a ser utilizado
        listaDePessoas.setAdapter(adapter);
    }
}
