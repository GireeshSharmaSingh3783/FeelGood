//Gireesh Sharma-Singh N01193783
//Zhiyuan Hua N01406966
//Eghe Iyobosa N01107171
//Supriya N01394695
package ca.aceapps.it.feelgood.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

import ca.aceapps.it.feelgood.JournalRecord;
import ca.aceapps.it.feelgood.LoginActivity;
import ca.aceapps.it.feelgood.MainActivity;
import ca.aceapps.it.feelgood.MentalDistortions;
import ca.aceapps.it.feelgood.R;

import ca.aceapps.it.feelgood.databinding.FragmentGalleryBinding;
import ca.aceapps.it.feelgood.ui.slideshow.SlideshowFragment;
import ca.aceapps.it.feelgood.ui.slideshow.SlideshowViewModel;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;
    private Button happy, sad;
    EditText say;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        ////sad button functionality

        happy=root.findViewById(R.id.happyButton);
        sad=root.findViewById(R.id.sadButton);

        say=root.findViewById(R.id.editText);



        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"I'm happy", Toast.LENGTH_SHORT).show();
               // go to Record Journal Activity
                Intent inte = new Intent(getActivity(), JournalRecord.class);
                startActivity(inte);



            }
        });
        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"I'm sad", Toast.LENGTH_SHORT).show();
                // go to Record Journal Activity
                Intent inten = new Intent(getActivity(), JournalRecord.class);
                startActivity(inten);

            }
        });






        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}