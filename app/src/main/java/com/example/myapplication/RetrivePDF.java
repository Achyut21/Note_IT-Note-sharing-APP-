package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RetrivePDF extends AppCompatActivity {
    ListView listView;
    DatabaseReference databaseReference;
    List<putpdf> uploadedPDF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive_pdf);

        listView = findViewById(R.id.listview);
        uploadedPDF = new ArrayList<>();

        retrivePDFFiles();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                putpdf putPDF = uploadedPDF.get(i);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setType("application/pdf");
                intent.setData(Uri.parse(putPDF.getUrl()));
                startActivity(intent);
            }
        });
    }

    private void retrivePDFFiles() {

        databaseReference = FirebaseDatabase.getInstance().getReference("bitsappathon");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){
                    putpdf putpdf = ds.getValue(com.example.myapplication.putpdf.class);
                    uploadedPDF.add(putpdf);
                }

                String[] uploadName = new String[uploadedPDF.size()];

                for(int i = 0; i< uploadName.length;i++){
                    uploadName[i] = uploadedPDF.get(i).getName();
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,uploadName){
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                        View view = super.getView(position, convertView, parent);
                        TextView textView =(TextView) view.findViewById(android.R.id.text1);

                        textView.setTextColor(Color.BLUE);
                        textView.setTextSize(20);
                        return view;
                    }
                };
                listView.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}