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

import br.digitalhouse.desafioandroidlucaspereira.Interface.InterfacePratoOnClick;

import br.digitalhouse.desafioandroidlucaspereira.Model.Prato;

import br.digitalhouse.desafioandroidlucaspereira.R;

public class PratoAdapter extends RecyclerView.Adapter<PratoAdapter.ViewHolder> {

    private List<Prato> listapratos;
    private InterfacePratoOnClick interfacePratoOnClick;

    public PratoAdapter(List<Prato> listapratos, InterfacePratoOnClick interfacePratoOnClick) {
        this.listapratos = listapratos;
        this.interfacePratoOnClick = interfacePratoOnClick;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //trocar layout //
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemprato_recyclerview,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PratoAdapter.ViewHolder holder, int position) {
        final Prato prato = listapratos.get(position);
        holder.Bind(prato);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfacePratoOnClick.clicar(prato);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listapratos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nome;
        private ImageView imagem;

//Fazer recyclerview dos pratos

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.tVNomePrato);
            imagem = itemView.findViewById(R.id.fotoprato);

        }

        public void Bind(Prato prato){
            nome.setText(prato.getNome());
            Drawable drawable = itemView.getResources().getDrawable(prato.getImagem());
            imagem.setImageDrawable(drawable);

        }
    }
}