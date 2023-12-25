package com.example.Crowdfunding.Categories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategorySansMockitoTest {

    private CategoriesService categoriesService;
    private FakeCategoriesRepository fakeCategoriesRepository;

    @BeforeEach
    public void setup() {
        fakeCategoriesRepository = new FakeCategoriesRepository();
        categoriesService = new CategoriesService(fakeCategoriesRepository);
    }

    @Test
    public void testGetAllCategories() {
        // Given
        List<Categories> categoriesList = new ArrayList<>();
        categoriesList.add(new Categories(1L, "TestCategory1"));
        categoriesList.add(new Categories(2L, "TestCategory2"));
        fakeCategoriesRepository.setCategories(categoriesList);

        // When
        List<Categories> result = categoriesService.getAllCategories();

        // Then
        assertEquals(categoriesList.size(), result.size());
    }

    // Add more test cases as needed for other methods in CategoriesService

    // A fake implementation of CategoriesRepository for testing purposes
    private class FakeCategoriesRepository implements CategoriesRepository {
        private List<Categories> categories = new ArrayList<>();

        public void setCategories(List<Categories> categories) {
            this.categories = categories;
        }

        @Override
        public <S extends Categories> S save(S entity) {
            categories.add(entity);
            return entity;
        }

        @Override
        public <S extends Categories> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public List<Categories> findAll() {
            return categories;
        }

        @Override
        public List<Categories> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public Optional<Categories> findById(Long aLong) {
            return categories.stream().filter(c -> c.getCategory_id().equals(aLong)).findFirst();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public void deleteById(Long aLong) {
            categories.removeIf(c -> c.getCategory_id().equals(aLong));
        }

        @Override
        public void delete(Categories entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Categories> entities) {

        }

        @Override
        public void deleteAll() {

        }


    @Test
    public void testCreateCategory() {
        // Given
        Categories categoryToCreate = new Categories(1L, "TestCategory");

        // When
        categoriesService.createCategory(categoryToCreate);

        // Then
        List<Categories> categories = fakeCategoriesRepository.findAll();
        assertEquals(1, categories.size());
        assertEquals(categoryToCreate, categories.get(0));
    }

    @Test
    public void testDeleteCategory() {
        // Given
        Long categoryId = 1L;
        Categories categoryToDelete = new Categories(categoryId, "TestCategory");
        fakeCategoriesRepository.save(categoryToDelete);

        // When
        categoriesService.deleteCategory(categoryId);

        // Then
        List<Categories> categories = fakeCategoriesRepository.findAll();
        assertEquals(0, categories.size());
    }

    @Test
    public void testUpdateCategory() {
        // Given
        Long categoryId = 1L;
        Categories categoryToUpdate = new Categories(categoryId, "TestCategory");
        fakeCategoriesRepository.save(categoryToUpdate);

        // When
        Categories updatedCategory = new Categories(categoryId, "UpdatedCategory");
        categoriesService.updateCategory(categoryId, updatedCategory);

        // Then
        List<Categories> categories = fakeCategoriesRepository.findAll();
        assertEquals(1, categories.size());
        assertEquals(updatedCategory.getCategory_name(), categories.get(0).getCategory_name());
    }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Categories> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Categories> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Categories> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Categories getOne(Long aLong) {
            return null;
        }

        @Override
        public Categories getById(Long aLong) {
            return null;
        }

        @Override
        public Categories getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Categories> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Categories> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Categories> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends Categories> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Categories> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Categories> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Categories, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }

        @Override
        public List<Categories> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<Categories> findAll(Pageable pageable) {
            return null;
        }
    }
}
