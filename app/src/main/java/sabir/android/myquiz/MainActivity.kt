package sabir.android.myquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart : Button = findViewById(R.id.btn_start)
        val etname : EditText = findViewById(R.id.et_name)
        btnStart.setOnClickListener {

            if (etname.text.isEmpty()){
                Toast.makeText(this,"Please Enter Your Name to Begin",Toast.LENGTH_SHORT).show()

            }else{
                val intent = Intent(this , QuizquestionsActivity::class.java)
                intent.putExtra(Consytants.USER_NAME,etname.text.toString())
                startActivity(intent)
            }
        }
    }
}