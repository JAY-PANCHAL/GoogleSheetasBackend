package com.example.googlesheetsasbackend

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    private var userModalArrayList: ArrayList<model>? = null
    private var userRVAdapter: UserRVAdapter? = null
    private var userRV: RecyclerView? = null
    private var loadingPB: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userModalArrayList = ArrayList()
        userRV = findViewById(R.id.idRVUsers)
        loadingPB = findViewById(R.id.idPBLoading)
        getDataFromAPI()
    }

    private fun getDataFromAPI() {
        val url =
            "https://sheets.googleapis.com/v4/spreadsheets/1eUft9Nl7-5L9bO8Oy7Tpdic09G1anczRbz61IRgfpwE/values/tab?alt=json&key=AIzaSyD9tzYgZBkIPlmk9zMzRIehJ7w3GLQquXA\n"
        val queue = Volley.newRequestQueue(this@MainActivity)

        val jsonObjectRequest =
            JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                object : Response.Listener<JSONObject> {
                    override fun onResponse(response: JSONObject) {
                        loadingPB!!.visibility = View.GONE
                        try {
                            // val feedObj = response.getJSONObject("")
                            val entryArray = response.getJSONArray("values")

                            for (i in 1 until entryArray.length()) {
                                val entryObj = entryArray.getJSONArray(i)
                                val firstName =
                                    entryObj[3].toString()
                                val lastName = entryObj[4].toString()
                                //  entryObj.getJSONObject("gsx\$lastname").getString("\$t")
                                val email = entryObj[2].toString()
                                val contact = entryObj[5].toString()
                                val dob = entryObj[6].toString()
                                val hobby = entryObj[7].toString()

                                userModalArrayList!!.add(
                                    model(
                                        firstName,
                                        lastName,
                                        email,
                                        contact,
                                        dob,
                                        hobby
                                    )
                                )


                                // passing array list to our adapter class.
                                userRVAdapter = UserRVAdapter(userModalArrayList!!)

                                // setting layout manager to our recycler view.
                                userRV!!.layoutManager = LinearLayoutManager(this@MainActivity)

                                // setting adapter to our recycler view.
                                userRV!!.adapter = userRVAdapter
                            }
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }
                },
                object : Response.ErrorListener {
                    override fun onErrorResponse(error: VolleyError?) {
                        // handline on error listener method.
                        Toast.makeText(this@MainActivity, "Fail to get data..", Toast.LENGTH_SHORT)
                            .show()
                    }
                })
        queue.add(jsonObjectRequest);
    }
}