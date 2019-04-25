package freaklab.sandyz.com.cpresumebuilder.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramotion.cardslider.CardSliderLayoutManager;

import java.util.ArrayList;

import freaklab.sandyz.com.cpresumebuilder.Database.Expereince_Database;
import freaklab.sandyz.com.cpresumebuilder.R;
import freaklab.sandyz.com.cpresumebuilder.activitys.Final_Preview;
import freaklab.sandyz.com.cpresumebuilder.beans.Experince_Beans;
import freaklab.sandyz.com.cpresumebuilder.fragments.dialogs.Experience_dialog_fragment;
import freaklab.sandyz.com.cpresumebuilder.views.viewHolder.Experience_info_adapter;

public class Experience_info_holderFragment extends Fragment {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    Experience_info_adapter adapter;
    ArrayList<Experince_Beans>mydata;
    Expereince_Database database;

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

        View myView=inflater.inflate(R.layout.experience_details_fragment,container,false);
        fab= myView.findViewById(R.id.fab_experience);
        recyclerView=myView.findViewById(R.id.experience_recycle);


        database= new Expereince_Database(getActivity().getApplicationContext());
        mydata=database.get_all_experiece();


        adapter= new Experience_info_adapter(getActivity().getApplicationContext(),mydata);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getContext(), Final_Preview.class);
                startActivity(intent);

//                Experience_dialog_fragment experience_dialog_fragment = Experience_dialog_fragment.newInstance();
//                experience_dialog_fragment.show(getActivity().getFragmentManager(),"Expereince_dialog");

            }
        });



        return myView;

    }
}
