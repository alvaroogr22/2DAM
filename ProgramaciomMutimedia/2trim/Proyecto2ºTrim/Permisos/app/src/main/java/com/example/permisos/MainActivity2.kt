package com.example.permisos

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity2 : AppCompatActivity() {

    private val CAMERA_AND_STORAGE_PERMISSION_REQUEST = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCapturePhoto = findViewById<Button>(R.id.btnCapturePhoto)
        btnCapturePhoto.setOnClickListener {
            showPermissionDialog()
        }
    }

    private fun showPermissionDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Permiso necesario")
        alertDialog.setMessage("Esta aplicación necesita permisos para acceder a la cámara y almacenamiento para capturar fotos.")
        alertDialog.setPositiveButton("Conceder") { _, _ ->
            checkCameraAndStoragePermissions()
        }
        alertDialog.setNegativeButton("Cancelar", null)
        alertDialog.show()
    }

    private fun checkCameraAndStoragePermissions() {
        val cameraPermission =
            ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        val storagePermission =
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        val permissionsToRequest = mutableListOf<String>()

        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            permissionsToRequest.add(Manifest.permission.CAMERA)
        }

        if (storagePermission != PackageManager.PERMISSION_GRANTED) {
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        if (permissionsToRequest.isNotEmpty()) {
            // Solicitar permisos de cámara y almacenamiento
            ActivityCompat.requestPermissions(
                this,
                permissionsToRequest.toTypedArray(),
                CAMERA_AND_STORAGE_PERMISSION_REQUEST
            )
        } else {
            // Ambos permisos ya están concedidos
            capturePhoto()
        }
    }

    private fun capturePhoto() {
        // Lógica para capturar la foto
        Toast.makeText(this, "Capturando foto...", Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == CAMERA_AND_STORAGE_PERMISSION_REQUEST) {
            if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                // Ambos permisos concedidos
                capturePhoto()
            } else {
                // Al menos uno de los permisos fue denegado
                Toast.makeText(
                    this,
                    "Se requieren permisos de cámara y almacenamiento para capturar fotos.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
