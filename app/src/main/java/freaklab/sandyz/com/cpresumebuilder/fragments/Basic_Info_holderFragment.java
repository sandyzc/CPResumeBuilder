package freaklab.sandyz.com.cpresumebuilder.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import freaklab.sandyz.com.cpresumebuilder.R;

public class Basic_Info_holderFragment extends Fragment {






    private static final String ARG_SECTION_NUMBER = "section_number";

    public Basic_Info_holderFragment() {
    }

    public static Basic_Info_holderFragment newInstance(int sectionNumber) {
        Basic_Info_holderFragment fragment = new Basic_Info_holderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.basic_info_fragment, container, false);

        return rootView;
    }



}






