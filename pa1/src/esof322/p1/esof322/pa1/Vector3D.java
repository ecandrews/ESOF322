package esof322.pa1;

public class Vector3D {
    // Variables to hold double coordinate values of a 3D vector
    private final double xCoord;
    private final double yCoord;
    private final double zCoord;

    //contructor to assign input coordinate values to local variables
    public Vector3D(double x, double y, double z) {
        this.xCoord = x;
        this.yCoord = y;
        this.zCoord = z;
    }
    // Scale method that recalculates vector coordinates by multiplying them by an input scale value
    // and returning a new vector
    public Vector3D scale(double f) {
        return new Vector3D(this.xCoord * f, this.yCoord * f, this.zCoord * f);
    }
    // adds two vectors together by combining their x y and z coordinate values and returns a
    // new vector
    public Vector3D add(Vector3D v) {
        return new Vector3D(v.xCoord + this.xCoord, v.yCoord + this.yCoord, v.zCoord + this.zCoord);
    }
    // subtracts one vector from another by calculating the difference in their x y and z values
    public Vector3D subtract(Vector3D v) {
        return new Vector3D(v.xCoord - this.xCoord, v.yCoord - this.yCoord, v.zCoord - this.zCoord);
    }
    // multiplies all values of a vector  by -1 using existing scale method
    public Vector3D negate() {
        return scale(-1);
    }

    // calculates the magnitude oif a vector by calculating the square root of the sum of the x, y,
    // and z values.
    public double magnitude() {
        double totalX = this.xCoord * this.xCoord;
        double totalY = this.yCoord * this.yCoord;
        double totalZ = this.zCoord * this.zCoord;
        return Math.sqrt(totalX + totalY + totalZ);
    }
    // calculates the dot product of two vectors by multiplying the corresponding x, y, and z
    // coordinates and adding them together
    public double dot(Vector3D v) {
        return (this.xCoord * v.xCoord) + (this.yCoord * v.yCoord) + (this.zCoord * v.zCoord);
    }
    // checks if two vectors are equal by comparing the absolute values of x y and z coordinates.
    public boolean equals(Vector3D v, Vector3D w) {
        double epsilon = 1e-9;
        return (Math.abs(v.xCoord - w.xCoord) < epsilon
                && Math.abs(v.yCoord - w.yCoord) < epsilon
                && Math.abs(v.zCoord - w.zCoord) < epsilon);
    }
    // converts the x y an z coordinates of a vector intoa  string of format [X,Y,Z]
    public String toString(Vector3D v) {
        String vectorOutput = "["+v.xCoord+", "+v.yCoord+", "+v.zCoord+"]";
        return vectorOutput;
    }

}