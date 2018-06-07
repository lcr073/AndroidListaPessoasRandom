package com.calculadoraaula.lucianoermilivitch.listviewcomdb;

import android.app.Activity;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
        ImageView ivFotoUsuario = (ImageView) view.findViewById(R.id.ivFotoUsu);
        TextView tvNomeUsu = (TextView) view.findViewById(R.id.tvNomeUsu);
        TextView tvSobrenomeUsu = (TextView) view.findViewById(R.id.tvSobrenomeUsu);
        TextView tvSexo = (TextView) view.findViewById(R.id.tvSexo);
        TextView tvEmail = (TextView) view.findViewById(R.id.tvEmail);


        tvNomeUsu.setText("Nome:  " + pessoa.getNome());
        tvSobrenomeUsu.setText("Sobrenome:  " + pessoa.getSobrenome());
        tvSexo.setText("Sexo:  " + pessoa.getSexo());
        tvEmail.setText(pessoa.getEmail());

        // Chamando o picasso para carregar uma imagem pela url
        Picasso.get().load(pessoa.getUrlFoto()).into(ivFotoUsuario);

      //  imagem.setImageResource(R.drawable.ic_launcher_background);
        return view;
    }
}
