package com.example.markattendance

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Int64Ref
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper = UserDatabase(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM LOGIN ", null)
        if (rs.moveToNext())
            Toast.makeText(applicationContext, rs.getString(1), Toast.LENGTH_LONG).show()


        val loginBtn = findViewById<Button>(R.id.loginbtn)
        val mobileText = findViewById<EditText>(R.id.etuser)
        val passText = findViewById<EditText>(R.id.etpass)

        loginBtn.setOnClickListener {
            val mobile = mobileText.text.toString().trim()
            val password = passText.text.toString().trim()
            if (mobile.isEmpty()) {
                mobileText.error = "Username Required "
                return@setOnClickListener
            } else if (password.isEmpty()) {
                passText.error = " Password Required"
                return@setOnClickListener
            } else {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)

                var cv = ContentValues()
                cv.put("MOBILE_NO", mobileText.text.toString())
                cv.put("PASSWORD", passText.text.toString())
                db.insert("LOGIN", null, cv)

                mobileText.setText("")
                passText.setText("")

            }


        }

    }
}