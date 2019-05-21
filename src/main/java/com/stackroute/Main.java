package com.stackroute;

import com.stackroute.db.CrudOperation;

public class Main {
    public static void main(String[] args) {
        CrudOperation crudOperation = new CrudOperation();
       // crudOperation.displayData();
        crudOperation.displayCustomrerByName("sravani","female");
    }
}
