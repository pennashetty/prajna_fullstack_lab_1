import java.util.*; 

class Employee {
    String firstName;
    String lastName;
    int department;

    // Parameterized constructor
    public Employee(String firstName, String lastName, int option) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = option;
    }
}

class CredentialService {
    // Generate a random password with one digit, one uppercase letter, one lowercase letter, and one special character
    static String generatePassword() {
        String passwordCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            password.append(passwordCharacters.charAt(random.nextInt(passwordCharacters.length())));
        }

        return password.toString();
    }

    static String generatedepartment(int option){
        Map<Integer, String> dept = new HashMap<Integer, String>();
            dept.put(1, "tech" ); 
            dept.put(2, "admin"); 
            dept.put(3, "hr"); 
            dept.put(4, "legal");

            return dept.get(option);
    }

    // Generate email address based on the given syntax
    static String generateEmailAddress(Employee employee) {
        var department = generatedepartment(employee.department);
        return employee.firstName.toLowerCase() + employee.lastName.toLowerCase() + "@" + department + ".company.com";
    }

    // Display the generated credentials
    static void showCredentials(Employee employee, String password) {
        System.out.println("Dear " + employee.firstName + ", your generated credentials are as follows:");
        System.out.println("Email ---> " + generateEmailAddress(employee));
        System.out.println("Password ---> " + password);
    }
}



class  itSupport {

    public static void main(String[] args) {
        // Example employee creation with parameterized constructor
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter firstName: ");
        String fname = scanner.nextLine();
                
        System.out.print("Enter lastName: ");
        String lname = scanner.nextLine();
        
        System.out.print("Please Enter Department from the following: ");
        System.out.print("1. Techinical ");
        System.out.print("2. Admin ");
        System.out.print("3. Human Resource ");
        System.out.print("4. Legal");
        Integer option  = scanner.nextInt();
                       
        scanner.close();

        Employee newEmployee = new Employee(fname, lname, option);

        // Example credential generation and display
        String password = CredentialService.generatePassword();
        CredentialService.showCredentials(newEmployee, password);
    }

}