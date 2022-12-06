package com.example.firebaserealtimedatabase_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_fetchactivity.*

class fetchactivity : AppCompatActivity() {
    private  lateinit var emRecyclerView: RecyclerView
    private  lateinit var emplist: ArrayList<EmployeModel>
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetchactivity)
        emRecyclerView = findViewById(R.id.rvDrug)
        emRecyclerView.setHasFixedSize(true)
        emplist = arrayListOf<EmployeModel>()
        getEmployeesData()


    }
    private fun getEmployeesData(){
       dbRef = FirebaseDatabase.getInstance().getReference("Employees")
       dbRef.addValueEventListener(object : ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
              emplist.clear()
                  if(snapshot.exists()){
                      for(empSnap in snapshot.children){
                          val empData = empSnap.getValue(EmployeModel::class.java)
                          emplist.add(empData!!)
                      }
                      val mAdapter = EmpAdapter(emplist)
                      rvDrug.adapter=mAdapter
                      mAdapter.setOnItemClickListener(object : EmpAdapter.onItemClickListener{
                          override fun onItemClick(position: Int) {
                              val intent = Intent(this@fetchactivity, Details::class.java)
                              intent.putExtra("Id", emplist[position].id)
                              intent.putExtra("Name", emplist[position].name)
                              intent.putExtra("Age", emplist[position].age)
                              intent.putExtra("Salary", emplist[position].salary)
                              startActivity(intent)
                          }

                      })

                  }

           }
           override fun onCancelled(error: DatabaseError) {
               TODO("Not yet implemented")
           }

       })
    }
}