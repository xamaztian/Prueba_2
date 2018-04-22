package cl.xamaztian.pruebados.models;

import com.orm.SugarRecord;

/**
 * Created by Xamaztian on 12-04-2018.
 */

public class Bird extends SugarRecord {
    private String name;
    private String scientificName;
    private boolean watched;

    public Bird() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}