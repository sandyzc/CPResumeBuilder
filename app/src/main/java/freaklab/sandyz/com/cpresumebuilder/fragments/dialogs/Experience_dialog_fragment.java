package freaklab.sandyz.com.cpresumebuilder.fragments.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import freaklab.sandyz.com.cpresumebuilder.Database.Expereince_Database;
import freaklab.sandyz.com.cpresumebuilder.R;

public class Experience_dialog_fragment extends DialogFragment {

    MaterialEditText et_company_name,et_designation,et_startWork_from,et_endWork_to;
    Button save;
    Expereince_Database myDatabase;
    final static int MIN_COMPANY_NAME=2;
    final static int MIN_DESIGNATION_NAME=2;
    final static int MIN_COMPANY_FROM=4;
    final static int MIN_COMPANY_TO=4;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getDialog().getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;
    }

    public static Experience_dialog_fragment newInstance(){

        return new Experience_dialog_fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View myView= inflater.inflate(R.layout.exp_dialog,container,false);
        et_company_name=myView.findViewById(R.id.exp_dialog_company_name);
        et_designation=myView.findViewById(R.id.exp_dialog_design);
        et_startWork_from= myView.findViewById(R.id.exp_dialog_from);
        et_endWork_to=myView.findViewById(R.id.exp_dialog_to);
        save=myView.findViewById(R.id.exp_dialog_button);

        et_company_name.setMinCharacters(MIN_COMPANY_FROM);
        et_designation.setMinCharacters(MIN_DESIGNATION_NAME);
        et_startWork_from.setMinCharacters(MIN_COMPANY_NAME);
        et_endWork_to.setMinCharacters(MIN_COMPANY_TO);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String company_name=et_company_name.getText().toString();
                String designation=et_designation.getText().toString();
                String work_start=et_startWork_from.getText().toString();
                String work_end=et_endWork_to.getText().toString();

                if (company_name.length()>=MIN_COMPANY_NAME
                        && designation.length()>=MIN_DESIGNATION_NAME
                        && work_start.length()>=MIN_COMPANY_FROM
                        && work_end.length()>=MIN_COMPANY_TO
                        ) {

                    myDatabase = new Expereince_Database(getActivity().getApplicationContext());
                    myDatabase.open_exp_db();
                    myDatabase.insert_expereince_data(company_name, designation, work_start, work_end);

                    Snackbar.make(getActivity().findViewById(android.R.id.content), "Saved Sucessfully", Snackbar.LENGTH_SHORT).show();

                    dismiss();
                }

                else {
                   
                    Snackbar.make(getActivity().findViewById(android.R.id.content),"Please check the input data..!",Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        return myView;

    }
}
