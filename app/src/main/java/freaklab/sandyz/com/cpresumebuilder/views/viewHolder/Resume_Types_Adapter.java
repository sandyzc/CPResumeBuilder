package freaklab.sandyz.com.cpresumebuilder.views.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import freaklab.sandyz.com.cpresumebuilder.activitys.InsertDataActivity;
import freaklab.sandyz.com.cpresumebuilder.R;
import freaklab.sandyz.com.cpresumebuilder.Utils;

/**
 * Created by Santosh sc on 07-04-2018.
 */

public class Resume_Types_Adapter extends RecyclerView.Adapter<Resume_Types_Adapter.Viewholder>implements View.OnClickListener {

    private static final int ANIMATED_ITEMS_COUNT = 2;

    private int lastAnimatedPosition = -1;
    private int itemsCount = 0;
    Context context;
    public Resume_Types_Adapter(Context context)     {
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.resume_types_card, parent, false);
        v.setOnClickListener(this);
        Viewholder viewholder = new Viewholder(v);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        runEnterAnimation(holder.itemView,position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent(context, InsertDataActivity.class);
        context.startActivity(intent);

    }


    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView sampleResume;


        public Viewholder(View itemView) {
            super(itemView);
            sampleResume = itemView.findViewById(R.id.resume_type_image);
            Picasso.get().load(R.mipmap.sample_resume).fit().into(sampleResume);

        }
    }

    private void runEnterAnimation(View view, int position) {
        if (position >= ANIMATED_ITEMS_COUNT - 1) {
            return;
        }

        if (position > lastAnimatedPosition) {
            lastAnimatedPosition = position;
            view.setTranslationY(Utils.getScreenHeight(context));
            view.animate()
                    .translationY(0)
                    .setInterpolator(new DecelerateInterpolator(2.f))
                    .setDuration(1000)
                    .start();
        }


    }
}
