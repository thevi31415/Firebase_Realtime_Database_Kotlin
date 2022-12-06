package com.example.firebaserealtimedatabase_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_insertion.*

class InsertionActivity : AppCompatActivity() {
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertion)
        dbRef = FirebaseDatabase.getInstance().getReference("Employees")
        btn_save.setOnClickListener {
            saveEmployeeData()
        }
    }
    private fun saveEmployeeData(){
        val empID  = dbRef.push().key!!
        val employee = EmployeModel(empID, edit_name.text.toString(), edit_Age.text.toString(), edit_salary.text.toString())
        dbRef.child(empID).setValue(employee)
            .addOnCompleteListener {
                Toast.makeText(this, "Da them thanh cong ${employee.id}", Toast.LENGTH_SHORT).show()
                edit_name.text.clear()
                edit_Age.text.clear()
                edit_salary.text.clear()
            }.addOnFailureListener { err->
                Toast.makeText(this, "Da them that bai !", Toast.LENGTH_SHORT).show()
            }
    }
}