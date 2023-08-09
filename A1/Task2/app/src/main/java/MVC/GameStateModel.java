package MVC;

import android.widget.Button;
import android.widget.TextView;

public class GameStateModel {
    public Button[][] buttons = null;
    public Button btnS = null;
    public Button btnO= null;

    public String character = "S";
    public String Board[][] = new String[5][5];
    public String lines[][] = new String[5][5];
    public TextView Player1TextLabel = null;
    public TextView Player2TextLabel = null;
    public TextView Player1ScoreLabel = null;
    public TextView Player2ScoreLabel = null;

    Integer P1Score=0;
    Integer P2Score=0;


    public GameStateModel(Button[][] _buttons, TextView P1TL, TextView P2TL, TextView P1SL, TextView P2SL, Button _btnS, Button _btnO)
    {
        this.buttons = _buttons;
        this.Player1ScoreLabel = P1SL;
        this.Player2ScoreLabel = P2SL;
        this.Player1TextLabel = P1TL;
        this.Player2TextLabel = P2TL;
        this.btnS = _btnS;
        this.btnO = _btnO;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Board[i][j]="";
                lines[i][j]="";
            }
        }
    }
}
