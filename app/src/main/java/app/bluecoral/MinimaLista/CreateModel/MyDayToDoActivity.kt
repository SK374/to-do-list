package app.bluecoral.MinimaLista.CreateModel

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.bluecoral.MinimaLista.R
import kotlinx.android.synthetic.main.activity_create_home_bills_todo.*

class MyDayToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_my_day_todo)

        saveButton.setOnClickListener {
            var title = ""
            if (importantCheckBox.isChecked) {
                title = "❗️️️️ " + titleEditText.text.toString()
            } else {
                title = titleEditText.text.toString()
            }
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS1), setOf()).toMutableSet()
            todos.add(title)
            prefs.edit().putStringSet("todostrings1", todos).apply()

            finish()
        }
    }
}
