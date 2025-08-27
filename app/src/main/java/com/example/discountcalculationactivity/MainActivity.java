package com.example.discountcalculationactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textViewPercent;
    TextView textViewPrice;
    EditText ticketPrice;
    String ticketPriceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewPercent = findViewById(R.id.textViewDiscountedPercentNumber);
        textViewPrice = findViewById(R.id.textViewDiscountedPriceNumber);
        ticketPrice = findViewById(R.id.editTextNumberDecimalTicketPrice);

        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewPercent.setText("");
                textViewPrice.setText("");
                ticketPrice.setText("");
            }
        });

        findViewById(R.id.button5Percent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ticketPriceNumber = ticketNumberTest(ticketPrice);
                if (ticketPriceNumber != -1){
                    ticketPriceNumber = ticketPriceNumber*0.95;
                    textViewPrice.setText(String.format("$%.2f",ticketPriceNumber));
                    textViewPercent.setText("5%");
                }

            }
        });
        findViewById(R.id.button10Percent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ticketPriceNumber = ticketNumberTest(ticketPrice);
                if (ticketPriceNumber != -1){
                    ticketPriceNumber = ticketPriceNumber*0.90;
                    textViewPrice.setText(String.format("$%.2f",ticketPriceNumber));
                    textViewPercent.setText("10%");
                }
            }
        });
        findViewById(R.id.button15Percent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ticketPriceNumber = ticketNumberTest(ticketPrice);
                if (ticketPriceNumber != -1){
                    ticketPriceNumber = ticketPriceNumber*0.85;
                    textViewPrice.setText(String.format("$%.2f",ticketPriceNumber));
                    textViewPercent.setText("15%");
                }
            }
        });
        findViewById(R.id.button20Percent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ticketPriceNumber = ticketNumberTest(ticketPrice);
                if (ticketPriceNumber != -1){
                    ticketPriceNumber = ticketPriceNumber*0.80;
                    textViewPrice.setText(String.format("$%.2f",ticketPriceNumber));
                    textViewPercent.setText("20%");
                }
            }
        });
        findViewById(R.id.button50Percent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ticketPriceNumber = ticketNumberTest(ticketPrice);
                if (ticketPriceNumber != -1){
                    ticketPriceNumber = ticketPriceNumber*0.50;
                    textViewPrice.setText(String.format("$%.2f",ticketPriceNumber));
                    textViewPercent.setText("50%");
                }
            }
        });


    }
    public double ticketNumberTest(EditText ticketPrice) {
        ticketPriceText = ticketPrice.getText().toString();
        if (!ticketPriceText.isEmpty()){
            try{
                return Double.parseDouble(ticketPriceText);
            } catch (NumberFormatException e){
                Toast.makeText(MainActivity.this, "Invalid Number Format", Toast.LENGTH_LONG).show();
                return -1;
            }
        }else {
            Toast.makeText(MainActivity.this, "Invalid Number Format", Toast.LENGTH_LONG).show();
            return -1;
        }
    }
}

