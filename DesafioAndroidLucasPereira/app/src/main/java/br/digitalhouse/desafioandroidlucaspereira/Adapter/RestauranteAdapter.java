package br.digitalhouse.desafioandroidlucaspereira.Adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.digitalhouse.desafioandroidlucaspereira.Interface.OnclickRecyclerRes;
import br.digitalhouse.desafioandroidlucaspereira.Model.Restaurante;
import br.digitalhouse.desafioandroidlucaspereira.R;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder> {

    private List<Restaurante> listarestaurantes;
    private OnclickRecyclerRes onclickRecyclerRes;


    public RestauranteAdapter(List<Restaurante> listarestaurantes, OnclickRecyclerRes onclickRecyclerRes) {
        this.listarestaurantes = listarestaurantes;
        this.onclickRecyclerRes = onclickRecyclerRes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestauranteAdapter.ViewHolder holder, int position) {
        final Restaurante restaurante = listarestaurantes.get(position);
        holder.Bind(restaurante);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickRecyclerRes.clicarRestautante(restaurante);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listarestaurantes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nome;
        private TextView horario;
        private TextView endereco;
        private ImageView imagem;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.txtNomeRestaurante);
            horario = itemView.findViewById(R.id.txtHorarioRestaurante);
            endereco = itemView.findViewById(R.id.txtEnderecoRestaurante);
            imagem = itemView.findViewById(R.id.imagemRestaurante);

        }

        public void Bind(Restaurante restaurante){
            nome.setText(restaurante.getNome());
            horario.setText(restaurante.getHorario());
            endereco.setText(restaurante.getEndereco());
            Drawable drawable = itemView.getResources().getDrawable(restaurante.getImagem());
            imagem.setImageDrawable(drawable);
        }
    }
}
