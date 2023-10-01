package com.example.array2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayAccount = ArrayList<String>()
        var arrayPassword =ArrayList<String>()

//        var implicit_array = arrayOf(1,2,"ST-RING NUMBER",4,5,6)
//        var explicit_array = arrayOf<Int>(1,2,3,4,5,6)
        var implicit_array = arrayOf(1)
       var textAccount = findViewById<TextView>(R.id.txtAccount)

        var buttonAccount = findViewById<Button>(R.id.btnAccount)
        var updateAccount = findViewById<Button>(R.id.update)
        var deleteAccount = findViewById<Button>(R.id.delete)
        var showAccount = findViewById<Button>(R.id.show)

        var editAccount = findViewById<EditText>(R.id.edtAccount)
        var editPassword = findViewById<EditText>(R.id.edtPassword)

        var editToastStatement = "Account edited Successfully"
        var addToastStatement= "Account is already existing"

        buttonAccount.setOnClickListener {
            //getText() && setText()
            try{
                val existingAccount =arrayAccount.stream().anyMatch{x -> x ==editAccount.text.toString()}
                Log.i("info_amada",existingAccount.toString())

                 if(editAccount.text.isEmpty()|| editPassword.text.isEmpty()){
                    addToastStatement = "Please fill out the information"
                }else if(!existingAccount)  {
                    arrayAccount.add(editAccount.text.toString())
                    arrayPassword.add(editPassword.text.toString())
                    textAccount.setText(arrayAccount.size.toString())
                    addToastStatement = "Account added Successfully"

                     Log.i("info_amada",addToastStatement)
                }else{
                    addToastStatement = "Account is already existing"
                }
                Toast.makeText(this, addToastStatement, Toast.LENGTH_SHORT)

            }catch(e:Exception){
                Log.e("error po hehe" , e.message.toString())
            }
            Toast.makeText(this, addToastStatement, Toast.LENGTH_SHORT).show()

        } //        button

        //update button
        updateAccount.setOnClickListener {
            try{
                val existingAccount =arrayAccount.stream().anyMatch{x -> x ==editAccount.text.toString()}
                Log.i("info_amada",existingAccount.toString())
                if (!existingAccount){
//                    arrayAccount.add(editAccount.text.toString())
//                    textAccount.setText(arrayAccount.size.toString())
                    editToastStatement = "Account is not existing"
                    Log.i("info_amada",editToastStatement)

                }else{
                    editToastStatement = "Account edited Successfully"
                    var number= arrayAccount.indexOf(editAccount.text.toString())
                    arrayAccount[number]= arrayAccount[number] + "_UPDATED"
                    arrayPassword[number]= arrayPassword[number] + "_UPDATED"
                    Log.i("info_amado",editToastStatement)
                    Toast.makeText(this, editToastStatement, Toast.LENGTH_SHORT).show()
                }

            }catch(e:Exception){
                Log.e("error po hehe" , e.message.toString())
            }
        }

        //delete
        deleteAccount.setOnClickListener {
            try{
                val existingAccount =arrayAccount.stream().anyMatch{x -> x ==editAccount.text.toString()}
                Log.i("info_amada",existingAccount.toString())
                if (!existingAccount){
//                    arrayAccount.add(editAccount.text.toString())
//                    textAccount.setText(arrayAccount.size.toString())
                    editToastStatement = "Account is not existing"
                    Log.i("info_amada",editToastStatement)
                    Toast.makeText(this, editToastStatement, Toast.LENGTH_SHORT).show()
                }else{
                    editToastStatement = "Account DELETED Successfully"
                    var number= arrayAccount.indexOf(editAccount.text.toString())

                    arrayAccount.removeAt(number)
                    arrayPassword.removeAt(number)
                    Log.i("info_amado",editToastStatement)

                    textAccount.setText(arrayAccount.size.toString())

                    Toast.makeText(this, editToastStatement, Toast.LENGTH_SHORT).show()
                }

            }catch(e:Exception){
                Log.e("error po hehe" , e.message.toString())
            }
        }

        //show
        showAccount.setOnClickListener {
            for(x in implicit_array){
                Log.i("info", x.toString())
                Log.i("info", arrayPassword.toString())
                Log.i("info", arrayAccount.toString())
            }
            addToastStatement = "SHOW Successfully"
            Toast.makeText(this, addToastStatement, Toast.LENGTH_SHORT).show()
        }



        //end
    }
}

