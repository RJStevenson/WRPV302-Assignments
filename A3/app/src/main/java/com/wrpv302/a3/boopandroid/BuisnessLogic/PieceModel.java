package com.wrpv302.a3.boopandroid.BuisnessLogic;

public class PieceModel {
    public PieceModel(boolean t, boolean p)
    {
        if(t)
            Type = PieceType.kitten;
        else
            Type = PieceType.cat;
        if(p)
            Player = PlayerType.P1;
        else
            Player = PlayerType.P2;

    }
    public PieceType Type;
    public PlayerType Player;
    public enum PlayerType {
        P1,
        P2

    }
    public enum PieceType
    {
        kitten,
        cat
    }

}
