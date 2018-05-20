package com.example.victor.cafeteria;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    private void display(int number){
        TextView quantidadeTextView = (TextView) findViewById( R.id.qtd_text_view );
        quantidadeTextView.setText( "" + number );
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById( R.id.order_Summary_text_view );
        orderSummaryTextView.setText( message );
    }

    public void incremento (View view){
        if (quantity ==100)
        {
            Toast.makeText( this,getString( R.string.max_message ),Toast.LENGTH_SHORT).show( );
            return;
        }
        quantity++;
        display(quantity);
        return;

    }

    public void decremento (View view){
        if (quantity ==1)
        {
            Toast.makeText( this,getString( R.string.min_message ),Toast.LENGTH_SHORT).show( );
            return;
        }
        quantity--;
        display(quantity);
        return;

    }

    public void enviarpedido (View view){

        CheckBox haschantilly = (CheckBox) findViewById( R.id.chantilly_check );
        boolean isChantillyCheck = haschantilly.isChecked();

        CheckBox haschocolate = (CheckBox) findViewById( R.id.chocolate_check );
        boolean isChocolateCheck = haschocolate.isChecked();

        int priceOrder = calculatePrice(isChantillyCheck,isChocolateCheck);

        EditText orderName = (EditText) findViewById( R.id.nome_text_view );
        String nome = orderName.getText().toString();

        createOrderSummary( nome,priceOrder,isChantillyCheck,isChocolateCheck );

    }

    private void createOrderSummary (String name,int price, boolean isChantillyCheck, boolean isChocolateCheck){
        String orderSummary = name;
        orderSummary += "\n" + isChantillyCheck;
        orderSummary += "\n" + isChocolateCheck;
        orderSummary += "\n" + quantity;
        orderSummary += "\n" + price;
        orderSummary += "\n";

        displayMessage(orderSummary);
        return;




    }

    private int calculatePrice(boolean adChantillyCheck, boolean adChocolateCheck){
        int precoBase = 5;

        if (adChantillyCheck){
            precoBase += 1;
        }
        if (adChocolateCheck){
            precoBase += 2;
        }

        return (quantity * precoBase);



    }






}
