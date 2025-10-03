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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // Links to your activity_main.xml

        // This is your existing code for window insets
        // Ensure R.id.main exists in your activity_main.xml
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // --- Code to handle button click to go to SecondActivity ---

        // 1. Find the button from your layout.
        // Make sure your button in activity_main.xml has android:id="@+id/myButton"
        // or change R.id.myButton to the correct ID (e.g., R.id.buttonto2ndpage from earlier)
        Button buttonto2ndpage = findViewById(R.id.buttonto2ndpage); // <--- IMPORTANT: Use the correct ID of your button

        // 2. Set an OnClickListener on the button
        // (It's good practice to check if myButton is not null before setting the listener)
        if (buttonto2ndpage != null) {
            buttonto2ndpage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 3. Create an Intent to start SecondActivity
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    // 4. Start the new activity
                    startActivity(intent);
                }
            });
        }
        // --- End of button click code ---
    }
}
