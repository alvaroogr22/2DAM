package com.example.examenparcial

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    private var opcionSeleccionada: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSiguiente = findViewById<Button>(R.id.btnEntrar)
        val etName = findViewById<EditText>(R.id.Nombre)
        val etApellido = findViewById<EditText>(R.id.Apellidos)
        val etFecha = findViewById<EditText>(R.id.Fecha)
        val etContra = findViewById<EditText>(R.id.Contraseña)
        val etConfContra = findViewById<EditText>(R.id.ConfirmContraseña)
        val notificaciónU = findViewById<CardView>(R.id.cv)

        notificaciónU.setOnClickListener {
            handleCardViewClick(notificaciónU)
        }

        btnSiguiente.setOnClickListener {
            val apellido = etApellido.text.toString()
            val nombre = etName.text.toString()
            val fecha = etFecha.text.toString()
            val contrasenia = etContra.text.toString()
            val confcontra = etConfContra.text.toString()

            if (apellido.isNotEmpty() && nombre.isNotEmpty() &&
                fecha.isNotEmpty() && contrasenia.isNotEmpty() && confcontra.isNotEmpty()
            ) {
                val intent = Intent(this, SegundaPantalla::class.java)
                intent.putExtra("EXTRA_APELLIDO", apellido)
                intent.putExtra("EXTRA_NOMBRE", nombre)
                intent.putExtra("EXTRA_FECHA", fecha)
                intent.putExtra("EXTRA_CONTRA", contrasenia)
                intent.putExtra("EXTRA_CONFCONTRA", confcontra)
                intent.putExtra("EXTRA_NOTIFICACIÓN", opcionSeleccionada)
                startActivity(intent)

                // Muestra un Toast indicando que los datos se han introducido correctamente
                showToast("Datos ingresados correctamente")

                // Imprime un mensaje en el Logcat para gestionar mensajes
                Log.d("MainActivity", "Datos ingresados correctamente")
            } else {
                // Muestra un Toast indicando que todos los campos son obligatorios
                showToast("Todos los campos son obligatorios")

                // Imprime un mensaje en el Logcat para gestionar mensajes
                Log.d("MainActivity", "Todos los campos son obligatorios")
            }
        }
    }

    private fun handleCardViewClick(cardView: CardView) {
        when (cardView.id) {
            R.id.cv -> {
                println("Se ha pulsado cardview1")

                // Imprime un mensaje en el Logcat para gestionar mensajes
                Log.d("MainActivity", "Has pulsado el cardview1")

                opcionSeleccionada = "La notificación es urgente"
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}