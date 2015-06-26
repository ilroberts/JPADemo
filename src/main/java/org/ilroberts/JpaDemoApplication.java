package org.ilroberts;

import org.ilroberts.entities.Address;
import org.ilroberts.entities.User;
import org.ilroberts.enums.Gender;
import org.ilroberts.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    @Autowired
    UserRepository repository;

    public static void main(String[] args) {

        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {

        createUsers();
        retrieveUsers();
        updateUser();
        retrieveUsers();
        deleteUser();
        retrieveUsers();
    }

    private void deleteUser() {
        repository.deleteByFirstName("iwan");
    }

    private void updateUser() {

        Address newAddress = new Address();

        newAddress.setLine1("Downing Street");
        newAddress.setCity("London");
        newAddress.setZip("00001");

        List<Address> addressList = new ArrayList<Address>();
        addressList.add(newAddress);

        List<User> userList = repository.findByFirstName("iwan");
        for(User tempUser : userList ) {
            tempUser.setAddressList(addressList);
            repository.save(tempUser);
        }
    }

    private void retrieveUsers() {

        // now to get the data back again
        List<User> userList = repository.findByLastName("roberts");
        System.out.println("found " + userList.size() + " users");

        for (User tempUser : userList) {
            System.out.print("user's first name is " + tempUser.getFirstName());
            if (tempUser.getAddressList() != null) {
                switch (tempUser.getGender()) {
                    case MALE:
                        System.out.print(", he ");
                        break;
                    case FEMALE:
                        System.out.print(", she ");
                        break;
                }
                System.out.println("lives at " + tempUser.getAddressList().get(0).getLine1());
            } else {
                System.out.println(", no address specified");
            }
        }
    }

    private void createUsers() {

        User iwan = new User("iwan", "roberts", Gender.MALE);
        User owen = new User("owen", "roberts", Gender.MALE);
        User glyn = new User("glyn", "roberts", Gender.MALE);
        User helen = new User("helen", "roberts", Gender.FEMALE);

        Address address1 = new Address();
        address1.setLine1("2 Dalton Park");
        address1.setCity("Comber");
        address1.setState("NH");
        address1.setZip("01915");

        Address address2 = new Address();
        address2.setLine1("Buckingham Palace");
        address2.setCity("London");
        address2.setZip("00001");

        List<Address> addressList = new ArrayList<Address>();
        addressList.add(address1);
        iwan.setAddressList(addressList);

        List<Address> royalAddressList = new ArrayList<Address>();
        royalAddressList.add(address2);
        helen.setAddressList(royalAddressList);

        repository.save(iwan);
        repository.save(owen);
        repository.save(helen);
        repository.save(glyn);
    }
}
