package cl.xamaztian.pruebados.data;

import java.util.ArrayList;
import java.util.List;

import cl.xamaztian.pruebados.models.Bird;

/**
 * Created by Xamaztian on 19-04-2018.
 */

public class Queries {

    public static List<Bird> toWatchList(){
        List<Bird> birds = new ArrayList<>();
        List<Bird> birdsToWatch = Bird.find(Bird.class,"1=1");

        if (birdsToWatch != null && birdsToWatch.size() >0) {
            birds.addAll(birdsToWatch);
        }

        return birds;
    }

}
