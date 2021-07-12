package com.company.GameOverFrame;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SaveRecord {
    SaveRecord(int applesEaten, String windowSize, String gameLevel) throws IOException {
        String date = getDataOfGame();
        File dataRecords = new File("src/history/historyGames.txt");
        saveData(date, applesEaten, windowSize, gameLevel, dataRecords);

    }

    private String getDataOfGame(){
        String dataPattern = "E, dd MMM yyyy HH:mm:ss z";
        SimpleDateFormat simpleDate = new SimpleDateFormat(dataPattern);
        return simpleDate.format(new Date());
    }

    private void saveData(String date, int applesEaten, String windowSize, String gameLevel, File dataFile) throws IOException {
        FileWriter writeData = new FileWriter("src/history/historyGames.txt", true);
        String record = "Date game : " + date + "\nLevel : "+ gameLevel + "\nGame Size : " + windowSize +
                "\nScore (apples eaten) : "+ applesEaten + "\n\n\n";
        if(dataFile.exists()){
            writeData.append(record);
        }else{
            writeData.write(record);
        }
        writeData.close();
    }
}
