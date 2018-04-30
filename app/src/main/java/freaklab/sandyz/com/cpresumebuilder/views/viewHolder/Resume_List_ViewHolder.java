package freaklab.sandyz.com.cpresumebuilder.views.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import freaklab.sandyz.com.cpresumebuilder.R;

/**
 * Created by santosh on 14-03-2018.
 */

public class Resume_List_ViewHolder extends RecyclerView.ViewHolder {

    private TextView name,experience,breif_description,designation;
    ImageView display_picture , line1,line2;


    public Resume_List_ViewHolder(View itemView) {
        super(itemView);

        name= itemView.findViewById(R.id.resumes_list_name);
        experience=itemView.findViewById(R.id.resumes_list_experience);
        breif_description= itemView.findViewById(R.id.resumes_list_breif_description);
        designation = itemView.findViewById(R.id.resumes_list_designaion);
        display_picture=itemView.findViewById(R.id.resumes_list_photo);
        line1=itemView.findViewById(R.id.just_a_line);
        line2=itemView.findViewById(R.id.just_a_line_below_xp);



    }
}
