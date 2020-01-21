abstract class Shape {
    private String name;
    private double area;
    private double perimeter;

    Shape(String _name){
        this.name = _name;
        this.area = 0;
        this.perimeter = 0;
    }

    public String toString(){
        return String.format("%s of area %.3f", this.name, this.area);
    }

    public double getArea(){
        return area;
    }

    public void setArea(double _area){
        this.area = _area;
    }

    public double getPerimeter(){
        return perimeter;
    }

    public void setPerimeter(double _perimeter){
        this.perimeter = _perimeter;
    }

    public double compareTo(Shape maxShape){
        return this.area - maxShape.getArea();
    }

}
