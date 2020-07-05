package com.example.updatingindiatwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.updatingindiatwo.CovidNews.COvidNewsDashboard;
import com.example.updatingindiatwo.DataBase.HeaderHelperClass;
import com.example.updatingindiatwo.States.StatesAndaman;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    //spinner value
    Spinner spinnerState;
    TextView total, active, death, recovered;
    //India  -----
    TextView indiaActive, indiaTotal, indiaDeath, indiaRecovered;
    //Andaman and nicobar
    TextView andamanActive, andamanRecovered, andamanDeath, andamanTotal;
    //Andaman strings
    String andamantotal, andamandeath, andamanrecovered, andamanactive;
    //Andhra pradesh
    TextView andhraActive, andhraRecovered, andhraDeath, andhraTotal;
    //String andhra Pradesh
    String andhraactive, andhrarecovered, andhradeath, andhratotal;
    //Arunachal
    TextView arunachalActive, arunachalRecovered, arunachalDeath, arunachalTotal;
    //Assam
    TextView assamActive, assamRecovered, assamDeath, assamTotal;
    //Bihar
    TextView biharActive, biharRecovered, biharDeath, biharTotal;
    //chandigarh
    TextView chandigarhActive, chandigarhRecovered, chandigarhDeath, chandigarhTotal;
    //chhattisgarh
    TextView chhattisgarhActive, chhattisgarhRecovered, chhattisgarhDeath, chhattisgarhTotal;
    //dadra
    TextView dadraActive, dadraRecovered, dadraDeath, dadraTotal;
    //delhi
    TextView delhiActive, delhiRecovered, delhiDeath, delhiTotal;
    //goa
    TextView goaActive, goaRecovered, goaDeath, goaTotal;
    //gujarat
    TextView gujaratActive, gujaratRecovered, gujaratDeath, gujaratTotal;
    //haryana
    TextView haryanaActive, haryanaRecovered, haryanaDeath, haryanaTotal;
    //Himachal
    TextView himachalActive, himachalRecovered, himachalDeath, himalchalTotal;
    //Jammu and kashmir
    TextView jammuActive, jammuRecovered, jammuDeath, jammuTotal;
    //Jharkhand
    TextView jharkhandActive, jharkhandRecovered, jharkhandDeath, jharkhandTotal;
    //karnataka
    TextView karnatakaActive, karnatakaRecovered, karnatakaDeath, karnatakaTotal;
    //kerala
    TextView keralaActive, keralaRecovered, keralaDeath, keralaTotal;
    //ladakh
    TextView ladakhActive, ladakhDeath, ladakhRecovered, ladakhTotal;
    //lakshadweep
    TextView lakshadweepActive, lakshadweepDeath, lakshadweepTotal, lakshadweepRecovered;
    //madhya pradesh
    TextView madhyaActive,madhyaTotal,madhyaDeath,madhyaRecovered;
    //manipur
    TextView manipurActive,manipurDeath,manipurTotal,manipurRecovered;
    //meghalaya
    TextView meghalayaActive,meghalayaDeath,meghalayaTotal,meghalayaRecovered;
    //mizoram
    TextView mizoramActive,mizoramDeath,mizoramTotal,mizoramRecovered;
    //nagaland
    TextView nagalandActive,nagalandDeath,nagalandTotal,nagalandRecovered;
    //odisha
    TextView odishaActive,odishaDeath,odishaTotal,odishaRecovered;
    //puducherry
    TextView puducherryActive,puducherryDeath,puducherrytotal,puducherryRecovered;
    //punjab
    TextView punjabActive,punjabDeath,punjabtotal,punjabRecovered;
    //rajasthan
    TextView rajasthanActive,rajasthanDeath,rajasthantotal,rajasthanRecovered;
    //sikkim
    TextView sikkimActive,sikkimDeath,sikkimtotal,sikkimRecovered;
    //state unassigned
    TextView stateUnassignedActive,stateUnassignedDeath,stateUnassignedTotal,stateUnassignedRecovered;
    //tamil nadu
    TextView tamilNaduActive,tamilNaduDeath,tamilNaduTotal,tamilNaduRecovered;
    //telangana
    TextView telanganaActive,telanganaDeath,telanganaTotal,telanganaRecovered;
    //tripura
    TextView tripuraActive,tripuraDeath,tripuraTotal,tripuraRecovered;
    //uttarpradesh
    TextView uttarpradeshActive,uttarpradeshDeath,uttarpradeshTotal,uttarpradeshRecovered;
    //uttrakhand
    TextView uttrakhandActive,uttrakhandDeath,uttrakhandTotal,uttrakhandRecovered;
    //westbengal
    TextView westbengalActive,westbengalDeath,westbengalTotal,westbengalRecovered;

    //updates data
    TextView lastupdates;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hooks for spinner data;
        spinnerState = findViewById(R.id.states_spinner);
        total = findViewById(R.id.total_cases);
        active = findViewById(R.id.active_cases);
        death = findViewById(R.id.death_cases);
        recovered = findViewById(R.id.recovered_cases);
        //hooks for india
        indiaTotal = findViewById(R.id.india_cases);
        indiaActive = findViewById(R.id.india_active_cases);
        indiaRecovered = findViewById(R.id.india_recovered_cases);
        indiaDeath = findViewById(R.id.india_death_cases);
        //hooks for andaman and nicobar
        andamanActive = findViewById(R.id.andaman_active_cases);
        andamanDeath = findViewById(R.id.andaman_death_cases);
        andamanTotal = findViewById(R.id.andaman_cases);
        andamanRecovered = findViewById(R.id.andaman_recovered_cases);
        //hooks for andhra pradesh
        andhraActive = findViewById(R.id.andhra_pradesh_active_cases);
        andhraTotal = findViewById(R.id.andhra_pradesh_cases);
        andhraRecovered = findViewById(R.id.andhra_pradesh_recovered_cases);
        andhraDeath = findViewById(R.id.andhra_pradesh_death_cases);
        //hooks for anrunachal
        arunachalActive = findViewById(R.id.anurachal_pradesh_active_cases);
        arunachalDeath = findViewById(R.id.anurachal_pradesh_death_cases);
        arunachalRecovered = findViewById(R.id.anurachal_pradesh_recovered_cases);
        arunachalTotal = findViewById(R.id.anurachal_pradesh_cases);
        //hooks for assam
        assamActive = findViewById(R.id.assam_active_cases);
        assamDeath = findViewById(R.id.assam_death_cases);
        assamRecovered = findViewById(R.id.assam_recovered_cases);
        assamTotal = findViewById(R.id.assam_cases);
        //hooks for bihar
        biharActive = findViewById(R.id.bihar_active_cases);
        biharRecovered = findViewById(R.id.bihar_recovered_cases);
        biharTotal = findViewById(R.id.bihar_cases);
        biharDeath = findViewById(R.id.bihar_death_cases);
        //hooks for chandigarh
        chandigarhActive = findViewById(R.id.chandigarh_active_cases);
        chandigarhDeath = findViewById(R.id.chandigarh_death_cases);
        chandigarhRecovered = findViewById(R.id.chandigarh_recovered_cases);
        chandigarhTotal = findViewById(R.id.chandigarh_cases);
        //hooks for chhattisgarh
        chhattisgarhActive = findViewById(R.id.chhattisgarh_active_cases);
        chhattisgarhRecovered = findViewById(R.id.chhattisgarh_recovered_cases);
        chhattisgarhDeath = findViewById(R.id.chhattisgarh_death_cases);
        chhattisgarhTotal = findViewById(R.id.chhattisgarh_cases);
        //hooks for dadra
        dadraActive = findViewById(R.id.dadra_active_cases);
        dadraDeath = findViewById(R.id.dadra_death_cases);
        dadraRecovered = findViewById(R.id.dadra_recovered_cases);
        dadraTotal = findViewById(R.id.dadra_cases);
        //hooks for delhi
        delhiActive = findViewById(R.id.delhi_active_cases);
        delhiRecovered = findViewById(R.id.delhi_recovered_cases);
        delhiDeath = findViewById(R.id.delhi_death_cases);
        delhiTotal = findViewById(R.id.delhi_cases);
        //hooks for goa
        goaActive = findViewById(R.id.goa_active_cases);
        goaRecovered = findViewById(R.id.goa_recovered_cases);
        goaDeath = findViewById(R.id.goa_death_cases);
        goaTotal = findViewById(R.id.goa_cases);
        //hooks for gujarat
        gujaratActive = findViewById(R.id.gujarat_active_cases);
        gujaratRecovered = findViewById(R.id.gujarat_recovered_cases);
        gujaratDeath = findViewById(R.id.gujarat_death_cases);
        gujaratTotal = findViewById(R.id.gujarat_cases);
        //hooks for haryana
        haryanaActive = findViewById(R.id.haryana_active_cases);
        haryanaDeath = findViewById(R.id.haryana_death_cases);
        haryanaRecovered = findViewById(R.id.haryana_recovered_cases);
        haryanaTotal = findViewById(R.id.haryana_cases);
        //hooks for himachal
        himachalActive = findViewById(R.id.himachal_active_cases);
        himachalRecovered = findViewById(R.id.himachal_recovered_cases);
        himachalDeath = findViewById(R.id.himachal_death_cases);
        himalchalTotal = findViewById(R.id.himachal_cases);
        //hooks for JAMMU And kashmir
        jammuActive = findViewById(R.id.jammu_active_cases);
        jammuDeath = findViewById(R.id.jammu_death_cases);
        jammuRecovered = findViewById(R.id.jammu_recovered_cases);
        jammuTotal = findViewById(R.id.jammu_cases);
        //hooks for jharkhand
        jharkhandActive = findViewById(R.id.jharkhand_active_cases);
        jharkhandRecovered = findViewById(R.id.jharkhand_recovered_cases);
        jharkhandDeath = findViewById(R.id.jharkhand_death_cases);
        jharkhandTotal = findViewById(R.id.jharkhand_cases);
        //hooks for karnataka
        karnatakaActive = findViewById(R.id.karnataka_active_cases);
        karnatakaDeath = findViewById(R.id.karnataka_death_cases);
        karnatakaRecovered = findViewById(R.id.karnataka_recovered_cases);
        karnatakaTotal = findViewById(R.id.karnataka_cases);
        //hooks for kerala
        keralaActive = findViewById(R.id.kerala_active_cases);
        keralaRecovered = findViewById(R.id.kerala_recovered_cases);
        keralaDeath = findViewById(R.id.kerala_death_cases);
        keralaTotal = findViewById(R.id.kerala_cases);
        //hooks  for ladakh
        ladakhActive = findViewById(R.id.ladakh_active_cases);
        ladakhRecovered = findViewById(R.id.ladakh_recovered_cases);
        ladakhDeath = findViewById(R.id.ladakh_death_cases);
        ladakhTotal = findViewById(R.id.ladakh_cases);
        //hooks for lakshadweep
        lakshadweepActive = findViewById(R.id.lakshadweep_active_cases);
        lakshadweepDeath = findViewById(R.id.lakshadweep_death_cases);
        lakshadweepRecovered = findViewById(R.id.lakshadweep_recovered_cases);
        lakshadweepTotal = findViewById(R.id.lakshadweep_cases);
        //hooks for meghalaya
        meghalayaActive = findViewById(R.id.meghalaya_active_cases);
        meghalayaDeath = findViewById(R.id.meghalaya_death_cases);
        meghalayaRecovered = findViewById(R.id.meghalaya_recovered_cases);
        meghalayaTotal = findViewById(R.id.meghalaya_cases);
        //hooks for manipur
        manipurActive = findViewById(R.id.manipur_active_cases);
        manipurDeath = findViewById(R.id.manipur_death_cases);
        manipurRecovered = findViewById(R.id.manipur_recovered_cases);
        manipurTotal = findViewById(R.id.manipur_cases);
        //hooks for madhya pradesh
        madhyaActive = findViewById(R.id.madhya_active_cases);
        madhyaDeath = findViewById(R.id.madhya_death_cases);
        madhyaRecovered = findViewById(R.id.madhya_recovered_cases);
        madhyaTotal = findViewById(R.id.madhya_cases);
        //hooks for mizoram
        mizoramActive = findViewById(R.id.mizoram_active_cases);
        mizoramDeath = findViewById(R.id.mizoram_death_cases);
        mizoramRecovered = findViewById(R.id.mizoram_recovered_cases);
        mizoramTotal = findViewById(R.id.mizoram_cases);
        //hooks for nagaland
        nagalandActive = findViewById(R.id.nagaland_active_cases);
        nagalandDeath = findViewById(R.id.nagaland_death_cases);
        nagalandRecovered = findViewById(R.id.nagaland_recovered_cases);
        nagalandTotal = findViewById(R.id.nagaland_cases);
        //hooks for odisha
        odishaActive = findViewById(R.id.odisha_active_cases);
        odishaDeath = findViewById(R.id.odisha_death_cases);
        odishaRecovered = findViewById(R.id.odisha_recovered_cases);
        odishaTotal = findViewById(R.id.odisha_cases);
        //hooks for puducherry
        puducherryActive = findViewById(R.id.puducherry_active_cases);
        puducherryDeath = findViewById(R.id.puducherry_death_cases);
        puducherryRecovered = findViewById(R.id.puducherry_recovered_cases);
        puducherrytotal = findViewById(R.id.puducherry_cases);
        //hooks for punjab
        punjabActive = findViewById(R.id.punjab_active_cases);
        punjabDeath = findViewById(R.id.punjab_death_cases);
        punjabRecovered = findViewById(R.id.punjab_recovered_cases);
        punjabtotal = findViewById(R.id.punjab_cases);
        //hooks for rajasthan
        rajasthanActive = findViewById(R.id.rajasthan_active_cases);
        rajasthanDeath = findViewById(R.id.rajasthan_death_cases);
        rajasthanRecovered = findViewById(R.id.rajasthan_recovered_cases);
        rajasthantotal = findViewById(R.id.rajasthan_cases);
        //hooks for sikkim
        sikkimActive = findViewById(R.id.sikkim_active_cases);
        sikkimDeath = findViewById(R.id.sikkim_death_cases);
        sikkimRecovered = findViewById(R.id.sikkim_recovered_cases);
        sikkimtotal = findViewById(R.id.sikkim_cases);
        //hooks for State Unassigned
        stateUnassignedActive = findViewById(R.id.state_unassigned_active_cases);
        stateUnassignedDeath = findViewById(R.id.state_unassigned_death_cases);
        stateUnassignedRecovered = findViewById(R.id.state_unassigned_recovered_cases);
        stateUnassignedTotal = findViewById(R.id.state_unassigned_cases);
        //hooks for tamil nadu
        tamilNaduActive = findViewById(R.id.tamil_nadu_active_cases);
        tamilNaduDeath = findViewById(R.id.tamil_nadu_death_cases);
        tamilNaduRecovered = findViewById(R.id.tamil_nadu_recovered_cases);
        tamilNaduTotal = findViewById(R.id.tamil_nadu_cases);
        //hooks for telangana
        telanganaActive = findViewById(R.id.telangana_active_cases);
        telanganaDeath = findViewById(R.id.telangana_death_cases);
        telanganaRecovered = findViewById(R.id.telangana_recovered_cases);
        telanganaTotal = findViewById(R.id.telangana_cases);
        //hooks for tripura
        tripuraActive = findViewById(R.id.tripura_active_cases);
        tripuraDeath = findViewById(R.id.tripura_death_cases);
        tripuraRecovered = findViewById(R.id.tripura_recovered_cases);
        tripuraTotal = findViewById(R.id.tripura_cases);
        //hooks for Uttarpradesh
        uttarpradeshActive= findViewById(R.id.uttar_pradesh_active_cases);
        uttarpradeshDeath= findViewById(R.id.uttar_pradesh_death_cases);
        uttarpradeshRecovered = findViewById(R.id.uttar_pradesh_recovered_cases);
        uttarpradeshTotal = findViewById(R.id.uttar_pradesh_cases);
        //hooks for uttrakhand
        uttrakhandActive= findViewById(R.id.uttrakhand_active_cases);
        uttrakhandDeath= findViewById(R.id.uttrakhand_death_cases);
        uttrakhandRecovered = findViewById(R.id.uttrakhand_recovered_cases);
        uttrakhandTotal = findViewById(R.id.uttrakhand_cases);
        //hooks for westbengal
        westbengalActive=findViewById(R.id.westbengal_active_cases);
        westbengalDeath= findViewById(R.id.westbengal_death_cases);
        westbengalRecovered = findViewById(R.id.westbengal_recovered_cases);
        westbengalTotal = findViewById(R.id.westbengal_cases);



        //hooks for last updates
        String Total = total.getText().toString().trim();
        String Active = active.getText().toString().trim();
        String Recovered = recovered.getText().toString().trim();
        String Death = death.getText().toString().trim();
        // storeheaderData();
        headerDisplay();
