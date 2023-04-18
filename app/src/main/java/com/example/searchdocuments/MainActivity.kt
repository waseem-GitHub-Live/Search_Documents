package com.example.searchdocuments

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchdocuments.adapter.AdapterSearchView
import com.example.searchdocuments.data.DataClassSearch
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var noDataFoundLayout: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<DataClassSearch>()
    private lateinit var adapter: AdapterSearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.itemsrecyclerview)
//        searchView = findViewById(R.id.searchVitew)
        noDataFoundLayout = findViewById(R.id.noDataFoundLayout)
        val searchView: SearchView = findViewById(R.id.searchVitew)
        val icon = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_mag_icon)
        icon.setColorFilter(ContextCompat.getColor(this, androidx.appcompat.R.color.material_blue_grey_800), PorterDuff.Mode.SRC_IN)
        val icons = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_close_btn)
        icons.setColorFilter(ContextCompat.getColor(this, androidx.appcompat.R.color.material_blue_grey_800),  PorterDuff.Mode.SRC_ATOP)
// Change the text color of the search box
        val searchEditText: EditText = searchView.findViewById(androidx.appcompat.R.id.search_src_text)
        searchEditText.setTextColor(ContextCompat.getColor(this, R.color.black))
// Change the color of the hint text
        searchEditText.setHintTextColor(ContextCompat.getColor(this, androidx.appcompat.R.color.material_blue_grey_800))
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = AdapterSearchView(mList)
        recyclerView.adapter = adapter
        searchView.setOnQueryTextFocusChangeListener { v, hasFocus ->
            v.isActivated = hasFocus
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.isActivated=false
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<DataClassSearch>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                recyclerView.visibility = View.GONE
                noDataFoundLayout.visibility = View.VISIBLE
            } else {
                recyclerView.visibility = View.VISIBLE
                noDataFoundLayout.visibility = View.GONE
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(DataClassSearch("Java", R.drawable.documetsimage))
        mList.add(DataClassSearch("Kotlin", R.drawable.documetsimage))
        mList.add(DataClassSearch("C++", R.drawable.documetsimage))
        mList.add(DataClassSearch("Python", R.drawable.documetsimage))
        mList.add(DataClassSearch("HTML", R.drawable.documetsimage))
        mList.add(DataClassSearch("Swift", R.drawable.documetsimage))
        mList.add(DataClassSearch("C#", R.drawable.documetsimage))
        mList.add(DataClassSearch("JavaScript", R.drawable.documetsimage))
    }
}