package com.wrpv302.a3.boopandroid.BuisnessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoopModel {
    public PieceModel.PlayerType Turn;

    public List<Integer[]> Directions = new ArrayList<>();
    public boolean Winner = false;
    public PieceModel[][] Board = new PieceModel[6][6];
    public int[] Scores = {0,0};
    public Stack<PieceModel>[] Pools = new Stack[2];
    public Stack<PieceModel>[] Reserves = new Stack[2];

    public void Initialize()
    {
        Turn = PieceModel.PlayerType.P1;
        Winner = false;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                Board[i][j] =null;
            }
            Pools[0].push(new PieceModel(true, true));
            Pools[1].push(new PieceModel(true, false));
            Reserves[0].push(new PieceModel(false, true));
            Reserves[1].push(new PieceModel(false, false));
        }
        Directions.add(new Integer[]{- 1,  - 1});     //1 UP Left
        Directions.add(new Integer[]{-1,0});            //2 UP
        Directions.add(new Integer[]{-1,1});          //3 UP Right
        Directions.add(new Integer[]{0,-1});            //4 Left
        Directions.add(new Integer[]{0,1});            //5 Right
        Directions.add(new Integer[]{1,-1});          //6 Down Left
        Directions.add(new Integer[]{1,0});            //7 Down
        Directions.add(new Integer[]{1,1});          //8 Down Right
    }

    public Result<ThreeModel> Move(PieceModel piece, int row, int col)
    {
        if (Board[row][col]!=null)
            return  new Result<>(false, "Piece Already Exists on this square");
        else
        {
            CheckMove(piece.Type, row, col);
            //need to add check rows
            return new Result<>()
        }
    }

    private ThreeModel GetThrees()
    {
        ThreeModel TM = new ThreeModel();
        for (int i = 0; i < ; i++) {

        }
    }

    private boolean GetThreesR()
    {
    }



    private void CheckMove(PieceModel.PieceType type, int row, int col)
    {
        int r = row;
        int c = col;
        /*
        List<Integer[]> Positions = new ArrayList<>();
        Positions.add(new Integer[]{r - 1, c - 1});     //1 UP Left
        Positions.add(new Integer[]{r-1,c});            //2 UP
        Positions.add(new Integer[]{r-1,c+1});          //3 UP Right
        Positions.add(new Integer[]{r,c-1});            //4 Left
        Positions.add(new Integer[]{r,c+1});            //5 Right
        Positions.add(new Integer[]{r+1,c-1});          //6 Down Left
        Positions.add(new Integer[]{r+1,c});            //7 Down
        Positions.add(new Integer[]{r+1,c+1});          //8 Down Right
        */

        for (int i = 0; i < Directions.size(); i++) {
            int dr = Directions.get(i)[0];
            int dc = Directions.get(i)[1];
            if(CheckMoveR(row, col, dr, dr, 1,type))
            {
                //starting the move
                //could add callback here
                PieceModel temp = Board[row+dr][col+dc];
                Board[row+dr] = null;
                if(RCBounds(row+dr+dr, col+dc+dc))
                Board[row+dr+dr][col+dc+dc] = temp;
                //move complete
            }
        }
    }

    private boolean CheckMoveR(int r, int c, int dr, int dc, int Depth, PieceModel.PieceType type)
    {
        int rr = r+dr;
        int cc = c+dc;
        if(RCBounds(rr,cc))
        {
            PieceModel place = Board[rr][cc];
            if(place.equals(null) && Depth==1)
                return false;
            else if(place.equals(null) && Depth==2)
            {
                if(type.equals(place.Type))
                    return true;
                else if((type== PieceModel.PieceType.cat) && (place.Type== PieceModel.PieceType.kitten))
                    return true;
                else
                    return false;
            }
            else if(!place.equals(null) && Depth==1)
            {
                return CheckMoveR(rr,cc,dr,dc,1+1,place.Type);
            }

        }
        else
        {
            if(Depth==1)
                return false;
            if(Depth==2)
                return true;
        }
        return false;
    }
    private boolean CheckBounds(int num)
    {
        int boundary = this.Board.length-1;
        if(num>boundary || num<0)
            return false;
        else
            return true;
    }

    private boolean RCBounds(int r, int c)
    {
        if(CheckBounds(r) && CheckBounds(c))
            return true;
        else
            return false;
    }

}
