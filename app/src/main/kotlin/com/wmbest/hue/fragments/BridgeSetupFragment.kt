package com.wmbest.hue.fragments

import android.app.*
import android.content.*
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.*
import android.view.*

import retrofit.*
import retrofit.client.*

import kotlinx.android.synthetic.frag_bridge_setup.view.*

import rx.Observable

import com.wmbest.hue.R
import com.wmbest.hue.api.*
import com.wmbest.hue.util.*
import com.wmbest.hue.model.Bridge

class BridgeSetupFragment : Fragment(), MeetHueApi by Apis.getInstance().meetHue() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, state: Bundle?) : View {
        super<Fragment>.onCreateView(inflater, container, state)
        val result = inflater.inflate(R.layout.frag_bridge_setup, container, false)

        result.next.hide()

        bind(bridges())
            .toItems()
            .subscribe({ bridge ->
                "Found Bridge ${bridge.getIpAddress()}".d()
            }, 
            { error -> error.printStackTrace() },
            {   
                result.next.show()
                result.progress.gone()
            })
            
        return result;
    }
}
