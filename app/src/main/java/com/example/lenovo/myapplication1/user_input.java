package com.example.lenovo.myapplication1;




        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class user_input extends AppCompatActivity {

    String status = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int no =  Integer.parseInt(String.valueOf(quantityTextView.getText()));
        int cost = 10;
        CheckBox checkbox =  (CheckBox) findViewById(R.id.checkbox);
        if(checkbox.isChecked()) {
            status = "true";
            cost = 15;
        }
        else
            status = "false";
        display(no , cost);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number , int cost) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        TextView priceTextView =   (TextView) findViewById(R.id.price_text_view);
        EditText name_edittext = (EditText) findViewById(R.id.name_field);
        String name = String.valueOf(name_edittext.getText());
        String finalmessage = "Hello "+name+"\n"+ "Whipped Cream? "+ status+"\n"+"Your cost is "+ (number*cost) +"\n"+ "Thank You";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "coffee order for "+name );
        intent.putExtra(Intent.EXTRA_TEXT, finalmessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        priceTextView.setText("Hello "+name+"\n"+ "Whipped Cream? "+ status+"\n"+"Your cost is "+ (number*cost) );
    }

    public void increment(View view)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText( ""+ ( 1+ Integer.parseInt(String.valueOf(quantityTextView.getText()))));

    }
    public void decrement(View view)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);

        int no  = Integer.parseInt(String.valueOf(quantityTextView.getText()));
        if(no!=0)
        quantityTextView.setText( ""+ (Integer.parseInt(String.valueOf(quantityTextView.getText())) -1 ));
        else
            quantityTextView.setText( ""+ (Integer.parseInt(String.valueOf(quantityTextView.getText()))));
    }
}