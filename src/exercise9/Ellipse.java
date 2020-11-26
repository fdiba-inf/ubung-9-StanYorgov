package exercise9;

public class Ellipse {
    private Point startPoint;
    private double height;
    private double width;

    public Ellipse() {
        startPoint = new Point(0,0);
        height = 1;
        width = 1;
    }

    public Ellipse (Point startPoint, double width, double height) {
        this.startPoint = new Point(startPoint);
        this.height = height;
        this.width = width;
    }

    public Ellipse (Ellipse otherEllipse) {
        this.startPoint = new Point(otherEllipse.startPoint);
        this.height = otherEllipse.height;
        this.width = otherEllipse.width;
    }

    public boolean isValid() {
        return height > 0 && width > 0;
    }

    public void initialize() {
        do {
            System.out.println("Enter the start point: ");
            this.startPoint.initialize();

            System.out.println("Enter the height: ");
            this.height = Utils.INPUT.nextDouble();

            System.out.println("Enter the width: ");
            this.width = Utils.INPUT.nextDouble();

        } while (!isValid());
    }

    public double calculatePerimeter() {
        return Math.PI * (3 * (height + width) - Math.sqrt((3 * height + width) * (height + 3 * width)));
    }

    public double calculateArea() {
        return Math.PI * height * width;
    }

    public String getType() {
        return Utils.equals(height, width) ? "Cycle" : "Ellipse";
    }

    @Override
    public String toString() {
        return String.format("%s-[%s, %s], %s, P=%s, A=%s", startPoint, height, width, getType(), calculatePerimeter(), calculateArea());
    }

    public boolean equals(Ellipse otherEllipse) {
        boolean sameHeight = Utils.equals(this.height, otherEllipse.height);
        boolean sameWidth = Utils.equals(this.width, otherEllipse.width);
        boolean reversedHeight = Utils.equals(this.height, otherEllipse.width);
        boolean reversedWidth = Utils.equals(this.width, otherEllipse.height);

        return (sameHeight && sameWidth) || (reversedHeight && reversedWidth);
    }
}


