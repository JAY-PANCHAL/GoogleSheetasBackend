package com.example.googlesheetsasbackend

class model {
    // variables for our first name,
    // last name, email and avatar
    private var first_name: String? = null
    private var last_name: String? = null
    private var email: String? = null
    private var contactno: String? = null
    private var dob: String? = null
    private var hobby: String? = null

    constructor(
        first_name: String,
        last_name: String,
        email: String,
        contactno: String,
        dob: String,
        hobby: String
    ) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.contactno = contactno
        this.dob = dob
        this.hobby = hobby
    }

    fun getFirst_name(): String? {
        return first_name
    }

    fun setcontact(contactno: String?) {
        this.contactno = contactno
    }

    fun getContact(): String? {
        return contactno
    }

    fun setdob(dob: String?) {
        this.dob = dob
    }

    fun getDob(): String? {
        return dob
    }

    fun sethobby(hobby: String?) {
        this.hobby = hobby
    }

    fun getHobby(): String? {
        return hobby
    }

    fun setFirst_name(first_name: String?) {
        this.first_name = first_name
    }

    fun getLast_name(): String? {
        return last_name
    }

    fun setLast_name(last_name: String?) {
        this.last_name = last_name
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email
    }

}