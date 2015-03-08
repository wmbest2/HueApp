package com.wmbest.hue;

import android.app.Activity;

public class MainActivity extends Activity {

    final Channel mChannel;
    final WifiP2pManager mManager;
    WifiP2pServiceRequest mRequester;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(), new ChannelListener() {

            public void onChannelDisconnected() {
                Log.i("CI", "Channel detected!");

            }
        });
        mManager.setUpnpServiceResponseListener(mChannel, new UpnpServiceResponseListener() {

            public void onUpnpServiceAvailable(List<String> arg0, WifiP2pDevice arg1) {
                Log.i("sd", "Found device!!");          
            }

        });
        mRequester = WifiP2pUpnpServiceRequest.newInstance();

        mManager.addServiceRequest(mChannel, mRequester, new ActionListener() {

            public void onSuccess() {

                Log.i("d", "AddServiceRequest success!");

                mManager.discoverServices(mChannel, new ActionListener() {

                    public void onSuccess() {
                        Log.i("d", "DiscoverServices success!");
                    }

                    public void onFailure(int reason) { 
                    }
                });

            }

            public void onFailure(int reason) {
            }
        });

    } 
} 
