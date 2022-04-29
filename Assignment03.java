import java.util.*;
import java.io.*;

class Employee implements Serializable {
    int age;
    String name;
    String date_of_birth;
    String email_address;

    Employee(String name, int age, String date_of_birth, String email_address) {
        this.name = name;
        this.age = age;
        this.date_of_birth = date_of_birth;
        this.email_address = email_address;
    }

    public String toString() {
        return name + " " + age + " " + date_of_birth + " " + email_address;
    }
}

class Employees {
    public static void main(String[] args) throws Exception {

        int choice = -1;

        Scanner integer_input = new Scanner(System.in); // for integer input
        Scanner string_input = new Scanner(System.in); // for string input

        File file = new File("employees.txt");
        ArrayList<Employee> array_list = new ArrayList<Employee>();
        ObjectOutputStream object_output_stream = null;
        ObjectInputStream object_input_stream = null;
        ListIterator list_iterator = null;

        if (file.isFile()) {
            object_input_stream = new ObjectInputStream(new FileInputStream(file));
            array_list = (ArrayList<Employee>) object_input_stream.readObject();
            object_input_stream.close();
        }

        do {
            System.out.println("1.Add");
            System.out.println("2.Display");
            System.out.println("3.Delete");
            System.out.println("4.Search");
            System.out.println("5.Sort by name");
            System.out.println("6.Sort by name descending order");
            System.out.println("7.Sort by age");
            System.out.println("0.Exit");
            System.out.println("Enter Your Choice: ");

            choice = integer_input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter how many employees you want: ");
                    int n = integer_input.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter Employee Name: ");
                        String name = string_input.nextLine();

                        System.out.print("Enter Employee Age: ");
                        int age = integer_input.nextInt();

                        System.out.print("Enter Employee Date of birth: ");
                        String date_of_birth = string_input.nextLine();

                        System.out.print("Enter Employee email address: ");
                        String email_address = string_input.nextLine();

                        array_list.add(new Employee(name, age, date_of_birth, email_address));
                    }
                    object_output_stream = new ObjectOutputStream(new FileOutputStream(file));
                    object_output_stream.writeObject(array_list);
                    object_output_stream.close();

                    break;

                case 2:
                    if (file.isFile()) {
                        object_input_stream = new ObjectInputStream(new FileInputStream(file));
                        array_list = (ArrayList<Employee>) object_input_stream.readObject();
                        object_input_stream.close();

                        System.out.println("----------------------------------------");
                        list_iterator = array_list.listIterator();
                        while (list_iterator.hasNext())
                            System.out.println(list_iterator.next());
                        System.out.println("----------------------------------------");
                    } else {
                        System.out.println("File not Exist...!!");
                    }
                    break;

                case 3:
                    if (file.isFile()) {
                        object_input_stream = new ObjectInputStream(new FileInputStream(file));
                        array_list = (ArrayList<Employee>) object_input_stream.readObject();
                        object_input_stream.close();

                        boolean found = false;
                        System.out.print("Enter name to delete: ");
                        String name = string_input.nextLine();
                        System.out.println("----------------------------------------");
                        list_iterator = array_list.listIterator();
                        while (list_iterator.hasNext()) {
                            Employee employee = (Employee) list_iterator.next();
                            if (employee.name.equals(name)) {
                                list_iterator.remove();
                                found = true;
                            }
                        }
                        if (found) {
                            object_output_stream = new ObjectOutputStream(new FileOutputStream(file));
                            object_output_stream.writeObject(array_list);
                            object_output_stream.close();
                            System.out.println("Record deleted successfully");
                        } else {
                            System.out.println("Record not found....!");
                        }
                        System.out.println("----------------------------------------");
                    } else {
                        System.out.println("File not Exist...!!");
                    }
                    break;

                case 4:
                    if (file.isFile()) {
                        object_input_stream = new ObjectInputStream(new FileInputStream(file));
                        array_list = (ArrayList<Employee>) object_input_stream.readObject();
                        object_input_stream.close();

                        boolean found = false;
                        System.out.println("Enter name to search: ");
                        String name = string_input.nextLine();
                        System.out.println("----------------------------------------");
                        list_iterator = array_list.listIterator();
                        while (list_iterator.hasNext()) {
                            Employee employee = (Employee) list_iterator.next();
                            if (employee.name.equals(name)) {
                                System.out.println(employee);
                                found = true;
                            }
                        }
                        if (!found)
                            System.out.println("Record not found...!!");
                        System.out.println("----------------------------------------");
                    } else {
                        System.out.println("File not Exist...!!");
                    }
                    break;

                case 5:
                    if (file.isFile()) {
                        object_input_stream = new ObjectInputStream(new FileInputStream(file));
                        array_list = (ArrayList<Employee>) object_input_stream.readObject();
                        object_input_stream.close();

                        Collections.sort(array_list, new Comparator<Employee>() {
                            public int compare(Employee employee1, Employee employee2) {
                                return employee1.name.compareTo(employee2.name);
                            }
                        });

                        object_output_stream = new ObjectOutputStream(new FileOutputStream(file));
                        object_output_stream.writeObject(array_list);
                        object_output_stream.close();

                        System.out.println("----------------------------------------");
                        list_iterator = array_list.listIterator();
                        while (list_iterator.hasNext())
                            System.out.println(list_iterator.next());
                        System.out.println("----------------------------------------");
                    } else {
                        System.out.println("File not Exist...!!");
                    }
                    break;

                case 6:
                    if (file.isFile()) {
                        object_input_stream = new ObjectInputStream(new FileInputStream(file));
                        array_list = (ArrayList<Employee>) object_input_stream.readObject();
                        object_input_stream.close();

                        Collections.sort(array_list, new Comparator<Employee>() {
                            public int compare(Employee employee1, Employee employee2) {
                                return employee2.name.compareTo(employee1.name);
                            }
                        });

                        object_output_stream = new ObjectOutputStream(new FileOutputStream(file));
                        object_output_stream.writeObject(array_list);
                        object_output_stream.close();

                        System.out.println("----------------------------------------");
                        list_iterator = array_list.listIterator();
                        while (list_iterator.hasNext())
                            System.out.println(list_iterator.next());
                        System.out.println("----------------------------------------");
                    } else {
                        System.out.println("File not Exist...!!");
                    }
                    break;

                case 7:
                    if (file.isFile()) {
                        object_input_stream = new ObjectInputStream(new FileInputStream(file));
                        array_list = (ArrayList<Employee>) object_input_stream.readObject();
                        object_input_stream.close();

                        Collections.sort(array_list, new Comparator<Employee>() {
                            public int compare(Employee employee1, Employee employee2) {
                                return employee1.age - employee2.age;
                            }
                        });

                        object_output_stream = new ObjectOutputStream(new FileOutputStream(file));
                        object_output_stream.writeObject(array_list);
                        object_output_stream.close();

                        System.out.println("----------------------------------------");
                        list_iterator = array_list.listIterator();
                        while (list_iterator.hasNext())
                            System.out.println(list_iterator.next());
                        System.out.println("----------------------------------------");
                    } else {
                        System.out.println("File not Exist...!!");
                    }
                    break;

            }
        } while (choice != 0);
    }
}