package com.example.updatingindiatwo.DataBase;

import android.widget.TextView;

public class HeaderHelperClass {
    String total,active,recovered,death;
    public HeaderHelperClass(){}

    public String getTotal() {
        return total;
    }

    public String getActive() {
        return active;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getDeath() {
        return death;
    }

    public HeaderHelperClass(String total, String active, String recovered, String death) {
        this.total = total;
        this.active = active;
        this.recovered = recovered;
        this.death = death;
    }
}
