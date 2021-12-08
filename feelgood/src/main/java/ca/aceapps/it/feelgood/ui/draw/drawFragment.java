//Gireesh Sharma-Singh N01193783
//Zhiyuan Hua N01406966
//Eghe Iyobosa N01107171
//Supriya N01394695
////////////////////////////////////////
package ca.aceapps.it.feelgood.ui.draw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;;

import android.widget.RelativeLayout;

import ca.aceapps.it.feelgood.R;
import ca.aceapps.it.feelgood.databinding.FragmentDrawBinding;


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