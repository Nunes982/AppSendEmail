package app.manager.appsendemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String emailDestinatario, assunto, mensagem;
    EditText editEmailDestinatario, editAssunto, editMensagem;
    Button btnEnviarEmail;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmailDestinatario = findViewById(R.id.editEmailDestinatario);
        editAssunto = findViewById(R.id.editAssunto);
        editMensagem = findViewById(R.id.editMensagem);

        btnEnviarEmail = findViewById(R.id.btnEnviarEmail);

        btnEnviarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                processarFormulario();

                intent = new Intent(Intent.ACTION_SEND);

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailDestinatario});
                intent.putExtra(Intent.EXTRA_SUBJECT, assunto);
                intent.putExtra(Intent.EXTRA_TEXT, mensagem);

                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent, "Selecione um aplicativo"));
            }
        });
    }

    public void processarFormulario(){

        emailDestinatario = editEmailDestinatario.getText().toString();
        assunto = editAssunto.getText().toString();
        mensagem = editMensagem.getText().toString();
    }
}