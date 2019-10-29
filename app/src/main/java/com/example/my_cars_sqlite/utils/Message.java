package com.example.my_cars_sqlite.utils;

import android.content.Context;
import android.app.AlertDialog;

        public class Message {
            private Context _context;
        //Construtor

       public Message(Context context) {this._context = context;}

        //Mostra msg

        public void show(String titulo, final String texto, int icone) {
            AlertDialog.Builder msg = new AlertDialog.Builder(_context);
            msg.setIcon(icone);
            msg.setTitle(titulo);
            msg.setMessage(texto);
            msg.setPositiveButton("OK", null);

            msg.show();


        }
    }








