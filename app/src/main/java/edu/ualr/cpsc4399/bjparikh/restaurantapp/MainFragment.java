package edu.ualr.cpsc4399.bjparikh.restaurantapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    TextView textView;
    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;
    TextView txt2;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        textView = (TextView) view.findViewById(R.id.textView);
        textView.setText("Welcome to Veggi Deli App");
        viewFlipper = (ViewFlipper) view.findViewById(R.id.viewFlipper);
        fade_in = AnimationUtils.loadAnimation(getActivity(),android.R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out);
        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setInAnimation(fade_out);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.startFlipping();
        txt2 = (TextView) view.findViewById(R.id.txt2);
        txt2.setText("We are located at " + "\n" + "9112 N Rodney Parham Rd suite #102," +
        "\n" + "Little Rock, Ar - 72205" + "\n" + "Click the Navigation Toolbar on the top-left" +
                " to navigate through the app.");

        return view;
    }

}
