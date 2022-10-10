package com.ortopedic.ortopedicWork.service;

import com.ortopedic.ortopedicWork.models.Admin;
import com.ortopedic.ortopedicWork.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins(){
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int admin_id){
        return adminRepository.getAdmin(admin_id);
    }

    public Admin insertAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Admin admin){
        if (admin.getId() != null){
            Optional<Admin> adminTem = adminRepository.getAdmin(admin.getId());
            if (!adminTem.isEmpty()){
                if (admin.getName() != null ){
                    adminTem.get().setName(admin.getName());
                }
                if (admin.getCorreo() != null){
                    adminTem.get().setCorreo(admin.getCorreo());
                }
                if (admin.getPassword() != null){
                    adminTem.get().setPassword(admin.getPassword());
                }
                return adminRepository.save(adminTem.get());
            }else {
                return admin;
            }
        }else {
            return admin;
        }
    }

    public Boolean deleteAdmin(int admin_id){
        Boolean success = adminRepository.getAdmin(admin_id).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return success;
    }

}
