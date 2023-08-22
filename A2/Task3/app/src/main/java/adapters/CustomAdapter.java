package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.wrpv302.a1.contacts.R;

import java.util.ArrayList;
import java.util.List;

import models.ContactItem;

public class CustomAdapter extends ArrayAdapter<models.ContactItem>
{

    List<ContactItem> datalist = new ArrayList<>();
    public CustomAdapter(@NonNull Context context, int resource, List<ContactItem> objs) {
        super(context, resource, objs);
        datalist = objs;
    }

    @Override
    public int getCount(){
        return super.getCount();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View vfront = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        vfront = inflater.inflate(R.layout.contactcardfront, null);
        vfront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view = inflater.inflate(R.layout.contactcardback, null);
                ImageView img = (ImageView) view.findViewById(R.id.AvatarImgViewBack);
                Button btnedit = (Button) view.findViewById(R.id.btnedit);
                Button btnmessage = (Button) view.findViewById(R.id.btnmessage);
                Button btncall = (Button) view.findViewById(R.id.btndial);

            }
        });
        TextView nam = (TextView) vfront.findViewById(R.id.AvatarName);
        TextView num = (TextView) vfront.findViewById(R.id.AvatarCellNumber);
        ImageView img = (ImageView) vfront.findViewById(R.id.AvatarImgView);



        nam.setText(datalist.get(position).Name);
        num.setText(datalist.get(position).Number);
        img.setImageResource(vfront.getResources().getIdentifier(datalist.get(position).Img,"drawable", getContext().getPackageName()));
        return vfront;
    }
}
