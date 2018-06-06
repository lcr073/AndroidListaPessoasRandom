package com.calculadoraaula.lucianoermilivitch.listviewcomdb;

import android.app.Activity;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class custonAdapter extends BaseAdapter {
    private final List<Pessoa> listaPessoas;
    private final Activity act;

    public custonAdapter(List<Pessoa> listaPessoas, Activity act){
        this.listaPessoas = listaPessoas;
        this.act = act;

    }

    @Override
    public int getCount() {
        return listaPessoas.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPessoas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.item_menu, parent, false);
        Pessoa pessoa = listaPessoas.get(position);

        // Mapeando os itens da futura view do layout
        ImageView imagem = (ImageView) view.findViewById(R.id.lista_curso_personalizada_imagem);
        TextView titulo = (TextView) view.findViewById(R.id.lista_curso_personalizada_nome);
        TextView descricao = (TextView) view.findViewById(R.id.lista_curso_personalizada_descricao);

        titulo.setText(pessoa.getNome());
        descricao.setText(pessoa.getSobrenome());
        imagem.setImageResource(R.drawable.ic_launcher_background);
        return view;
    }
}
