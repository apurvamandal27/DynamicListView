package com.example.apurva.dynamiclistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button add;
    ListView list;
    EditText name;
    ArrayList<String> name_list;
    ArrayAdapter<String> adapter;
    String et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.button);
        list=findViewById(R.id.list_View);
        name=findViewById(R.id.editText);


        name_list=new ArrayList<>();
        adapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,name_list);
        list.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 et=name.getText().toString();
                name_list.add(et);

                adapter.notifyDataSetChanged();//refresh
                name.setText("");
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                name_list.remove(position);
                adapter.notifyDataSetChanged();

//                Fist Activity
//                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
//                intent.putStringArrayListExtra("arraylist",name_list);
////
//                   Second Activity
//                    Bundle b=getIntent().getExtras();
//                    ArrayList a;
//                    a=b.getStringArrayList("arraylist");

                return false;
            }
        });
    }
}
