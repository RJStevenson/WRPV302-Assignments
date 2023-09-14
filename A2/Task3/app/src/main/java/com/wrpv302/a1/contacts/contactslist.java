package com.wrpv302.a1.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.List;

import adapters.CustomAdapter;
import adapters.CustomRecyleAdapter;
import controllers.BusinessLogic;

public class contactslist extends AppCompatActivity {
    public List<models.ContactItem> datalist;
    public RecyclerView simplelist;

    public controllers.BusinessLogic bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactslist);
        bd = new BusinessLogic(this.getWindow().getContext());
        datalist = bd.Items;
        simplelist = (RecyclerView) findViewById(R.id.recycle);
        //CustomAdapter myadapt = new CustomAdapter(this, R.layout.contactcardfront, datalist);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        simplelist.setLayoutManager(staggeredGridLayoutManager);

        CustomRecyleAdapter mine = new CustomRecyleAdapter(datalist);
        simplelist.setAdapter(mine);
    }
}