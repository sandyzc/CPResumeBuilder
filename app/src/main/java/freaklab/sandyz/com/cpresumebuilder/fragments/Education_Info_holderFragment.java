package freaklab.sandyz.com.cpresumebuilder.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import freaklab.sandyz.com.cpresumebuilder.Database.Education_Databse;
import freaklab.sandyz.com.cpresumebuilder.R;
import freaklab.sandyz.com.cpresumebuilder.beans.Education_Beans;
import freaklab.sandyz.com.cpresumebuilder.fragments.dialogs.Education_dialog_fragment;
import freaklab.sandyz.com.cpresumebuilder.views.viewHolder.Education_info_Adapter;


public class Education_Info_holderFragment extends Fragment {

    FloatingActionButton floatingActionButton;

    Education_info_Adapter adapter;
    RecyclerView recyclerView;

    ArrayList<Education_Beans>data;

    Education_Databse databse;



    String college_name,majore,edu_from,edu_to;

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

        View rootview = getLayoutInflater().inflate(R.layout.education_details_fragment, container, false);

        floatingActionButton = rootview.findViewById(R.id.fab_edu);
        recyclerView = rootview.findViewById(R.id.edu_recycle);




        databse= new Education_Databse(getActivity().getBaseContext());

        data= new ArrayList<>();
        data= databse.edu_data();

        adapter = new Education_info_Adapter(getActivity().getBaseContext(),data);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Education_dialog_fragment fragment= Education_dialog_fragment.newInstance();
                fragment.show(getActivity().getFragmentManager(),"Dialog");


            }
        });


        return rootview;
    }


}




