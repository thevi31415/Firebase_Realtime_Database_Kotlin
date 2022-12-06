package com.example.firebaserealtimedatabase_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_insertion.*

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initView()
        setValuesToview()
        btn_update.setOnClickListener {
            val id= intent.getStringExtra("Id").toString()
            updateEmpDat(id, editdetail_name.text.toString(), editdetail_age.text.toString(), editdetail_salary.text.toString())
            Toast.makeText(this, "Update thanh cong !", Toast.LENGTH_SHORT).show()

        }
        btn_delete.setOnClickListener {
            val id= intent.getStringExtra("Id").toString()
            val dbRef = FirebaseDatabase.getInstance().getReference("Employees").child(id)
            val Delete = dbRef.removeValue()
            Delete.addOnCompleteListener {
                Toast.makeText(this, "Xoa thanh cong !", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, fetchactivity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun initView(){

    }
    private fun updateEmpDat(
        id: String ,
        name: String,
        age: String,
        salary: String
    ){

        val dbRef = FirebaseDatabase.getInstance().getReference("Employees").child(id)
        val empInfo = EmployeModel(id, name, age, salary)
        dbRef.setValue(empInfo)
    }
    private fun setValuesToview(){
        editdetail_name.setText(intent.getStringExtra("Name").toString())
        editdetail_age.setText(intent.getStringExtra("Age").toString())
        editdetail_salary.setText(intent.getStringExtra("Salary").toString())


    }
}