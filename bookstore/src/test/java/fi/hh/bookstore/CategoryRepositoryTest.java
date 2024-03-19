package fi.hh.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.hh.bookstore.domain.Category;
import fi.hh.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
@Autowired
private CategoryRepository repository;

@Test
public void createNewCategoryAndSave(){ // testataan save()metodin toimivuutta
Category category = new Category("Romantic");
repository.save(category);
assertThat(category.getCategoryId()).isNotNull();
}

@Test 
public void deleteCategory(){ //delete toimivuus testi
    Category category = new Category("Scifi-horror");
    repository.save(category);

    repository.delete(category);

    assertThat(repository.findById(category.getCategoryId()).isEmpty());
}

@Test
public void findCategoryByName() { //categori etsintá findby metodi
    
    Category category = new Category("Mystery");
    repository.save(category);

    
    List<Category> categories = repository.findByName("Mystery");

    
    assertThat(categories).isNotEmpty();
    assertThat(categories.get(0).getName()).isEqualTo(category.getName());
}
}

