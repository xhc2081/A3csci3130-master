package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetailViewActivity extends Activity {

    private static final String TAG = "DetailViewActivity";
    private static final String REQUIRED = "Required";

    private EditText nameField, numberField,primaryField,addressField,provinceField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");


        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        primaryField = (EditText) findViewById(R.id.primary);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            numberField.setText(receivedPersonInfo.number);
            primaryField.setText(receivedPersonInfo.primary);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    public void updateContact(View v){
        // Update contact funcionality
//        appState.firebaseReference.child( receivedPersonInfo.uid).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Contact contact = dataSnapshot.getValue(Contact.class);
//                if (contact == null) {
//                    // User is null, error out
//                    Log.e(TAG, "User " + contact.uid + " is unexpectedly null");
//                    Toast.makeText(DetailViewActivity.this,
//                            "Error: could not fetch user.",
//                            Toast.LENGTH_SHORT).show();
//                } else {
//                    // Write new post
//                    writeNewPost(userId, user.username, title, body);
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        String uid = receivedPersonInfo.uid;
        String name = nameField.getText().toString();
        String number = numberField.getText().toString();
        String primary = primaryField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        Contact person = new Contact(uid,name,number,primary,address,province);

        appState.firebaseReference.child(uid).setValue(person);

        Toast.makeText(DetailViewActivity.this, "The contact has been updated!", Toast.LENGTH_SHORT).show();
        finish();
//        Map<String, Object> values = contact.toMap();
//
//        Map<String, Object> childUpdates = new HashMap<>();
//        childUpdates.put("/contacts/" + uid, values);

    }

    /**
     * Delete the  contact
     * @param v erase button
     */
    public void eraseContact(View v)
    {
        //Erase contact functionality
        appState.firebaseReference.child( receivedPersonInfo.uid).removeValue();
        Toast.makeText(DetailViewActivity.this, "The contact has been deleted!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
