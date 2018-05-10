package freaklab.sandyz.com.cpresumebuilder.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import freaklab.sandyz.com.cpresumebuilder.R;

public class Experience_info_holderFragment extends Fragment {

    public Experience_info_holderFragment() {
    }

    public static Experience_info_holderFragment newInstance(int sectionNumber){
        Experience_info_holderFragment fragment = new Experience_info_holderFragment();
        Bundle args = new Bundle();
        args.putInt("Argument number",sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.experience_details_fragment,container,false);

    }
}
