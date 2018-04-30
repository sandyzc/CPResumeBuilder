package freaklab.sandyz.com.cpresumebuilder.views.viewHolder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

import freaklab.sandyz.com.cpresumebuilder.R;
import freaklab.sandyz.com.cpresumebuilder.Utils;

/**
 * Created by Santosh sc on 26-03-2018.
 */

public class Resume_List_Recycler_Adapter extends RecyclerView.Adapter<Resume_List_ViewHolder> {

    private Context context;


    public Resume_List_Recycler_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Resume_List_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Resume_List_ViewHolder viewHolder = null;


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View v = inflater.inflate(R.layout.resume_list_card, parent, false);
        viewHolder = new Resume_List_ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Resume_List_ViewHolder holder, int position) {
        runEnterAnimation(holder.itemView, position);

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    private void runEnterAnimation(View view, int position) {

        view.setTranslationY(Utils.getScreenHeight(context));
        view.animate()
                .translationY(0)
                .setInterpolator(new DecelerateInterpolator(3.f))
                .setDuration(1000)
                .start();


    }

}
