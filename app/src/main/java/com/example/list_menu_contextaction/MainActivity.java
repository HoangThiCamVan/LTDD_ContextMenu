package com.example.list_menu_contextaction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listProduct;
    Context context;
    ArrayList<Model> data;
    CustomerAdapter customerAdapter;
    Model model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_main);



        listProduct=findViewById(R.id.listProduct);
        registerForContextMenu(listProduct);
        data=new ArrayList<>();

        populateData();
        customerAdapter=new CustomerAdapter(context,data);
        listProduct.setAdapter(customerAdapter);
    }

    private void populateData(){

        model=new Model();
        model.setId(1);
        model.setTieuDe("Hoa nở không màu");
        model.setTieuDePhu("Hoài Lâm");
        model.setImage(R.drawable.product_hnkm);
        data.add(model);

        model=new Model();
        model.setId(1);
        model.setTieuDe("Thích thì đến");
        model.setTieuDePhu("Trịnh Thăng Bình");
        model.setImage(R.drawable.product_ttd);
        data.add(model);

        model=new Model();
        model.setId(1);
        model.setTieuDe("Đồi hoa mặt trời");
        model.setTieuDePhu("Hoàng Yến");
        model.setImage(R.drawable.product_dhmt);
        data.add(model);

        model=new Model();
        model.setId(1);
        model.setTieuDe("Cha và con gái");
        model.setTieuDePhu("Thùy Chi");
        model.setImage(R.drawable.product_cvcg);
        data.add(model);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.it_Delete:
                data.remove(info.position);
                customerAdapter.notifyDataSetChanged();
                return true;
            default:return super.onContextItemSelected(item);
        }

    }
}