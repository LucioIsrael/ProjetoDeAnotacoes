package br.com.treino.projetominhasanotaes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


import br.com.treino.projetominhasanotaes.databinding.ActivityMainBinding;

import android.widget.EditText;

import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AnotacaoPreferencias anotacaoPreferencias;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextao);

        anotacaoPreferencias = new AnotacaoPreferencias(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Validar se foi digitado algo
                String textoRecuperado = editText.getText().toString();
                if (textoRecuperado.equals("")) {
                    Snackbar.make(view, "Preencha a anotaçao!", Snackbar.LENGTH_LONG).show();
                } else {

                    anotacaoPreferencias.salvarAnotacoes(textoRecuperado);
                    Snackbar.make(view, "Anotaçao salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }

            }
        });
        String anotacao = anotacaoPreferencias.recuperarAnotacao();
        if(!anotacao.equals("")){
            editText.setText(anotacao);
        }
    }
}
