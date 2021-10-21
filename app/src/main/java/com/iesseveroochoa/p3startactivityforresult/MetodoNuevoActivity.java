package com.iesseveroochoa.p3startactivityforresult;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MetodoNuevoActivity  extends AppCompatActivity {

    TextView tv_Nombre;
    TextView tv_Apellido;
    //Registramos la llamada. Tendremos que registrar tantos como llamadas diferentes queramos realizar a una activity o crear
    //la lógica necesaria para saber para que la llamamos
    //Llamada para obtener el nombre
    ActivityResultLauncher<Intent> mStartForResultNombre = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //si el usuario pulsa OK en la Activity que hemos llamado
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //recuperamos los dados
                        Intent intent = result.getData();
                        String resultado = intent.getStringExtra(EntradaDatosActivity.EXTRA_DATOS_RESULTADO);
                        tv_Nombre.setText(resultado);
                    }
                }
            });
    //Registramos las llamada para datos de Apellido
    ActivityResultLauncher<Intent> mStartForResultApellido = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //si el usuario pulsa OK en la Activity que hemos llamado
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //recuperamos los dados
                        Intent intent = result.getData();
                        String resultado = intent.getStringExtra(EntradaDatosActivity.EXTRA_DATOS_RESULTADO);
                        tv_Apellido.setText(resultado);
                    }
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodo_nuevo);

        tv_Nombre= findViewById(R.id.tv_Nombre);
        tv_Apellido= findViewById(R.id.tv_Apellido);

        //Manejaremos el evento del botón en el mismo Listener. Para ello fijaros como la activity implementa View.OnClickListener
        findViewById(R.id.btn_Nombre).setOnClickListener(v-> llamarDatosNombre());
        findViewById(R.id.btn_Apellido).setOnClickListener(v->llamarDatosApellido());

    }


/*
llamamos a la activity EntradaDatosActivityde la cual recibiremos datos
 */
    private void llamarDatosNombre() {

        //creamos el intent para llamar a la acitividad
        Intent i=new Intent(this,EntradaDatosActivity.class);
        i.putExtra(EntradaDatosActivity.EXTRA_DATOS,tv_Nombre.getText().toString());
        mStartForResultNombre.launch(i);
    }
    private void llamarDatosApellido() {
        //creamos el intent para llamar a la acitividad
        Intent i=new Intent(this,EntradaDatosActivity.class);
        i.putExtra(EntradaDatosActivity.EXTRA_DATOS,tv_Apellido.getText().toString());
        mStartForResultApellido.launch(i);
    }

}
