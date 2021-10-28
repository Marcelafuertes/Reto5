
package com.sa.G8.Grupo01.Reto5.service;
import com.sa.G8.Grupo01.Reto5.entity.Category;
import com.sa.G8.Grupo01.Reto5.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Novosix
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    
    public Category saveCategory(Category category){
       return repository.save(category);
    }
    
    public List<Category> getCategory(){
        return repository.findAll();
    }
    
    public Category getCategoryById(int id){
        return repository.findById(id).orElse(null);
    }
    
      
    public String deleteCategory(int id){
        repository.deleteById(id);
        return "Categoria removida "+id;
    }
    
    public Category updateCategory(Category Category){
        Category existingCategory=repository.findById(Category.getId()).orElse(null);
       existingCategory.setName(Category.getName());
       existingCategory.setDescription(Category.getDescription());
       return repository.save(existingCategory);
    }
}