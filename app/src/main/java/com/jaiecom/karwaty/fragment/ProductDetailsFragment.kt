

package com.jaiecom.karwaty.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jaiecom.karwaty.R
import com.jaiecom.karwaty.adapter.RVAdapter
import com.jaiecom.karwaty.adapter.RVGenInfoAdapter
import kotlinx.android.synthetic.main.fragment_product_details.*

@Suppress("UNREACHABLE_CODE")
class ProductDetailsFragment: Fragment() {

    lateinit var rvAdapter: RVAdapter
    lateinit var rvGenInfoAdapter: RVGenInfoAdapter
    lateinit var convenience_comfertList: ArrayList<String>
    lateinit var safetyList: ArrayList<String>
    lateinit var entTechList: ArrayList<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product_details, container, false)
    }


    private fun openDialog(s: String, selectQualification: ArrayList<String>) {
        val dialog = activity?.let { Dialog(it) }
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(true)
        dialog?.setContentView(R.layout.custom_layout)
        val body = dialog?.findViewById(R.id.tvTitle) as TextView
        val rv_items = dialog?.findViewById(R.id.rv_items) as RecyclerView
        body.text = s

        rv_items.apply {
            layoutManager = LinearLayoutManager(activity)
            rv_items.setLayoutManager(layoutManager)
            rvGenInfoAdapter = RVGenInfoAdapter()
            rvGenInfoAdapter.setListData(selectQualification)
            rvGenInfoAdapter.notifyDataSetChanged()
            adapter = rvGenInfoAdapter

        }

        dialog.show()
    }

    private fun initRVConvenienceComfert() {
        rv_conv_comf.apply {
            layoutManager = GridLayoutManager(
                activity,
                2,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            rv_conv_comf.setLayoutManager(layoutManager)
            rvAdapter = RVAdapter()
            rvAdapter.setListData(convenience_comfertList)
            rvAdapter.notifyDataSetChanged()
            adapter = rvAdapter


        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val select_qualification = arrayListOf<String>(
            "General Information 01",
            "General Information 02 AAA",
            "General Information 0BB",
            "General Information 02 CC",
            "General Information 02 DDD",
            "General Information 02 EEEEEE"
        )

        this.convenience_comfertList = arrayListOf(
            "Bluetooth",
            "Electric Mirror",
            "Sunroof",
            "Electric Seats",
            "Automatic Climate Control",
            "Adjustable Seats"
        )

        this.safetyList = arrayListOf(
            "Belts",
            "ABS Brakes",
            "Alarm",
            "Imobiliser",
            "Airbags"
        )

        this.entTechList = arrayListOf(
            "AUX",
            "Navigation",
            "DVD",
            "TV Screen",
        )

        val vehInfo1 = resources.getStringArray(R.array.VehicleInformation1)
        val vehInfo2 = resources.getStringArray(R.array.VehicleInformation2)
        val vehInfo3 = resources.getStringArray(R.array.VehicleInformation3)
        val convComf = resources.getStringArray(R.array.ConvComf)
        val safety = resources.getStringArray(R.array.Safety)
        val entTech = resources.getStringArray(R.array.EntertainmentTechnology)
        val odo= resources.getStringArray(R.array.Odo)
        val range = resources.getStringArray(R.array.Range)






        if (spinner_veh_info1 != null) {
            val adapter =
                activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, vehInfo1) }
            spinner_veh_info1.adapter = adapter
        }

        if (spinner_veh_info2 != null) {
            val adapter =
                activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, vehInfo2) }
            spinner_veh_info2.adapter = adapter
        }

        if (spinner_veh_info3 != null) {
            val adapter =
                activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, vehInfo3) }
            spinner_veh_info3.adapter = adapter
        }

        if (spinner_conv_comf != null) {
            val adapter =
                activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, convComf) }
            spinner_conv_comf.adapter = adapter
        }

        if (spinner_safety != null) {
            val adapter =
                activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, safety) }
            spinner_safety.adapter = adapter
        }

        if (spinner_ent_tech != null) {
            val adapter =
                activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, entTech) }
            spinner_ent_tech.adapter = adapter
        }
        if (spinner_odometer != null) {
            val adapter = activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, odo) }
            spinner_odometer.adapter = adapter
        }

        if (spinner_Range != null) {
            val adapter =
                activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, range) }
            spinner_Range.adapter = adapter
        }

        initRVConvenienceComfert()
        initSafety()
        initEntertainment()

        tv_gen_info.setOnClickListener {
            openDialog("Multiple Selection", select_qualification)
        }




        txt_next.setOnClickListener {
            // val intent = Intent(this, LocationActivity::class.java)
            //  startActivity(intent)


            val fragment = LocationFragment()
            showFragment(fragment)
        }

    }

    fun showFragment(fragment: LocationFragment){
        val fram = activity?.supportFragmentManager?.beginTransaction()
        if (fram != null) {
            fram.replace(R.id.fragment_main,fragment)
            fram.addToBackStack(null)
            fram.commit()
        }

    }
    private fun initEntertainment() {
        rv_ent_tech.apply {
            layoutManager = GridLayoutManager(
                activity,
                2,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            /*rv_safety.setLayoutManager(layoutManager)
        rvSafetyAdapter = RVSafetyAdapter()
        rvSafetyAdapter.setListData(safetyList)
        rvSafetyAdapter.notifyDataSetChanged()
        adapter = rvSafetyAdapter*/


            rv_ent_tech.setLayoutManager(layoutManager)
            rvAdapter = RVAdapter()
            rvAdapter.setListData(entTechList)
            rvAdapter.notifyDataSetChanged()
            adapter = rvAdapter
        }
    }

    private fun initSafety() {
        rv_safety.apply {
            layoutManager = GridLayoutManager(
                activity,
                2,
                LinearLayoutManager.HORIZONTAL,
                false
            )

            rv_safety.setLayoutManager(layoutManager)
            rvAdapter = RVAdapter()
            rvAdapter.setListData(safetyList)
            rvAdapter.notifyDataSetChanged()
            adapter = rvAdapter

        }


    }
}