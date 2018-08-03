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
import freaklab.sandyz.com.cpresumebuilder.beans.Experince_Beans;
import freaklab.sandyz.com.cpresumebuilder.fragments.Experience_info_holderFragment;

public class Experience_info_adapter extends RecyclerView.Adapter<Experience_info_adapter.Experience_info_ViewHolder>{

    Context context;
    ArrayList<Experince_Beans> data;

    public Experience_info_adapter(Context context, ArrayList data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public Experience_info_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View v=inflater.inflate(R.layout.experience_fragment_card,parent,false);
        Experience_info_ViewHolder holder = new Experience_info_ViewHolder(v);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Experience_info_ViewHolder holder, int position) {

        final Experince_Beans beans= data.get(position);

        holder.comapany_name.setText(beans.getCompany_name());
        holder.exp_from.setText(beans.getStart_year());
        holder.exp_to.setText(beans.getLeft_year());
        holder.position.setText(beans.getDesignation());

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Experience_info_ViewHolder extends RecyclerView.ViewHolder{

        TextView comapany_name,position,exp_from,exp_to;

        public Experience_info_ViewHolder(View itemView) {
            super(itemView);

            comapany_name=itemView.findViewById(R.id.exp_card_company_name);
            position=itemView.findViewById(R.id.exp_card_position);
            exp_from = itemView.findViewById(R.id.exp_card_from);
            exp_to= itemView.findViewById(R.id.exp_card_to);


        }
    }
}
