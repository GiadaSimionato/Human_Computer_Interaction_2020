package com.example.cue;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PeersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PeersFragment extends Fragment implements MultiSpinner.MultiSpinnerListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button  buttonFilter;
    MultiSpinner classSpinner, divSpinner;
    // string variable to store selected values
    String selectedClass, selectedDiv;
    MultiSpinner classSpinner1, divSpinner1;
    // string variable to store selected values
    String selectedClass1, selectedDiv1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PeersFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PeersFragment newInstance() {
        PeersFragment fragment = new PeersFragment();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);*/
        fragment.setArguments(null);
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
        return inflater.inflate(R.layout.activity_searchpeer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonFilter = (Button) view.findViewById(R.id.buttonFilter);



        buttonFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openMainActivity();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), ListPeersFragment.newInstance());

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });



        final Context cont=this.getActivity();
        final List<String> Lines = Arrays.asList(getResources().getStringArray(R.array.items_class));
        final List<String> def=Arrays.asList(getResources().getStringArray(R.array.def));


        classSpinner = (MultiSpinner) view.findViewById(R.id.state1);

        classSpinner.setItems(Lines,"",this);
        MultiSpinner.MultiSpinnerListener lis=this;
        divSpinner = (MultiSpinner) view.findViewById(R.id.divSpinner_);
        divSpinner.setItems(def,"--",lis );


        // Class Spinner implementing onItemSelectedListener
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {


                String selectedClass = parent.getItemAtPosition(position).toString();
                if(selectedClass.equals("England, Italy")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_1)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_3)) ;
                    //li.addAll(lii);
                    List<String> fin= Stream.of(li,lii)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    divSpinner.setItems(fin,"-", lis);



                }

                if(selectedClass.equals("England, Germany")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_1)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_2)) ;
                    //li.addAll(lii);
                    List<String> fin=Stream.of(li,lii)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    divSpinner.setItems(fin,"--", lis);
                }
                if(selectedClass.equals("England, Usa")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_1)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_4)) ;
                    //li.addAll(lii);
                    List<String> fin=Stream.of(li,lii)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    divSpinner.setItems(fin,"--", lis);
                }
                if(selectedClass.equals("Germany, Italy")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_2)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_3)) ;
                    //li.addAll(lii);
                    List<String> fin=Stream.of(li,lii)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    divSpinner.setItems(fin,"--", lis);
                }
                if(selectedClass.equals("Germany, Usa")){
                    String[] li= getResources().getStringArray(R.array.items_div_class3_2) ;
                    String[] li1= getResources().getStringArray(R.array.items_div_class3_4);
                    String[] fin= Stream.concat(Arrays.stream(li), Arrays.stream(li1))
                            .toArray(String[]::new);;
                    divSpinner.setAdapter(new ArrayAdapter<String>(cont,
                            android.R.layout.simple_spinner_dropdown_item,
                            fin));
                }
                if(selectedClass.equals("Italy, Usa")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_3)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_4)) ;
                    //li.addAll(lii);
                    List<String> fin=Stream.of(li,lii)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    divSpinner.setItems(fin,"--", lis);
                }

                if(selectedClass.equals("England, Germany, Italy")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_1)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_2)) ;
                    //li.addAll(lii);
                    List<String> li1= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_3)) ;

                    List<String> fin=Stream.of(li,lii,li1)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());

                    divSpinner.setItems(fin,"--", lis);
                }

                if(selectedClass.equals("England, Germany, Usa")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_1)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_2)) ;
                    //li.addAll(lii);
                    List<String> li1= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_4)) ;

                    List<String> fin=Stream.of(li,lii,li1)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());

                    divSpinner.setItems(fin,"--", lis);
                }
                if(selectedClass.equals("England, Italy, Usa")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_1)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_3)) ;
                    //li.addAll(lii);
                    List<String> li1= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_4)) ;

                    List<String> fin=Stream.of(li,lii,li1)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());

                    divSpinner.setItems(fin,"--", lis);
                }
                if(selectedClass.equals("Germany, Italy, Usa")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_2)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_3)) ;
                    //li.addAll(lii);
                    List<String> li1= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_4)) ;

                    List<String> fin=Stream.of(li,lii,li1)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());

                    divSpinner.setItems(fin,"--", lis);
                }
                if(selectedClass.equals("England, Germany, Italy, Usa")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_1)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_2)) ;
                    //li.addAll(lii);
                    List<String> li1= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_3)) ;
                    List<String> li2= Arrays.asList(getResources().getStringArray(R.array.items_div_class3_4)) ;

                    List<String> fin=Stream.of(li,lii,li1,li2)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());

                    divSpinner.setItems(fin,"--", lis);
                }





                switch (selectedClass)
                {
                    case "England":
                        // assigning div item list defined in XML to the div Spinner
                        List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class_1)) ;
                        divSpinner.setItems(li,"--", lis);
                        break;

                    case "Germany":
                        List<String> li1= Arrays.asList(getResources().getStringArray(R.array.items_div_class_2)) ;
                        divSpinner.setItems(li1,"--", lis);
                        break;

                    case "Italy":
                        List<String> li2= Arrays.asList(getResources().getStringArray(R.array.items_div_class_3)) ;
                        divSpinner.setItems(li2,"--", lis);
                        break;

                    case "Usa":
                        List<String> li3= Arrays.asList(getResources().getStringArray(R.array.items_div_class_4)) ;
                        divSpinner.setItems(li3,"--", lis);
                        break;

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


        final List<String> Linea = Arrays.asList(getResources().getStringArray(R.array.items_class1));



        classSpinner1 = (MultiSpinner) view.findViewById(R.id.department);

        classSpinner1.setItems(Linea,"",this);
        divSpinner1 = (MultiSpinner) view.findViewById(R.id.faculties);
        divSpinner1.setItems(def,"--",lis );

        // Class Spinner implementing onItemSelectedListener
        classSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)


            {
                String selectedClass = parent.getItemAtPosition(position).toString();

                if(selectedClass.equals("Engineering, Litterature")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_1)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_2)) ;
                    //li.addAll(lii);
                    List<String> fin=Stream.of(li,lii)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    divSpinner1.setItems(fin,"--", lis);
                }
                if(selectedClass.equals("Engineering, History")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_1)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_3)) ;
                    //li.addAll(lii);
                    List<String> fin=Stream.of(li,lii)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    divSpinner1.setItems(fin,"--", lis);
                }

                if(selectedClass.equals("Engineering, Maths,Physics")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_1)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_4)) ;
                    //li.addAll(lii);
                    List<String> fin=Stream.of(li,lii)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    divSpinner1.setItems(fin,"--", lis);
                }
                if(selectedClass.equals("Litterature, History")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_2)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_3)) ;
                    //li.addAll(lii);
                    List<String> fin=Stream.of(li,lii)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    divSpinner1.setItems(fin,"--", lis);
                }
                if(selectedClass.equals("Litterature , Maths,Physics")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_2)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_4)) ;
                    //li.addAll(lii);
                    List<String> fin=Stream.of(li,lii)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    divSpinner1.setItems(fin,"--", lis);
                }
                if(selectedClass.equals("History, Maths,Physics")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_3)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_4)) ;
                    //li.addAll(lii);
                    List<String> fin=Stream.of(li,lii)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    divSpinner1.setItems(fin,"--", lis);
                }
                if(selectedClass.equals("Engineering, Litterature, History")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_1)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_2)) ;
                    List<String> li1= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_3)) ;
                    //li.addAll(lii);
                    List<String> fin=Stream.of(li,lii,li1)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    divSpinner1.setItems(fin,"--", lis);
                }
                if(selectedClass.equals("Engineering, Litterature, Maths,Physics")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_1)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_2)) ;
                    List<String> li1= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_4)) ;
                    //li.addAll(lii);
                    List<String> fin=Stream.of(li,lii,li1)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    divSpinner1.setItems(fin,"--", lis);
                }

                if(selectedClass.equals("Engineering, Litterature, History, Maths,Physics")){
                    List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_1)) ;
                    List<String> lii= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_2)) ;
                    List<String> li1= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_3)) ;
                    List<String> li2= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_4)) ;
                    //li.addAll(lii);
                    List<String> fin=Stream.of(li,lii,li1,li2)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    divSpinner1.setItems(fin,"--", lis);
                }




                switch (selectedClass)
                {
                    case "Engineering":
                        // assigning div item list defined in XML to the div Spinner
                        List<String> li= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_1)) ;
                        divSpinner1.setItems(li,"--", lis);

                        break;

                    case "Litterature":
                        List<String> li1= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_2)) ;
                        divSpinner1.setItems(li1,"--", lis);
                        break;

                    case "History":
                        List<String> li2= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_3)) ;
                        divSpinner1.setItems(li2,"--", lis);
                        break;

                    case "Maths,Physics":
                        List<String> li3= Arrays.asList(getResources().getStringArray(R.array.items_div_class1_4)) ;
                        divSpinner1.setItems(li3,"--", lis);
                        break;

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

    public void openMainActivity() {
        Intent intent = new Intent(this.getActivity(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemsSelected(boolean[] selected) {

    }


    @Override
    //Pressed return button - returns to the results menu
    public void onResume() {
        super.onResume();
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){

                    //your code
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(((ViewGroup) getView().getParent()).getId(), MainPageFragment.newInstance());

                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                return false;
            }
        });
    }
}
