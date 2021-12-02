package com.example.examenfinalapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.examenfinalapps.Adaptadores.adaptadorContactos;
import com.example.examenfinalapps.Modelos.Contacto;
import com.example.examenfinalapps.Modelos.Telefono;
import com.example.examenfinalapps.Modelos.accion;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=findViewById(R.id.listas);
        String[] permisosnecesarios=new String[1];
        permisosnecesarios[0]= Manifest.permission.CALL_PHONE;
        List<Contacto> l=new ArrayList<>();
        l.add(new Contacto("Angel",new Telefono("8714576501","+52")));
        List<accion> lis=new ArrayList<>();
        lis.add(new accion("Marcar","Marcar al 8714576501",1));
        lis.add(new accion("Abrir navegador","Abrir google",2));
        lis.add(new accion("Abrir el mapa","Google Maps",3));
        lis.add(new accion("Abrir el marcador","Numero 8714576501",4));
        lis.add(new accion("Cambiar de pantalla","Cambia la pantalla",5));
        adaptadorContactos ad= new adaptadorContactos(lis);
        lista.setAdapter(ad);
        LinearLayoutManager lm=new LinearLayoutManager(this);
        lista.setLayoutManager(lm);
        lista.setHasFixedSize(true);
        verificarPermiso(permisosnecesarios);
    }

    private void verificarPermiso(String[] permisosnecesarios) {
        String[] permisosDenegados=new String[1];
        for (int x=0;x<permisosnecesarios.length;x++){
            if (ContextCompat.checkSelfPermission(this,permisosnecesarios[x])== PackageManager.PERMISSION_DENIED){
                permisosDenegados[x]=permisosnecesarios[x];
            }
        }
        requestPermissions(permisosDenegados,3000);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 300:
                if(permissions.length>0){
                    if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                        //ejecutar accion
                    }
                    else{
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this,permissions[0])){

                        }
                    }
                }
                break;
        }

}}