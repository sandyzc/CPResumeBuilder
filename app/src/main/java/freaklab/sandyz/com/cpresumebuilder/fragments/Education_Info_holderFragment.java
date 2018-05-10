package freaklab.sandyz.com.cpresumebuilder.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import freaklab.sandyz.com.cpresumebuilder.R;


public class Education_Info_holderFragment extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section number";

    public Education_Info_holderFragment() {
    }
    public static Education_Info_holderFragment newInstance(int sectionNumber) {
        Education_Info_holderFragment fragment = new Education_Info_holderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.education_details_fragment, container, false);
    }
}




