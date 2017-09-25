package tdp.com.contactdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

import tdp.com.contactdemo.Adapter.ContactAdapter;
import tdp.com.contactdemo.Model.Contact;

public class MainActivity extends AppCompatActivity {
    private EditText edtNumber, edtName;
    private RadioButton rbtnMale, rbtnFemale;
    private Button btnAddContact;
    private ListView lvContact;
    private ArrayList<Contact> arrayListContact;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        arrayListContact = new ArrayList<>();
        arrayAdapter = new ContactAdapter(this, R.layout.list_contact, arrayListContact);
        lvContact.setAdapter(arrayAdapter);

    }


    public void initWidget() {
        edtNumber = (EditText) findViewById(R.id.edt_number);
        edtName = (EditText) findViewById(R.id.edt_name);
        rbtnFemale = (RadioButton) findViewById(R.id.rbtn_female);
        rbtnMale = (RadioButton) findViewById(R.id.rbtn_male);
        btnAddContact = (Button) findViewById(R.id.btn_add_contact);
        lvContact = (ListView) findViewById(R.id.lv_contact);
    }
    public  void addContact(View view){
        if (view.getId() == R.id.btn_add_contact) {
            String name = edtName.getText().toString().trim();
            String number = edtNumber.getText().toString().trim();
            boolean isGender = true;
            if (rbtnMale.isChecked()) {
                isGender = true;
            } else {
                isGender = false;
            }
            if (TextUtils.isEmpty(name) && TextUtils.isEmpty(number)) {
                Toast.makeText(MainActivity.this, "Please input name and number", Toast.LENGTH_SHORT).show();
            } else {
                Contact contact = new Contact(isGender, number, name);
                arrayListContact.add(contact);
            }
            arrayAdapter.notifyDataSetChanged();

        }
        edtName.setText("");
        edtNumber.setText("");
        edtName.clearFocus();
    }




}
