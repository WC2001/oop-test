package agh.ics.oop;

import java.util.Comparator;

public class Comparators {

    static Comparator<AbstractWordMapElement> compareX = new Comparator<AbstractWordMapElement>() {
        @Override
        public int compare(AbstractWordMapElement o1, AbstractWordMapElement o2) {

            Vector2d v1 = o1.getPosition();
            Vector2d v2 = o2.getPosition();
            if(v1.x < v2.x)
                return -1;

            if(v1.x > v2.x)
                return 1;

            if(v1.y < v2.y)
                return -1;

            if(v1.y > v2.y)
                return 1;

            return 0;
        }
    };

    static Comparator<AbstractWordMapElement> compareY = new Comparator<AbstractWordMapElement>() {
        @Override
        public int compare(AbstractWordMapElement o1, AbstractWordMapElement o2) {

            Vector2d v1 = o1.getPosition();
            Vector2d v2 = o2.getPosition();

            if(v1.y < v2.y)
                return -1;
            if(v1.y > v2.y)
                return 1;
            if(v1.x < v2.x)
                return -1;
            if(v1.x > v2.x)
                return 1;
            return 0;
        }
    };
}
