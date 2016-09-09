package application.repositories;

import application.model.Dish;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class DishSpecifications {

    private DishSpecifications() {
        //private constructor to hide implicit public one
    }

    public static class DishPriceLessThanSpecification implements Specification<Dish> {
        int price;

        public DishPriceLessThanSpecification(int price) {
            this.price = price;
        }

        @Override
        public Predicate toPredicate(Root<Dish> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            return cb.le(root.<Number>get("price"), this.price);
        }
    }

    public static class DishNameSpecification implements Specification<Dish> {

        String name;

        public DishNameSpecification(String name) {
            this.name = name;
        }

        @Override
        public Predicate toPredicate(Root<Dish> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            return cb.equal(root.get("dishName"), this.name);
        }
    }
}
