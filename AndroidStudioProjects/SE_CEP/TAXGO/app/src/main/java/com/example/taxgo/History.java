package com.example.taxgo;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link History#newInstance} factory method to
 * create an instance of this fragment.
 */
public class History extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ShimmerFrameLayout shimmerFrameLayout;

    NavigationView navigation;

    RecyclerView recyclerView;

    ArrayList<History_DataModal> Data_holder;

    String server_url = "http://192.168.2.4/project/fetch_transaction_history.php";

    public History() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewHistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static History newInstance(String param1, String param2) {
        History fragment = new History();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();

        if(getActivity()!=null) {
            ((MainActivity) getActivity()).setActionBarTitle("History");
        }

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keycode, KeyEvent keyEvent) {

                if (keyEvent.getAction() == KeyEvent.ACTION_UP && keycode == KeyEvent.KEYCODE_BACK){
                    Menu drawer_menu = navigation.getMenu();
                    MenuItem menuItem = drawer_menu.findItem(R.id.History);
                    menuItem.setChecked(false);
                    getActivity().onBackPressed();
                    return true;
                }

                return false;
            }
        });

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View  view =  inflater.inflate(R.layout.fragment_history, container, false);

       shimmerFrameLayout = view.findViewById(R.id.history_shimmer);
       shimmerFrameLayout.startShimmer();

       navigation = (NavigationView)getActivity().findViewById(R.id.nav_view);

       Menu drawer_menu = navigation.getMenu();

       MenuItem menuItem;

       menuItem = drawer_menu.findItem(R.id.home);

       MenuItem menuItem1 = drawer_menu.findItem(R.id.home);
       MenuItem menuItem2 = drawer_menu.findItem(R.id.transaction);
       MenuItem menuItem3 = drawer_menu.findItem(R.id.History);
       MenuItem menuItem4 = drawer_menu.findItem(R.id.about_us);
       MenuItem menuItem5 = drawer_menu.findItem(R.id.view_profile);
       MenuItem menuItem6 = drawer_menu.findItem(R.id.faq);

       menuItem.setChecked(false);
       menuItem1.setChecked(false);
       menuItem2.setChecked(false);
       menuItem3.setChecked(false);
       menuItem4.setChecked(false);
       menuItem5.setChecked(false);
       menuItem6.setChecked(false);

       if(!menuItem3.isChecked()){
           menuItem3.setChecked(true);

       }

       recyclerView = view.findViewById(R.id.His_rv);
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


       Data_holder = new ArrayList<>();


       StringRequest stringRequest = new StringRequest(Request.Method.GET, server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            shimmerFrameLayout.stopShimmer();
                            shimmerFrameLayout.setVisibility(view.GONE);
                            recyclerView.setVisibility(view.VISIBLE);
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);

                                //adding the product to product list
                                Data_holder.add(new History_DataModal(
                                        product.getString("date"),
                                        product.getString("time"),
                                        product.getString("method"),
                                        product.getString("amount")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            History_Adapter adapter = new History_Adapter((getContext()), Data_holder);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our string_request to queue
        My_Singleton.getInstance(getContext()).addToRequestQue(stringRequest);

        return  view;
    }

}