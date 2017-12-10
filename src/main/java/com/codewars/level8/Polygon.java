package com.codewars.level8;

/*You are the owner of a box making company.

Your company can produce any equal sided polygon box,
but plenty of your customers want to transport circular objects in these boxes.
Circles are a very common shape in the consumer industry.
Tin cans, glasses, tyres and CD's are a few examples of these.

As a result you decide to add this information on your boxes:
The largest (diameter) circular object that can fit into a given box.

formula : r = a/(2tg(180/n))
*/
public class Polygon {
    int sides;
    int sideLength;

    public Polygon(int sides, int sideLength) {
        this.sides = sides;
        this.sideLength = sideLength;
    }

    public double circleDiameter(){
        //Your code comes here
        return 2*(sideLength/(2*(Math.tan(Math.toRadians(180d/sides)))));
    }

}
