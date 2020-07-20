package com.example.cue;



import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchResFragment extends Fragment {

    RecyclerView recyclerViewC;
    TextView nresTextView;
    List<Course> courseList;
    Button edit;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchResFragment() {
        // Required empty public constructor
    }




    public static  SearchResFragment newInstance() {
        SearchResFragment myFragment = new SearchResFragment();
        return myFragment;
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
        return inflater.inflate(R.layout.course_activity, container, false);
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {


        recyclerViewC = view.findViewById(R.id.recyclerViewC);
        nresTextView = view.findViewById(R.id.nresTextView);
        edit=view.findViewById(R.id.button);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), SearchFragment.newInstance());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        initData();
        initRecyclerView();
        String message = courseList.size() + " results for Engineering in Computer Science course";
        nresTextView.setText(message);
    }

    public void editSearch(View view) {
        // Put HERE Intent to start new activity (Edit Search pressed)
    }

    private void initRecyclerView() {
        CourseAdapter courseAdapter = new CourseAdapter(courseList);
        recyclerViewC.setAdapter(courseAdapter);
    }

    private void initData() {
        courseList = new ArrayList<>();
        // [EDIT]
        courseList.add(new Course("Engineering in Computer Science", "La Sapienza University of Rome", "The Master of Science in Engineering in Computer Science lasts 2 years. The aim of the course is to train Computer Engineers with specific expertise both in the sector of Computer Science, focussing on software applications such as software design, data management and analysis and software application to A.I., and in the sectors of information processing systems and security, models and methodologies, tools for the assessment of systems performance, as well as the optimization of systems for information processing and network systems.", "Rome, Italy", true, true, true, true));
        courseList.add(new Course("Computer Science and Engineering", "Politecnico di Milano", "The study programme in Computer Science and Engineering is a two years programme that can be taken by students awarded with a (bachelor level) Laurea Degree in Engineering of Computing Systems or similar, provided an approval from an admission committee. The study programme can be folowed by a three years PhD programme. Each of the two years of the Master programme is partitioned into two semesters. In order to allow students to access the Master course at the start of each semester, the first and second semester of each year are interchangeable; the courses that are programmed for each semester can, in fact, be attended without any noticeable inconvenience, both in the natural sequence (1st semester, 2nd semester) and in the reverse order (2nd semester, 1st semester).", "Milan, Italy", true, true, false, false));
        courseList.add(new Course("Ingegneria Informatica", "University of Padua", "Il corso di Laurea Magistrale in Ingegneria Informatica forma un professionista, ingegnere di secondo livello, beneficiando delle attività di ricerca di punta espresse dal Dipartimento di Ingegneria dell’Informazione dell’Università di Padova. La figura professionale del laureato magistrale è di alto profilo e in grado di utilizzare un ampio spettro di conoscenze per interpretare, descrivere e risolvere in modo innovativo problemi dell’ingegneria informatica, che richiedono un elevato grado di approfondimento unitamente ad un approccio interdisciplinare.", "Padua, Italy", true, true, false, true));
        courseList.add(new Course("Computer Science and Networking", "University of Pisa", "The 2-year Master Programme in Computer Science and Networking at University of Pisa has been designed to meet the growing demand for an emerging kind of professionals with high-level expertise in both computer and information science and technologies, and communication networking science and technologies.", "Pisa, Italy", true, true, false, false));
        courseList.add(new Course("Ingegneria Informatica", "University Federico II of Naples", "Obiettivo del Corso di Laurea magistrale in Ingegneria Informatica è quello di formare un professionista in grado di inserirsi in realtà produttive molto differenziate e in rapida evoluzione con ruoli di promozione e gestione dell'innovazione tecnologica, di progetto e di gestione di sistemi complessi, di coordinamento di gruppi di lavoro e di responsabilità in ambito tecnico e produttivo ai massimi livelli. Oltre agli ambiti specifici dell'Ingegneria Informatica, le sue competenze copriranno anche altri ambiti dell'Ingegneria con particolare riferimento all'intero settore delle Tecnologie dell'Informazione e della Comunicazione.", "Naples, Italy", true, true, true, true));
        courseList.add(new Course("Computer Engineering", "Telematic University Uninettuno", "The second-cycle degree course in Computer Engineering at the International Telematic University UNINETTUNO is basically aimed at training engineers able to work in the fields of design, engineering, development, operation and management of computer applications and plants, of information processing systems and complex information systems.", "Online", true, true, false, false));
        courseList.add(new Course("Computer Science", "University of Camerino", "Computer Science programme at the University of Camerino has applications in several fields, that are very different from each other and in constant increasing number.", "Camerino, Italy", true, true, true, false));
        courseList.add(new Course("Computational Data Science", "Free University of Bozen-Bolzano", "The Master in Computational Data Science at the Free University of Bozen-Bolzano will provide you with the key competencies that you will need to develop next-generation information systems used to describe and manage data, discover new facts and relations in the data, make predictions, and give advice to decision makers.", "Bozen, Italy", true, true, true, false));
        courseList.add(new Course("ICT Internet Engineering", "Tor Vergata University of Rome", "Internet has changed our way of working and confronting, realizing the biggest revolution in our age. The newly reinforced Degree ICT and Internet Engineering programme at Tor Vergata University of Rome and the introduction of the English language are the answer to the world that is changing.", "Rome, Italy", true, true, false, true));
        courseList.add(new Course("Computer Science", "University of Genova", "The Computer Science from University of Genova is organized in two curricula: Data Science & Engineering, centered on the management, and visualization of massive amounts of digital data for artificial intelligence and Software Security & Engineering, devoted to the development of high-quality, innovative software systems through state of the art technologies, and standardized processes.", "Genova, Italy", true, true, false, true));
        courseList.add(new Course("Engineering in Computer Science", "La Sapienza University of Rome", "The Master of Science in Engineering in Computer Science lasts 2 years. The aim of the course is to train Computer Engineers with specific expertise both in the sector of Computer Science, focussing on software applications such as software design, data management and analysis and software application to A.I., and in the sectors of information processing systems and security, models and methodologies, tools for the assessment of systems performance, as well as the optimization of systems for information processing and network systems.", "Rome, Italy", true, true, true, false));
        courseList.add(new Course("Computer Science and Engineering", "Politecnico di Milano", "The study programme in Computer Science and Engineering is a two years programme that can be taken by students awarded with a (bachelor level) Laurea Degree in Engineering of Computing Systems or similar, provided an approval from an admission committee. The study programme can be folowed by a three years PhD programme. Each of the two years of the Master programme is partitioned into two semesters. In order to allow students to access the Master course at the start of each semester, the first and second semester of each year are interchangeable; the courses that are programmed for each semester can, in fact, be attended without any noticeable inconvenience, both in the natural sequence (1st semester, 2nd semester) and in the reverse order (2nd semester, 1st semester).", "Milan, Italy", true, true, false, false));
        courseList.add(new Course("Ingegneria Informatica", "University of Padua", "Il corso di Laurea Magistrale in Ingegneria Informatica forma un professionista, ingegnere di secondo livello, beneficiando delle attività di ricerca di punta espresse dal Dipartimento di Ingegneria dell’Informazione dell’Università di Padova. La figura professionale del laureato magistrale è di alto profilo e in grado di utilizzare un ampio spettro di conoscenze per interpretare, descrivere e risolvere in modo innovativo problemi dell’ingegneria informatica, che richiedono un elevato grado di approfondimento unitamente ad un approccio interdisciplinare.", "Padua, Italy", true, true, true, false));
        courseList.add(new Course("Computer Science and Networking", "University of Pisa", "The 2-year Master Programme in Computer Science and Networking at University of Pisa has been designed to meet the growing demand for an emerging kind of professionals with high-level expertise in both computer and information science and technologies, and communication networking science and technologies.", "Pisa, Italy", true, true, false, false));
    }



    public List getCl(){
        return courseList;
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
                    fragmentTransaction.replace(((ViewGroup) getView().getParent()).getId(), SearchFragment.newInstance());

                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                return false;
            }
        });
    }

}