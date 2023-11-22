package newpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import newpackage.Person;

public class PersonService {
    
 public static void addPerson(ArrayList<Person> people){

        
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Press 1 to add OR Press 0 to exit ");
            int input = sc.nextInt();
            if (input == 0) {

                break;
            } else if (input == 1) {

                sc.nextLine();
                System.out.println("Enter Name");
                String name = sc.nextLine();
                while (!PersonService.isValidName(name)) {
                    System.out.println("enter a valid name");
                    name = sc.nextLine();
                    if (PersonService.isValidName(name)) {
                        break;
                    }
                }
               
                System.out.println("Enter Contact");
                String contact = sc.nextLine();
                boolean valid = PersonService.isValidContact(contact);
                while (!valid) {
                    System.out.println("enter again");
                    contact = sc.nextLine();
                    if (PersonService.isValidContact(contact)) {
                        contact = contact;
                        break;
                    }
                }
                
                
                System.out.println("Enter Mail");
                String mail = sc.nextLine();
                
                while(PersonService.isValidEmail(mail)==false) {
                    System.out.println("enter valid mail id");
                    mail=sc.nextLine();
                    if(PersonService.isValidEmail(mail)){
                        
                        break;
                    }
                }
                 while(!PersonService.isExists(mail, people)){
                    System.out.println("Already exist Enter another ");
                    mail=sc.nextLine();
                    if(PersonService.isExists(mail, people)){
                        
                    break;
                    }
                }
                     
                System.out.println("Enter Address");
                String address = sc.nextLine();
                Person person = new Person(name, contact, mail, address);
                people.add(person);
                System.out.println("Person " + person.PersonName + " added successfully");
                PersonService.listAllPeople((ArrayList<Person>) people);

            }
        }

    }

    public static void deletePerson(ArrayList<Person> people) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id to delete: ");

        int idToDelete = sc.nextInt();
        System.out.println(idToDelete);
        boolean flag=false;

        for (Person person : people) {
            if(person.getPersonId() == idToDelete) {

                people.remove(person);
                System.out.println("Person deleted");
                flag=true;
                
                break;
                
            }else{
                flag=false;
            }
            
        }
        if(!flag){
             System.out.println("not found");
            
        }
       
        

    }


    public static void updatePerson(ArrayList<Person> people) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter id to update");
        int updaterId = sc.nextInt();

        sc.nextLine();
        for (Person person : people) {
            if (person.getPersonId() == updaterId) {
                System.out.println("enter new name");
                String newName = sc.nextLine();
                while (!PersonService.isValidName(newName)) {
                    System.out.println("enter a valid name");
                    newName = sc.nextLine();
                    if (PersonService.isValidName(newName)) {
                        break;
                    }
                }
                
                System.out.println("Enter new Mail-id");
                String newMail=sc.nextLine();
                  while(PersonService.isValidEmail(newMail)==false) {
                    System.out.println("enter valid mail id");
                    newMail=sc.nextLine();
                    if(PersonService.isValidEmail(newMail)){
                        
                        break;
                    }
                }
                 while(!PersonService.isExists(newMail, people)){
                    if(person.PersonMail.equalsIgnoreCase(newMail)){
                        break;
                    }
                    System.out.println("Already exist Enter another ");
                    newMail=sc.nextLine();
                    if(PersonService.isExists(newMail, people)){
                        
                    break;
                    }
                }

                
                System.out.println("enter new contact");
                String newContact = sc.nextLine();
                person.update(newName, newContact,newMail);
                System.out.println("Person updated successfully!");

            } 
            
                
                
            }
        }
    
    public static boolean isExists(String mail, ArrayList<Person> people) {
        for (Person person : people) {
            if (person.PersonMail.equalsIgnoreCase(mail))
            {
            return false;
            
            }
                
        

        }
        return true;
    }

    public static boolean isValidContact(String contact) {
        if (contact.length() != 10) {
            return false;
        }
        for (char c : contact.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void listAllPeople(ArrayList<Person> people) {
        
        for (Person person : people) {
            if(people.isEmpty()){
                System.out.println("List is Empty");
            }
            person.displayInfo();
            System.out.println();
        }
    }

    public static boolean isValidName(String name) {
        return name.matches("^[a-zA-Z]+$");
    }

    public static boolean isValidEmail(String mail) {
        String regex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        return Pattern.compile(regex).matcher(mail).matches();
    }

    public static Person searchById( ArrayList<Person> people) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter id for search : ");
        int id=sc.nextInt();
        for (Person person : people) {
            if (person.PersonId == id) {
               person.displayInfo();
                return person;
            }else
            {
               // System.out.println("User not found");
            }

        }
        return null;

}
    
}