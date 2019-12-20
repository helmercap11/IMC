package com.helmercapassola.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btn_calcular;
    TextView  txt_resultado, txt_descricao;
    EditText edit_peso, edit_altura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final float[] imc = new  float[1];

        txt_resultado = findViewById(R.id.txt_resultado);
        txt_descricao = findViewById(R.id.txt_descricao);
        edit_peso = findViewById(R.id.edit_peso);
        edit_altura = findViewById(R.id.edit_altura);
        btn_calcular = findViewById(R.id.btn_calcular);

       // Toast.makeText(this, "Campo obrigatorio", Toast.LENGTH_SHORT).show();

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (validar()){
                    txt_descricao.setText("");
                    txt_resultado.setText("");
                    Toast.makeText(MainActivity.this, "Campos obrigatorios", Toast.LENGTH_SHORT).show();
                }else {

                int peso = Integer.parseInt(edit_peso.getText().toString());
                float altura = Float.parseFloat(edit_altura.getText().toString());


                imc[0] = peso / (altura * altura);

                if (imc[0] <= 17 && imc[0] <= 18.5) {

                    txt_resultado.setText(imc[0] + "");
                    txt_descricao.setText("Baixo Peso");
                } else {
                    if (imc[0] < 25) {
                        txt_resultado.setText(imc[0] + "");
                        txt_descricao.setText("Sobre Peso");
                    } else {
                        if (imc[0] < 30) {
                            txt_resultado.setText(imc[0] + "");
                            txt_descricao.setText("Obesidade do I grau");
                        } else {
                            txt_resultado.setText(imc[0] + "");
                            txt_descricao.setText("obeso");
                        }

                    }
                    }
                    limpar();
                }
            }

        });

    }


    public boolean validar(){

        if(edit_peso.getText().toString().isEmpty() || edit_altura.getText().toString().isEmpty()){
            return true;
        }
        return false;
    }

    public void limpar(){
        edit_peso.setText("");
        edit_altura.setText("");
    }

}
