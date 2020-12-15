package com.example.setevenwidget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.adapters.AdapterViewBindingAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.example.setevenwidget.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding data ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
       data = DataBindingUtil.setContentView(this,R.layout.activity_main);

       // lay danh sach cac quoc gia
        List<String> lstQGs = LayDSQuocGia();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,lstQGs);
        data.spQuocgia.setAdapter(adapter);

        data.spQuocgia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            boolean choosed = true;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(choosed){
                    choosed = false;
                }else{
                    Toast.makeText(MainActivity.this,"Ban vua chon " + parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




       // cach 1(set su kien)
//       data.btnHienthi.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Toast.makeText(MainActivity.this,"Ban vua nhap " + data.edtNhap.getText().toString(),Toast.LENGTH_SHORT).show();
//           }
//       });
        //cach 2
//        data.btnHienthi.setOnClickListener(new MyOnclickButtonHienThi());
    }











    //class cach 2
//    class MyOnclickButtonHienThi implements  View.OnClickListener{
//
//        @Override
//        public void onClick(View v) {
//            Toast.makeText(MainActivity.this,"Ban vua nhap " + data.edtNhap.getText().toString(),Toast.LENGTH_SHORT).show();
//            data.edtNhap.clearFocus();
//        }
//    }
    //cach 3:
    public void ButtonSetEven(View view){
            Toast.makeText(MainActivity.this,"Ban vua nhap " + data.edtNhap.getText().toString(),Toast.LENGTH_SHORT).show();
    }

    private List<String> LayDSQuocGia() {
        List<String> listQGs = new ArrayList<String>();
        listQGs.add("Viet Nam");
        listQGs.add("My");
        listQGs.add("Trung Quoc");
        listQGs.add("Han Quoc");
        listQGs.add("Nhat Ban");

        return listQGs;
    }



}