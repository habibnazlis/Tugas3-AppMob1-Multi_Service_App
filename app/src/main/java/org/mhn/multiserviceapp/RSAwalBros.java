package org.mhn.multiserviceapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalBros extends ListActivity {
    protected void onCreate (Bundle icicle){

        super.onCreate(icicle);
        String[] listAct = new String[]{"Call Center", "SMS Center", "Driving Direction", "Website", "Info On Google", "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listAct));
    }
    protected void onListItemClick (ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanPilihan(pilihan);
    }

    private void tampilkanPilihan(String pilihan) {
        try{
            Intent a = null;
            if (pilihan.equals("Call Center"))
            {
                String phoneNumber = "tel:+6276121000";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber));

            } else if (pilihan.equals("SMS Center")){
                String smsText = "Muhammad Habib Nazlis / L";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:085271153302"));
                a.putExtra("sms_body", smsText);

            } else if (pilihan.equals("Driving Direction")){
                String location = "google.navigation:q=0.463823,101.390353";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
            } else if (pilihan.equals("Website")){
                String website = "http://awalbros.com/branch/pekanbaru/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(website));

            } else if (pilihan.equals("Info On Google")){
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY, "Rumah Sakit Awal Bros");

            }
            startActivity(a);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
