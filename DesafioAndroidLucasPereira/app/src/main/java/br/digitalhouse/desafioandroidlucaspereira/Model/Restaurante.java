package br.digitalhouse.desafioandroidlucaspereira.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import br.digitalhouse.desafioandroidlucaspereira.R;

public class Restaurante implements Parcelable {

    private String nome;
    private String horario;
    private String endereco;
    private int imagem;
    private List<Prato> listapratos = new ArrayList<>();

    public Restaurante(String nome, String horario, String endereco, int imagem, List<Prato> listapratos) {
        this.nome = nome;
        this.horario = horario;
        this.endereco = endereco;
        this.imagem = imagem;
        this.listapratos = listapratos;
    }



    public List<Prato> retornarListaPratos() {

        listapratos.add(new Prato ("Panetone", "O panetone é um alimento tradicional da época de Natal, de origem milanesa, região a noroeste da Itália. Várias lendas tentam explicar a sua origem. O pão doce ou bolo de natal possui fragrância discreta de baunilha e recheio de frutas secas, tais como damasco, laranja, limão, figo, maçã, cidra e a uva passa.\n" +
                "\n" +
                "Apesar de geralmente ser associado à cultura milanesa, tendo a forma alta e mais fina, há também o panetone piemontês, diferente apenas por ser mais largo e redondo.[1]", R.drawable.panetone));
        listapratos.add(new Prato ("Pizza", "Pizza (também grafada piza em Portugal ) é uma preparação culinária que consiste em um disco de massa fermentada de farinha de trigo, coberto com molho de tomate e os ingredientes variados que normalmente incluem algum tipo de queijo, carnes preparadas ou defumadas e ervas, normalmente orégano ou manjericão, tudo assado em forno.", R.drawable.pizza ));
        listapratos.add(new Prato ("Sorvete", "Sorvete ou gelado  é uma sobremesa gelada à base de lacticínios, como leite ou nata, à qual é adicionada fruta ou outros ingredientes e sabores. A maior parte contém açúcar, embora alguns sejam feitos com adoçantes. Em alguns casos, são acrescentados corantes ou aromatizantes como complemento ou substituição dos ingredientes naturais. A emulsão é batida lentamente durante o arrefecimento, de forma a incorporar ar e prevenir a formação de cristais de gelo de grandes dimensões. O produto final é uma espuma semissólida suave e consistente, facilmente maleável e que pode ser retirada com uma colher.", R.drawable.sorvete ));
        listapratos.add(new Prato ("Pastel", "Pastel é um alimento composto por uma massa à base de farinha a que se dá a forma de um envelope, se recheia e depois se frita por imersão em óleo fervente. Originário da culinária brasileira, e de origem paulista, o pastel um dos alimentos mais frequentemente encontrados em carrinhos de rua e centros de comércio popular do Brasil, Portugal e também populares no resto do mundo.", R.drawable.pastel ));
        listapratos.add(new Prato ("Torta", "Uma torta (pt-BR) ou tarte (pt) é um alimento cozido ao forno, feito com massa de farinha e recheado com ingredientes variados, tanto doces quanto salgados.\n" +
                "\n" +
                "Existem vários tipos de torta doce, como, tortas de mirtilo, maçã (ou tarte de maçã, em Portugal), abóbora, amora, pêssego ou limão[4].\n" +
                "\n" +
                "Mas também existem tortas salgadas, como, de carne bovina, frango, camarão e palmito.\n" +
                "\n" +
                "Em Portugal, \"torta\" é um bolo quadrado, que no Brasil é conhecido como empada. As tortas doces do Brasil são conhecidas como \"tartesitas\", em Portugal.", R.drawable.torta ));
        listapratos.add(new Prato("Hamburguer", "O hambúrguer (do inglês hamburger), também conhecido como hamburgo e hamburguesa, sanduíche de carne é carne (principalmente de carne bovina, mas também de frango moído, suína moída ou sem carne, como são conhecidos os \"hambúrgueres vegetarianos\") temperada e moldada em formato circular.", R.drawable.hamburguer));
        listapratos.add(new Prato("Taco", "O hambúrguer (do inglês hamburger), também conhecido como hamburgo e hamburguesa, sanduíche de carne é carne (principalmente de carne bovina, mas também de frango moído, suína moída ou sem carne, como são conhecidos os \"hambúrgueres vegetarianos\") temperada e moldada em formato circular." + "n" +
                "É geralmente servida como sanduíche, é este, por extensão, o seu significado mais comum. Pode ser acompanhado por condimentos e outros ingredientes também colocados dentro do pão, como cebola, alface, picles, tomate, maionese, ketchup, queijo e bacon.", R.drawable.taco));
        listapratos.add(new Prato("Donut", "Um donut, doughnut, dónute[1], rosca ou rosquinha é um pequeno bolo em forma de rosca (mais precisamente de toro), popular nos EUA e de origem incerta. Consiste numa massa açucarada frita, que pode ser coberta com diversos tipos de coberturas doces coloridas, como por exemplo chocolate.", R.drawable.donut));

        return listapratos;
    }

    protected Restaurante(Parcel in) {
        nome = in.readString();
        horario = in.readString();
        endereco = in.readString();
        imagem = in.readInt();
    }

    public static final Creator<Restaurante> CREATOR = new Creator<Restaurante>() {
        @Override
        public Restaurante createFromParcel(Parcel in) {
            return new Restaurante(in);
        }

        @Override
        public Restaurante[] newArray(int size) {
            return new Restaurante[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public List<Prato> getListapratos() {
        return listapratos;
    }

    public void setListapratos(List<Prato> listapratos) {
        this.listapratos = listapratos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(horario);
        dest.writeString(endereco);
        dest.writeInt(imagem);
        dest.writeList(listapratos);
    }
}
