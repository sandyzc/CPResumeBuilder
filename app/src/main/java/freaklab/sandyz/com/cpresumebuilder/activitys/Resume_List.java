package freaklab.sandyz.com.cpresumebuilder.activitys;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import freaklab.sandyz.com.cpresumebuilder.R;
import freaklab.sandyz.com.cpresumebuilder.views.viewHolder.Resume_List_Recycler_Adapter;
import io.codetail.animation.ViewAnimationUtils;

public class Resume_List extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    Resume_List_Recycler_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        fab = findViewById(R.id.fab);

        adapter = new Resume_List_Recycler_Adapter(this);

        recyclerView = findViewById(R.id.resumes_list_recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resume_List.this, ResumeTypesActivity.class);
                startActivity(intent);
            }
        });
    }
}



