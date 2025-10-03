package com.example.a3assignment;

import android.content.Intent; // <-- Import Intent
import android.os.Bundle;
import android.view.View;      // <-- Import View for OnClickListener
import android.widget.Button;   // <-- Import Button

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonto3rdpage = findViewById(R.id.buttonto3rdpage); // <--- IMPORTANT: Use the correct ID of your button

        // 2. Set an OnClickListener on the button
        // (It's good practice to check if myButton is not null before setting the listener)
        if (buttonto3rdpage != null) {
            buttonto3rdpage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 3. Create an Intent to start SecondActivity
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    // 4. Start the new activity
                    startActivity(intent);
                }
            });
        }
    }
}