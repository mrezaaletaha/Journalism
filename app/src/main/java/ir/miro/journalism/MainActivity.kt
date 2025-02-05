package ir.miro.journalism

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author mrezaaletaha
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.data.observe(this) { data ->
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        }
    }
}