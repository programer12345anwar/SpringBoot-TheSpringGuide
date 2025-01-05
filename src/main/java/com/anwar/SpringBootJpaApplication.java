package com.anwar;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.anwar.Dto.UserRepository;
import com.anwar.entities.User;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringBootJpaApplication.class, args);
		 UserRepository userRepository=context.getBean(UserRepository.class);
		 
//		 User user=new User();
//		 user.setName("Md Aamir");
//		 user.setCity("Begusarai");
//		 user.setStatus("unmarried");
//		 User user1= userRepository.save(user);
//		 System.out.println(user1.getId()+" "+user1.getName()+" "+user1.getCity());
		 
		 //System.out.println(user1); it will print com.anwar.entities.User@14d6ede3
		 //to get redable output use toString method 
		 
		 //============================================
//		 User user1=new User();
//		 user1.setName("Md Aamir");
//		 user1.setCity("Begusarai");
//		 user1.setStatus("married");
		 //User user= userRepository.save(user1);
		 //System.out.println(user);
		 
//		 User user2=new User();
//		 user2.setName("Md Aamir");
//		 user2.setCity("Begusarai");
//		 user2.setStatus("married");
		 //User users= userRepository.save(user1);
		 //System.out.println(users);
		 
		 //if there is 10 users then you need to call save method 10 times-->use List.of(e1,e2,e3,...); above java9
//		 List<User> users10=List.of(user1,user2);//List.of() method is of static types that it is immutable
		 
		 //saved multiple objects
//		 Iterable<User> resList= userRepository.saveAll(users10);
		 //System.out.println(resList); //giving output:[com.anwar.entities.User@5837cb9e, com.anwar.entities.User@7ca0b05e]
		 
//		 resList.forEach(user->{
//			 //System.out.println(user.getId()+" "+user.getName()+" "+user.getCity());
//			 System.out.println(user);
//		 });
		 
		 
		 
		 
		 
		 //perform updation //for exaple i want to update the data of id 53 he is married but i want to save as unmarried
		 
//		 Optional<User> userToUpdate= userRepository.findById(53);
//		 User user=userToUpdate.get();
//		 user.setStatus("unmarried not married");
//		 userRepository.save(user);
		 
		 //find all or print all users
		  Iterable<User> itr= userRepository.findAll();
//		  Iterator<User> iterator=itr.iterator();
//		  
//		  while (iterator.hasNext()) {
//			User user2 = (User) iterator.next();
//			System.out.println(user2.getName());
//			
//		  	}
		  
		  //2ND WAY
		  
//		  itr.forEach(new Consumer<User>(){
//			  @Override
//			  public void accept(User t) {
//				  System.out.println(t);
//			  }
//		});
		  
		  
		  //3RD WAY
//		  itr.forEach(user1->{
//			  System.out.println(user1);
//		  });
//		 
		  
		  
		  
		  //DELETING THE USER ELEMENTS
//		  userRepository.deleteById(53);
//		  System.out.println("Deleted successfully");
		  
		  //delete all
//		  Iterable<User> allUsers=userRepository.findAll();
//		  allUsers.forEach(user2->{
//			  userRepository.delete(user2);
//		  });
		  
		  
		  //custum query
		 List<User> users= userRepository.getUserByName("manuu");
		 
		 users.forEach(u->{
			 System.out.println(u.getId()+" "+u.getName()+" "+u.getCity());
		 });
		 
		 
	}

}
