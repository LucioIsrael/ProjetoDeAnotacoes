package br.com.treino.projetominhasanotaes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {

    private Context c;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    //Nome do arquivo xml que será salvo é anotacao.preferencias
    private final static String NOME_ARQUIVO = "anotacao.preferencias";

    private final String CHAVE_NOME = "nome";

    public AnotacaoPreferencias( Context context ) {
        this.c = context;
        preferences = c.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();
    }

    public void salvarAnotacoes(String anotacao) {
        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();

    }

    public String recuperarAnotacao(){
        return preferences.getString(CHAVE_NOME, "");
    }

}
