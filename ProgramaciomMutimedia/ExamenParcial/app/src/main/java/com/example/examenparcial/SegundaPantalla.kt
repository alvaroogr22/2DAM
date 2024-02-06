package com.example.examenparcial


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class SegundaPantalla : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_pantalla)
        val tvResult=findViewById<TextView>(R.id.tvmensaje)
        val name: String = intent.extras?.getString("EXTRA_NOMBRE").orEmpty()
        val apellido:String = intent.extras?.getString("EXTRA_APELLIDO").orEmpty()
        val fecha:String = intent.extras?.getString("EXTRA_FECHA").orEmpty()
        val contra:String = intent.extras?.getString("EXTRA_CONTRA").orEmpty()
        val confcontra:String = intent.extras?.getString("EXTRA_CONFCONTRA").orEmpty()

        val noticiaU:String = intent.extras?.getString("EXTRA_NOTIFICACIÓN").orEmpty()
        tvResult.text = "Notificación para:\nNombre: $name\nApellido: $apellido\nFecha: $fecha\n$noticiaU "
    }
}
