package com.sphere.io.glass.mock;

import com.sphere.io.glass.model.Alternative;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Android Studio .
 * User: Carlos Muñoz Romero
 * Date: 5/11/14
 * Time: 13:19
 * Project: SphereGlass
 */
public class AlternativesMocks {

    public List<Alternative> getAlternativesMocks() {
        List<Alternative> items = new ArrayList<Alternative>();
        Alternative alt = new Alternative();
        alt.setName("Name 1");
        alt.setImageUrl("http://photoshoproadmap.com/Photoshop-blog/wp-content/uploads/2013/12/AquariusTaster.jpg");
        items.add(alt);

        alt = new Alternative();
        alt.setName("Name 2");
        alt.setImageUrl("http://photoshoproadmap.com/Photoshop-blog/wp-content/uploads/2013/12/AquariusTaster.jpg");
        items.add(alt);

        alt = new Alternative();
        alt.setName("Name 3");
        alt.setImageUrl("http://photoshoproadmap.com/Photoshop-blog/wp-content/uploads/2013/12/AquariusTaster.jpg");
        items.add(alt);

        alt = new Alternative();
        alt.setName("Name 4");
        alt.setImageUrl("http://photoshoproadmap.com/Photoshop-blog/wp-content/uploads/2013/12/AquariusTaster.jpg");
        items.add(alt);

        return items;
    }

}
