import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

public class MyClient {
    public static void main(String args[]){
        ArrayList<Person> people = new ArrayList<>();
        fillArray(people);
        Filter filter1;
        Filter filter2;
        Concat concat;
        if(args.length<3){
            System.out.println("You have to enter RMI object address in the form" +
                    ": //host_address/worker1 //host_address/worker2 //host_address/worker3");
            return;
        }
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        String address = args[0];
        String address2 = args[1];
        String address3 = args[2];
        try{
            filter1 = (Filter) Naming.lookup(address);
            filter2 = (Filter) Naming.lookup(address2);
            concat = (Concat) Naming.lookup(address3);

        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Referncja do "+address+" jest pobrana.");
        System.out.println("Referncja do "+address2+" jest pobrana.");
        System.out.println("Referncja do "+address3+" jest pobrana.");
        try{
            Person[] filteredPeople1 = filter1.filter(listToArray(people), "Jacek");
            Person[] filteredPeople2 = filter2.filter(listToArray(people), "Jan");
            showPeople(filteredPeople1);
            showPeople(filteredPeople2);
            Person[] concatPeople = concat.concat(filteredPeople1,filteredPeople2);
            showPeople(concatPeople);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private static void fillArray(ArrayList<Person> people){
        people.add(new Person("Jan", "Nowak"));
        people.add(new Person("Michal", "Nowak"));
        people.add(new Person("Kazmierz", "Nowak"));
        people.add(new Person("Piotr", "Nowak"));
        people.add(new Person("Jacek", "Nowak"));
        people.add(new Person("Jacek", "Nowak"));
        people.add(new Person("Jan", "Nowak"));
    }

    private static void showPeople(Person[] people){
        for(int i=0; i<people.length; i++){
            System.out.println("Imie: "+people[i].getName()+" Nazwisko: "+people[i].getSurname());
        }
    }

    private static Person[] listToArray(ArrayList<Person> arrayList){
        Person[] people = new Person[arrayList.size()];
        for(int i=0; i<people.length; i++){
            people[i]=arrayList.get(i);
        }
        return people;
    }
}
