package com.vishal.wikisearch.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vishal.wikisearch.MainActivity;
import com.vishal.wikisearch.R;
import com.vishal.wikisearch.WebviewActivity;
import com.vishal.wikisearch.database.PageDataBase;
import com.vishal.wikisearch.models.Page;
import com.vishal.wikisearch.models.Terms;
import com.vishal.wikisearch.models.Thumbnail;

import java.util.LinkedList;
import java.util.List;

public class Adapter extends BaseAdapter {
    private Context context;
    private List<Page> list;

    public Adapter(Context context,LinkedList<Page> list){
        this.list=list;
        this.context=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.searchitem,viewGroup,false);

        ImageView icon=view.findViewById(R.id.icon);
        TextView title=view.findViewById(R.id.title);
        TextView des=view.findViewById(R.id.abstrac);
        ImageView download=view.findViewById(R.id.download);
        CardView card=view.findViewById(R.id.card);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebviewActivity.class);
                intent.putExtra("link",list.get(i).getTitle());
                context.startActivity(intent);
            }
        });

        title.setText(list.get(i).getTitle());
        if (list.get(i).getTerms()!=null && list.get(i).getTerms().getDescription()!=null){
            des.setText(list.get(i).getTerms().getDescription().get(0));
        }
        if (list.get(i).getTerms()!=null) {
            if (list.get(i).getTerms().getDes() != null && list.get(i).getTerms().getDescription() == null) {
                des.setText(list.get(i).getTerms().getDes());
                download.setVisibility(View.GONE);
            }
        }

        if (list.get(i).getThumbnail()!=null){
            Glide.with(context)
                    .load(list.get(i).getThumbnail().getSource())
                    .into(icon);
        }
        else {
            icon.setVisibility(View.GONE);
        }



        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            PageDataBase.getDataBase(context).gettable().insertdata(list.get(i));
                            Terms terms = list.get(i).getTerms();
                            terms.setParentkey(list.get(i).getPageid());
                            terms.setDes(list.get(i).getTerms().getDescription().get(0));
                            PageDataBase.getDataBase(context).gettermtable().insertterms(terms);
                            Thumbnail thumbnail = list.get(i).getThumbnail();
                            thumbnail.setParentid(list.get(i).getPageid());
                            PageDataBase.getDataBase(context).getThumbnailTable().insertthumbnil(thumbnail);

                        } catch (Exception e) {

                        }
                        MainActivity activity = (MainActivity) context;
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context,"Saved",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });

        return view;
    }


}
