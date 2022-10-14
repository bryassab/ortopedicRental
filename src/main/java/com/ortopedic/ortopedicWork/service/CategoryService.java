package com.ortopedic.ortopedicWork.service;

import com.ortopedic.ortopedicWork.models.Category;
import com.ortopedic.ortopedicWork.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category insertCategory(Category category){
       return categoryRepository.save(category);
    }

    public Category updateCategory(Category category){
        if (category.getId() != null){
            Optional<Category> categoryTem = categoryRepository.getCategory(category.getId());
            if (!categoryTem.isEmpty()){
                if (category.getName() != null ){
                    categoryTem.get().setName(category.getName());
                }
                if (category.getDescription() != null){
                    categoryTem.get().setDescription(category.getDescription());
                }
                if (category.getOrtopedics() != null){
                    categoryTem.get().setOrtopedics(category.getOrtopedics());
                }
                 categoryRepository.save(categoryTem.get());
                return categoryTem.get();
            }else {
                return category;
            }
        }else {
            return category;
        }
    }

    public Boolean deleteCategory(int id){
        Boolean success = categoryRepository.getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return success;
    }

}
