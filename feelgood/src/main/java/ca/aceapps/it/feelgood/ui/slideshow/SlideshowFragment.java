//Gireesh Sharma-Singh N01193783
//Zhiyuan Hua N01406966
// Brett Kean N01158642
//Eghe Iyobosa N01107171
package ca.aceapps.it.feelgood.ui.slideshow;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ca.aceapps.it.feelgood.MainActivity;
import ca.aceapps.it.feelgood.R;
import ca.aceapps.it.feelgood.databinding.FragmentSlideshowBinding;

import static androidx.core.content.ContextCompat.getSystemService;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;
    private ImageButton button1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        button1=root.findViewById(R.id.Notification);

         if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
             NotificationChannel channel =new NotificationChannel("My notification","My notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = ( NotificationManager ) getActivity().getSystemService(NotificationManager.class);
             manager.createNotificationChannel(channel);
          }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(),"My notification")
                        .setSmallIcon(R.drawable.ic_baseline_add_alert_24)
                        .setContentTitle("Notification1")
                        .setContentText("have a good day!")
                        .setAutoCancel(true);


                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getActivity());
                notificationManager.notify(1,builder.build());

            }
        });





        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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