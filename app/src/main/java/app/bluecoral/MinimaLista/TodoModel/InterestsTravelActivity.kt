package app.bluecoral.MinimaLista.TodoModel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import app.bluecoral.MinimaLista.Adapter.InterestsTravelAdapter
import app.bluecoral.MinimaLista.CreateModel.InterestsTravelToDoActivity
import app.bluecoral.MinimaLista.R

import kotlinx.android.synthetic.main.activity_interests_travel_todo.*
import kotlinx.android.synthetic.main.content_home_bills.*

class InterestsTravelActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: InterestsTravelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interests_travel_todo)
        setSupportActionBar(toolbar)

        //Add intent to go to HomeBillsToDoActivity
        fab.setOnClickListener { view ->
            val intent = Intent(this, InterestsTravelToDoActivity::class.java )
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        updateRecycler()
    }
    fun updateRecycler() {
        var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
        var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS6), setOf()).toMutableSet()
        println(todos)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = InterestsTravelAdapter(todos.toList())
        recyclerView.adapter = adapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.action_delete_all) {
            var prefs = getSharedPreferences(getString(
                R.string.SHARED_PREF_NAME
            ), Context.MODE_PRIVATE)
            prefs.edit().putStringSet(getString(R.string.TODO_STRINGS6), null).apply()
            updateRecycler()

            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
