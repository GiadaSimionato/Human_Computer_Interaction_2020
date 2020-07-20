package com.example.cue;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditUni extends Fragment {

    private ArrayAdapter<String> listviewAdapter;
    private ArrayAdapter<String> spinnerAdapter;
    private Button bt = null;
    private ImageButton bt1 = null;
    Spinner classSpinner, divSpinner;
    // string variable to store selected values
    String selectedClass, selectedDiv;
    Spinner classSpinner1, divSpinner1;
    // string variable to store selected values
    String selectedClass1, selectedDiv1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditUni() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static EditUni newInstance() {
        EditUni fragment = new EditUni();
        Bundle args = new Bundle();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.editprofile, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        classSpinner = (Spinner) view.findViewById(R.id.state1);
        divSpinner = (Spinner) view.findViewById(R.id.divSpinner_);
        final Context cont= getActivity();


        // Class Spinner implementing onItemSelectedListener
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedClass = parent.getItemAtPosition(position).toString();
                switch (selectedClass)
                {
                    case "England":
                        // assigning div item list defined in XML to the div Spinner
                        divSpinner.setAdapter(new ArrayAdapter<String>(cont,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class3_1)));
                        break;

                    case "Germany":
                        divSpinner.setAdapter(new ArrayAdapter<String>(cont,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class3_2)));
                        break;

                    case "Italy":
                        divSpinner.setAdapter(new ArrayAdapter<String>(cont,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class3_3)));
                        break;

                    case "Usa":
                        divSpinner.setAdapter(new ArrayAdapter<String>(cont,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class3_4)));
                        break;

                    /*case "--":
                        divSpinner.setAdapter(new ArrayAdapter<String>(search.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_5)));
                        break;*/

                }

                //set divSpinner Visibility to Visible
                divSpinner.setVisibility(View.VISIBLE);
            }





            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });




        classSpinner1 = (Spinner) view.findViewById(R.id.department);
        divSpinner1 = (Spinner) view.findViewById(R.id.faculties);

        // Class Spinner implementing onItemSelectedListener
        classSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedClass = parent.getItemAtPosition(position).toString();
                switch (selectedClass)
                {
                    case "Engineering":
                        // assigning div item list defined in XML to the div Spinner
                        divSpinner1.setAdapter(new ArrayAdapter<String>(cont,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class1_1)));
                        break;

                    case "Litterature":
                        divSpinner1.setAdapter(new ArrayAdapter<String>(cont,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class1_2)));
                        break;

                    case "History":
                        divSpinner1.setAdapter(new ArrayAdapter<String>(cont,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class1_3)));
                        break;

                    case "Maths,Physics":
                        divSpinner1.setAdapter(new ArrayAdapter<String>(cont,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class1_4)));
                        break;
                                                          /*  case "--":
                                                                divSpinner1.setAdapter(new ArrayAdapter<String>(search.this,
                                                                        android.R.layout.simple_spinner_dropdown_item,
                                                                        getResources().getStringArray(R.array.items_div_class_5)));
                                                                break;*/
                }

                //set divSpinner Visibility to Visible
                divSpinner1.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });





        // Div Spinner implementing onItemSelectedListener
        divSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                selectedDiv = parent.getItemAtPosition(position).toString();
                /*
                    Now that we have both values, lets create a Toast to
                    show the values on screen
                */
                /*Toast.makeText(search.this, "\n Class: \t " + selectedClass +
                        "\n Div: \t" + selectedDiv, Toast.LENGTH_LONG).show();*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }

        });


        divSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                selectedDiv1 = parent.getItemAtPosition(position).toString();
                /*
                    Now that we have both values, lets create a Toast to
                    show the values on screen
                */
                /*Toast.makeText(search.this, "\n Class: \t " + selectedClass1 +
                        "\n Div: \t" + selectedDiv1, Toast.LENGTH_LONG).show();*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }

        });

    }
}