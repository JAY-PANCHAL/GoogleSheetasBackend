package com.example.googlesheetsasbackend

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class ActivityAddData : AppCompatActivity() {
    private var edFname: EditText? = null
    private var edLanme: EditText? = null
    private var edEmail: EditText? = null
    private var btnAddData1: Button? = null
    private var edContact: EditText? = null
    private var edDOb: EditText? = null
    private var edHobby: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)

        edFname = findViewById(R.id.edFname)
        edLanme = findViewById(R.id.edLname)
        edEmail = findViewById(R.id.edEmail)
        edContact = findViewById(R.id.edcontactNo)
        edDOb = findViewById(R.id.edDob)
        edHobby = findViewById(R.id.edhobby)

        btnAddData1 = findViewById(R.id.btnAddData)

        val btn = btnAddData1
        val f = edFname
        val l = edLanme
        val email = edEmail
        val contactno = edContact
        val dob = edDOb
        val hobby = edHobby

        dob?.setOnClickListener() { DateAndTimeUtils.setDate(this, dob) }

        btn?.setOnClickListener {

            addData(
                f?.text.toString(),
                l?.text.toString(),
                email?.text.toString(),
                contactno?.text.toString(),
                dob?.text.toString(),
                hobby?.text.toString()
            )
        }
    }

    private fun addData(
        fname: String,
        lname: String,
        email: String,
        contact: String,
        dob: String,
        hobby: String
    ) {
        val loading: ProgressDialog = ProgressDialog.show(this, "Adding Item", "Please wait");

        val stringRequest: StringRequest =
            object : StringRequest(
                Request.Method.POST,
                "https://script.google.com/macros/s/AKfycbwn_3ODXi0mzsVd78afsEUNjrBQVQkfFYLk4HzqM2FQgYk6f1EwcoCHtuVhBlaCltoE/exec",
                object : Response.Listener<String?> {

                    override fun onResponse(response: String?) {

                        loading.dismiss()

                        Toast.makeText(this@ActivityAddData, response, Toast.LENGTH_LONG).show()

                        val intent = Intent(applicationContext, MainActivity::class.java)

                        startActivity(intent)

                    }
                },
                object : Response.ErrorListener {
                    override fun onErrorResponse(error: VolleyError?) {}
                }
            ) {
                override fun getParams(): Map<String, String>? {
                    val parmas: MutableMap<String, String> = HashMap()
                    //here we pass params
                    parmas["action"] = "addItem"

                    parmas["email"] = email

                    parmas["first_name"] = fname

                    parmas["last_name"] = lname

                    parmas["contactno"] = contact

                    parmas["dob"] = dob

                    parmas["hobby"] = hobby

                    return parmas

                }

            }

        val socketTimeOut = 5000 // u can change this .. here it is 50 seconds

        val retryPolicy: RetryPolicy =
            DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        stringRequest.retryPolicy = retryPolicy

        val queue = Volley.newRequestQueue(this)

        queue.add(stringRequest)
    }
}