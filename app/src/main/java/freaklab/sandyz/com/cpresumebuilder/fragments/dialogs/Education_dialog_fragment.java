package freaklab.sandyz.com.cpresumebuilder.fragments.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;

import freaklab.sandyz.com.cpresumebuilder.Database.Education_Databse;
import freaklab.sandyz.com.cpresumebuilder.R;

public class Education_dialog_fragment extends DialogFragment {

    Education_Databse databse;
    String college_name,majore,edu_from,edu_to;
    MaterialEditText et_college_name,et_major,et_edu_from,et_edu_to;
    Button click;

    final static int MIN_COLLEGEE_NAME=2;
    final static int MIN_MAJOR_NAME=2;
    final static int MIN_COLLEGEE_FROM=4;
    final static int MIN_COLLEGEE_TO=4;

    public static Education_dialog_fragment newInstance() {

        return new Education_dialog_fragment();

    }

    //animate the dialog
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getDialog().getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.edu_dialog,container,false);

         et_college_name = view.findViewById(R.id.edu_dialog_college_name);
         et_major = view.findViewById(R.id.edu_dialog_major);
         et_edu_from = view.findViewById(R.id.edu_dialog_from);
         et_edu_to = view.findViewById(R.id.edu_dialog_to);
         click=view.findViewById(R.id.edu_dialog_button);

         et_college_name.setMinCharacters(MIN_COLLEGEE_FROM);
         et_major.setMinCharacters(MIN_MAJOR_NAME);
         et_edu_from.setMinCharacters(MIN_COLLEGEE_FROM);
         et_edu_to.setMinCharacters(MIN_COLLEGEE_TO);

            click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (et_college_name.getText().toString().length() >= MIN_COLLEGEE_NAME
                            && et_major.getText().toString().length() >= MIN_MAJOR_NAME
                            && et_edu_from.getText().toString().length() >= MIN_COLLEGEE_FROM
                            && et_edu_to.getText().toString().length() >= MIN_COLLEGEE_TO
                            ) {

                        college_name = et_college_name.getText().toString();
                        majore = et_major.getText().toString();
                        edu_from = et_edu_from.getText().toString();
                        edu_to = et_edu_to.getText().toString();

                        databse = new Education_Databse(getActivity().getApplicationContext());
                        databse.open();
                        databse.insert_edu_details(college_name, majore, edu_from, edu_to);
                        Snackbar.make(getActivity().findViewById(android.R.id.content), "Sucessfully Saved..!", Snackbar.LENGTH_SHORT).show();

                        dismiss();
                    }

                    else{
                        Snackbar.make(getActivity().findViewById(android.R.id.content), "Check the input..!", Snackbar.LENGTH_SHORT).show();
                    }
                }
            });



        return view;
    }
}
