package com.rupam.photoframe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Displays the current image
    private ImageView imageView;
    // Array of images
    private int[] images = {R.drawable.first, R.drawable.second, R.drawable.third, R.drawable.fourth, R.drawable.fifth};

    // Tracks current image index
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView2); // Connects ImageView from layout
        imageView.setImageResource(images[currentIndex]); // Display the first image

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    // Method to switch to the next image
    public void Next(View view){
        currentIndex = (currentIndex + 1) % images.length;
        imageView.setImageResource(images[currentIndex]);
    }

    // Method to switch to the previous image
    public void Previous(View view) {
        currentIndex = (currentIndex - 1 + images.length) % images.length;
        imageView.setImageResource(images[currentIndex]);
    }
}