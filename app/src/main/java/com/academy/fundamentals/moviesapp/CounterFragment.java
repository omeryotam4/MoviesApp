package com.academy.fundamentals.moviesapp;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


public class CounterFragment extends Fragment implements View.OnClickListener {

    public final static String FRAGMENT_TYPE = "fragment_type";
    private IAsyncTaskEvents callbackListener;
    private Button btnCreate,btnStart,btnCancel;
    private TextView txtValue;
//  private OnFragmentInteractionListener mListener;

    public CounterFragment()
    {
        // Required empty public constructor
    }


//    public static CounterFragment newInstance(String param1, String param2) {
//        CounterFragment fragment = new CounterFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment:
        View v=inflater.inflate(R.layout.fragment_counter, container, false);
        btnCreate=v.findViewById(R.id.create_button);
        btnStart=v.findViewById(R.id.start_button);
        btnCancel=v.findViewById(R.id.cancel_button);

        txtValue=v.findViewById(R.id.textView);

        btnCreate.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        Bundle bundle = this.getArguments();
        if (bundle != null)
        {
            String fragmentText = this.getArguments().getString(FRAGMENT_TYPE).toString();
            txtValue.setText(fragmentText);
        }

        return v;
    }

//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onClick(View v)
    {
        if(!isAdded() || callbackListener == null)
        {
            return;
        }

        switch(v.getId())
        {
            case R.id.create_button:
                callbackListener.createAsyncTask();
                break;
            case R.id.start_button:
                callbackListener.startAsyncTask();
                break;
            case R.id.cancel_button:
                callbackListener.cancelAsyncTask();
                break;
        }

    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        Activity a=getActivity();
        if (a != null && a instanceof IAsyncTaskEvents)
        {
            callbackListener = (IAsyncTaskEvents) a;
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        callbackListener = null;
    }


//    public interface OnFragmentInteractionListener {
//        void onFragmentInteraction(Uri uri);
//    }

    public void updateFragmentText(String txt)
    {
        if(txtValue != null)
        {
            txtValue.setText(txt);
        }
    }
}