//        spinnerdata();

    }


    private void headerDisplay() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getReference("Header Data");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                String Total = dataSnapshot.child("total").child("total").getValue(String.class);
                String Active = dataSnapshot.child("total").child("active").getValue(String.class);
                String Recovered = dataSnapshot.child("total").child("recovered").getValue(String.class);
                String Death = dataSnapshot.child("total").child("death").getValue(String.class);
                total.setText(Total);
                active.setText(Active);
                recovered.setText(Recovered);
                death.setText(Death);
                indiaActive.setText(Active);
                indiaDeath.setText(Death);
                indiaRecovered.setText(Recovered);
                indiaTotal.setText(Total);

                //display of andaman and nicobar

                andamantotal = dataSnapshot.child("Andaman").child("total").getValue(String.class);
                andamanactive = dataSnapshot.child("Andaman").child("active").getValue(String.class);
                andamanrecovered = dataSnapshot.child("Andaman").child("recovered").getValue(String.class);
                andamandeath = dataSnapshot.child("Andaman").child("death").getValue(String.class);
                andamanActive.setText(andamanactive);
                andamanTotal.setText(andamantotal);
                andamanRecovered.setText(andamanrecovered);
                andamanDeath.setText(andamandeath);

                //display of andhra pradesh

                andhraActive.setText(dataSnapshot.child("Andhra").child("active").getValue(String.class));
                andhraTotal.setText(dataSnapshot.child("Andhra").child("total").getValue(String.class));
                andhraDeath.setText(dataSnapshot.child("Andhra").child("death").getValue(String.class));
                andhraRecovered.setText(dataSnapshot.child("Andhra").child("recovered").getValue(String.class));
                //display of arunachal
                arunachalActive.setText(dataSnapshot.child("Arunachal").child("active").getValue(String.class));
                arunachalDeath.setText(dataSnapshot.child("Arunachal").child("death").getValue(String.class));
                arunachalRecovered.setText(dataSnapshot.child("Arunachal").child("recovered").getValue(String.class));
                arunachalTotal.setText(dataSnapshot.child("Arunachal").child("total").getValue(String.class));
                //display of assam
                assamActive.setText(dataSnapshot.child("Assam").child("active").getValue(String.class));
                assamDeath.setText(dataSnapshot.child("Assam").child("death").getValue(String.class));
                assamRecovered.setText(dataSnapshot.child("Assam").child("recovered").getValue(String.class));
                assamTotal.setText(dataSnapshot.child("Assam").child("total").getValue(String.class));
                //Bihar
                biharActive.setText(dataSnapshot.child("Bihar").child("active").getValue(String.class));
                biharRecovered.setText(dataSnapshot.child("Bihar").child("recovered").getValue(String.class));
                biharDeath.setText(dataSnapshot.child("Bihar").child("death").getValue(String.class));
                biharTotal.setText(dataSnapshot.child("Bihar").child("total").getValue(String.class));
                //display chandigarh
                chandigarhActive.setText(dataSnapshot.child("Chandigarh").child("active").getValue(String.class));
                chandigarhDeath.setText(dataSnapshot.child("Chandigarh").child("death").getValue(String.class));
                chandigarhRecovered.setText(dataSnapshot.child("Chandigarh").child("recovered").getValue(String.class));
                chandigarhTotal.setText(dataSnapshot.child("Chandigarh").child("total").getValue(String.class));
                //display chhattisgarh
                chhattisgarhActive.setText(dataSnapshot.child("Chhattisgarh").child("active").getValue(String.class));
                chhattisgarhRecovered.setText(dataSnapshot.child("Chhattisgarh").child("recovered").getValue(String.class));
                chhattisgarhDeath.setText(dataSnapshot.child("Chhattisgarh").child("death").getValue(String.class));
                chhattisgarhTotal.setText(dataSnapshot.child("Chhattisgarh").child("total").getValue(String.class));
                //display dadra
                dadraActive.setText(dataSnapshot.child("Dadra").child("active").getValue(String.class));
                dadraDeath.setText(dataSnapshot.child("Dadra").child("death").getValue(String.class));
                dadraRecovered.setText(dataSnapshot.child("Dadra").child("recovered").getValue(String.class));
                dadraTotal.setText(dataSnapshot.child("Dadra").child("total").getValue(String.class));
                //display delhi
                delhiActive.setText(dataSnapshot.child("Delhi").child("active").getValue(String.class));
                delhiTotal.setText(dataSnapshot.child("Delhi").child("total").getValue(String.class));
                delhiRecovered.setText(dataSnapshot.child("Delhi").child("recovered").getValue(String.class));
                delhiDeath.setText(dataSnapshot.child("Delhi").child("death").getValue(String.class));
                //display goa
                goaActive.setText(dataSnapshot.child("Goa").child("active").getValue(String.class));
                goaRecovered.setText(dataSnapshot.child("Goa").child("recovered").getValue(String.class));
                goaDeath.setText(dataSnapshot.child("Goa").child("death").getValue(String.class));
                goaTotal.setText(dataSnapshot.child("Goa").child("total").getValue(String.class));
                //display gujarat
                gujaratActive.setText(dataSnapshot.child("Gujarat").child("active").getValue(String.class));
                gujaratRecovered.setText(dataSnapshot.child("Gujarat").child("recovered").getValue(String.class));
                gujaratDeath.setText(dataSnapshot.child("Gujarat").child("death").getValue(String.class));
                gujaratTotal.setText(dataSnapshot.child("Gujarat").child("total").getValue(String.class));
                //display haryana
                haryanaActive.setText(dataSnapshot.child("Haryana").child("active").getValue(String.class));
                haryanaTotal.setText(dataSnapshot.child("Haryana").child("total").getValue(String.class));
                haryanaDeath.setText(dataSnapshot.child("Haryana").child("death").getValue(String.class));
                haryanaRecovered.setText(dataSnapshot.child("Haryana").child("recovered").getValue(String.class));
                //display himachal pradesh
                himachalActive.setText(dataSnapshot.child("Himachal").child("active").getValue(String.class));
                himachalDeath.setText(dataSnapshot.child("Himachal").child("death").getValue(String.class));
                himachalRecovered.setText(dataSnapshot.child("Himachal").child("recovered").getValue(String.class));
                himalchalTotal.setText(dataSnapshot.child("Himachal").child("total").getValue(String.class));
                //display jammu and kashmir
                jammuActive.setText(dataSnapshot.child("Jammu").child("active").getValue(String.class));
                jammuRecovered.setText(dataSnapshot.child("Jammu").child("recovered").getValue(String.class));
                jammuTotal.setText(dataSnapshot.child("Jammu").child("total").getValue(String.class));
                jammuDeath.setText(dataSnapshot.child("Jammu").child("death").getValue(String.class));
                // display jharkhand
                jharkhandRecovered.setText(dataSnapshot.child("Jharkhand").child("recovered").getValue(String.class));
                jharkhandDeath.setText(dataSnapshot.child("Jharkhand").child("death").getValue(String.class));
                jharkhandActive.setText(dataSnapshot.child("Jharkhand").child("active").getValue(String.class));
                jharkhandTotal.setText(dataSnapshot.child("Jharkhand").child("total").getValue(String.class));
                //display kerala
                keralaActive.setText(dataSnapshot.child("Kerala").child("active").getValue(String.class));
                keralaRecovered.setText(dataSnapshot.child("Kerala").child("recovered").getValue(String.class));
                keralaDeath.setText(dataSnapshot.child("Kerala").child("death").getValue(String.class));
                keralaTotal.setText(dataSnapshot.child("Kerala").child("total").getValue(String.class));
                //display karnataka
                karnatakaActive.setText(dataSnapshot.child("Karnataka").child("active").getValue(String.class));
                karnatakaRecovered.setText(dataSnapshot.child("Karnataka").child("recovered").getValue(String.class));
                karnatakaDeath.setText(dataSnapshot.child("Karnataka").child("death").getValue(String.class));
                karnatakaTotal.setText(dataSnapshot.child("Karnataka").child("total").getValue(String.class));
                //display ladakh
                ladakhActive.setText(dataSnapshot.child("Ladakh").child("active").getValue(String.class));
                ladakhRecovered.setText(dataSnapshot.child("Ladakh").child("recovered").getValue(String.class));
                ladakhDeath.setText(dataSnapshot.child("Ladakh").child("death").getValue(String.class));
                ladakhTotal.setText(dataSnapshot.child("Ladakh").child("total").getValue(String.class));
                //display lakshadweep
                lakshadweepActive.setText(dataSnapshot.child("Lakshadweep").child("active").getValue(String.class));
                lakshadweepRecovered.setText(dataSnapshot.child("Lakshadweep").child("recovered").getValue(String.class));
                lakshadweepDeath.setText(dataSnapshot.child("Lakshadweep").child("death").getValue(String.class));
                lakshadweepTotal.setText(dataSnapshot.child("Lakshadweep").child("total").getValue(String.class));
                //display manipur
                manipurActive.setText(dataSnapshot.child("Manipur").child("active").getValue(String.class));
                manipurRecovered.setText(dataSnapshot.child("Manipur").child("recovered").getValue(String.class));
                manipurDeath.setText(dataSnapshot.child("Manipur").child("death").getValue(String.class));
                manipurTotal.setText(dataSnapshot.child("Manipur").child("total").getValue(String.class));
                //display madhya pradesh
                madhyaActive.setText(dataSnapshot.child("Madhya").child("active").getValue(String.class));
                madhyaRecovered.setText(dataSnapshot.child("Madhya").child("recovered").getValue(String.class));
                madhyaDeath.setText(dataSnapshot.child("Madhya").child("death").getValue(String.class));
                madhyaTotal.setText(dataSnapshot.child("Madhya").child("total").getValue(String.class));
                //display meghalaya
                meghalayaActive.setText(dataSnapshot.child("Meghalaya").child("active").getValue(String.class));
                meghalayaRecovered.setText(dataSnapshot.child("Meghalaya").child("recovered").getValue(String.class));
                meghalayaDeath.setText(dataSnapshot.child("Meghalaya").child("death").getValue(String.class));
                meghalayaTotal.setText(dataSnapshot.child("Meghalaya").child("total").getValue(String.class));
                //display mizoram
                mizoramActive.setText(dataSnapshot.child("Mizoram").child("active").getValue(String.class));
                mizoramRecovered.setText(dataSnapshot.child("Mizoram").child("recovered").getValue(String.class));
                mizoramDeath.setText(dataSnapshot.child("Mizoram").child("death").getValue(String.class));
                mizoramTotal.setText(dataSnapshot.child("Mizoram").child("total").getValue(String.class));
                //display nagaland
                nagalandActive.setText(dataSnapshot.child("Nagaland").child("active").getValue(String.class));
                nagalandRecovered.setText(dataSnapshot.child("Nagaland").child("recovered").getValue(String.class));
                nagalandDeath.setText(dataSnapshot.child("Nagaland").child("death").getValue(String.class));
                nagalandTotal.setText(dataSnapshot.child("Nagaland").child("total").getValue(String.class));
                //display odisha
                odishaActive.setText(dataSnapshot.child("Odisha").child("active").getValue(String.class));
                odishaRecovered.setText(dataSnapshot.child("Odisha").child("recovered").getValue(String.class));
                odishaDeath.setText(dataSnapshot.child("Odisha").child("death").getValue(String.class));
                odishaTotal.setText(dataSnapshot.child("Odisha").child("total").getValue(String.class));
                //display puducherry
                puducherryActive.setText(dataSnapshot.child("Puducherry").child("active").getValue(String.class));
                puducherryRecovered.setText(dataSnapshot.child("Puducherry").child("recovered").getValue(String.class));
                puducherryDeath.setText(dataSnapshot.child("Puducherry").child("death").getValue(String.class));
                puducherrytotal.setText(dataSnapshot.child("Puducherry").child("total").getValue(String.class));
                //display punjab
                punjabActive.setText(dataSnapshot.child("Punjab").child("active").getValue(String.class));
                punjabRecovered.setText(dataSnapshot.child("Punjab").child("recovered").getValue(String.class));
                punjabDeath.setText(dataSnapshot.child("Punjab").child("death").getValue(String.class));
                punjabtotal.setText(dataSnapshot.child("Punjab").child("total").getValue(String.class));
                //display rajasthan
                rajasthanActive.setText(dataSnapshot.child("Rajasthan").child("active").getValue(String.class));
                rajasthanRecovered.setText(dataSnapshot.child("Rajasthan").child("recovered").getValue(String.class));
                rajasthanDeath.setText(dataSnapshot.child("Rajasthan").child("death").getValue(String.class));
                rajasthantotal.setText(dataSnapshot.child("Rajasthan").child("total").getValue(String.class));
                //display sikkim
                sikkimActive.setText(dataSnapshot.child("Sikkim").child("active").getValue(String.class));
                sikkimRecovered.setText(dataSnapshot.child("Sikkim").child("recovered").getValue(String.class));
                sikkimDeath.setText(dataSnapshot.child("Sikkim").child("death").getValue(String.class));
                sikkimtotal.setText(dataSnapshot.child("Sikkim").child("total").getValue(String.class));
                //display state unassigned
                stateUnassignedActive.setText(dataSnapshot.child("State unassigned").child("active").getValue(String.class));
                stateUnassignedRecovered.setText(dataSnapshot.child("State unassigned").child("recovered").getValue(String.class));
                stateUnassignedDeath.setText(dataSnapshot.child("State unassigned").child("death").getValue(String.class));
                stateUnassignedTotal.setText(dataSnapshot.child("State unassigned").child("total").getValue(String.class));
                //display telangana
                telanganaActive.setText(dataSnapshot.child("Telangana").child("active").getValue(String.class));
                telanganaRecovered.setText(dataSnapshot.child("Telangana").child("recovered").getValue(String.class));
                telanganaDeath.setText(dataSnapshot.child("Telangana").child("death").getValue(String.class));
                telanganaTotal.setText(dataSnapshot.child("Telangana").child("total").getValue(String.class));
                //display tamilnadu
                tamilNaduActive.setText(dataSnapshot.child("Tamilnadu").child("active").getValue(String.class));
                tamilNaduRecovered.setText(dataSnapshot.child("Tamilnadu").child("recovered").getValue(String.class));
                tamilNaduDeath.setText(dataSnapshot.child("Tamilnadu").child("death").getValue(String.class));
                tamilNaduTotal.setText(dataSnapshot.child("Tamilnadu").child("total").getValue(String.class));
                //display tripura
                tripuraActive.setText(dataSnapshot.child("Tripura").child("active").getValue(String.class));
                tripuraRecovered.setText(dataSnapshot.child("Tripura").child("recovered").getValue(String.class));
                tripuraDeath.setText(dataSnapshot.child("Tripura").child("death").getValue(String.class));
                tripuraTotal.setText(dataSnapshot.child("Tripura").child("total").getValue(String.class));
                //display uttarpradesh
                uttarpradeshActive.setText(dataSnapshot.child("Uttarpradesh").child("active").getValue(String.class));
                uttarpradeshRecovered.setText(dataSnapshot.child("Uttarpradesh").child("recovered").getValue(String.class));
                uttarpradeshDeath.setText(dataSnapshot.child("Uttarpradesh").child("death").getValue(String.class));
                uttarpradeshTotal.setText(dataSnapshot.child("Uttarpradesh").child("total").getValue(String.class));
                //display uttrakhand
                uttrakhandActive.setText(dataSnapshot.child("Uttrakhand").child("active").getValue(String.class));
                uttrakhandRecovered.setText(dataSnapshot.child("Uttrakhand").child("recovered").getValue(String.class));
                uttrakhandDeath.setText(dataSnapshot.child("Uttrakhand").child("death").getValue(String.class));
                uttrakhandTotal.setText(dataSnapshot.child("Uttrakhand").child("total").getValue(String.class));
                //display westbengal
                westbengalActive.setText(dataSnapshot.child("Westbengal").child("active").getValue(String.class));
                westbengalRecovered.setText(dataSnapshot.child("Westbengal").child("recovered").getValue(String.class));
                westbengalDeath.setText(dataSnapshot.child("Westbengal").child("death").getValue(String.class));
                westbengalTotal.setText(dataSnapshot.child("Westbengal").child("total").getValue(String.class));
                //header last updates data
                //spinner data

                spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (parent.getItemAtPosition(position).equals("India")) {

                        } else {
                            String item = parent.getSelectedItem().toString();
                            if (item.equals("Andaman and nicobar")) {
                                Intent intent=new Intent(getApplicationContext(), StatesAndaman.class);
                                startActivity(intent);
//                                total.setText(andamantotal);
//                                active.setText(andamanactive);
//                                recovered.setText(andamanrecovered);
//                                death.setText(andamandeath);
                            }
                            if(item.equals("Andhra Pradesh")){

                            }
                            if(item.equals("India"))
                            {

                            }
                            Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Please connect to internet for live updates", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //    private void storeheaderData() {
//        String Total=total.getText().toString().trim();
//        String Active=active.getText().toString().trim();
//        String Recovered=recovered.getText().toString().trim();
//        String Death=death.getText().toString().trim();
//        FirebaseDatabase rootNode=FirebaseDatabase.getInstance();
//        DatabaseReference reference = rootNode.getReference("Header Data");
//        HeaderHelperClass addHeaderData=new HeaderHelperClass(Total,Active,Recovered,Death);
//        reference.child("total").setValue(addHeaderData);
//    }
    public void feedback(View view) {
        Intent intent = new Intent(getApplicationContext(), Feedback.class);
        startActivity(intent);

    }
    public void callCovidNews(View view){
        Intent intent=new Intent(getApplicationContext(), COvidNewsDashboard.class);
        startActivity(intent);
    }
}
