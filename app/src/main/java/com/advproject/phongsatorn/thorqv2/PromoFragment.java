package com.advproject.phongsatorn.thorqv2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class PromoFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private List<PromoModel> list;
    private Context context;

    private RecyclerView recyclerView;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private List<PromoModel> result;
    private PromoAdapter adapter;

    public static PromoFragment newInstance(String param1, String param2) {
        PromoFragment fragment = new PromoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.promoactivity_list, container, false);
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("promotion");

        result = new ArrayList<>();
        updateList();
        recyclerView = view.findViewById(R.id.promotion_once);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager lim = new LinearLayoutManager(getContext());
        lim.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(lim);

        adapter = new PromoAdapter(getContext(), result);
        recyclerView.setAdapter(adapter);
    }

    private int getItemIndex(PromoModel order){
        int index = -1;

        for (int i=0 ; i<result.size() ; i++){
            if(result.get(i).key.equals(order.key)){
                index = 1;
                break;
            }
        }
        return index;
    }

    public void updateList(){
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                result.add(dataSnapshot.getValue(PromoModel.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                PromoModel model = dataSnapshot.getValue(PromoModel.class);

                int index = getItemIndex(model);
                result.set(index, model);
                adapter.notifyItemChanged(index);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                PromoModel model = dataSnapshot.getValue(PromoModel.class);

                int index = getItemIndex(model);
                result.set(index, model);
                adapter.notifyItemRemoved(index);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            Toast.makeText(context, "Stored Fragment Attached", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
