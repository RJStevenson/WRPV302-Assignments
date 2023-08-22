package controllers;


import android.content.Context;

import com.wrpv302.a1.contacts.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.ContactItem;

public class BusinessLogic {
    public List<models.ContactItem> Items;
    public Context  context;

    public BusinessLogic(Context _context)
    {
        this.context = _context;
        List<String> files = Arrays.asList(context.fileList());
        if(files.contains("ContactItems.ser"))
        {
            try {
                FileInputStream fis = context.openFileInput("ContactItems.Ser");
                ObjectInputStream in = new ObjectInputStream(fis);
                Items = (List<ContactItem>)in.readObject();

            } catch (Exception e) {
            }

        }
        else
            this.Items = DataFromScratch();
    }

    public void WriteData()
    {
        try{
            FileOutputStream fileout = context.openFileOutput("ContactItems.Ser", Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(this.Items);
            fileout.close();
        }
        catch(Exception e)
        {
    }
    }

    private List<ContactItem> DataFromScratch()
    {
        List<ContactItem> temp = new ArrayList<>();
        String[] nams = {"Ben", "Oscar", "Belinda", "Ryan", "Jemma", "Themba", "Sitha", "Ted", "Barney", "Marshall"};
        String num = "0841234567";
        for (int i = 0; i < nams.length; i++) {

            if(i==9)
                temp.add(new ContactItem(nams[i], num,"avatar_" + Integer.toString(i+1)));//+".png"));
            else
            temp.add(new ContactItem(nams[i], num,"avatar_0" + Integer.toString(i+1)));// +".png"));
        }
        return temp;
    }
}
