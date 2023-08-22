package adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wrpv302.a1.contacts.R;

import java.util.ArrayList;
import java.util.List;

import models.ContactItem;

public class CustomRecyleAdapterNew extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    public List<ContactItem> datalist = new ArrayList<>();
    public Context context;

    public CustomRecyleAdapterNew(Context context, List<ContactItem> items)
    {
       this.context = context;
       this.datalist = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contactcardfront, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TextView nam = (TextView) itemView.findViewById(R.id.AvatarName);
            TextView num = (TextView) itemView.findViewById(R.id.AvatarCellNumber);
            ImageView img = (ImageView) itemView.findViewById(R.id.AvatarImgView);


            nam.setText(datalist.get(this.getAdapterPosition()).Name);
            num.setText(datalist.get(this.getAdapterPosition()).Number);
            //img.setImageResource(itemView.getResources().getIdentifier(datalist.get(getAdapterPosition()).Img,"drawable", getContext().getPackageName()));
        }
    }
}
