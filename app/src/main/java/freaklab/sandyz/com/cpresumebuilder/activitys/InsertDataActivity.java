package freaklab.sandyz.com.cpresumebuilder.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import freaklab.sandyz.com.cpresumebuilder.R;
import freaklab.sandyz.com.cpresumebuilder.fragments.Basic_Info_holderFragment;
import freaklab.sandyz.com.cpresumebuilder.fragments.Education_Info_holderFragment;
import freaklab.sandyz.com.cpresumebuilder.fragments.Experience_info_holderFragment;
import freaklab.sandyz.com.cpresumebuilder.fragments.Skill_set;

public class InsertDataActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        ViewPager mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }
//Adapter for viewpager


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:
                    return Basic_Info_holderFragment.newInstance(0);
                case 2:
                    return Education_Info_holderFragment.newInstance(1);
                case 3:
                    return Experience_info_holderFragment.newInstance(2);
                case 1:
                    return Skill_set.newInstance(3);
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }
    }

}
