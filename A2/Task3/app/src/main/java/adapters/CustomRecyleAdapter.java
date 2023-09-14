package adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wrpv302.a1.contacts.R;

import java.util.List;

import models.ContactItem;

public class  CustomRecyleAdapter extends RecyclerView.Adapter<CustomRecyleAdapter.ContactViewHolder>
{
    public List<ContactItem> datalist;

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
       ContactItem contactItem = datalist.get(position);
       holder.SetContact(contactItem);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public ContactItem get(int positon)
    {
        return datalist.get(positon);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        public  ContactItem Contact;

        TextView nam ;
        TextView num;
        ImageView img;


        ImageView img2;
        Button btnedit;
        Button btnmessage;
        Button btncall;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

             nam = (TextView) itemView.findViewById(R.id.AvatarName);
             num = (TextView) itemView.findViewById(R.id.AvatarCellNumber);
             img = (ImageView) itemView.findViewById(R.id.AvatarImgView);


             /**
            img = (ImageView) itemView.findViewById(R.id.AvatarImgViewBack);
            btnedit = (Button) itemView.findViewById(R.id.btnedit);
            btnmessage = (Button) itemView.findViewById(R.id.btnmessage);
            btncall = (Button) itemView.findViewById(R.id.btndial);

              **/
        }

        public void SetContact(ContactItem contact)
        {
            this.Contact = contact;

            nam.setText(Contact.Name);
            num.setText(Contact.Number);
            img.setImageResource(itemView.getResources().getIdentifier(Contact.Img,"drawable", itemView.getContext().getPackageName()));
            //img.setImageResource(itemView.getResources().getIdentifier(Contact.Img,"drawable", itemView.getContext().getPackageName()));

        }
    }

    public CustomRecyleAdapter(List<ContactItem> Contacts)
    {
        this.datalist = Contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contactcardfront,parent, false);
        ContactViewHolder pvh = new ContactViewHolder(view);
        return pvh;
    }


}
