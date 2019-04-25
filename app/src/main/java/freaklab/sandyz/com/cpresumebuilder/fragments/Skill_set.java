package freaklab.sandyz.com.cpresumebuilder.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import freaklab.sandyz.com.cpresumebuilder.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link Skill_set#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Skill_set extends Fragment {
    private static final String ARG_PARAM1 = "param1";




    public Skill_set() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Skill_set newInstance(int param1) {
        Skill_set fragment = new Skill_set();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_set, container, false);
    }


}
