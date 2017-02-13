package edu.ualr.cpsc4399.bjparikh.restaurantapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {


    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        TextView textView4 = (TextView) view.findViewById(R.id.textView4);
        textView4.setText("You can call us during our office hourse which are Tuesday through" +
        " Sunday from 11:00 Am to 7:00 Pm." + "\n" + "To contact us or to place an order," +
        " call us directly using the button below.");
        Button btn2 = (Button) view.findViewById(R.id.button12);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:7322585160"));
                startActivity(intent);
            }
        });
        return view;
    }

}
