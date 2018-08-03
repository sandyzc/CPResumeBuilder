package freaklab.sandyz.com.cpresumebuilder.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.squareup.picasso.Picasso;

import java.io.FileNotFoundException;
import java.io.InputStream;

import freaklab.sandyz.com.cpresumebuilder.R;

import static android.app.Activity.RESULT_OK;

public class Basic_Info_holderFragment extends Fragment {

    ImageView photo_button;
    FloatingActionButton fab;

    private static final int GALLERY_REQUEST = 100;

    MaterialEditText
            name,
            title,
            profile_summery,
            phone_number,
            email_id,
            address_lin1,
            address_line2,
            address_street,
            address_pincode,
            professional_objective;

    int     name_length=2,
            title_length=2,
            profile_summery_length=5,
            phone_number_length =10,
            email_id_length=10,
            address_line1_length=2,
            address_line2_length=2,
            address_street_length=2,
            adress_pincode_length=6,
            proffesional_objective_length=10;


    private static final String ARG_SECTION_NUMBER = "section_number";

    public Basic_Info_holderFragment() {
    }

    public static Basic_Info_holderFragment newInstance(int sectionNumber) {
        Basic_Info_holderFragment fragment = new Basic_Info_holderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    // get the photo inside
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case GALLERY_REQUEST:
                if (resultCode == RESULT_OK) {

                    Uri selectedImage = data.getData();
                    InputStream imageStream = null;

                    Picasso.get().load(selectedImage).fit().centerInside().into(photo_button);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "you havent selected the image", Toast.LENGTH_LONG).show();
                }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.basic_info_fragment, container, false);
        loadViews(rootView);

        photo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent get_pic = new Intent(Intent.ACTION_PICK);
                get_pic.setType("image/jpeg");
                startActivityForResult(get_pic, GALLERY_REQUEST);
            }
        });

        return rootView;
    }

    private void loadViews(View rootView){


        photo_button = rootView.findViewById(R.id.data_photo);



        name = rootView.findViewById(R.id.data_person_Name);
        title = rootView.findViewById(R.id.data_title);
        profile_summery = rootView.findViewById(R.id.data_summery);
        phone_number = rootView.findViewById(R.id.data_phone_number);
        email_id = rootView.findViewById(R.id.data_email_id);
        address_lin1 = rootView.findViewById(R.id.data_address_line1);
        address_line2 = rootView.findViewById(R.id.data_address_line2);
        address_pincode = rootView.findViewById(R.id.data_address_pincode);
        address_street = rootView.findViewById(R.id.data_address_street);
        professional_objective = rootView.findViewById(R.id.data_objective);

        fab=rootView.findViewById(R.id.fab_basic_info);


    }

    private void validate(){


    }


}






