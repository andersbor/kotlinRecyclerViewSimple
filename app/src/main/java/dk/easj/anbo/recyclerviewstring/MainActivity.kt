package dk.easj.anbo.recyclerviewstring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dk.easj.anbo.recyclerviewstring.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val names: List<String> = mutableListOf("Anders", "Benjamin", "Carl", "Dennis")
    private val numbers: List<Int> = mutableListOf(1, 5, 2, 14593)
    private val students: List<Student> = mutableListOf(Student("Anders", 4), Student("Billy"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = MyAdapter(students) { position -> onListItemClick(position) }
    }

    private fun onListItemClick(position: Int) {
        Toast.makeText(this, "You clicked " + students[position], Toast.LENGTH_SHORT).show()
    }
}

// https://kotlinlang.org/docs/data-classes.html
data class Student(var name: String, var semester: Int = 1) {
    override fun toString(): String {
        return "$name $semester"
    }
}