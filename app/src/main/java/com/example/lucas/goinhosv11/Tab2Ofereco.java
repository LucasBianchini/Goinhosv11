package com.example.lucas.goinhosv11;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Lucas on 17/04/2017.
 */



public class Tab2Ofereco extends Fragment {

      @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2ofereco, container, false);

        return rootView;
    }


    public class Tab2Ofereco_dados extends AppCompatActivity {

        private TextView dados;
        private EditText nome, telefone, horario;
        private Button confirmar;

        DatabaseReference databaseReference;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.tab2ofereco);

            dados = (TextView) findViewById(R.id.dados);

            nome = (EditText) findViewById(R.id.usernome);
            telefone = (EditText) findViewById(R.id.usertelefone);
            horario = (EditText) findViewById(R.id.userhorario);

            confirmar = (Button) findViewById(R.id.confirmaranuncio);

            mprogres = new ProgressDialog(this);
            mprogres.setMessage("Salvando...");

            databaseReference = FirebaseDatabase.getInstance().getReference().child("Usuarios");

            confirmar.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    AdicionarDados();

                }
            });
        }

        public void AdicionarDados(){

            Nome = nome.getText().toString().trim();
            Telefone = telefone.getText().toString().trim();
            Horario = horario.getText().toString().trim();
            //String Nome = nome.getText().toString().trim();
            //String Telefone = telefone.getText().toString().trim();
            //String Horario = horario.getText().toString().trim();
            mprogres.show();

            Tab2Confirmar_dados confirmaranuncio = new Tab2Confirmar_dados(Nome,Telefone,Horario);
            databaseReference.setValue(confirmaranuncio);
            mprogres.dismiss();
            Toast.makeText(getApplication(), "Salvo", Toast.LENGTH_LONG.show();

        }
    }




}
