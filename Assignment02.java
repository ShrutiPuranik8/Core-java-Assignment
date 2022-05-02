import java.util.Scanner;
import java.util.InputMismatchException;

interface Circle {
        void circle(int radius_of_circle);
}

interface Rectangle {
        void rectangle(int length_of_rectangle, int width_of_rectangle);
}

interface Triangle {
        void triangle(int base_of_triangle, int height_of_triangle);
}

interface Square {
        void square(int side_of_square);
}

interface Sphere {
        void sphere(int radius_of_sphere);
}

interface Cylinder {
        void cylinder(int radius_of_cylinder, int height_of_cylinder);
}

class Shape implements Circle, Rectangle, Triangle, Square, Sphere, Cylinder {

        public void circle(int radius_of_circle) {
                float area_of_circle = (float) (3.14 * radius_of_circle * radius_of_circle);
                System.out.println('\n'
                                + "----------------------------------------------------------------------------------------------------------");
                System.out.println('\n' + "Area of the Circle with radius " + radius_of_circle + " is : "
                                + area_of_circle);

                float circumference_of_circle = (float) (2 * 3.14 * radius_of_circle);
                System.out.println("Circumference of the Circle with radius " + radius_of_circle + " is : "
                                + circumference_of_circle);
                System.out.println('\n'
                                + "----------------------------------------------------------------------------------------------------------");

        }

        public void rectangle(int length_of_rectangle, int width_of_rectangle) {
                float area_of_rectangle = (float) (length_of_rectangle * width_of_rectangle);
                System.out.println('\n'
                                + "----------------------------------------------------------------------------------------------------------");
                System.out.println(
                                '\n' + "Area of the rectangle with length " + length_of_rectangle + " and width "
                                                + width_of_rectangle + " is : " + area_of_rectangle);

                float perimeter_of_rectangle = (float) (2 * (length_of_rectangle + width_of_rectangle));
                System.out
                                .println("Perimeter of the rectangle with length " + length_of_rectangle + " and width "
                                                + width_of_rectangle + " is : " + perimeter_of_rectangle);
                System.out.println('\n'
                                + "----------------------------------------------------------------------------------------------------------");

        }

        public void triangle(int base_of_triangle, int height_of_triangle) {
                float area_of_triangle = (float) ((base_of_triangle * height_of_triangle) / 2);
                System.out.println('\n'
                                + "----------------------------------------------------------------------------------------------------------");
                System.out.println('\n' + "Area of the Triangle with base " + base_of_triangle + " and height "
                                + height_of_triangle + " is: " + area_of_triangle);
                System.out.println('\n'
                                + "----------------------------------------------------------------------------------------------------------");

        }

        public void perimeterOfTriangle(int side_one_of_triangle, int side_two_of_triangle,
                        int side_three_of_triangle) {

                float perimeter_of_triangle = (float) (side_one_of_triangle + side_two_of_triangle
                                + side_three_of_triangle);
                System.out.println('\n'
                                + "----------------------------------------------------------------------------------------------------------");
                System.out.println('\n' + "Perimeter of the Triangle with side_one " + side_one_of_triangle
                                + " and side_two " + side_two_of_triangle + " and side_three " + side_three_of_triangle
                                + " is: " + perimeter_of_triangle);
                System.out.println('\n'
                                + "----------------------------------------------------------------------------------------------------------");

        }

        public void square(int side_of_square) {
                float area_of_square = (float) (side_of_square * side_of_square);
                System.out.println('\n'
                                + "----------------------------------------------------------------------------------------------------------");
                System.out.println(
                                '\n' + "Area of the Square with side " + side_of_square + " is : " + area_of_square);
                float perimeter_of_square = (float) (4 * side_of_square);
                System.out.println("perimeter_of_square of the Square with side " + side_of_square + " is : "
                                + perimeter_of_square);
                System.out.println('\n'
                                + "----------------------------------------------------------------------------------------------------------");

        }

        public void sphere(int radius_of_sphere) {
                float area_of_sphere = (float) (4 * 3.14 * radius_of_sphere * radius_of_sphere);
                System.out.println('\n'
                                + "----------------------------------------------------------------------------------------------------------");
                System.out.println('\n' + "Area of the Sphere with radius " + radius_of_sphere + " is : "
                                + area_of_sphere);

                float circumference_of_sphere = (float) (2 * 3.14 * radius_of_sphere);
                System.out.println("Circumference of the Sphere with radius " + radius_of_sphere + " is : "
                                + circumference_of_sphere);
                System.out.println('\n'
                                + "----------------------------------------------------------------------------------------------------------");

        }

