package com.vishal.wikisearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.vishal.wikisearch.adapters.Adapter;
import com.vishal.wikisearch.database.PageDataBase;
import com.vishal.wikisearch.models.Page;
import com.vishal.wikisearch.models.Terms;
import com.vishal.wikisearch.models.Thumbnail;
import com.vishal.wikisearch.viewmodel.ResultModelClass;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    private Adapter adapter;
    private LinkedList<Page> mainlist;
    ResultModelClass model;
    private TextView text;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.listview);
        mainlist=new LinkedList<>();
        adapter=new Adapter(this,mainlist);
        listView.setAdapter(adapter);

        text=findViewById(R.id.text);

        searchView=findViewById(R.id.serchview);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.setFocusable(true);
                searchView.setIconified(false);
                searchView.requestFocusFromTouch();
            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                serchdatachange(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                serchdatachange(s);
                return false;
            }
        });



        model = ViewModelProviders.of(this).get(ResultModelClass.class);

        model.getfromlocal(this).observe(this,result->{
                List<Page> list = result;
                mainlist.clear();
                if (list.size() > 0)
                    text.setVisibility(View.GONE);
                for (int i = 0; i < list.size(); i++) {
                    final int temp = i;
                    model.getThumbnail(MainActivity.this, list.get(temp).getPageid()).observe(this, thumbnail -> {
                        list.get(temp).setThumbnail(thumbnail);
                        model.getTerms(MainActivity.this, list.get(temp).getPageid()).observe(this, terms -> {
                            list.get(temp).setTerms(terms);
                            if (temp == list.size() - 1) {
                                mainlist.clear();
                                mainlist.addAll(list);
                                adapter.notifyDataSetChanged();
                            }
                        });
                    });
                }
        });

    }


    public void serchdatachange(String serchvalue){
        model.getrepo(serchvalue).observe(this,result->{
            if (result.getQuery()!=null) {
                LinkedList<Page> list = result.getQuery().getPages();
                if (list.size()>0)
                    text.setVisibility(View.GONE);
                mainlist.clear();
                mainlist.addAll(list);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
