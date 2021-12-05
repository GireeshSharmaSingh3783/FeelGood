package ca.aceapps.it.feelgood.ui.draw;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import ca.aceapps.it.feelgood.R;
import ca.aceapps.it.feelgood.databinding.FragmentDrawBinding;
import ca.aceapps.it.feelgood.ui.gallery.GalleryViewModel;


public class drawFragment extends Fragment {

    private ReviewScreen reviewScreen;
    private FragmentDrawBinding binding;
;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        reviewScreen =
                new ViewModelProvider(this).get(ReviewScreen.class);

        binding = FragmentDrawBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RelativeLayout relativeLayout = (RelativeLayout) root.findViewById(R.id.draw_display);
        relativeLayout.addView(new DrawCircle(getActivity()));




        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}