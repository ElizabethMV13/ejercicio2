package com.example.ejercicio2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.ejercicio2.model.EstudianteViewHolder
import com.example.ejercicio2.model.StudentAdapter
import com.example.ejercicio2.model.Student
import com.example.ejercicio2.model.StudentApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SegundoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class SegundoFragment : Fragment() {

    private val studentList: MutableList<Student> = mutableListOf()
    lateinit var adapterStudent: StudentAdapter
    lateinit var recyclerView: RecyclerView

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_segundo, container, false)


        // Configurar el RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewEstudent)


        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        fetchStudentData()

        return view
    }

    private fun fetchStudentData() {

        // Crear una instancia de Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://private-b21a12-ejercicio2estudiantes.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentApiService::class.java)


        // Hacer la llamada a la API para obtener los datos de los estudiantes
        var retroData = retrofit.getStudents().enqueue(object : Callback<List<Student>> {
            override fun onResponse(call: Call<List<Student>>, response: Response<List<Student>>) {
                if (response.isSuccessful) {
                    val students = response.body()
                    students?.let {
                        // Agregar los estudiantes a la lista
                        studentList.addAll(students)

                        adapterStudent = StudentAdapter(requireContext(), students )

                        recyclerView.adapter = adapterStudent


                        Log.d("data", students.toString())
                    }
                } else {
                    // Manejar el caso de respuesta no exitosa
                }
            }

            override fun onFailure(call: Call<List<Student>>, t: Throwable) {
                // Manejar el caso de error de la llamada
            }
        })
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment secondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SegundoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



}