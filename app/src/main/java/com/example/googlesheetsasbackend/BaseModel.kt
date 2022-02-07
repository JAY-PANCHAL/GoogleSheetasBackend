package com.example.googlesheetsasbackend

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BaseModel {
    @SerializedName("range")
    @Expose
    private var range: String? = null

    @SerializedName("majorDimension")
    @Expose
    private var majorDimension: String? = null

    @SerializedName("values")
    @Expose
    private var values: List<List<model?>?>? = null

    fun getRange(): String? {
        return range
    }

    fun setRange(range: String?) {
        this.range = range
    }

    fun getMajorDimension(): String? {
        return majorDimension
    }

    fun setMajorDimension(majorDimension: String?) {
        this.majorDimension = majorDimension
    }

    fun getValues(): List<List<model?>?>? {
        return values
    }

    fun setValues(values: List<List<model?>?>?) {
        this.values = values
    }

}