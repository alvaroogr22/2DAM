import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.cardview.widget.CardView
import com.example.examenpmdm.R


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

        val citaU = findViewById<CardView>(R.id.cv)

        citaU.setOnClickListener {
            handleCardViewClick(citaU)
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
                intent.putExtra("EXTRA_CITA",opcionSeleccionada)
                startActivity(intent)
            }
        }
    }
    private fun handleCardViewClick(cardView: CardView) {
        when (cardView.id) {
            R.id.cv -> {
                println("Se ha pulsado cardview1")
                Log.d("CardView", "Has pulsado el cardview1")
                opcionSeleccionada = "la cita es urgente"
            }
        }
    }
}