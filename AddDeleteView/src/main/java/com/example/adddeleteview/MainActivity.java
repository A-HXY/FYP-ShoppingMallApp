package com.example.adddeleteview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AddDeleteView add_delete_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_delete_view = findViewById(R.id.add_delete_view);
        add_delete_view.setOnNumberChangeListener(new AddDeleteView.OnNumberChangeListener() {
            @Override
            public void onNumberChange(int value) {
                Toast.makeText(MainActivity.this, "当前产品数量=="+value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
