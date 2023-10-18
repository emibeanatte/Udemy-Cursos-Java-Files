

package ejercicio_final.server;

import ejercicio_final.classes.Person;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



public class Server {
    
    public static final String PERSON_LIST_FILE_DIR = "C:\\test";

    
    public static void main(String[] args) throws IOException {
        
        try (ServerSocket socket = new ServerSocket(8080);
               Socket client = socket.accept();
               DataInputStream dis = new DataInputStream(client.getInputStream());){

            System.out.printf("<Server> %s Client connected \n", client.getInetAddress().getHostName());
            
            String msg = null;
            ArrayList<Person> people = new ArrayList<>();

            System.out.println("<Server> Welcome. Select your action: ");
            do {
                
                System.out.println("1 - Read people's List.");
                System.out.println("2 - Add person.");
                System.out.println("3 - Modify person.");
                System.out.println("4 - exit.");
                
                msg = dis.readUTF();
                System.out.printf("%s <Client> : %s \n",client.getInetAddress().getHostName(), msg);
                
                switch (Integer.parseInt(msg)){
                    
                    case 1:
                        try {
                            if (people != null) {

                                for (Person person : people) {

                                    System.out.println(person);
                                }
                                System.out.println();
                            } else {
                                System.out.println("Null");
                            }

                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }  
                        break;
                    case 2:
                        System.out.println("<Server> Add person");
                        System.out.println("<Server> Enter name: ");
                        String name = dis.readUTF();
                        System.out.println("<Client> " + name);
                        
                        System.out.println("<Server> Enter last name:");
                        String lastName = dis.readUTF();
                        System.out.println("<Client> " + lastName);
                        
                        System.out.println("<Server> Enter age:");
                        int age = Integer.parseInt(dis.readUTF());
                        System.out.println("<Client> " + age);
                        
                        people.add(new Person(name, lastName, age));
                        System.out.println("<Server> Person added succesfully.");
                        break;
                    case 3:
                        System.out.println("<Server> Modify Person.");
                        boolean found = false;
                        Person p = null;
                        do {
                            
                            System.out.println("<Server> Enter Last Name of the person: ");
                            lastName = dis.readUTF();
                            System.out.println("<Client> " + msg);
                        
                            for (Person person : people) {
                            
                                if (person.getLastName().equalsIgnoreCase(lastName)) {
                                    p = person;
                                    found = true;
                                    break;
                                } else {
                                    found = false;
                                }   
                            }
                            
                            if (!found) {
                                System.out.println("<Server> Person not found.\n");
                            }
                            
                            
                        } while (!found);
                        
                        System.out.println("<Server> Set new data for the person selected:");
                        System.out.println("<Server> Enter new name: ");
                        name = dis.readUTF();
                        System.out.println("<Client> " + name);
                        System.out.println("<Server> Enter new last name:");
                        lastName = dis.readUTF();
                        System.out.println("<Client> " + lastName);
                        System.out.println("<Server> Enter new age:");
                        age = Integer.parseInt(dis.readUTF());
                        System.out.println("<Client> " + age);
                        
                        p.setName(name);
                        p.setLastName(lastName);
                        p.setAge(age);
                        
                        System.out.println("<Server> Person modified succesfully.\n");
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("<Server> Invalid option.\n");
                        break;   
                }

            } while (Integer.parseInt(msg) != 4);
            
            File file = new File(PERSON_LIST_FILE_DIR.concat("\\people.txt"));
            
            if (!file.exists()) {
                file.createNewFile();
            }
            
            try(FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
           
                oos.writeObject(people);
            }
            
            System.out.println("<Server> Person's List was saved in " + file);
            

            System.out.println("<Server> Shutting down Server\n");
            client.close();
            dis.close();

        }
        
    }
}

