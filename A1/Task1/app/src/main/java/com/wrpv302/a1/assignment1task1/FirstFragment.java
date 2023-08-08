package com.wrpv302.a1.assignment1task1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.wrpv302.a1.assignment1task1.databinding.FragmentFirstBinding;

import org.w3c.dom.Text;

import java.util.Random;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private int i = 0;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btnrandom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            TextView TV = (TextView) view.getRootView().findViewById(R.id.txts);
                TV.setText("Your Random number is: " +new Random().ints(0,100).findFirst().getAsInt());
            }
        });

        binding.btncount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
              TextView TV=  (TextView) view.getRootView().findViewById(R.id.txtvm);
              i++;
              TV.setText(Integer.toString(i));
            }
            }
        );

        binding.btntoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_SHORT);
                myToast.show();
            }

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}