        public void cylinder(int radius_of_cylinder, int height_of_cylinder) {

                float area_of_cylinder = (float) ((2 * 3.14 * radius_of_cylinder * height_of_cylinder)
                                + (2 * 3.14 * radius_of_cylinder * radius_of_cylinder));
                System.out.println('\n'
                                + "----------------------------------------------------------------------------------------------------------");
                System.out.println(
                                '\n' + "Area of the cylinder with radius " + radius_of_cylinder + " and height "
                                                + height_of_cylinder + " is : " + area_of_cylinder);

                float perimeter_of_cylinder = (float) ((4 * 3.14 * radius_of_cylinder)
                                + (2 * height_of_cylinder));
                System.out
                                .println("Perimeter of the cylinder with radius " + radius_of_cylinder + " and height "
                                                + height_of_cylinder + " is : " + perimeter_of_cylinder);
                System.out.println('\n'
                                + "----------------------------------------------------------------------------------------------------------");

        }

        public static void main(String args[]) {
                Scanner input = new Scanner(System.in);

                Shape shape_object = new Shape();

                int shape = -1;
                do {
                        System.out.println('\n' + "Select the shape to calculate area and perimeters for :" + '\n');
                        System.out.println("1 Circle");
                        System.out.println("2 Rectangle");
                        System.out.println("3 Triangle");
                        System.out.println("4 Square");
                        System.out.println("5 Sphere");
                        System.out.println("6 Cylinder");
                        System.out.println("To exit press 0");
                        System.out.println('\n' + "Enter your choice");

                        try {
                                shape = input.nextInt();
                                if (shape == 1) {
                                        System.out.println('\n' + "You selected shape 'Circle'");
                                        System.out.print("Enter Radius: ");
                                        int radius_of_circle = input.nextInt();
                                        shape_object.circle(radius_of_circle);
                                }
                                if (shape == 2) {
                                        System.out.println('\n' + "You selected shape 'rectangle'");
                                        System.out.print("Enter Length: ");
                                        int length_of_rectangle = input.nextInt();
                                        System.out.print("Enter Width: ");
                                        int width_of_rectangle = input.nextInt();
                                        shape_object.rectangle(length_of_rectangle, width_of_rectangle);

                                }
                                if (shape == 3) {
                                        System.out.println('\n' + "You selected shape 'Triangle'");
                                        System.out.println("For area of triangle");
                                        System.out.print("Enter base: ");
                                        int base_of_triangle = input.nextInt();
                                        System.out.print("Enter height: ");
                                        int height_of_triangle = input.nextInt();

                                        shape_object.triangle(base_of_triangle, height_of_triangle);

                                        System.out.println("For perimeter of triangle");
                                        System.out.print('\n' + "Enter side_one: ");
                                        int side_one_of_triangle = input.nextInt();
                                        System.out.print("Enter side_two: ");
                                        int side_two_of_triangle = input.nextInt();
                                        System.out.print("Enter side_three: ");
                                        int side_three_of_triangle = input.nextInt();

                                        shape_object.perimeterOfTriangle(side_one_of_triangle, side_two_of_triangle,
                                                        side_three_of_triangle);

                                }
                                if (shape == 4) {
                                        System.out.println('\n' + "You selected shape 'Square'");
                                        System.out.print("Enter side: ");
                                        int side_of_square = input.nextInt();

                                        shape_object.square(side_of_square);
                                }
                                if (shape == 5) {
                                        System.out.println('\n' + "You selected shape 'Sphere'");
                                        System.out.print("Enter Radius: ");
                                        int radius_of_sphere = input.nextInt();

                                        shape_object.sphere(radius_of_sphere);

                                }
                                if (shape == 6) {

                                        System.out.println('\n' + "You selected shape 'Cylinder'");
                                        System.out.print("Enter Radius: ");
                                        int radius_of_cylinder = input.nextInt();
                                        System.out.print("Enter Height: ");
                                        int height_of_cylinder = input.nextInt();

                                        shape_object.cylinder(radius_of_cylinder, height_of_cylinder);

                                }
                        } catch (InputMismatchException exception) {
                                System.out.println('\n' + "Invalid Input");
                                input.nextLine();
                        }

                } while (shape != 0);
        }
}
