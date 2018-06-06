package com.calculadoraaula.lucianoermilivitch.listviewcomdb;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();

        // Adicionando alguns elementos a lista de pessoas para testar
        Pessoa p1 = new Pessoa("Clay", "Ton", 22);
        Pessoa p2 = new Pessoa("Vas", "Con", 33);
        Pessoa p3 = new Pessoa("Bau","Beef", 20);

        // Adicionando as pessoas a lista de pessoas
        listaPessoas.add(p1);
        listaPessoas.add(p2);
        listaPessoas.add(p3);

        // Mapeando a lista de pessoas da View para o controller
        ListView listaDePessoas = (ListView) findViewById(R.id.lvPessoas);

        // Criando um adapter para converter nossos dados em views
        //ArrayAdapter<Pessoa> adapter = new ArrayAdapter<Pessoa>(this,android.R.layout.simple_list_item_1,listaPessoas);
        custonAdapter adapter = new custonAdapter(listaPessoas,this);

        // Indicando ao listView referenciado qual sera o adapter a ser utilizado
        listaDePessoas.setAdapter(adapter);
    }
}
