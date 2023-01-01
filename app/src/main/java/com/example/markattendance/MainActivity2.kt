

package com.example.markattendance

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity2 : AppCompatActivity() {
    private val cameraRequestId : Int = 123
    private lateinit var camBtn: Button
    private lateinit var myImage: ImageView
    private lateinit var signBtn: Button

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        camBtn = findViewById(R.id.attendBtn)
        myImage = findViewById(R.id.imgbtn)
        signBtn = findViewById(R.id.signBtn)
        if (ContextCompat.checkSelfPermission(
                applicationContext,Manifest.permission.CAMERA
            )== PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.CAMERA),
                cameraRequestId
            )
        camBtn.setOnClickListener {
            val camIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(camIntent,cameraRequestId)
        }

        signBtn.setOnClickListener {
          val setIntent = Intent(this, MainActivity::class.java)
            startActivity(setIntent)

        }


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == cameraRequestId){
            val image:Bitmap = data?.extras?.get("data") as Bitmap
            myImage.setImageBitmap(image)

        }
    }
}