package MVC;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wrpv302.a1.assignment1task2.MainActivity;
import com.wrpv302.a1.assignment1task2.R;

public class MainController extends AppCompatActivity {

    public Button[][] buttons= null;
    public View MainView=null;

    public MainActivity MA;

    public GameStateModel model;
    public MainController(View MainView, MainActivity _MA){
        this.MainView = MainView;
        model = new GameStateModel(SetButtons(), (TextView) MainView.findViewById(R.id.txtp1), (TextView) MainView.findViewById(R.id.txtp2), (TextView) MainView.findViewById(R.id.txtp1s), (TextView) MainView.findViewById(R.id.txtp2s), (Button) MainView.findViewById(R.id.buttonS), (Button) MainView.findViewById(R.id.buttonO) );
        MA = _MA;

    }

    private Button[][] SetButtons()
    {
        /*
        buttons =  new Button[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String btnid = "btn"+Integer.toString(i) + Integer.toString(j);
                //int id= getResources().getIdentifier(btnid, "id", getPackageName());
               // int id= getResources().getIdentifier(btnid, "id", getPackageName());
                Integer id = MA.PinegetID(btnid);
                buttons[i][j] = findViewById(id);
                buttons[i][j].setText(" ");
            }
        }

        **/
      // buttons=  MA.buts;
        buttons = null;
        return buttons;
    }

}
