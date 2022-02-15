package com.example.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service("userService")
public class UserService {
	
	@Autowired
    private UserRepository userRepo;
    
    
    public List<User> listAll(){
        return (List<User>) userRepo.findAll();
    }
    
   
 

    public void save(User user) {
        // TODO Auto-generated method stub
        userRepo.save(user);
        
    }
public User validateUser(String email, String password) {

	List<User> userList=(List<User>)userRepo.findAll();
	for(User user:userList) 
	{
		if(user.getEmail().equals(email)&&user.getPassword().equals(password)) 
		{
			return user;
		}
	}
	return null;
}
 

    public User get(Integer id) throws ClassNotFoundException {
        // TODO Auto-generated method stub
        try {
        return userRepo.findById(id).get();
        }catch(NoSuchElementException ex) {
            throw new ClassNotFoundException("Could not find any user with ID" +id);
        }
        
    }
    public void delete(Integer id) throws ClassNotFoundException  {
//        Long countById=userRepo.countById(id);
//        if(countById==null || countById==0) {
//            throw new ClassNotFoundException("Could not find any user with ID" +id);
//        }
//        userRepo.deleteById(id);
        
    }
    

 

//	@Autowired
//    private UserRepository userRepo;
//    
//    @Autowired
//    private RoleRepository roleRepo;
//    
//	@Autowired
//	private UserService userService;
//	
//	 public User validateLogin(String email,String password) {
//	        User user = userRepo.findByEmail(email);
//	        String userEmail=user.getEmail();
//	        if(userEmail== null) {
//	            throw new RuntimeException("User does not exist.");
//	        }
//	        if(!password.equals(user.getPassword())){
//	            throw new RuntimeException("Password mismatch.");
//	        }
//	        return user ;
//	    }
//
//	
////	public User addUser(User uObj) {
////
////		uObj.setRole("customer");
////		uObj.setEmail("aashish13@yahoo.com");
////		uObj.setFirstName("Ashu");
////		uObj.setLastName("Aashu");
////		uObj.setPassword("Aashu@123");
////		return userRepository.save(uObj);
////	}
////
////	public User validateUser(String email, String password) {
////
////		List<User> userList=userRepository.findAll();
////		for(User user:userList) 
////		{
////			if(user.getEmail().equals(email)&&user.getPassword().equals(password)) 
////			{
////				return user;
////			}
////		}
////		return null;
////	}
////
////	@Override
////	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////		// TODO Auto-generated method stub
////		return null;
////	}
}
