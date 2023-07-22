package sg.edu.rp.c346.id22022505.myndpsongs;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;
    public Song(int id, String title, String singers, int year, int stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }
    public static void add(Song obj) {
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setSongTitle(String title) {
        this.title = title;
    }
    public String getSingers() {
        return singers;
    }
    public void setSongSingers(String singers) {
        this.singers = singers;
    }
    public int getYear() {
        return year;
    }
    public void setSongYear(int year) {
        this.year = year;
    }
    public int getStars() {
        return stars;
    }
    public void setSongStars(int stars) {
        this.stars = stars;
    }
    @Override
    public String toString() {
        String StarST = "";
        if(stars == 1)
        {
            StarST = "*";
        }
        else if(stars == 2)
        {
            StarST = "**";
        }
        else if(stars == 3)
        {
            StarST = "***";
        }
        else if(stars == 4)
        {
            StarST = "****";
        }
        else if(stars == 5)
        {
            StarST = "*****";
        }
        return title + "\n" + singers + " - " + year + "\n" + StarST;
    }
}


