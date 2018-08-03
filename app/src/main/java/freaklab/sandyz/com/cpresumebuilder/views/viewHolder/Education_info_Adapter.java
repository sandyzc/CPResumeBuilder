package freaklab.sandyz.com.cpresumebuilder.views.viewHolder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import freaklab.sandyz.com.cpresumebuilder.R;
import freaklab.sandyz.com.cpresumebuilder.beans.Education_Beans;

public class Education_info_Adapter extends RecyclerView.Adapter<Education_info_Adapter.Education_info_ViewHolder>{

    Context context;
    ArrayList<Education_Beans> data;

    public Education_info_Adapter(Context context, ArrayList data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public Education_info_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.education_fragment_card,parent,false);

        Education_info_ViewHolder viewHolder= new Education_info_ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Education_info_ViewHolder holder, int position) {

       final Education_Beans beans = data.get(position);

        holder.major.setText(beans.getMajor());
        holder.college_name.setText(beans.getCollege_name());
        holder.edu_from.setText(beans.getEdu_from());
        holder.edu_to.setText(beans.getEdu_to());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //Bind the views to the viewholder

    public class Education_info_ViewHolder extends RecyclerView.ViewHolder{

        TextView major,college_name,edu_from,edu_to;

        public Education_info_ViewHolder(View itemView) {
            super(itemView);

            major=itemView.findViewById(R.id.edu_card_major);
            college_name=itemView.findViewById(R.id.edu_card_college);
            edu_from=itemView.findViewById(R.id.edu_card_year_from);
            edu_to=itemView.findViewById(R.id.edu_card_year_to);

        }
    }

    public void refresh_dat(ArrayList<Education_Beans> beans){
        this.data=beans;
        notifyDataSetChanged();

    }


}
