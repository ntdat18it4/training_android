package thanhdat.sict.project.simpleappbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            R.id.search ->{
                Toast.makeText(this, item.title.toString(), Toast.LENGTH_LONG).show()
                return true
            }

            R.id.android ->{
                Toast.makeText(this, item.title.toString(), Toast.LENGTH_LONG).show()
                return true
            }

            R.id.java ->{
                Toast.makeText(this, item.title.toString(), Toast.LENGTH_LONG).show()
                return true
            }

            R.id.kotlin ->{
                Toast.makeText(this, item.title.toString(), Toast.LENGTH_LONG).show()
                return true
            }

            R.id.php ->{
                Toast.makeText(this, item.title.toString(), Toast.LENGTH_LONG).show()
                return true
            }

            R.id.python ->{
                Toast.makeText(this, item.title.toString(), Toast.LENGTH_LONG).show()
                return true
            }else -> super.onOptionsItemSelected(item)

        }

    }

}