package com.jaiecom.karwaty.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.jaiecom.karwaty.R
import kotlinx.android.synthetic.main.fragment_location.*
import java.util.*

class LocationFragment : Fragment() , LocationListener {

    val locationPermissionCode = 106
    lateinit var locationManager: LocationManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_location, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        txt_locate.setOnClickListener { getLocationn() }



        tv_next.setOnClickListener {
           /* val intent = Intent(this, AddProductActivity::class.java)
            startActivity(intent)*/

            val fragment = AddProductFragment()
            showFragment(fragment)
        }


    }
    fun showFragment(fragment: AddProductFragment){
        val fram = activity?.supportFragmentManager?.beginTransaction()
        if (fram != null) {
            fram.replace(R.id.fragment_main,fragment)
            fram.addToBackStack(null)
            fram.commit()
        }

    }

    private fun getLocationn() {

        locationManager = activity?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((context?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.ACCESS_FINE_LOCATION) } != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(context as Activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionCode)
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)

    }

    override fun onLocationChanged(location: Location) {


        getAddress(location.latitude, location.longitude)

    }

    private fun getAddress(latitude: Double, longitude: Double) {
        val geocoder: Geocoder
        val addresses: List<Address>
        geocoder = Geocoder(activity, Locale.getDefault())

        addresses = geocoder.getFromLocation(
            latitude,
            longitude,
            1
        ) // Here 1 represent max location result to returned, by documents it recommended 1 to 5


        val address: String =
            addresses[0].getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()

        /* val city: String = addresses[0].getLocality()
         val state: String = addresses[0].getAdminArea()
         val country: String = addresses[0].getCountryName()
         val postalCode: String = addresses[0].getPostalCode()
         val knownName: String = addresses[0].getFeatureName()*/

        /* Toast.makeText(
             this,
             "Location is: " + address + " " + city + " " + state + " " + country + " " + postalCode,
             Toast.LENGTH_SHORT
         ).show()*/

        txt_locate.text=address
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == locationPermissionCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(activity, "Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}