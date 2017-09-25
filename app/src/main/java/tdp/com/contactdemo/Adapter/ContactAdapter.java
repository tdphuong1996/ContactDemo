package tdp.com.contactdemo.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tdp.com.contactdemo.Model.Contact;
import tdp.com.contactdemo.R;

/**
 * Created by TDP on 25/09/2017.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {

    private Context context;
    private int resource;
    private List<Contact> arrContact;

    public ContactAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrContact=objects;
    }


    private class ViewHolder {
        ImageView imgAvatar, imgEdit, imgDelete;
        TextView tvName, tvNumber;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_contact, parent, false);
            holder = new ViewHolder();

            holder.imgAvatar = (ImageView) convertView.findViewById(R.id.img_avatar);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.img_delete);
            holder.imgEdit = (ImageView) convertView.findViewById(R.id.img_edit);

            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvNumber= (TextView) convertView.findViewById(R.id.tv_number);
            convertView.setTag(holder);


        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Contact contact = arrContact.get(position);

        holder.tvName.setText(contact.getmName());
        holder.tvNumber.setText(contact.getmNumber());
        if (contact.isMale()) {
            holder.imgAvatar.setBackgroundResource(R.drawable.man);
        } else {

            holder.imgAvatar.setBackgroundResource(R.drawable.female);
        }
        return convertView;
    }
}
