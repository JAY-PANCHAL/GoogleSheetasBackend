package com.example.googlesheetsasbackend

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserRVAdapter(modelArraylist: ArrayList<model>) :
    RecyclerView.Adapter<UserRVAdapter.ViewHolder>() {

    // variable for our array list and context.
    private val userModalArrayList: ArrayList<model> = modelArraylist
    private val context: Context? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstNameTV: TextView? = itemView.findViewById(R.id.idTVFirstName)
        var lastNameTV: TextView? = itemView.findViewById(R.id.idTVLastName)
        var emailTV: TextView? = itemView.findViewById(R.id.idTVEmail)
        var contact: TextView? = itemView.findViewById(R.id.idTVContactNo)
        var dob: TextView? = itemView.findViewById(R.id.idTVDateOfBirth)
        var hobby: TextView? = itemView.findViewById(R.id.idTVHobby)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.user_rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // getting data from our array list in our modal class.
        // getting data from our array list in our modal class.
        val userModal: model = userModalArrayList[position]

        // on the below line we are setting data to our text view.

        // on the below line we are setting data to our text view.
        holder.firstNameTV?.setText(userModal.getFirst_name())
        holder.lastNameTV?.setText(userModal.getLast_name())
        holder.emailTV?.setText(userModal.getEmail())
        holder.contact?.setText(userModal.getContact())
        holder.dob?.setText(userModal.getDob())
        holder.hobby?.setText(userModal.getHobby())
    }

    override fun getItemCount(): Int {
        return userModalArrayList.size
    }
}