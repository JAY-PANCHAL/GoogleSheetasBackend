package com.example.googlesheetsasbackend

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.widget.EditText
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.*

class DateAndTimeUtils {

    companion object {
        // onclick of edittext open date picker dialog.
        @SuppressLint("SimpleDateFormat")
        fun setDate(context: Context, editText: EditText) {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                context, { _, yearCalendar, monthOfYear, dayOfMonth ->
                    calendar.set(Calendar.YEAR, yearCalendar)
                    calendar.set(Calendar.MONTH, monthOfYear)
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    // Display Selected date in textBox
                    editText.setText(SimpleDateFormat("dd/MMM/yyyy").format(calendar.time))
                },
                year,
                month,
                day
            )
            //it will let user select whatever dates he want to
            datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
            // datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000
            datePickerDialog.show()
            val positiveColor =
                ContextCompat.getColor(context, R.color.primarydark)
            val negativeColor = ContextCompat.getColor(context, R.color.primarydark)
            datePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(positiveColor)
            datePickerDialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(negativeColor)

        }

    }

}