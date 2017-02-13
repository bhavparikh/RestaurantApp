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
public class LocationFragment extends Fragment {
    TextView txtview;
    Button btn1;
    Intent intent = null, chooser = null;

    public LocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        txtview = (TextView) view.findViewById(R.id.txtview);
        txtview.setText("To visit our Restaurant please use the address below. To use Google Maps please click" +
        " the button below. Copy and paste the  following address in the google maps" + "\n" +
        "VEGGI DELI" + "\n" + "9112 N Rodney Parham Rd, " + "\n" +
                "suite #102" + "\n" + "Little Rock, Ar - 72205");
        btn1 = (Button) view.findViewById(R.id.button10);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:34.7582953,-92.3756609999999998"));
                chooser = Intent.createChooser(intent, "Launch Maps");

                LocationFragment.this.startActivity(chooser);
            }
        });
        return view;
    }

}
